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
public class Semester implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 学期 格式 2018-2019第一学期
     */
    private String semester;

    /**
     * 选课开始时间
     */
    private String selStartTime;

    /**
     * 选课结束时间
     */
    private String selOverTime;

    /**
     * 学期结束时间
     */
    private String semOverTime;

    /**
     * 状态
     */
    private int semStatus;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getSelStartTime() {
        return selStartTime;
    }

    public void setSelStartTime(String selStartTime) {
        this.selStartTime = selStartTime;
    }

    public String getSelOverTime() {
        return selOverTime;
    }

    public void setSelOverTime(String selOverTime) {
        this.selOverTime = selOverTime;
    }

    public String getSemOverTime() {
        return semOverTime;
    }

    public void setSemOverTime(String semOverTime) {
        this.semOverTime = semOverTime;
    }

    public int getSemStatus() {
        return semStatus;
    }

    public void setSemStatus(int semStatus) {
        this.semStatus = semStatus;
    }

    @Override
    public String toString() {
        return "Semester{" +
                "semester=" + semester +
                ", selStartTime=" + selStartTime +
                ", selOverTime=" + selOverTime +
                ", semOverTime=" + semOverTime +
                ", semStatus=" + semStatus +
                "}";
    }
}
