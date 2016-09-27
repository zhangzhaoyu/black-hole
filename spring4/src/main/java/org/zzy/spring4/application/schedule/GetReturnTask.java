package org.zzy.spring4.application.schedule;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 16-9-22
 * @sine 1.0
 */
@Component
public class GetReturnTask {

    @Async
    public Future<String> printSystemTask(String name) {
        try {
            TimeUnit.SECONDS.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " get current Time : " + new Date().toString());
        return new AsyncResult<>("task finished.");
    }

    @Async
    public ListenableFuture<String> printSystemTimeAndReturnListenableFuture(boolean flag) {
        try {
            TimeUnit.SECONDS.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (flag) {
            throw new IllegalArgumentException("error argument.");
        }
        System.out.println("get current Time : " + new Date().toString());
        return new AsyncResult<>("ListenableFuture return ");
    }

    @Async
    public void getTaskResult(Future<String> future) throws ExecutionException, InterruptedException {
        while (!future.isDone()) {
            TimeUnit.SECONDS.sleep(2);
            System.out.println("task not finished");
        }
        System.out.println("task finished, result " + future.get());
    }

}