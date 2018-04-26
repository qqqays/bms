package com.qays.bms.common.tasks;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 04-26-2018 9:56
 */
@Configuration
@Component
@EnableScheduling
public class ScheduleTask {

    public void overTimeNotice() {
        //实际的业务

        System.out.println("OverTime start time"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        System.out.println("OverTime end time"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
