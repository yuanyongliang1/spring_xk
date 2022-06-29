package com.teacher.mapper;

import com.select.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @USER 张磊
 * @date 2021/5/29 - 15:26
 */
@Mapper
public interface TeacherMapper {

    /**
     * 查询所有教师，或通过教师姓名或账号查询
     * @param teaAccount 账号（精准查询）
     * @param teaName 姓名（模糊查询）
     * @return
     */
    @Select("<script> select tea_account,tea_password,tea_department,tea_name,tea_lev from teacher"+
            "<where>"+
            "<if test='teaAccount != null'> and tea_account = #{teaAccount}</if>"+
            "<if test='teaName != null'> and tea_name like concat('%',#{teaName},'%')</if>"+
            "</where>"+
            "</script>"
    )
    List<Teacher> getTea(@Param("teaAccount") String teaAccount, @Param("teaName") String teaName);
}
