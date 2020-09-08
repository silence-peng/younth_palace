package com.ruiwang.younthpalace.bojo.platform;

import com.ruiwang.younthpalace.entity.platform.SysEquipmentPosition;
import com.ruiwang.younthpalace.entity.platform.SysEquipmentSys;
import com.ruiwang.younthpalace.entity.platform.SysEquipmentType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class BoEquipmentInfReady {
    private ArrayList<SysEquipmentSys> sysEquipmentSyss;
    private ArrayList<SysEquipmentType> sysEquipmentTypes;

    public ArrayList<SysEquipmentSys> getSysEquipmentSyss() {
        return sysEquipmentSyss;
    }

    public void setSysEquipmentSyss(ArrayList<SysEquipmentSys> sysEquipmentSyss) {
        this.sysEquipmentSyss = sysEquipmentSyss;
    }

    public ArrayList<SysEquipmentType> getSysEquipmentTypes() {
        return sysEquipmentTypes;
    }

    public void setSysEquipmentTypes(ArrayList<SysEquipmentType> sysEquipmentTypes) {
        this.sysEquipmentTypes = sysEquipmentTypes;
    }

    @Override
    public String toString() {
        return "BoEquipmentInfReady{" +
                "sysEquipmentSyss=" + sysEquipmentSyss +
                ", sysEquipmentTypes=" + sysEquipmentTypes +
                '}';
    }
}
