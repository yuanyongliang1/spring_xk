package com.teacher.service;

import com.select.pojo.Courses;
import com.select.pojo.vo.StudentVo;

import java.util.List;

public interface CoursesService {

    /**
     * 根据工号  查看该老师所有课程
     * @param teaAccount
     * @return
     */
    List<Courses> findAll(String teaAccount);

    /**
     * 查看该课程所有信息
     * @param couId
     * @return
     */
    Courses findone(String couId);

    /**
     * 更新课程信息
     * @param couTime
     * @param couWeek
     * @param crPlace
     * @param couIntroduce
     * @param couId
     * @return
     */
    Integer edit(String couTime, String couWeek, String crPlace, String couIntroduce, String couId);

    int enterScore(List<StudentVo> list);
}
