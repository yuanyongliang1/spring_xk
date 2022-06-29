package com.systop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName GatewayMain
 * @Description TODO
 * @Author 袁永亮
 * @Date 2021/5/18 21:08
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class GatewayMain {
    public static void main(String[] args) {
        SpringApplication.run(GatewayMain.class,args);
    }
}
