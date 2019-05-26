package com.zuoshao.gmall.bean;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author zuoshao
 * @date 2019/5/11 - 15:06
 */
public class UserInfo {

    @Id
    private String userId;
    @Column
    private String userName;
    @Column
    private String userPassword;
    @Column
    private String userSex;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }
}
