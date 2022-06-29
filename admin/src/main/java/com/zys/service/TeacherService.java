package com.zys.service;

import com.select.pojo.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @USER 张英帅
 * @date 2021/5/25 - 10:14
 */
@Repository
public interface TeacherService {
/*    //查询教师
    List<Teacher> getTea();
    //搜索老师（通过账号或姓名,合二为一）
    List<Teacher> getTeaByAn(String an);
    //搜索老师（通过账号）
    List<Teacher> getTeaByAccount(String account);*/
    //修改教师授权状态
    int updateTeaLev(String teaLev, String teaAccount);
    //添加老师
    int addTea(Teacher teacher);

}
