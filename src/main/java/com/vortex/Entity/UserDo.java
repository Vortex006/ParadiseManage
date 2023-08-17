package com.vortex.Entity;

public class UserDo {
    private int userId;//用户ID
    private String userName;//用户姓名
    private String userPassword;//用户密码
    private String userSalt;
    private String userCreateDate;//用户创建时间
    private String userLastLoginDate;//用户最后登录时间
    private short userState;//用户状态
    private int userPermission;//用户权限
    private String userEmail;//用户邮箱
    private String userPhone;//用户手机号

    public UserDo() {
    }

    public UserDo(String userName, String userPassword, String userSalt, String userCreateDate,
                  String userLastLoginDate, short userState, int userPermission, String userEmail, String userPhone) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userSalt = userSalt;
        this.userCreateDate = userCreateDate;
        this.userLastLoginDate = userLastLoginDate;
        this.userState = userState;
        this.userPermission = userPermission;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
    }

    public UserDo(int userId, String userName, String userPassword, String userSalt, String userCreateDate,
                  String userLastLoginDate, short userState, int userPermission, String userEmail, String userPhone) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userSalt = userSalt;
        this.userCreateDate = userCreateDate;
        this.userLastLoginDate = userLastLoginDate;
        this.userState = userState;
        this.userPermission = userPermission;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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

    public String getUserSalt() {
        return userSalt;
    }

    public void setUserSalt(String userSalt) {
        this.userSalt = userSalt;
    }

    public String getUserCreateDate() {
        return userCreateDate;
    }

    public void setUserCreateDate(String userCreateDate) {
        this.userCreateDate = userCreateDate;
    }

    public String getUserLastLoginDate() {
        return userLastLoginDate;
    }

    public void setUserLastLoginDate(String userLastLoginDate) {
        this.userLastLoginDate = userLastLoginDate;
    }

    public short getUserState() {
        return userState;
    }

    public void setUserState(short userState) {
        this.userState = userState;
    }

    public int getUserPermission() {
        return userPermission;
    }

    public void setUserPermission(int userPermission) {
        this.userPermission = userPermission;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userSalt='" + userSalt + '\'' +
                ", userCreateDate='" + userCreateDate + '\'' +
                ", userLastLoginDate='" + userLastLoginDate + '\'' +
                ", userState=" + userState +
                ", userPermission=" + userPermission +
                ", userEmail='" + userEmail + '\'' +
                ", userPhone='" + userPhone + '\'' +
                '}';
    }
}
