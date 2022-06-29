package com.zys.pojo;

import java.io.Serializable;

/**
 * @USER 张英帅
 * @date 2021/5/18 - 16:10
 */
public class Admin implements Serializable {
    private String admAccount;
    private String admPassword;
    private String admLev;
    private String admName;
    private String admDepartment;

    public Admin() {
    }

    public Admin(String admAccount, String admPassword, String admLev, String admName, String admDepartment) {
        this.admAccount = admAccount;
        this.admPassword = admPassword;
        this.admLev = admLev;
        this.admName = admName;
        this.admDepartment = admDepartment;
    }

    public String getAdmAccount() {
        return admAccount;
    }

    public void setAdmAccount(String admAccount) {
        this.admAccount = admAccount;
    }

    public String getAdmPassword() {
        return admPassword;
    }

    public void setAdmPassword(String admPassword) {
        this.admPassword = admPassword;
    }

    public String getAdmLev() {
        return admLev;
    }

    public void setAdmLev(String admLev) {
        this.admLev = admLev;
    }

    public String getAdmName() {
        return admName;
    }

    public void setAdmName(String admName) {
        this.admName = admName;
    }

    public String getAdmDepartment() {
        return admDepartment;
    }

    public void setAdmDepartment(String admDepartment) {
        this.admDepartment = admDepartment;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "admAccount='" + admAccount + '\'' +
                ", admPassword='" + admPassword + '\'' +
                ", admLev='" + admLev + '\'' +
                ", admName='" + admName + '\'' +
                ", admDepartment='" + admDepartment + '\'' +
                '}';
    }
}
