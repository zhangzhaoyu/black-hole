package org.zzy.spring4.application.schedule.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 16-9-23
 * @sine 1.0
 */
public class ExampleJob extends QuartzJobBean {

    private int timeout;

    public ExampleJob() {
    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println(context.getJobDetail());
        System.out.println("Example Job : " + new Date().toString());
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
}
