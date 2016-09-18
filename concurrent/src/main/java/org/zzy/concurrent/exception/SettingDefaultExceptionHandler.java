package org.zzy.concurrent.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhaoyu on 16-9-2.
 */
public class SettingDefaultExceptionHandler {
    public static void main(String[] args) {
        // set default exception handler
        Thread.setDefaultUncaughtExceptionHandler(
                new MyUncaughtExceptionHandler()
        );
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new ExceptionThread());
        executorService.shutdown();
    }
}
