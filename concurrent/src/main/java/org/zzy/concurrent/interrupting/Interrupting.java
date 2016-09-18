package org.zzy.concurrent.interrupting;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhaoyu on 16-9-7.
 */
class SleepBlocked implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
        System.out.println("Exiting SleepBlocked.run()\n");
    }
}

class IOBlocking implements Runnable {
    private InputStream in;

    public IOBlocking(InputStream in) {
        this.in = in;
    }

    @Override
    public void run() {
        try {
            System.out.println("waiting for read():");
            in.read();
        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted from blocked I/O.");
            }
            else {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Exiting IOBlocked.run().\n");
    }
}

class SynchronizedBlocked implements Runnable {
    public SynchronizedBlocked() {
        new Thread() {
            @Override
            public void run() {
                f();
            }
        }.start();
    }

    public synchronized void f() {
        while (true) {
            Thread.yield();
        }
    }
    @Override
    public void run() {
        System.out.println("Trying to call f()");
        f();
        System.out.println("Exiting SynchronizedBlocking.run().");
    }
}

public class Interrupting {
    private static ExecutorService executorService =
            Executors.newCachedThreadPool();

    static void test(Runnable runnable) throws InterruptedException {
        Future<?> f = executorService.submit(runnable);
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Interrupting " + runnable.getClass().getName());
        f.cancel(true);
        System.out.println("Interrupt sent to " + runnable.getClass().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        test(new SleepBlocked());
        test(new IOBlocking(System.in));
        test(new SynchronizedBlocked());

        TimeUnit.SECONDS.sleep(3);
        System.out.println("Aborting with System.exit(0)");
        System.exit(0);
    }
}
