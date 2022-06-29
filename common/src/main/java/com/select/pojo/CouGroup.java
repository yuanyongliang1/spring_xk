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
public class CouGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 课组id
     */
    private Integer id;

    /**
     * 课组名称
     */
    private String couGroup;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCouGroup() {
        return couGroup;
    }

    public void setCouGroup(String couGroup) {
        this.couGroup = couGroup;
    }

    @Override
    public String toString() {
        return "CouGroup{" +
        "id=" + id +
        ", couGroup=" + couGroup +
        "}";
    }
}
