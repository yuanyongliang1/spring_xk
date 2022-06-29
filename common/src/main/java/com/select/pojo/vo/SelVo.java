package com.select.pojo.vo;

/**
 * @Author ：ZhangLei
 * @Data ：2021/5/21 17:00
 * @Description ：
 */
public class SelVo {

    /**
     * 课程编号
     */
    private String couId;

    /**
     * 课程名称
     */
    private String couName;

    /**
     * 任课老师姓名
     */
    private String teaName;

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
     * 课程学生数量
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
     * 课程状态
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
    private String couGroup;

    /**
     * 年级
     */
    private String couGrade;

    /**
     * 课程最大人数  教室最大容纳量
     */
    private Integer crMaxsize;

    public Integer getCrMaxsize() {
        return crMaxsize;
    }

    public void setCrMaxsize(Integer crMaxsize) {
        this.crMaxsize = crMaxsize;
    }

    @Override
    public String toString() {
        return "SelVo{" +
                "couId='" + couId + '\'' +
                ", couName='" + couName + '\'' +
                ", teaName='" + teaName + '\'' +
                ", couTime='" + couTime + '\'' +
                ", couWeek='" + couWeek + '\'' +
                ", couLeaTime=" + couLeaTime +
                ", couLeaNum=" + couLeaNum +
                ", crPlace='" + crPlace + '\'' +
                ", couStuNum=" + couStuNum +
                ", couLev='" + couLev + '\'' +
                ", couIntroduce='" + couIntroduce + '\'' +
                ", couStatus='" + couStatus + '\'' +
                ", couDepartment='" + couDepartment + '\'' +
                ", couMinStu=" + couMinStu +
                ", couGroup='" + couGroup + '\'' +
                ", couGrade='" + couGrade + '\'' +
                ", crMaxsize=" + crMaxsize +
                '}';
    }

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

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
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

    public String getCouGroup() {
        return couGroup;
    }

    public void setCouGroup(String couGroup) {
        this.couGroup = couGroup;
    }

    public String getCouGrade() {
        return couGrade;
    }

    public void setCouGrade(String couGrade) {
        this.couGrade = couGrade;
    }
}
