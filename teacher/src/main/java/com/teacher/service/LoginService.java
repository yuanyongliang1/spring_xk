package com.teacher.service;

import com.select.pojo.Teacher;
import org.apache.ibatis.annotations.Param;


public interface LoginService {

    /**
     * 查找老师
     * @param teacher
     * @return
     */
    Teacher find(Teacher teacher);

    /**
     * 查看老师信息
     * @param teaAccount
     * @return
     */
    Teacher findOneTea(String teaAccount);

    /**
     * 修改老师等级
     * @param teaLev
     * @param teaAccount
     * @return
     */
    Integer up(@Param("teaLev") String teaLev, @Param("teaAccount") String teaAccount);
}
