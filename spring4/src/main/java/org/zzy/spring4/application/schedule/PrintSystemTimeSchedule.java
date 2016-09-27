package org.zzy.spring4.application.schedule;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 16-9-22
 * @sine 1.0
 */
@Component
public class PrintSystemTimeSchedule implements InitializingBean {

    @Scheduled(fixedRate = 5000)
    public void printSystemTime() {
        System.out.println("current time is : " + (new Date().toString()));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        /*Timer timer = new Timer();
        timer.schedule(new PrintTimeScheduleTask("from InitializingBean", 3), 2000, 2000);*/
    }

    private final class PrintTimeScheduleTask extends TimerTask {

        private static final int FIXED_RATE = 5;

        private String flag;
        private Integer fixedRate = FIXED_RATE;
        private AtomicInteger times;

        public PrintTimeScheduleTask(String flag, int fixedRate) {
            this.flag = flag;
            this.fixedRate = fixedRate;
            this.times = new AtomicInteger(0);
        }

        @Override
        public void run() {
            System.out.println(flag + " : " + new Date().toString());
            if (times.intValue() == 10) {
                System.out.println("task finished.");
                cancel();
            }
            times.incrementAndGet();
            try {
                TimeUnit.SECONDS.sleep(fixedRate);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
