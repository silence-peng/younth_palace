package com.ruiwang.younthpalace.entity.file;

public class SysImgInfo {
    private Integer id;
    private String imgUrl;
    private Integer type;
    private String descName;
    private String groupType;

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    @Override
    public String toString() {
        return "SysImgInfo{" +
                "id=" + id +
                ", imgUrl='" + imgUrl + '\'' +
                ", type=" + type +
                ", imgName='" + descName + '\'' +
                '}';
    }

    public String getDescName() {
        return descName;
    }

    public void setDescName(String descName) {
        this.descName = descName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
