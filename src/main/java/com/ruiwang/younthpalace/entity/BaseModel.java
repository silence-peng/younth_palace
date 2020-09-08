package com.ruiwang.younthpalace.entity;



import java.io.Serializable;
import java.util.Date;

public class BaseModel implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1740465809795976576L;

    public static final int DELETED = 1;
    public static final int NOT_DELETED = 0;
    public static final int INIT_STATE = 0;

    protected Integer id;
    protected Integer version;
    protected String dateCreated;
    protected String dateUpdate;
    protected Integer state = INIT_STATE;
    protected Integer deleted = NOT_DELETED;
    protected Integer pageNum;
    protected Integer pageSize;

    public BaseModel() {
    }

    public BaseModel(Integer id, String dateCreated, String dateUpdate,
                     Integer state, Integer deleted) {
        super();
        this.id = id;
        this.dateCreated = dateCreated;
        this.dateUpdate = dateUpdate;
        this.state = state;
        this.deleted = deleted;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        if (id != null && id.intValue() > 0) {
            this.id = id;
        }
    }


    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }




    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "BaseModel{" +
                "id=" + id +
                ", version=" + version +
                ", dateCreated=" + dateCreated +
                ", dateUpdate=" + dateUpdate +
                ", state=" + state +
                ", deleted=" + deleted +
                '}';
    }
}