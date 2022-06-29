package com.select.pojo.vo;

/**
 * @ClassName ElectiveVo
 * @Description TODO
 * @Author 袁永亮
 * @Date 2021/5/24 10:17
 **/
public class ElectiveVo {
    /**
     * 课程名称
     */
    private String couName;
    /**
     * 教师姓名
     */
    private String teaName;
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
     * 每天的第几节课
     */
    private String couTime;

    /**
     * 当前人数
     */
    private Integer couStuNum;
    /**
     * 最大人数
     */
    private Integer crMaxsize;
    /**
     * 所属学院
     */
    private String couDepartment;
    /**
     * 课程简介
     */
    private String couIntroduce;

    @Override
    public String toString() {
        return "ElectiveVo{" +
                "couName='" + couName + '\'' +
                ", teaName='" + teaName + '\'' +
                ", couWeek='" + couWeek + '\'' +
                ", couLeaTime=" + couLeaTime +
                ", couLeaNum=" + couLeaNum +
                ", crPlace='" + crPlace + '\'' +
                ", couTime='" + couTime + '\'' +
                ", couStuNum=" + couStuNum +
                ", crMaxsize=" + crMaxsize +
                ", couDepartment='" + couDepartment + '\'' +
                ", couIntroduce='" + couIntroduce + '\'' +
                '}';
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

    public String getCouTime() {
        return couTime;
    }

    public void setCouTime(String couTime) {
        this.couTime = couTime;
    }

    public Integer getCouStuNum() {
        return couStuNum;
    }

    public void setCouStuNum(Integer couStuNum) {
        this.couStuNum = couStuNum;
    }

    public Integer getCrMaxsize() {
        return crMaxsize;
    }

    public void setCrMaxsize(Integer crMaxsize) {
        this.crMaxsize = crMaxsize;
    }

    public String getCouDepartment() {
        return couDepartment;
    }

    public void setCouDepartment(String couDepartment) {
        this.couDepartment = couDepartment;
    }

    public String getCouIntroduce() {
        return couIntroduce;
    }

    public void setCouIntroduce(String couIntroduce) {
        this.couIntroduce = couIntroduce;
    }
}
