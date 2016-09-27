package org.zzy.spring4.application.schedule;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 16-9-23
 * @sine 1.0
 */
@Component
public class DynamicCreateSchedule {

    private boolean flag = true;
    @Autowired
    private ThreadPoolTaskScheduler selfScheduler = null;


    @Scheduled(fixedRate = 10000)
    public void afterPropertiesSet() throws Exception {
        selfScheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("scheduleAtFixedRate new Schedule task");
            }
        }, 5000);
    }

    public void stopSchedule() {
        selfScheduler.destroy();
        System.out.println(DynamicCreateSchedule.class.getName() + " is shutdown.");
    }
}
