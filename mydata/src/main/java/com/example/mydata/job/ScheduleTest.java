package com.example.mydata.job;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class ScheduleTest {

    @Scheduled(cron = "0/5 * * * * ? ")
    public void execut1e(){
        /*System.out.println("hello");*/
    }

}
