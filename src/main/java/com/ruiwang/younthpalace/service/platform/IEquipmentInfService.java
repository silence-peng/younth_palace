package com.ruiwang.younthpalace.service.platform;

import com.ruiwang.younthpalace.bojo.platform.*;
import com.ruiwang.younthpalace.entity.platform.SysEquipmentInfo;
import com.ruiwang.younthpalace.util.ResultMap;


public interface IEquipmentInfService {
    //获取页面初始数据
    ResultMap<BoEquipmentInfReady> getEquipmentInf();
    //导入文件
    ResultMap<Integer> addequipmentInf( BoEquipmentInfAdd boEquipmentInfAdd);
    //批量导入
//    ResultMap<Integer> addequipmentInfAll(MultipartFile file);
    //获取列表信息
    ResultMap<BoEquipmentInfList> selectEquipmentList(BoEquipmentInfLimit boEquipmentInfLimit);

    //编辑单个台账的信息
    ResultMap<Integer> editequipmentInf(BoEquipmentInfAdd boEquipmentInfAdd);

    //删除台账
    ResultMap<Integer> deleteequipmentInf(Integer id);

    ResultMap<BoMaintenanceEquipmentInf> selectBoMaintenanceEquipmentInfByNum(String inf);

    ResultMap<Integer> checkEquipmentCode(String equipmentCode);

    ResultMap<SysEquipmentInfo> getSysEquipmentInfById(int parseInt);
}
