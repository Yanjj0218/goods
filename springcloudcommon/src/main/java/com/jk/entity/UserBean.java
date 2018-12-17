package com.jk.entity;

/**
 * @Auther: 闫晋杰
 * @Date: 2018/12/14 20:36
 * @Description:
 */
public class UserBean {
    private Integer id;
    private String name;
    private String loginNum;
    private String loginPwd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginNum() {
        return loginNum;
    }

    public void setLoginNum(String loginNum) {
        this.loginNum = loginNum;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", loginNum='" + loginNum + '\'' +
                ", loginPwd='" + loginPwd + '\'' +
                '}';
    }
}
