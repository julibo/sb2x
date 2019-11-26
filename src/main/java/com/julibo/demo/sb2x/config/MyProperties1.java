package com.julibo.demo.sb2x.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author carson
 * @date 2019-11-22
 */
@Component
@ConfigurationProperties(prefix = "my1")
@Data
public class MyProperties1 {

    private int age;
    private String name;

    @Override
    public String toString() {
        return "MyProperties1{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
