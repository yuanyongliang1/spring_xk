package com.student.feign;


import com.select.pojo.vo.TeacherCourseVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@FeignClient(value = "adminer", fallback = AdminFeign.class)
@Component
public interface AdminFeign {
    @GetMapping("/teacher/teacherSelect")
    public List<TeacherCourseVo> select(String teaAccount);
}
