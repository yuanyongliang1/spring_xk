package com.zys.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.select.pojo.Semester;
import com.select.utils.CommonResult;
import com.zys.pojo.Admin;
import com.zys.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @USER 张英帅
 * @date 2021/5/26 - 10:59
 */
@RestController
@RequestMapping("admin")
@CrossOrigin
public class SemesterController {

    @Autowired
    private SemesterService semesterService;

    //查询所有学期数据
    @GetMapping("getSemAll")
    public Map<String, Object> getSemAll(@RequestParam(value = "page",defaultValue = "1")Integer pn,
                                         @RequestParam(value = "limit",defaultValue = "10")Integer limit){
        PageHelper.startPage(pn,limit);//startPage后面紧跟的这个查询就是分页查询了
        List<Semester> semList = semesterService.getSemAll();
        PageInfo page = new PageInfo(semList,limit);
        Map<String,Object> pageMap = new HashMap<>();
        pageMap.put("code",200);
        pageMap.put("msg","处理成功");
        pageMap.put("data",page.getList());
        pageMap.put("count",page.getTotal());
        return pageMap;
    }
    //获取xx学期-xx学期
    @GetMapping("getMaxSem")
    public String getSems(){
        return semesterService.getMaxSem();
    }
    //添加学期规则
    @PostMapping("addSem")
    public CommonResult addSem(Semester semester){
        int i = semesterService.addSem(semester);
        if(i > 0){
            return CommonResult.ok("添加成功",i);
        }
        return CommonResult.ok("添加失败",null);
    }
    //修改学期规则
    @PostMapping("updateSem")
    public CommonResult updateSem(Semester semester){
        int i = semesterService.updateSem(semester);
        if(i > 0){
            return CommonResult.ok("修改成功",i);
        }
        return CommonResult.ok("修改失败",null);
    }


}
