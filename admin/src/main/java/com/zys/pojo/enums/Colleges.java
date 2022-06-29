package com.zys.pojo.enums;

/**
 * @USER 张英帅
 * @date 2021/5/25 - 10:05
 */
public enum Colleges {
    SCHOOL_COLLEGE("校级"),
    SOFT_COLLEGE("软件学院"),
    ACCOUNTANT_COLLEGE("会计学院"),
    INTERNET_COLLEGE("网通学院"),
    BUILD_COLLEGE("建筑学院"),
    ARTMEDIA_COLLEGE("艺术与传媒学院"),
    BIGDATA_COLLEGE("大数据学院"),
    CIVIL_COLLEGE("土木学院")
    ;
    private String collegeName;

    Colleges(String collegeName) {
        this.collegeName = collegeName;
    }

    Colleges() {
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }
}
