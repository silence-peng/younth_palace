package com.ruiwang.younthpalace.bojo.power;

import java.util.ArrayList;

public class BoUserMenu {
    private Integer id;
    private ArrayList<Integer> menuId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<Integer> getMenuId() {
        return menuId;
    }

    public void setMenuId(ArrayList<Integer> menuId) {
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        return "BoUserMenu{" +
                "id=" + id +
                ", menuId=" + menuId +
                '}';
    }
}
