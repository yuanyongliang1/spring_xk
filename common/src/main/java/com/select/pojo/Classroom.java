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
public class Classroom implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 教室地点
     */
    private String crPlace;

    /**
     * 教室最大容量
     */
    private Integer crMaxsize;


    public String getCrPlace() {
        return crPlace;
    }

    public void setCrPlace(String crPlace) {
        this.crPlace = crPlace;
    }

    public Integer getCrMaxsize() {
        return crMaxsize;
    }

    public void setCrMaxsize(Integer crMaxsize) {
        this.crMaxsize = crMaxsize;
    }

    @Override
    public String toString() {
        return "Classroom{" +
        "crPlace=" + crPlace +
        ", crMaxsize=" + crMaxsize +
        "}";
    }
}
