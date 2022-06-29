package com.teacher.service;

import com.select.pojo.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @USER 张磊
 * @date 2021/5/29 - 15:27
 */
@Repository
public interface TeacherService {

    //查询教师
    List<Teacher> getTea();

    //搜索老师（通过账号或姓名,合二为一）
    List<Teacher> getTeaByAn(String an);

    //搜索老师（通过账号）
    List<Teacher> getTeaByAccount(String account);
}
