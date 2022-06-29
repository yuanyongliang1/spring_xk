package com.select.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author shuai
 * @since 2021-05-26
 */
public class StudentElective implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标识列
     */
    private Integer studentElectiveId;

    /**
     * 学生id
     */
    private String stuAccount;

    /**
     * 选课id
     */
    private String couId;

    /**
     * 学生姓名
     */
    private String stuName;

    /**
     * 是否正在学习
     */
    private String courseFlag;

    /**
     * 时间戳，退课24小时后才能重新选课
     */
    private LocalDateTime timeStamp;


    public Integer getStudentElectiveId() {
        return studentElectiveId;
    }

    public void setStudentElectiveId(Integer studentElectiveId) {
        this.studentElectiveId = studentElectiveId;
    }

    public String getStuAccount() {
        return stuAccount;
    }

    public void setStuAccount(String stuAccount) {
        this.stuAccount = stuAccount;
    }

    public String getCouId() {
        return couId;
    }

    public void setCouId(String couId) {
        this.couId = couId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getCourseFlag() {
        return courseFlag;
    }

    public void setCourseFlag(String courseFlag) {
        this.courseFlag = courseFlag;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "StudentElective{" +
        "studentElectiveId=" + studentElectiveId +
        ", stuAccount=" + stuAccount +
        ", couId=" + couId +
        ", stuName=" + stuName +
        ", courseFlag=" + courseFlag +
        ", timeStamp=" + timeStamp +
        "}";
    }
}
