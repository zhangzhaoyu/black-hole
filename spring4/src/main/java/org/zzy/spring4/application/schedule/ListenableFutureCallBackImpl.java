package org.zzy.spring4.application.schedule;

import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * Created by zhaoyu on 16-9-14.
 * handle exception and result of async call.
 * @author zhaoyu
 * @date 16-9-22
 * @sine 1.0
 */
public class ListenableFutureCallBackImpl implements ListenableFutureCallback<String> {
    @Override
    public void onFailure(Throwable ex) {
        System.out.println(ex.getMessage());
    }

    @Override
    public void onSuccess(String result) {
        System.out.println("task finished , result is : " + result);
    }
}
