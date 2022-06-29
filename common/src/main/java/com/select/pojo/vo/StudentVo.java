package com.select.pojo.vo;

/**
 * @Author ：ZhangLei
 * @Data ：2021/6/10 8:38
 * @Description ：
 */
public class StudentVo {
    /**
     * 学生账号
     */
    private String stuAccount;

    /**
     * 学生姓名
     */
    private String stuName;

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

    /**
     * 期末成绩
     */
    private Double achEnd;

    /**
     * 平时成绩
     */
    private Double achDay;

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

    public String getStuClass() {
        return stuClass;
    }

    @Override
    public String toString() {
        return "StudentVo{" +
                "stuAccount='" + stuAccount + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuClass='" + stuClass + '\'' +
                ", stuDepartment='" + stuDepartment + '\'' +
                ", stuGrade='" + stuGrade + '\'' +
                ", achEnd=" + achEnd +
                ", achDay=" + achDay +
                '}';
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

    public Double getAchEnd() {
        return achEnd;
    }

    public void setAchEnd(Double achEnd) {
        this.achEnd = achEnd;
    }

    public Double getAchDay() {
        return achDay;
    }

    public void setAchDay(Double achDay) {
        this.achDay = achDay;
    }


}
