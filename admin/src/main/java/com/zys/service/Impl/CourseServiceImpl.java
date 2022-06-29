package com.zys.service.Impl;

import com.select.pojo.Courses;
import com.zys.mapper.CourseMapper;
import com.zys.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @USER 张英帅
 * @date 2021/5/29 - 10:03
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Courses> getCourse(Courses courses) {
        System.out.println(courses);
        System.out.println(courses.getCouDepartment());
        if("null".equals(courses.getCouDepartment()) || courses.getCouDepartment() == null){
            courses.setCouDepartment("校级");
        }
        if(courses.getCouName() == ""){
            courses.setCouName(null);
        }
        if(courses.getTeaAccount() == ""){
            courses.setTeaAccount(null);
        }
        System.out.println(courses);
        return courseMapper.getCourse(courses);
    }

    @Override
    public int updateCourse(Courses courses) {
        return courseMapper.updateCourse(courses);
    }
}
