package com.ruiwang.younthpalace.bojo.power;

import java.util.ArrayList;

public class BoUserSearch {
    private ArrayList<BoUser> boUsers;
    private Integer allNum;

    public ArrayList<BoUser> getBoUsers() {
        return boUsers;
    }

    public void setBoUsers(ArrayList<BoUser> boUsers) {
        this.boUsers = boUsers;
    }

    public Integer getAllNum() {
        return allNum;
    }

    public void setAllNum(Integer allNum) {
        this.allNum = allNum;
    }

    @Override
    public String toString() {
        return "BoUserSearch{" +
                "boUsers=" + boUsers +
                ", allNum=" + allNum +
                '}';
    }
}
