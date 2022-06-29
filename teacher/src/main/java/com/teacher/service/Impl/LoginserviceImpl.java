package com.teacher.service.Impl;

import com.select.pojo.Teacher;
import com.teacher.mapper.LoginMapper;
import com.teacher.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class LoginserviceImpl implements LoginService {
    @Autowired
    LoginMapper loginMapper;
    @Override
    public Teacher find(Teacher teacher) {
        return loginMapper.find(teacher);
    }

    @Override
    public Teacher findOneTea(String teaAccount) {
        return loginMapper.findOneTea(teaAccount);
    }

    @Override
    public Integer up(@RequestParam String teaLev, @RequestParam String teaAccount) {
        return loginMapper.up(teaLev,teaAccount);
    }

}
