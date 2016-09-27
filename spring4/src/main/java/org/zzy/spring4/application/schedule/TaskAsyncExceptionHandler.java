package org.zzy.spring4.application.schedule;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 16-9-22
 * @sine 1.0
 */
public class TaskAsyncExceptionHandler extends SimpleAsyncUncaughtExceptionHandler {
    @Override
    public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
        System.out.println("TaskAsyncExceptionHandler self definition task exception handler." + throwable.getMessage() + " : " + method.getName());
    }
}
