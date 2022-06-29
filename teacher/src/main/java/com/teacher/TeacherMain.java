package com.teacher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author ：ZhangLei
 * @Data ：2021/5/26 11:17
 * @Description ：
 */
@SpringBootApplication
@EnableDiscoveryClient
public class TeacherMain {
    public static void main(String[] args) {
        SpringApplication.run(TeacherMain. class,args);
    }
}
