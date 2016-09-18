package org.zzy.concurrent.chapter1;

import org.springframework.scheduling.concurrent.DefaultManagedAwareThreadFactory;

import java.util.concurrent.*;

/**
 * Created by zhaoyu on 16-9-1.
 */
public class SimpleDaemons implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("---- it is a daemon." + Thread.currentThread().isDaemon());
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        /*for (int i=0; i<10; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true);
            daemon.start();
        }*/
        ExecutorService executorService = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for (int i=0;i<10; i++) {
            executorService.execute(new SimpleDaemons());
        }
        executorService.shutdown();
        System.out.println("all daemons started.");
        TimeUnit.MILLISECONDS.sleep(100);
    }
}

class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setDaemon(true);
        return thread;
    }
}

class DaemonThreadPoolExecutor extends ThreadPoolExecutor {

    public DaemonThreadPoolExecutor( ) {
        super(0, Integer.MAX_VALUE, 60L,
                TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(),
                new DaemonThreadFactory());
    }
}
