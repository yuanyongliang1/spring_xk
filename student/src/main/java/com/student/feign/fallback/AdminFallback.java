package com.student.feign.fallback;


import com.select.pojo.vo.TeacherCourseVo;
import com.student.feign.AdminFeign;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class AdminFallback implements AdminFeign {
    @Override
    public List<TeacherCourseVo> select(String teaAccount) {
        return null;
    }
}
