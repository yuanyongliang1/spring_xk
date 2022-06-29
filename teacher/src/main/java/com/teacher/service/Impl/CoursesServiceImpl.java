package com.teacher.service.Impl;

import com.select.pojo.Courses;
import com.select.pojo.vo.StudentVo;
import com.teacher.mapper.CoursesMapper;
import com.teacher.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesServiceImpl implements CoursesService {
    @Autowired
    CoursesMapper coursesMapper;

    @Override
    public List<Courses> findAll(String teaAccount) {
        return coursesMapper.findAll(teaAccount);
    }

    @Override
    public Courses findone(String couId) {
        return coursesMapper.findone(couId);
    }

    @Override
    public Integer edit(String couTime, String couWeek, String crPlace, String couIntroduce, String couId) {
        return coursesMapper.edit(couTime,couWeek,crPlace,couIntroduce,couId);
    }

    @Override
    public int enterScore(List<StudentVo> list) {
        for (StudentVo o : list) {
            coursesMapper.enterScore(o);
        }
        return 0;
    }


}
