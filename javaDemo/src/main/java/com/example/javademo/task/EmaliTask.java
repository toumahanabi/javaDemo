package com.example.javademo.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class EmaliTask {

//    @Autowired
//    private JavaMailSender javaMailSender;
//
//    public void sendMail() {
//        long startTime = System.currentTimeMillis();
//        //初始化邮件对象
//        SimpleMailMessage mail = new SimpleMailMessage();
//        //主题
//        mail.setSubject("测试主题");
//        //文本
//        mail.setText("Hello World");
//        //接受人
//        mail.setTo("xx@fujitsu.com");
//        javaMailSender.send(mail);
//        long endTime = System.currentTimeMillis();
//        long mill = (endTime - startTime) / 1000;
//        System.out.println("发送邮件耗时：" + mill + "：秒");
//    }
}
