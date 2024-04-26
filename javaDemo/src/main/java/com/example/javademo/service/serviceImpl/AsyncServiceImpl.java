package com.example.javademo.service.serviceImpl;

import com.example.javademo.service.AsyncService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class AsyncServiceImpl implements AsyncService {

    @Async
    @Override
    public void call() {
        LocalDateTime startTime = LocalDateTime.now();
        System.out.println("异步任务开始执行，时间：" + startTime);

        // 模拟一个耗时操作
        try {
            Thread.sleep(5000); // 5秒
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("异步任务执行完成，时间：" + endTime);

        Duration duration = Duration.between(startTime, endTime);
        long seconds = duration.getSeconds();
        long millis = duration.toMillis();
        System.out.println("异步任务实际执行时间：" + seconds + "秒 " + millis + "毫秒");
    }
}
