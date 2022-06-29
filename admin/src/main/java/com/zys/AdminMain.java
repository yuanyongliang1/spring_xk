package com.zys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author ：ZhangLei
 * @Data ：2021/5/17 16:06
 * @Description ：
 */
@SpringBootApplication
@MapperScan("com.zys.mapper")
@EnableDiscoveryClient
@EnableFeignClients
public class AdminMain {
    public static void main(String[] args) {
        SpringApplication.run(AdminMain.class,args);
    }
}
