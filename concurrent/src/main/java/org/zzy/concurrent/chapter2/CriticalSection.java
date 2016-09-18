package org.zzy.concurrent.chapter2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhaoyu on 16-9-6.
 */
class Pair {
    private int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pair() {
        this(0, 0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void incrementX() {
       this.x++;
    }

    public void incrementY() {
        this.y++;
    }

    @Override
    public String toString() {
        return "x : " + x + ", y : " + y;
    }

    public class PairValuesNotEqualException extends RuntimeException {
        public PairValuesNotEqualException() {
            super("Pair values not equal : " + Pair.this);
        }
    }

    public void checkState() {
        if (x != y) {
            System.out.println("x!=y");
            throw new PairValuesNotEqualException();
        }
    }
}

abstract class PairManager {
    AtomicInteger checkCounter = new AtomicInteger(0);
    protected Pair p = new Pair();
    private List<Pair> storage = Collections.synchronizedList(new ArrayList<Pair>());

    public synchronized Pair getPair() {
        return new Pair(p.getX(), p.getY());
    }

    protected void store(Pair p) {
        this.storage.add(p);
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public abstract void increment();
}

class PairManager1 extends PairManager {
    @Override
    public synchronized void increment() {
        p.incrementX();
        p.incrementY();
        super.store(getPair());
    }
}

class PairManager2 extends PairManager {
    @Override
    public void increment() {
        Pair pair;
        synchronized (this) {
            p.incrementX();
            p.incrementY();
            pair = getPair();
        }
        store(pair);
    }
}

class ExplicitPairManager1 extends PairManager {
    private Lock lock = new ReentrantLock();

    @Override
    public void increment() {
        lock.lock();
        try {
            p.incrementX();
            p.incrementY();
            store(getPair());
        } finally {
            lock.unlock();
        }
    }
}

class ExplicitPairManager2 extends PairManager {
    private Lock lock = new ReentrantLock();

    @Override
    public void increment() {
        Pair temp;
        lock.lock();
        try {
            p.incrementX();
            p.incrementY();
            temp = getPair();
        } finally {
            lock.unlock();
        }
        store(temp);
    }
}

class PairManipulator implements Runnable {
    private PairManager pm;

    public PairManipulator(PairManager pm) {
        this.pm = pm;
    }

    @Override
    public void run() {
        while (true) {
            pm.increment();
        }
    }

    @Override
    public String toString() {
        return "PairManipulator{" +
                "pm=" + pm.getPair() +
                " checkCounter=" + pm.checkCounter.get() +
                '}';
    }
}

class PairChecker implements Runnable {
    private PairManager pm;

    public PairChecker(PairManager pm) {
        this.pm = pm;
    }

    @Override
    public void run() {
        while (true) {
            pm.checkCounter.incrementAndGet();
            pm.getPair().checkState();
        }
    }
}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("get exception");
        System.out.println(t.getName() + " : " + e);
    }
}

public class CriticalSection {
    public static void testApproaches(PairManager pm1, PairManager pm2) {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());

        ExecutorService executorService = Executors.newCachedThreadPool();
        PairManipulator
                pairManipulator1 = new PairManipulator(pm1),
                pairManipulator2 = new PairManipulator(pm2);

        PairChecker
                pairChecker1 = new PairChecker(pm1),
                pairChecker2 = new PairChecker(pm2);

        executorService.execute(pairManipulator1);
        executorService.execute(pairManipulator2);
        executorService.execute(pairChecker1);
        executorService.execute(pairChecker2);

        try {
            TimeUnit.MILLISECONDS.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("pairManipulator1: " + pairManipulator1);
        System.out.println("pairManipulator2: " + pairManipulator2);
        System.exit(0);
    }

    public static void main(String[] args) {
        PairManager
                pairManager1 = new PairManager1(),
                pairManager2 = new PairManager2();
        testApproaches(pairManager1, pairManager2);
    }
}
