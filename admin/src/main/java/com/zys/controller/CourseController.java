package com.zys.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.select.pojo.Courses;
import com.select.pojo.Teacher;
import com.select.utils.CommonResult;
import com.zys.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @USER 张英帅
 * @date 2021/5/29 - 10:08
 */
@RestController
@RequestMapping("admin")
@CrossOrigin
public class CourseController {

    @Autowired
    private CourseService courseService;

    //查询所有课程--条件查询
    @GetMapping("/getCourse/{couDepartment}")
    public Map<String, Object> getCourse(@PathVariable("couDepartment")String couDepartment,
                                         @RequestParam(value = "page",defaultValue = "1")Integer pn,
                                         @RequestParam(value = "limit",defaultValue = "10")Integer limit,
                                         Courses courses){
        courses.setCouDepartment(couDepartment);
        PageHelper.startPage(pn,limit);//startPage后面紧跟的这个查询就是分页查询了
        List<Courses> couList = courseService.getCourse(courses);
        PageInfo page = new PageInfo(couList,limit);
        Map<String,Object> pageMap = new HashMap<>();
        pageMap.put("code",200);
        pageMap.put("msg","处理成功");
        pageMap.put("data",page.getList());
        pageMap.put("count",page.getTotal());
        return pageMap;
    }
    @PutMapping("updateCourses")
    public CommonResult updateCourse(Courses courses){

        System.out.println(courses);

        int i = courseService.updateCourse(courses);
        if(i > 0){
            return CommonResult.ok("审批成功",i);
        }
        return CommonResult.ok("审批出错啦",null);
    }

}
