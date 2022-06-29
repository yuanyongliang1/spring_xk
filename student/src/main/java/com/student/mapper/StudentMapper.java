package com.student.mapper;

import com.select.pojo.Semester;
import com.select.pojo.Student;

import com.select.pojo.StudentElective;
import com.select.pojo.vo.AchievementVo;
import com.select.pojo.vo.ElectiveVo;
import com.select.pojo.vo.SelVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;


@Mapper
public interface StudentMapper {
    /**
     * 学生登录
     *
     * @param stuAccount
     * @param stuPassword
     * @return 学生信息
     */

    public Student studentLogin(@Param("stuAccount") String stuAccount,
                                @Param("stuPassword") String stuPassword);

    /**
     * 查询课程 已选课程不会显示
     * couDepartment 和 couDepartment2 每次只能传一个
     *
     * @param couGrade       级别
     * @param couDepartment  属于那个学院
     * @param couDepartment2 选择的课程级别 校级或者本学院的
     * @param couWeek        周几
     * @param couTime        每天的上课时间
     * @param stuAccount     学生账号
     * @return
     */
    List<SelVo> getCourse(@Param("couGrade") String couGrade,
                          @Param("couDepartment") String couDepartment,
                          @Param("couDepartment2") String couDepartment2,
                          @Param("couWeek") String couWeek,
                          @Param("couTime") String couTime,
                          @Param("stuAccount") String stuAccount);

    /**
     * 插入学生选课
     *
     * @param stuAccount
     * @param couId
     * @param stuName
     * @param courseFlag
     * @param timeStamp
     * @return
     */
    Integer insertcouser(@Param("stuAccount") String stuAccount,
                         @Param("couId") String couId,
                         @Param("stuName") String stuName,
                         @Param("courseFlag") String courseFlag,
                         @Param("timeStamp") Date timeStamp);

    /**
     * 查看选课时间
     *
     * @return
     */
    Semester selectData();

    /**
     * 查看学生已选的课程
     *
     * @param stuAccount
     * @return
     */
    ElectiveVo selectele(@Param("stuAccount") String stuAccount,
                         @Param("courseFlag") String courseFlag);


    /**
     * 更新课程人数
     *
     * @param couId
     * @param couStuNum
     * @return
     */
    Integer upCourse(@Param("couId") String couId,
                     @Param("couStuNum") Integer couStuNum);


    /**
     * 查询成绩
     *
     * @param stuAccount
     * @param semester
     * @return
     */
    List<AchievementVo> selectach(@Param("stuAccount") String stuAccount,
                                  @Param("semester") String semester);

    /**
     * 展示学期
     */
    List<String> selectSem();

    StudentElective selectstuele(@Param("stuAccount")String stuAccount,@Param("couId")String couId);
    /**
     * 学生退课
     * @param stuAccount
     * @param couId
     * @return
     */
    Integer delCourse(@Param("stuAccount")String stuAccount,@Param("couId")String couId);

}
