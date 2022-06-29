package com.student.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.select.pojo.Student;
import com.select.pojo.vo.AchievementVo;
import com.select.pojo.vo.ElectiveVo;
import com.select.pojo.vo.SelVo;
import com.select.pojo.vo.TeacherCourseVo;
import com.select.utils.CommonResult;
import com.student.feign.AdminFeign;
import com.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private AdminFeign adminFeign;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 学生登录
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/login")
    @SentinelResource("login")
    public CommonResult login(String username, String password) {
        Student student = this.studentService.studentLogin(username, password);
        if (student != null) {
            String token = UUID.randomUUID() + "";
            System.out.println(token);
            this.redisTemplate.opsForValue().set(token, student, Duration.ofMinutes(30L));
            return CommonResult.common1(200, token, "操作成功");
        } else {
            return CommonResult.error(null, "没有此学生");
        }
    }

    /**
     * 验证登录
     *
     * @param request
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping({"/getStudentLogin"})
    @SentinelResource("getStudentLogin")
    public CommonResult getStudentLogin(HttpServletRequest request) throws UnsupportedEncodingException {
        String token = request.getHeader("token");
        Object stu = this.redisTemplate.opsForValue().get(token);
        if (stu != null) {
            return CommonResult.ok(200, stu, "获取登录用户成功");
        }
        return CommonResult.ok(104, null, "获取登录用户失败");
    }

    /**
     * 查询所有选课
     *
     * @param couGrade
     * @param couDepartment
     * @param couDepartment2
     * @param couWeek
     * @param couTime
     * @param request
     * @param stuAccount
     * @return
     */
    @GetMapping({"/getCourse"})
    public CommonResult getCourse(String couGrade, String couDepartment, String couDepartment2,
                                  String couWeek, String couTime, HttpServletRequest request,
                                  String stuAccount) {
        String token = request.getHeader("token");
        Object stu = this.redisTemplate.opsForValue().get(token);
        System.out.println(stu);
        if (stu != null) {
            token = token == null ? "" : token;
            //获取token令牌有效时间
            Long expire = redisTemplate.getExpire(token);
            if (expire > 0) {
                //重置token令牌时间
                redisTemplate.expire(token, 30L, TimeUnit.MINUTES);
                List<SelVo> list = this.studentService.getCourse(couGrade, couDepartment, couDepartment2, couWeek, couTime, stuAccount);
                return CommonResult.ok(200, list, "成功");
            } else {
                return CommonResult.ok(104, null, "登陆失效，请重新登录");
            }
        }
        return CommonResult.ok(104, null, "获取登录用户失败");
    }

    /**
     * 插入学生选课信息
     *
     * @param stuAccount
     * @param couId
     * @param stuName
     * @param couStuNum
     * @return
     */
    @PostMapping({"/insertCouser"})
    @SentinelResource("insertCouser")
    public Integer insertCouser(String stuAccount, String couId, String stuName, Integer couStuNum, HttpServletRequest request) {
        String token = request.getHeader("token");
        System.out.println(token);
        Object stu = this.redisTemplate.opsForValue().get(token);
        System.out.println(stu);
        if (stu != null) {
            token = token == null ? "" : token;
            //获取token令牌有效时间
            Long expire = redisTemplate.getExpire(token);
            if (expire > 0) {
                Integer i = this.studentService.insertcouser(stuAccount, couId, stuName, couStuNum);
                return i;
            }
        }
        return 0;
    }

    /**
     * 查询学生选课信息
     *
     * @param stuAccount
     * @param courseFlag
     * @return
     */
    @GetMapping({"/selectele"})
    @SentinelResource("selectele")
    public CommonResult selectele(String stuAccount, String courseFlag, HttpServletRequest request) {
        String token = request.getHeader("token");
        Object stu = this.redisTemplate.opsForValue().get(token);
        if (stu != null) {
            token = token == null ? "" : token;
            //获取token令牌有效时间
            Long expire = redisTemplate.getExpire(token);
            if (expire > 0) {
                ElectiveVo selectele = this.studentService.selectele(stuAccount, courseFlag);
                List list = new ArrayList();
                list.add(selectele);
                return CommonResult.ok(200, list, "查看学生选课成功");
            }
        }
        return CommonResult.ok(104, null, "登录失效，请重新登录");
    }

    /**
     * 查询学生成绩
     *
     * @param stuAccount
     * @param semester
     * @return
     */
    @GetMapping({"/selectach"})
    public CommonResult selectach(String stuAccount, String semester, HttpServletRequest request) {
        String token = request.getHeader("token");
        Object stu = this.redisTemplate.opsForValue().get(token);
        if (stu != null) {
            token = token == null ? "" : token;
            //获取token令牌有效时间
            Long expire = redisTemplate.getExpire(token);
            if (expire > 0) {
                List<AchievementVo> selectach = this.studentService.selectach(stuAccount, semester);
                return CommonResult.ok(200, selectach, "查看成绩成功");
            }
        }
        return CommonResult.ok(104, null, "查看成绩成功");
    }

    /**
     * 查询学期
     *
     * @return
     */
    @GetMapping({"/selectSem"})
    @SentinelResource("selectSem")
    public CommonResult selectSem(HttpServletRequest request) {
        String token = request.getHeader("token");
        Object stu = this.redisTemplate.opsForValue().get(token);
        if (stu != null) {
            token = token == null ? "" : token;
            //获取token令牌有效时间
            Long expire = redisTemplate.getExpire(token);
            if (expire > 0) {
                List<String> semesters = this.studentService.selectSem();
                return CommonResult.ok(200, semesters, "查看学期成功");
            }
        }
        return CommonResult.ok(104, null, "登录失效，请重新登录");
    }

    /**
     * 调用老师的端口
     *
     * @param teaAccount
     * @return
     */
    @GetMapping("/teacher/selectCou")
    @SentinelResource("teacher/selectCou")
    public List<TeacherCourseVo> select1(String teaAccount, HttpServletRequest request) {
        String token = request.getHeader("token");
        Object stu = this.redisTemplate.opsForValue().get(token);
        if (stu != null) {
            token = token == null ? "" : token;
            //获取token令牌有效时间
            Long expire = redisTemplate.getExpire(token);
            if (expire > 0) {
                List<TeacherCourseVo> select = adminFeign.select(teaAccount);
                return select;
            }
        }
        return null;
    }

    /**
     * 退课
     * @param stuAccount
     * @param couId
     * @return
     * @throws ParseException
     */
    @GetMapping("/delCouser")
    public Integer delCouser(String stuAccount,String couId) throws ParseException {
        System.out.println(stuAccount);
        System.out.println(couId);
        return studentService.delCourse(stuAccount,couId);
    }
}
