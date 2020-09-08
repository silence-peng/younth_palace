package com.ruiwang.younthpalace.bojo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class LoginInf {
    int userId;
    String userName;
    ArrayList<String> menuList;
    ArrayList<String> positionList;

    public ArrayList<String> getMenuList() {
        return menuList;
    }

    public void setMenuList(ArrayList<String> menuList) {
        this.menuList = menuList;
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

    public ArrayList<String> getPositionList() {
        return positionList;
    }

    public void setPositionList(ArrayList<String> positionList) {
        this.positionList = positionList;
    }
}
