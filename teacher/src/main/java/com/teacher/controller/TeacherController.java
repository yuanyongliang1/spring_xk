package com.teacher.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.select.pojo.Teacher;
import com.select.utils.CommonResult;
import com.teacher.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @USER 张磊
 * @date 2021/5/29 - 15:31
 */
@RestController
@CrossOrigin
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    //查询所有教师
    @GetMapping("/getTeaAll")
    public Map<String, Object> getTeaAll(Integer page,Integer limit){
        PageHelper.startPage(page,limit);//startPage后面紧跟的这个查询就是分页查询了
        List<Teacher> teaList = teacherService.getTea();
        PageInfo pages = new PageInfo(teaList,limit);
        Map<String,Object> pageMap = new HashMap<>();
        pageMap.put("code",200);
        pageMap.put("msg","处理成功");
        pageMap.put("data",pages.getList());
        pageMap.put("count",pages.getTotal());
        return pageMap;
    }
/*   @GetMapping("/getTeaAll")
   public List<Teacher> getTeaAll(){
       List<Teacher> teaList = teacherService.getTea();
       return teaList;
   }*/

    //通过姓名或账号搜索教师
    @PostMapping("getTeaByAn")
    public List<Teacher> getTeaByAn(String an){
        System.out.println("-------an--------");
        System.out.println(an);
        System.out.println(teacherService.getTeaByAn(an));
        return teacherService.getTeaByAn(an);

    }
    //通过账号查询教师
    @PostMapping("getTeaByAcc")
    public CommonResult getTeaByAcc(@RequestBody String account){
        List<Teacher> teaByAccount = teacherService.getTeaByAccount(account);
        if(teaByAccount.isEmpty()){
            return CommonResult.common1(400);
        }
        return CommonResult.common1(200);

    }
    //通过账号查询教师
    @PostMapping("getTeaByAccList")
    public List<Teacher> getTeaByAccList(@RequestBody String account){
        System.out.println(account);
        List<Teacher> teaByAccount = teacherService.getTeaByAccount(account);
        if(teaByAccount.isEmpty()){
            return null;
        }
        System.out.println("++++++++++");
        System.out.println(teaByAccount);
        return teaByAccount;

    }
}
