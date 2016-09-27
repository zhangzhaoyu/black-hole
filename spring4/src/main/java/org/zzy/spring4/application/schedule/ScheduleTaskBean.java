package org.zzy.spring4.application.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 16-9-23
 * @sine 1.0
 */
@Component(value = "ScheduleTaskBean")
public class ScheduleTaskBean {

    // pojo bean for schedule task
    public void scheduleTask() {
        System.out.println("schedule tasking...");
    }

}
