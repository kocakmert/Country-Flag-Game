package com.gameflag.gameflag;

public class user {
    private String userName;
    private String user_image;


    public user(String userName,String user_image) {
        this.userName = userName;
        this.user_image = user_image;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserImage() {
        return user_image;
    }
    public void setUserImage(String user_image) {
        this.user_image = user_image;
    }

}
