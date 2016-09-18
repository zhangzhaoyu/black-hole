package org.zzy.concurrent.chapter1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhaoyu on 16-9-1.
 */
public class SimplePriorities implements Runnable {
    private int countDown = 5;
    private volatile double d;
    private int priority;

    public SimplePriorities(int priority) {
        this.priority = priority;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        while (true) {
            for (int i=1; i<10000000; i++) {
                d += (Math.PI + Math.E) / (double) i;
                if (i % 1000 == 0) {
                    Thread.yield();
                }
            }
            System.out.println(this);
            if (--countDown == 0) {
                return;
            }
        }
    }

    @Override
    public String toString() {
        return Thread.currentThread() + " : " +countDown;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new SimplePriorities(Thread.MAX_PRIORITY));
        for (int i=0; i<5; i++) {
            executorService.execute(new SimplePriorities(Thread.MIN_PRIORITY));
        }

        executorService.shutdown();
    }
}
