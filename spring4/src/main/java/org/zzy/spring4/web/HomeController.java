package org.zzy.spring4.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zzy.spring4.application.schedule.DynamicCreateSchedule;
import org.zzy.spring4.application.schedule.GetReturnTask;
import org.zzy.spring4.application.schedule.ListenableFutureCallBackImpl;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 16-9-19
 * @sine 1.0
 */
@Controller
public class HomeController {

    @Autowired
    private GetReturnTask getReturnTask;

    @Autowired
    private DynamicCreateSchedule dynamicCreateSchedule;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/task", method = RequestMethod.GET)
    @ResponseBody
    public String task() throws ExecutionException, InterruptedException {
        ListenableFuture<String> future = getReturnTask.printSystemTimeAndReturnListenableFuture(true);

        future.addCallback(new ListenableFutureCallBackImpl());
        return "task is running" + new Date().toString();
    }

    @RequestMapping(value = "/shutdownSchedule")
    @ResponseBody
    public String shutDownTask() {
        dynamicCreateSchedule.stopSchedule();
        return "schedule shutdown";
    }
}
