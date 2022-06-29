package com.teacher.mapper;

import com.select.pojo.Courses;
import com.select.pojo.vo.StudentVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Monster
 */
@Mapper
public interface CoursesMapper {

    /**
     * 根据工号  查看该老师所有课程
     * @param teaAccount
     * @return
     */
    @Select("select * from courses where tea_account=#{teaAccount}")
    List<Courses> findAll(String teaAccount);

    /**
     * 查看该课程所有信息
     * @param couId
     * @return
     */
    @Select("select * from courses where cou_id=#{cou_id}")
    Courses findone(String couId);

    /**
     * 更新课程信息
     * @param couTime
     * @param couWeek
     * @param crPlace
     * @param couIntroduce
     * @param couId
     * @return
     */
    @Update("update courses set cou_time=#{couTime},cou_week=#{couWeek},cr_place=#{crPlace},cou_introduce=#{couIntroduce} where cou_id=#{couId}")
    Integer edit(@Param("couTime") String couTime,
                 @Param("couWeek") String couWeek,
                 @Param("crPlace") String crPlace,
                 @Param("couIntroduce") String couIntroduce,
                 @Param("couId") String couId);

    /**
     * 添加学生成绩
     * @param studentVo
     * @return
     */
    @Insert("INSERT INTO achievement (stu_account,ach_end) VALUE (stuAccount,achEnd)")
    int enterScore(StudentVo studentVo);
}
