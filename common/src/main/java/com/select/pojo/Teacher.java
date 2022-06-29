package com.select.pojo;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author shuai
 * @since 2021-05-26
 */
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 教师工号
     */
    private String teaAccount;

    /**
     * 密码
     */
    private String teaPassword;

    /**
     * 教师权限选择（是给那个学院添加课程）
     */
    private String teaDepartment;

    /**
     * 教师姓名
     */
    private String teaName;

    /**
     * 是否授权 0未授权 1已授权校级 2已授权院级
     */
    private Integer teaLev;


    public String getTeaAccount() {
        return teaAccount;
    }

    public void setTeaAccount(String teaAccount) {
        this.teaAccount = teaAccount;
    }

    public String getTeaPassword() {
        return teaPassword;
    }

    public void setTeaPassword(String teaPassword) {
        this.teaPassword = teaPassword;
    }

    public String getTeaDepartment() {
        return teaDepartment;
    }

    public void setTeaDepartment(String teaDepartment) {
        this.teaDepartment = teaDepartment;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public Integer getTeaLev() {
        return teaLev;
    }

    public void setTeaLev(Integer teaLev) {
        this.teaLev = teaLev;
    }

    @Override
    public String toString() {
        return "Teacher{" +
        "teaAccount=" + teaAccount +
        ", teaPassword=" + teaPassword +
        ", teaDepartment=" + teaDepartment +
        ", teaName=" + teaName +
        ", teaLev=" + teaLev +
        "}";
    }
}
