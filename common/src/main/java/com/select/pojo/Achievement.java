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
public class Achievement implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 成绩id
     */
    private String achId;

    /**
     * 最后总成绩
     */
    private Integer achNum;

    /**
     * 教师账号
     */
    private String teaAccount;

    /**
     * 课程编号
     */
    private String couId;

    /**
     * 学生账号
     */
    private String stuAccount;

    /**
     * 学期
     */
    private String semester;

    /**
     * 期末成绩
     */
    private Double achEnd;

    /**
     * 平时成绩
     */
    private Double achDay;

    /**
     * 期末成绩比例
     */
    private Double achEndProportion;

    /**
     * 平时成绩比例
     */
    private Double achDayProportion;


    public String getAchId() {
        return achId;
    }

    public void setAchId(String achId) {
        this.achId = achId;
    }

    public Integer getAchNum() {
        return achNum;
    }

    public void setAchNum(Integer achNum) {
        this.achNum = achNum;
    }

    public String getTeaAccount() {
        return teaAccount;
    }

    public void setTeaAccount(String teaAccount) {
        this.teaAccount = teaAccount;
    }

    public String getCouId() {
        return couId;
    }

    public void setCouId(String couId) {
        this.couId = couId;
    }

    public String getStuAccount() {
        return stuAccount;
    }

    public void setStuAccount(String stuAccount) {
        this.stuAccount = stuAccount;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
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

    public Double getAchEndProportion() {
        return achEndProportion;
    }

    public void setAchEndProportion(Double achEndProportion) {
        this.achEndProportion = achEndProportion;
    }

    public Double getAchDayProportion() {
        return achDayProportion;
    }

    public void setAchDayProportion(Double achDayProportion) {
        this.achDayProportion = achDayProportion;
    }

    @Override
    public String toString() {
        return "Achievement{" +
        "achId=" + achId +
        ", achNum=" + achNum +
        ", teaAccount=" + teaAccount +
        ", couId=" + couId +
        ", stuAccount=" + stuAccount +
        ", semester=" + semester +
        ", achEnd=" + achEnd +
        ", achDay=" + achDay +
        ", achEndProportion=" + achEndProportion +
        ", achDayProportion=" + achDayProportion +
        "}";
    }
}
