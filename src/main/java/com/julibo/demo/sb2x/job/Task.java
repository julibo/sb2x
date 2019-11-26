package com.julibo.demo.sb2x.job;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.core.io.FileSystemResource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Date;
import javax.mail.internet.MimeMessage;

/**
 * @author carson
 * @date 2019-11-22
 */
@Component
public class Task {

    private static final Logger log = LoggerFactory.getLogger(Task.class);

    @Autowired
    private JavaMailSender jms;

    @Value("${spring.mail.username}")
    private String from;

    /**
     * 定时任务，每分钟发一个邮件
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void sendSimpleEmail() {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(from);
            // 接收人
            message.setTo("yuzhanwei@g7.com.cn");
            // 标题
            message.setSubject("简单青春");
            // 内容
            message.setText("再见青春，你好成功！");
            jms.send(message);
            System.out.println("发送成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    /**
     * 定时任务，每分钟发一个邮件
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void sendHtmlEmail() {
        MimeMessage message;
        try {
            message = jms.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo("yuzhanwei@g7.com.cn");
            helper.setSubject("一封HTML格式的邮件");
            // 带HTML格式的内容
            StringBuffer sb = new StringBuffer("<p style='color:#42b983'>使用Spring Boot发送HTML格式邮件。</p>");
            helper.setText(sb.toString(), true);
            jms.send(message);
            System.out.println("发送成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    /**
     * 定时任务，每分钟发一个邮件
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void sendAttachmentsMail() {
        try {
            MimeMessage message = jms.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo("yuzhanwei@g7.com.cn");
            helper.setSubject("一封带附件的邮件");
            helper.setText("详情参见附件内容！");
            // 传入附件
            FileSystemResource file = new FileSystemResource(new File("/Users/carson/Pictures/th.jpeg"));
            helper.addAttachment("螳螂捕蝉", file);
            jms.send(message);
            System.out.println("发送成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }


    }

    /**
     * 每隔3秒打印
     */
    @Async
    @Scheduled(fixedRate = 10000)
    public void fixedRateJob() throws InterruptedException {
        Thread.sleep(30000);
        System.out.println("fixedRate 每1秒执行一次：" + LocalDateTime.now());
    }

    /**
     * 方法执行完成后5秒打印
     */
    @Scheduled(fixedDelay = 50000)
    public void fixedDelayJob() {
        System.out.println("fixedDelay 每隔50秒" + new Date());
    }

    /**
     * 定时任务，每天下午4点55-58分执行
     */
    @Scheduled(cron = "0 55-58 16 * * ?")
    public void cronJob() {
        System.out.println(new Date() + " ...>>cron....");
    }



}
