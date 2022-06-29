package com.zys.service;

import com.select.pojo.Courses;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @USER 张英帅
 * @date 2021/5/29 - 10:02
 */
@Repository
public interface CourseService {

    //查询所有课程--条件查询
    List<Courses> getCourse(Courses courses);
    //审批课程
    int updateCourse(Courses courses);

}
