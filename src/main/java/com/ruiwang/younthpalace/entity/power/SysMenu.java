package com.ruiwang.younthpalace.entity.power;

public class SysMenu {
    private Integer id;
    private String menu_name;
    private String belongsto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public String getBelongsto() {
        return belongsto;
    }

    public void setBelongsto(String belongsto) {
        this.belongsto = belongsto;
    }

    @Override
    public String toString() {
        return "SysMenu{" +
                "id=" + id +
                ", menu_name='" + menu_name + '\'' +
                ", belongsto='" + belongsto + '\'' +
                '}';
    }
}
