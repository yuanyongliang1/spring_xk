package com.zys.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.select.pojo.Teacher;
import com.select.utils.CommonResult;
import com.zys.feign.TeacherFeignService;
import com.zys.pojo.Admin;
import com.zys.service.AdminService;
import com.zys.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @USER 张英帅
 * @date 2021/5/18 - 16:48
 */
@RestController
@CrossOrigin
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private TeacherFeignService teacherFeignService;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    //登陆验证
    @PostMapping("/login")
    @SentinelResource(value = "login")
    public CommonResult adminLogin(Admin admin){
        Admin getAdmin = adminService.adminLogin(admin);
        if(getAdmin != null){
            String token = UUID.randomUUID() + "";
            System.out.println(token);
            this.redisTemplate.opsForValue().set(token,getAdmin, Duration.ofMinutes(30L));
            return CommonResult.ok("登陆成功",getAdmin);
        }
        return CommonResult.ok("账号密码错误或不存在",null);
    }
    //管理员修改个人密码
    @PutMapping("/updateAdmPass")
    @SentinelResource(value = "updateAdmPass")
    public CommonResult updateAdmPass(Admin admin){
        int i = adminService.updateAdmPass(admin);
        if(i > 0){
            return CommonResult.ok("修改成功",i);
        }
        return CommonResult.ok("修改失败",null);
    }
    //查询所有管理员--也可条件查询
    @GetMapping("/getAdmin")
    @SentinelResource(value = "getAdmin")
    public CommonResult getAdmin(Admin admin,String admLoginAcc){
        List<Admin> adminList = null;
        //判断搜索框是否为空，不为空就查找该字段的人，为空就查找除登陆账号以外的所有数据
        if(admin.getAdmAccount() == ""){
            adminList = adminService.getAdminAllButOwn(admLoginAcc);
        }else{
            adminList = adminService.getAdmin(admin);
        }

        if(adminList != null){
            return CommonResult.ok("查询成功",adminList);
        }
        return CommonResult.ok("查询失败，无数据或无此人",null);
    }
    //查询所有管理员但排除登陆的账号
    @GetMapping("/getAdminAllButOwn/{acc}")
    @SentinelResource(value = "/getAdminAllButOwn/{acc}")
    public Map<String, Object> getAdminAllButOwn(@PathVariable("acc")String admAccount,
                                          @RequestParam(value = "page",defaultValue = "1")Integer pn,
                                          @RequestParam(value = "limit",defaultValue = "10")Integer limit){
        PageHelper.startPage(pn,limit);//startPage后面紧跟的这个查询就是分页查询了
        List<Admin> adminList = adminService.getAdminAllButOwn(admAccount);
        PageInfo page = new PageInfo(adminList,limit);
        Map<String,Object> pageMap = new HashMap<>();
        pageMap.put("code",200);
        pageMap.put("msg","处理成功");
        pageMap.put("data",page.getList());
        pageMap.put("count",page.getTotal());
        return pageMap;
    }
    //删除管理
    @DeleteMapping("/deleteAdminByAcc/{admAccount}")
    @SentinelResource(value = "/deleteAdminByAcc/{admAccount}")
    public CommonResult deleteAdmin(@PathVariable("admAccount") String admAccount){
        int i = adminService.deleteAdmin(admAccount);
        if(i > 0){
//            List<Teacher> teaByAn = teacherService.getTeaByAccount(admAccount);
            List<Teacher> teaByAn = teacherFeignService.getTeaByAccList(admAccount);
            if(!teaByAn.isEmpty() || teaByAn != null){
                int i1 = teacherService.updateTeaLev("0", admAccount);
                if(i1>0){
                    return CommonResult.ok("删除成功",i1);
                }
            }else{
                return CommonResult.ok("删除成功",i);
            }
        }
        return CommonResult.ok("删除失败",null);
    }

    //授权老师添加管理员
    @PostMapping("/addAdmin")
    @SentinelResource(value = "addAdmin")
    public CommonResult addAdmin(Admin admin){
        int i = adminService.addAdmin(admin);
        if(i > 0){
            int i1 = teacherService.updateTeaLev(admin.getAdmLev(), admin.getAdmAccount());
            if(i1 > 0){
                return CommonResult.ok("授权成功",i1);
            }
        }
        return CommonResult.ok("授权失败",null);
    }

}
