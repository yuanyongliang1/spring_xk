package com.zys.mapper;

import com.select.pojo.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @USER 张英帅
 * @date 2021/5/24 - 9:53
 */
@Repository
public interface TeacherMapper {

    /**
     * 查询所有教师，或通过教师姓名或账号查询
     * @param teaAccount 账号（精准查询）
     * @param teaName 姓名（模糊查询）
     * @return
     */
 /*   @Select("<script> select tea_account,tea_password,tea_department,tea_name,tea_lev from teacher"+
            "<where>"+
            "<if test='teaAccount != null'> and tea_account = #{teaAccount}</if>"+
            "<if test='teaName != null'> and tea_name like concat('%',#{teaName},'%')</if>"+
            "</where>"+
            "</script>"
    )
    List<Teacher> getTea(@Param("teaAccount") String teaAccount, @Param("teaName") String teaName);*/

    /**
     * 修改教师的授权状态
     * @param teaAccount 通过教师账号查询
     */
    @Update("update teacher set tea_lev = #{teaLev} where tea_account = #{teaAccount}")
    int updateTeaLev(@Param("teaLev") String teaLev, @Param("teaAccount") String teaAccount);

    /**
     * 添加教师
     * @param teacher 对象参数
     * @return
     */
    @Insert("insert into teacher(tea_account,tea_password,tea_name,tea_lev,tea_department) values (#{teaAccount},#{teaPassword},#{teaName},#{teaLev},#{teaDepartment})")
    int addTea(Teacher teacher);
}
