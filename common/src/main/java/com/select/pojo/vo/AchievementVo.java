package com.select.pojo.vo;

/**
 * @ClassName achievementVo
 * @Description TODO
 * @Author 袁永亮
 * @Date 2021/5/24 8:36
 **/
public class AchievementVo {


    /**
     * 最后总成绩
     */
    private Integer achNum;

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

    /**
     * 课程名称
     */
    private String couName;

    /**
     * 学分
     */
    private Integer couLeaNum;

    /**
     * 教师姓名
     */
    private String teaName;

    @Override
    public String toString() {
        return "achievementVo{" +
                "achNum=" + achNum +
                ", achEnd=" + achEnd +
                ", achDay=" + achDay +
                ", achEndProportion=" + achEndProportion +
                ", achDayProportion=" + achDayProportion +
                ", couName='" + couName + '\'' +
                ", couLeaNum=" + couLeaNum +
                ", teaName='" + teaName + '\'' +
                '}';
    }

    public Integer getAchNum() {
        return achNum;
    }

    public void setAchNum(Integer achNum) {
        this.achNum = achNum;
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

    public String getCouName() {
        return couName;
    }

    public void setCouName(String couName) {
        this.couName = couName;
    }

    public Integer getCouLeaNum() {
        return couLeaNum;
    }

    public void setCouLeaNum(Integer couLeaNum) {
        this.couLeaNum = couLeaNum;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }
}
