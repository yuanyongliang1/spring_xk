package com.teacher.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.select.pojo.Teacher;
import com.teacher.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.UUID;

/**
 * @author zhanglei
 */
@CrossOrigin
@Controller
public class LoginController {

    @Autowired
    LoginService loginService;
    Teacher teacher;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 登录接口
     * @param teacher
     * @return
     */
    @GetMapping("/denglu")
    @SentinelResource("denglu")
    @ResponseBody
    public String denglu(Teacher teacher) {
        System.out.println(teacher);
        if (loginService.find(teacher) == null) {
            return "fail";
        } else {
            String token = UUID.randomUUID() + "";
            System.out.println(token);
            this.redisTemplate.opsForValue().set(token, loginService.find(teacher), Duration.ofMinutes(30L));
            return "success";
        }

    }
}
