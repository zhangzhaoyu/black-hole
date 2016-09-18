package org.zzy.concurrent.chapter1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhaoyu on 16-9-1.
 */
public class LiftOff implements Runnable {
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "LoftOff") + ")";
    }

    @Override
    public void run() {
        synchronized (this) {
            while (countDown-- > 0) {
                System.out.println(status());
                // old style
                /*try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }*/
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class MainThread {
    public static void main(String[] args) throws IllegalAccessException,
            InstantiationException {
        // ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        // ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i=0; i<10; i++) {
            // Thread thread = new Thread(LiftOff.class.newInstance());
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
        System.out.println("Waiting for LiftOff");
    }
}
