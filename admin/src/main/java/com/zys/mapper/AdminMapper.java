package com.zys.mapper;

import com.zys.pojo.Admin;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @USER 张英帅
 * @date 2021/5/18 - 16:02
 */
@Repository
public interface AdminMapper {
    /**
     * 数据库中查找admin是否存在
     * @param admin 前台账号输入的管理员账号信息
     * @return
     */
    @Select("select adm_account,adm_password,adm_lev,adm_department,adm_name from admin where adm_account=#{admAccount} and adm_password=#{admPassword}")
    Admin adminLogin(Admin admin);

    /**
     * 修改管理员个人信息（修改管理员密码，姓名）
     * @param admin 传入对象参数
     * @return
     */
    @Update("update admin set adm_password=#{admPassword},adm_name=#{admName} where adm_account=#{admAccount}")
    int updateAdmPass(Admin admin);

    /**
     * 查询所有--条件查询
     * @param admin 对象参数，可传可不传
     * @return
     */
    @Select("<script> select * from admin"+
            "<where>"+
            "<if test=\"admAccount != null \"> and adm_account = #{admAccount}</if>"+
            "<if test='admLev != null'> and adm_lev = #{admLev}</if>"+
            "<if test='admDepartment != null'> and adm_department = #{admDepartment}</if>"+
            "<if test='admName != null'> and adm_name = #{admName}</if>"+
            "</where>"+
            "</script>")
    List<Admin> getAdmin(Admin admin);

    /**
     * 查询所有，但排除登陆的管理员数据
     * @param admAccount
     * @return
     */
    @Select("select adm_account,adm_lev,adm_department,adm_name from admin where adm_account != #{admAccount}")
    List<Admin> getAdminAllButOwn(String admAccount);

    /**
     * 删除管理员
     * @param admAccount 传入管理员账号参数
     * @return
     */
    @Delete("delete from admin where adm_account = #{admAccount}")
    int deleteAdmin(String admAccount);

    /**
     * 通过授权老师添加管理员
     * @param admin 参数
     * @return
     */
    @Insert("insert into admin values(#{admAccount},#{admPassword},#{admLev},#{admName},#{admDepartment})")
    int addAdmin(Admin admin);

}
