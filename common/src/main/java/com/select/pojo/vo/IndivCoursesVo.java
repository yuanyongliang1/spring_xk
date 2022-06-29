package com.select.pojo.vo;

/**
 * @ClassName indivCoursesVo
 * @Description TODO
 * @Author 袁永亮
 * @Date 2021/5/21 9:25
 **/
public class IndivCoursesVo {
    /**
     * 课程名
     */
    private String classname;
    /**
     * 教师姓名
     */
    private String tName;
    /**
     *  课时
     */
    private String classHour;
    /**
     *  学分
     */
    private String credit;
    /**
     *  已有人数
     */
    private String people;
    /**
     *  教室容量最大人数
     */
    private String maxClass;

    @Override
    public String toString() {
        return "IndivCoursesVo{" +
                "classname='" + classname + '\'' +
                ", tName='" + tName + '\'' +
                ", classHour='" + classHour + '\'' +
                ", credit='" + credit + '\'' +
                ", people='" + people + '\'' +
                ", maxClass='" + maxClass + '\'' +
                '}';
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String getClassHour() {
        return classHour;
    }

    public void setClassHour(String classHour) {
        this.classHour = classHour;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getMaxClass() {
        return maxClass;
    }

    public void setMaxClass(String maxClass) {
        this.maxClass = maxClass;
    }
}
