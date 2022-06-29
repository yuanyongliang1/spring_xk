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
public class Courses implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 课程编号
     */
    private String couId;

    /**
     * 课程名称
     */
    private String couName;

    /**
     * 任课老师账号
     */
    private String teaAccount;

    /**
     * 每天的第几节课
     */
    private String couTime;

    /**
     * 周几上课
     */
    private String couWeek;

    /**
     * 学时
     */
    private Integer couLeaTime;

    /**
     * 学分
     */
    private Integer couLeaNum;

    /**
     * 课程教室地点，格式4-305
     */
    private String crPlace;

    /**
     * 课程当前学生数量
     */
    private Integer couStuNum;

    /**
     * 校选课，院选课
     */
    private String couLev;

    /**
     * 课程简介
     */
    private String couIntroduce;

    /**
     * 课程状态  0：未开始 1：正在选 2:已满 3：已结束 4：补选 5：补选结束
     */
    private String couStatus;

    /**
     * 此门课程属于那个学院
     */
    private String couDepartment;

    /**
     * 开课最小人数
     */
    private Integer couMinStu;

    /**
     * 课组
     */
    private Integer couGroup;

    /**
     * 年级
     */
    private String couGrade;

    /**
     * 选课状态：1申请中 2同意 3拒绝
     */
    private Integer couState;


    public String getCouId() {
        return couId;
    }

    public void setCouId(String couId) {
        this.couId = couId;
    }

    public String getCouName() {
        return couName;
    }

    public void setCouName(String couName) {
        this.couName = couName;
    }

    public String getTeaAccount() {
        return teaAccount;
    }

    public void setTeaAccount(String teaAccount) {
        this.teaAccount = teaAccount;
    }

    public String getCouTime() {
        return couTime;
    }

    public void setCouTime(String couTime) {
        this.couTime = couTime;
    }

    public String getCouWeek() {
        return couWeek;
    }

    public void setCouWeek(String couWeek) {
        this.couWeek = couWeek;
    }

    public Integer getCouLeaTime() {
        return couLeaTime;
    }

    public void setCouLeaTime(Integer couLeaTime) {
        this.couLeaTime = couLeaTime;
    }

    public Integer getCouLeaNum() {
        return couLeaNum;
    }

    public void setCouLeaNum(Integer couLeaNum) {
        this.couLeaNum = couLeaNum;
    }

    public String getCrPlace() {
        return crPlace;
    }

    public void setCrPlace(String crPlace) {
        this.crPlace = crPlace;
    }

    public Integer getCouStuNum() {
        return couStuNum;
    }

    public void setCouStuNum(Integer couStuNum) {
        this.couStuNum = couStuNum;
    }

    public String getCouLev() {
        return couLev;
    }

    public void setCouLev(String couLev) {
        this.couLev = couLev;
    }

    public String getCouIntroduce() {
        return couIntroduce;
    }

    public void setCouIntroduce(String couIntroduce) {
        this.couIntroduce = couIntroduce;
    }

    public String getCouStatus() {
        return couStatus;
    }

    public void setCouStatus(String couStatus) {
        this.couStatus = couStatus;
    }

    public String getCouDepartment() {
        return couDepartment;
    }

    public void setCouDepartment(String couDepartment) {
        this.couDepartment = couDepartment;
    }

    public Integer getCouMinStu() {
        return couMinStu;
    }

    public void setCouMinStu(Integer couMinStu) {
        this.couMinStu = couMinStu;
    }

    public Integer getCouGroup() {
        return couGroup;
    }

    public void setCouGroup(Integer couGroup) {
        this.couGroup = couGroup;
    }

    public String getCouGrade() {
        return couGrade;
    }

    public void setCouGrade(String couGrade) {
        this.couGrade = couGrade;
    }

    public Integer getCouState() {
        return couState;
    }

    public void setCouState(Integer couState) {
        this.couState = couState;
    }

    @Override
    public String toString() {
        return "Courses{" +
        "couId=" + couId +
        ", couName=" + couName +
        ", teaAccount=" + teaAccount +
        ", couTime=" + couTime +
        ", couWeek=" + couWeek +
        ", couLeaTime=" + couLeaTime +
        ", couLeaNum=" + couLeaNum +
        ", crPlace=" + crPlace +
        ", couStuNum=" + couStuNum +
        ", couLev=" + couLev +
        ", couIntroduce=" + couIntroduce +
        ", couStatus=" + couStatus +
        ", couDepartment=" + couDepartment +
        ", couMinStu=" + couMinStu +
        ", couGroup=" + couGroup +
        ", couGrade=" + couGrade +
        ", couState=" + couState +
        "}";
    }
}
