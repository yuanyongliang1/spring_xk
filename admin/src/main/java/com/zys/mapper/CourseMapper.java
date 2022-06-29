package com.zys.mapper;

import com.select.pojo.Courses;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @USER 张英帅
 * @date 2021/5/29 - 9:55
 */
@Repository
public interface CourseMapper {

    //查询所有课程--条件查询
    @Select(
            "<script> select * from courses"+
                    "<where>"+
                    "cou_department like concat('%', #{couDepartment},'%')"+
                    "<if test='couName != null'> and cou_name like concat('%',#{couName},'%')</if>"+
                    "<if test='teaAccount != null'> and tea_account = #{teaAccount} </if>"+
                    "<if test='couGroup != null'> and cou_group = #{couGroup} </if>"+
                    "<if test='couState != null'> and cou_state = #{couState} </if>"+
                    "</where>"+
                    "</script>"
    )
    List<Courses> getCourse(Courses courses);

    @Update("update courses set cou_time =#{couTime},cou_week=#{couWeek},cou_lea_time=#{couLeaTime},cou_lea_num=#{couLeaNum}," +
            "cr_place=#{crPlace},cou_lev=#{couLev},cou_status=#{couStatus},cou_min_stu=#{couMinStu},cou_group=#{couGroup}," +
            "cou_grade=#{couGrade},cou_state=#{couState} where cou_id=#{couId}")
    int updateCourse(Courses courses);

}
