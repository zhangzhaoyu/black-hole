package org.zzy.concurrent.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by zhaoyu on 16-9-2.
 */
class ExceptionThread2 implements Runnable {
    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println("run() by " + thread);
        System.out.println(
                "eh = " + thread.getUncaughtExceptionHandler()
        );
        throw new RuntimeException("UncaughtException");
    }
}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("get exception");
        System.out.println(t.getName() + " : " + e);
    }
}

class HandlerThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this + " creating new Thread.");
        Thread thread = new Thread(r);
        System.out.println("created " + thread);
        // set exception handler
        thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println(
                "eh = " + thread.getUncaughtExceptionHandler()
        );
        return thread;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool(
                new HandlerThreadFactory()
        );
        executorService.execute(new ExceptionThread2());
        executorService.shutdown();
    }
}

public class ExceptionThread implements Runnable {
    @Override
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new ExceptionThread());
        executorService.shutdown();
    }
}

