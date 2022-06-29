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
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 学生账号
     */
    private String stuAccount;

    /**
     * 学生姓名
     */
    private String stuName;

    /**
     * 密码
     */
    private String stuPassword;

    /**
     * 班级
     */
    private String stuClass;

    /**
     * 学院
     */
    private String stuDepartment;

    /**
     * 年级
     */
    private String stuGrade;


    public String getStuAccount() {
        return stuAccount;
    }

    public void setStuAccount(String stuAccount) {
        this.stuAccount = stuAccount;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuPassword() {
        return stuPassword;
    }

    public void setStuPassword(String stuPassword) {
        this.stuPassword = stuPassword;
    }

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }

    public String getStuDepartment() {
        return stuDepartment;
    }

    public void setStuDepartment(String stuDepartment) {
        this.stuDepartment = stuDepartment;
    }

    public String getStuGrade() {
        return stuGrade;
    }

    public void setStuGrade(String stuGrade) {
        this.stuGrade = stuGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
        "stuAccount=" + stuAccount +
        ", stuName=" + stuName +
        ", stuPassword=" + stuPassword +
        ", stuClass=" + stuClass +
        ", stuDepartment=" + stuDepartment +
        ", stuGrade=" + stuGrade +
        "}";
    }
}
