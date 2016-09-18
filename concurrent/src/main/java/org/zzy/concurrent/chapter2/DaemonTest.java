package org.zzy.concurrent.chapter2;

import java.util.concurrent.TimeUnit;

/**
 * Created by zhaoyu on 16-9-9.
 */
public class DaemonTest implements Runnable {
    private int i = 0;

    @Override
    public void run() {
        while (true) {
            i++;
            System.out.println("i is :" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new DaemonTest());
        thread.setDaemon(true);
        thread.start();
        TimeUnit.SECONDS.sleep(1);
    }
}
