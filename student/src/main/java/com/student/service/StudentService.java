package com.student.service;

import com.select.pojo.Student;
import com.select.pojo.vo.AchievementVo;
import com.select.pojo.vo.ElectiveVo;
import com.select.pojo.vo.SelVo;


import java.text.ParseException;
import java.util.List;

/**
 * @ClassName StudentService
 * @Description TODO
 * @Author 袁永亮
 * @Date 2021/5/18 9:13
 **/
public interface StudentService {
    /**
     * 学生登录
     *
     * @param stuAccount
     * @param stuPassword
     * @return
     */
    public Student studentLogin(String stuAccount, String stuPassword);


    /**
     * 查询课程
     * couDepartment 和 couDepartment2 每次只能传一个
     *
     * @param couGrade
     * @param couDepartment
     * @param couDepartment2
     * @param couWeek
     * @param couTime
     * @param stuAccount
     * @return
     */
    List<SelVo> getCourse(String couGrade,
                          String couDepartment,
                          String couDepartment2,
                          String couWeek,
                          String couTime,
                          String stuAccount);

    /**
     * 插入学生所选课程
     *
     * @param stuAccount
     * @param couId
     * @param stuName
     * @return
     */
    Integer insertcouser(String stuAccount,
                         String couId,
                         String stuName,
                         Integer couStuNum);

    /**
     * 查看学生所选课程
     *
     * @param stuAccount
     * @param courseFlag
     * @return
     */
    ElectiveVo selectele(String stuAccount, String courseFlag);


    /**
     * 查询成绩
     *
     * @param stuAccount
     * @param semester
     * @return
     */
    List<AchievementVo> selectach(String stuAccount, String semester);

    /**
     * 查看所有学期
     *
     * @return
     */
    List<String> selectSem();

    /**
     * 学生退课
     * @param stu_account
     * @param cou_id
     * @return
     */
    Integer delCourse(String stu_account,String cou_id) throws ParseException;
}
