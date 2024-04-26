package com.example.javademo.task;


import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class ScheduleOutTask {

    //每3秒执行一次
    @Scheduled(fixedDelay = 3000)
    private void myTask01() {
        System.out.println("每三秒运行一次");
    }

}
