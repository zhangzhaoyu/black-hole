package org.zzy.spring4.application.schedule.quartz;

import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;

import java.util.Date;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 16-9-23
 * @sine 1.0
 */
public class ExampleBusinessObject {

    public ExampleBusinessObject() {
        new MethodInvokingJobDetailFactoryBean();
    }

    public void doIt() {
        System.out.println(this.getClass().getName() + new Date().toString());
    }

}
