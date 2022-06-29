package com.teacher.mapper;

import com.select.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * @author Monster
 */
@Mapper
public interface StudentMapper {

    /**
     * 查看学生该课成绩
     * @param couId
     * @return
     */
    @Select("select * from student where stu_account=(select stu_account from student_elective where cou_id=#{cou_id})")
    List<Student> findstu(String couId);
}
