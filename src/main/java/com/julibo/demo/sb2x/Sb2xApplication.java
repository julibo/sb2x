package com.julibo.demo.sb2x;

import com.battcn.swagger.annotation.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * @author carson
 * @date 2019-11-25
 */
@SpringBootApplication
@EnableScheduling
@EnableAsync
@EnableSwagger2Doc
public class Sb2xApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sb2xApplication.class, args);
    }

    /**
     * 很关键：默认情况下 TaskScheduler 的 poolSize = 1
     *
     * @return 线程池
     */
    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(10);
        return taskScheduler;
    }

}
