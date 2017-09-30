package com.spring.boot.moduls;


import java.io.Serializable;

/**
 * Created by zfy on 2017/8/18.
 */
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String userName;
    private String passWord;

    private String nickName;

    public UserEntity() {
        super();
    }

    public UserEntity(String userName, String passWord) {
        super();
        this.passWord = passWord;
        this.userName = userName;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }



    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "userName " + this.userName + ", pasword " + this.passWord ;
    }
}
