package com.student.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import com.select.pojo.Student;
import com.select.pojo.StudentElective;
import com.select.pojo.vo.AchievementVo;
import com.select.pojo.vo.ElectiveVo;
import com.select.pojo.vo.SelVo;
import com.student.mapper.StudentMapper;
import com.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @ClassName StudentServiceImpl
 * @Description TODO
 * @Author 袁永亮
 * @Date 2021/5/18 9:13
 **/
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentDao;

    /**
     * 学生登录
     *
     * @param stuAccount
     * @param stuPassword
     * @return
     */
    // 服务熔断
    @HystrixCommand(fallbackMethod = "paymentInfo_Circuit", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),// 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50")// 失败率
            // 加起来就是在10s内的10次请求中如果失败超过6次进入服务熔断
    })
    @Override
    public Student studentLogin(String stuAccount, String stuPassword) {
        return studentDao.studentLogin(stuAccount, stuPassword);
    }

    public Student paymentInfo_Circuit(String stuAccount, String stuPassword) {
        return new Student();
    }


    @Override
    public List<SelVo> getCourse(String couGrade, String couDepartment,
                                 String couDepartment2, String couWeek,
                                 String couTime, String stuAccount) {
//        将空字符串转换为null   空字符串在前面，防止报空指针异常
        if ("".equals(couGrade)) {
            couGrade = null;
        }
        if ("".equals(couDepartment)) {
            couDepartment = null;
        }
        if ("".equals(couDepartment2)) {
            couDepartment2 = null;
        }
        if ("".equals(couWeek)) {
            couWeek = null;
        }
        if ("".equals(couTime)) {
            couTime = null;
        }
        return studentDao.getCourse(couGrade, couDepartment, couDepartment2, couWeek, couTime, stuAccount);
    }

    /**
     * 插入学生选课
     *
     * @param stuAccount
     * @param couId
     * @param stuName
     * @return
     */
    @Override
    public Integer insertcouser(String stuAccount, String couId, String stuName, Integer couStuNum) {
        Date date = new Date();
         /*//查询选课时间
        Semester semester = selMapper.selectData();
        //选课开始时间
        Date selStartTime = semester.getSelStartTime();
        //选课结束时间
        Date selOverTime = semester.getSelOverTime();
        if(date.compareTo(selStartTime) == -1){
            System.out.println("还未到选课时间");
        }else if(selOverTime.compareTo(selStartTime) == -1){
            System.out.printf("选课时间已经结束");
        }*/
        String courseFlag = "learn";
        Integer res = studentDao.upCourse(couId, ++couStuNum);
        Integer i = studentDao.insertcouser(stuAccount, couId, stuName, courseFlag, date);
        if (res.equals(i)) {
            return 1;
        }
        return 0;
    }

    /**
     * 查询学生已选课程
     *
     * @param stuAccount
     * @param courseFlag
     * @return
     */
    @Override
    public ElectiveVo selectele(String stuAccount, String courseFlag) {
        ElectiveVo selectele = studentDao.selectele(stuAccount, courseFlag);
        return selectele;
    }


    /**
     * 查询成绩
     *
     * @param stuAccount
     * @param semester
     * @return
     */
    @Override
    public List<AchievementVo> selectach(String stuAccount, String semester) {
        return studentDao.selectach(stuAccount, semester);
    }

    /**
     * 查看所有学期
     *
     * @return
     */
    @Override
    public List<String> selectSem() {
        return studentDao.selectSem();
    }

    /**
     * 学生退课
     *
     * @param stu_account
     * @param cou_id
     * @return
     */
    @Override
    public Integer delCourse(String stu_account, String cou_id) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //查询时间戳
        StudentElective selectstuele = studentDao.selectstuele(stu_account, cou_id);
        String timeStamp = String.valueOf(selectstuele.getTimeStamp());
        String replace = timeStamp.replace("T", " ");
        //判断选课是否已过24小时
            //判断开始时间
            Date start = sdf.parse(replace);
            //判断结束时间
            Date date = new Date();
            String createTime = sdf.format(date);
            Date end = sdf.parse(createTime);
            long cha = end.getTime() - start.getTime();
            if (cha < 0) {
                return 0;
            }
            double result = cha * 1.0 / (1000 * 60 * 60);
            if (result <= 24) {
                //是小于等于 hour 小时
                return 0;
            } else {
                Integer integer = studentDao.delCourse(stu_account, cou_id);
                return integer;
            }
    }
}
