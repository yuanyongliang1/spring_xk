package com.zys.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.select.pojo.Teacher;
import com.select.utils.CommonResult;
import com.zys.feign.TeacherFeignService;
import com.zys.pojo.Admin;
import com.zys.pojo.enums.Colleges;
import com.zys.service.AdminService;
import com.zys.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @USER 张英帅
 * @date 2021/5/25 - 10:25
 */
@RestController
@CrossOrigin
@RequestMapping("/admin")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private TeacherFeignService teacherFeignService;

    //查询所有教师
    @GetMapping("/getTeaAll")
    public Map<String, Object> getTeaAll(@RequestParam(value = "page",defaultValue = "1")Integer pn,
                                         @RequestParam(value = "limit",defaultValue = "10")Integer limit){
        /*PageHelper.startPage(pn,limit);//startPage后面紧跟的这个查询就是分页查询了
        List<Teacher> teaList = teacherFeignService.getTeaAll();
        PageInfo page = new PageInfo(teaList,limit);
        Map<String,Object> pageMap = new HashMap<>();
        pageMap.put("code",200);
        pageMap.put("msg","处理成功");
        pageMap.put("data",page.getList());
        pageMap.put("count",page.getTotal());*/
        Map<String, Object> teaAll = teacherFeignService.getTeaAll(pn, limit);
        return teaAll;
    }

    //通过姓名或账号搜索教师
    @PostMapping("getTeaByAn")
    public CommonResult getTeaByAn(@RequestParam("an") String an){
//        return CommonResult.ok("查询成功",teacherService.getTeaByAn(an));
        List<Teacher> teaByAn = teacherFeignService.getTeaByAn(an);
        System.out.println(an);
        System.out.println(teacherFeignService.getTeaByAn(an));
        if(teaByAn == null){
            return CommonResult.ok("查询成功",null);
        }
        return CommonResult.ok("查询成功",teaByAn);
    }
    //拿到枚举类各学院的列表
    @GetMapping("getColleges")
    public CommonResult getColleges(){
        List list = Lists.newArrayList();//Lists.newArrayList()其实和new ArrayList()几乎一模
        //  一样, 唯一它帮你做的(其实是javac帮你做的), 就是自动推导(不是"倒")尖括号里的数据类型.
        for (Colleges colleges : Colleges.values()) {
//            枚举类中有多个属性的时候推荐使用Map方便查找查寻
//            Map<String, Object> map = new HashMap<String, Object>();
//            map.put("collegesName", colleges.getCollegeName());
            list.add(colleges.getCollegeName());
        }
        return CommonResult.ok("success",list);
    }

    //通过账号查询教师
    @PostMapping("getTeaByAcc")
    public CommonResult getTeaByAcc(String account){
        System.out.println(account);
        List<Teacher> teaByAccount = teacherFeignService.getTeaByAccList(account);
        System.out.println("----------------------");
        System.out.println(teaByAccount);
        if(teaByAccount == null){
            return CommonResult.common1(400);
        }
        return CommonResult.common1(200);
//        return teacherFeignService.getTeaByAcc(account);

    }
    //添加教师
    @PostMapping("addTea")
    public CommonResult addTea(Teacher teacher){
        System.out.println(teacher);
        int i = teacherService.addTea(teacher);
        if(teacher.getTeaLev() != 0){
            Admin admin = new Admin();
            admin.setAdmAccount(teacher.getTeaAccount());
            if(teacher.getTeaLev() == 1){
                admin.setAdmDepartment(null);
            }else{
                admin.setAdmDepartment(teacher.getTeaDepartment());
            }
            admin.setAdmLev(String.valueOf(teacher.getTeaLev()));
            admin.setAdmName(teacher.getTeaName());
            admin.setAdmPassword(teacher.getTeaPassword());
            int i1 = adminService.addAdmin(admin);
            if(i1>0){
                System.out.println("添加教师时的管理员级别添加成功");
            }
        }
        if(i > 0){
            return CommonResult.ok("添加成功",i);
        }
        return CommonResult.ok("出错啦添加失败",null);
    }

}
