package com.select.pojo.vo;

public class TeacherCourseVo {
    private String couId;
    private String couName;
    private String teaAccount;
    private String couTime;
    private String couWeek;
    private Integer couLeaTime;
    private Integer CouLeaNum;
    private String crPlace;
    private Integer couStuNum;
    private String couLev;
    private String couIntroduce;
    private String couStatus;
    private String couDepartment;
    private Integer couMinStu;
    private Integer couGroup;
    private String couGrade;
    private String teaName;

    @Override
    public String toString() {
        return "TeacherCourseVo{" +
                "couId='" + couId + '\'' +
                ", couName='" + couName + '\'' +
                ", teaAccount='" + teaAccount + '\'' +
                ", couTime='" + couTime + '\'' +
                ", couWeek='" + couWeek + '\'' +
                ", couLeaTime='" + couLeaTime + '\'' +
                ", CouLeaNum='" + CouLeaNum + '\'' +
                ", crPlace='" + crPlace + '\'' +
                ", couStuNum='" + couStuNum + '\'' +
                ", couLev='" + couLev + '\'' +
                ", couIntroduce='" + couIntroduce + '\'' +
                ", couStatus='" + couStatus + '\'' +
                ", couDepartment='" + couDepartment + '\'' +
                ", couMinStu='" + couMinStu + '\'' +
                ", couGroup='" + couGroup + '\'' +
                ", couGrade='" + couGrade + '\'' +
                ", teaName='" + teaName + '\'' +
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
        return CouLeaNum;
    }

    public void setCouLeaNum(Integer couLeaNum) {
        CouLeaNum = couLeaNum;
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

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }
}
