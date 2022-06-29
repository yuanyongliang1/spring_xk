package com.teacher.mapper;

import com.select.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author zhanglei
 */
@Mapper
public interface LoginMapper {

    /**
     * 查找老师
     * @param teacher
     * @return
     */
    @Select("select * from teacher where tea_account = #{teaAccount} and tea_password = #{teaPassword}")
    Teacher find(Teacher teacher);

    /**
     * 查看老师信息
     * @param teaAccount
     * @return
     */
    @Select("select * from teacher where tea_account=#{teaAccount}")
    Teacher findOneTea(@Param("teaAccount") String teaAccount);

    /**
     * 修改老师等级
     * @param teaLev
     * @param teaAccount
     * @return
     */
    @Update("update teacher set tea_lev=#{teaLev} where tea_account=#{teaAccount}")
    Integer up(@Param("teaLev") String teaLev, @Param("teaAccount") String teaAccount);
}
