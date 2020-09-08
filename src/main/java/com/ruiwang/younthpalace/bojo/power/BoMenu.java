package com.ruiwang.younthpalace.bojo.power;

public class BoMenu {
    private Integer id;
    private String name;

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

    @Override
    public String toString() {
        return "BoMenu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
