package com.ruiwang.younthpalace.mapper.platform;

import com.ruiwang.younthpalace.bojo.platform.BoEquipmentInf;
import com.ruiwang.younthpalace.bojo.platform.BoEquipmentInfAdd;
import com.ruiwang.younthpalace.bojo.platform.BoEquipmentInfLimit;
import com.ruiwang.younthpalace.entity.platform.SysEquipmentInfo;
import com.ruiwang.younthpalace.entity.platform.SysEquipmentPosition;
import com.ruiwang.younthpalace.entity.platform.SysEquipmentSys;
import com.ruiwang.younthpalace.entity.platform.SysEquipmentType;
import com.ruiwang.younthpalace.pojo.platform.PoEquipmentInfMainyenance;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface EquipmentInfMapper {
//    //获取区域或者大楼信息
//    ArrayList<SysEquipmentPosition> selectBuildings(@Param("id") Integer id);
    //获取设备类型
    ArrayList<SysEquipmentType> selectEquipmentTypes();

//    Integer selectPositionByFloor(Integer floor);

    Integer insertIntoEquipmentInf(@Param("boEquipmentInfAdd") BoEquipmentInfAdd boEquipmentInfAdd);

//    Integer insertIntoEquipmentInfAll(@Param("listInf") String[] listInf, @Param("list3") int list3, @Param("list6") int list6, @Param("position") Integer position);

    //按照中文名字查询
//    Integer selectPositionByName(@Param("buildingName") String buildingName, @Param("floorName") String floorName);

    ArrayList<BoEquipmentInf> selectEquipmentList(@Param("boEquipmentInfLimit") BoEquipmentInfLimit boEquipmentInfLimit);

    Integer selectEquipmentListAll(@Param("boEquipmentInfLimit") BoEquipmentInfLimit boEquipmentInfLimit);

    String getPosition(@Param("state_id") Integer id);

    SysEquipmentInfo selectSysEquipmentInfByid(@Param("id") Integer id);
    ArrayList<SysEquipmentSys> selectEquipmentSysList();
    Integer updateEquipmentInf(@Param("boEquipmentInfAdd") BoEquipmentInfAdd boEquipmentInfAdd);

    Integer deleteequipmentInf(@Param("id") Integer id);

    SysEquipmentSys selectEquipmentSysById(@Param("id") Integer id);

    PoEquipmentInfMainyenance selectBoMaintenanceEquipmentInf(@Param("equipment_num") String equipment_num);

    Integer selectEquipmentCountByCode(@Param("equipmentCode") String equipmentCode);
}
