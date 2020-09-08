package com.ruiwang.younthpalace.service.platform.impl;

import com.ruiwang.younthpalace.bojo.platform.*;
import com.ruiwang.younthpalace.bojo.power.BoUser;
import com.ruiwang.younthpalace.bojo.power.BoUserForReady;
import com.ruiwang.younthpalace.entity.platform.SysEquipmentInfo;
import com.ruiwang.younthpalace.entity.platform.SysEquipmentPosition;
import com.ruiwang.younthpalace.entity.platform.SysEquipmentSys;
import com.ruiwang.younthpalace.mapper.platform.EquipmentInfMapper;
import com.ruiwang.younthpalace.mapper.power.UserMapper;
import com.ruiwang.younthpalace.pojo.platform.PoEquipmentInfMainyenance;
import com.ruiwang.younthpalace.service.platform.IEquipmentInfService;
import com.ruiwang.younthpalace.util.QRCodeUtil;
import com.ruiwang.younthpalace.util.ResultMap;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class EquipmentInfService implements IEquipmentInfService {

    @Autowired
    EquipmentInfMapper equipmentInfMapper;
    @Autowired
    BoEquipmentInfReady boEquipmentInfReady;
    @Autowired
    UserMapper userMapper;

    @Autowired
    BoEquipmentInfList boEquipmentInfList;
    @Autowired
    PoEquipmentInfMainyenance poEquipmentInfMainyenance;
    @Autowired
    BoMaintenanceEquipmentInf boMaintenanceEquipmentInf;
    @Value("${filePath}")
    private String path;

    @Override
    public ResultMap<BoEquipmentInfReady> getEquipmentInf() {
        boEquipmentInfReady.setSysEquipmentSyss(equipmentInfMapper.selectEquipmentSysList());
        boEquipmentInfReady.setSysEquipmentTypes(equipmentInfMapper.selectEquipmentTypes());
        return new ResultMap<>(200,"",boEquipmentInfReady);
    }

    //单个添加
    @Override
    public ResultMap<Integer> addequipmentInf(BoEquipmentInfAdd boEquipmentInfAdd) {
        String time= LocalDateTime.now().toString();
        String fileName="";
        String filePath="";
        int code=0;
        SysEquipmentSys sysEquipmentSys=equipmentInfMapper.selectEquipmentSysById(boEquipmentInfAdd.getEquipmentSysId());
        BoUser boUser=userMapper.selectBoUserById(boEquipmentInfAdd.getBelongTo());
        String content=
                "设备名称："+boEquipmentInfAdd.getEquipmentName()+";       "+
                "设备编号:"+boEquipmentInfAdd.getEquipmentCode()+";       "+
                "所属系统："+sysEquipmentSys.getEsysName()+";       "+
                "系统描述："+sysEquipmentSys.getEasyDesc()+";       "+
                "负责人："+boUser.getUserNameCn()+";       "+
                "联系方式："+boUser.getPhone()+";       "
                ;
        if (QRCodeUtil.zxingCodeCreate(content,500,null,boEquipmentInfAdd.getEquipmentCode())){
            code= equipmentInfMapper.insertIntoEquipmentInf(boEquipmentInfAdd)>0?200:201;
            return new ResultMap<>(code,"",null);
        }
        return new ResultMap<>(201,"",null);

    }
//    //批量添加
//    @Override
//    @Transactional
//    public ResultMap<Integer> addequipmentInfAll(MultipartFile file) {
//            String fileName = file.getOriginalFilename();
//            Workbook workbook = null;
//            try {
//                InputStream is=file.getInputStream();
//                if(fileName.endsWith("xls")){
//                    //2003
//                    workbook = new HSSFWorkbook(is);
//                }else if(fileName.endsWith("xlsx")) {
//                    //2007
//                    workbook = new XSSFWorkbook(is);
//                }
//                //获取第一个工作表
//                Sheet sheet=workbook.getSheetAt(0);
//                //获取Sheet的第一个行号和最后一个行号
//                //获得当前sheet的开始行
//                int firstRowNum  = sheet.getFirstRowNum();
//                //获得当前sheet的结束行
//                int lastRowNum = sheet.getLastRowNum();
//                ArrayList<String[]> Arrs=new ArrayList<String[]>();
//                //循环除了第二行的所有行
//                for(int rowNum = firstRowNum+1;rowNum <= lastRowNum;rowNum++) {
//                    //获得当前行
//                    Row row = sheet.getRow(rowNum);
//                    if (row == null) {
//                        continue;
//                    }
//                    //获得当前行的开始列
//                    int firstCellNum = row.getFirstCellNum();
//                    //获得当前行的列数
//                    int lastCellNum = row.getPhysicalNumberOfCells();
//                    String[] cells = new String[row.getPhysicalNumberOfCells()];
//                    //循环当前行
//                    for (int cellNum = firstCellNum; cellNum < lastCellNum; cellNum++) {
//                        Cell cell = row.getCell(cellNum);
//                        String cellValue = "";
//                        if(cell == null){
//                            cellValue= "";
//                        }
//                        //把数字当成String来读，避免出现1读成1.0的情况
//                        if(cell.getCellTypeEnum() == CellType.NUMERIC){
//                            cell.setCellType(CellType.STRING);
//                        }
//                        //判断数据的类型
//                            //数字
//                            if(cell.getCellTypeEnum()==CellType.NUMERIC) {
//                                cellValue = String.valueOf(cell.getNumericCellValue());
//                            }
//                            //字符串
//                            else if(cell.getCellTypeEnum()==CellType.STRING) {
//                                cellValue = String.valueOf(cell.getStringCellValue());
//                            }
//                            //Boolean
//                            else if(cell.getCellTypeEnum()==CellType.BOOLEAN) {
//                                cellValue = String.valueOf(cell.getBooleanCellValue());
//                            }
//                            //公式
//                            else if(cell.getCellTypeEnum()==CellType.FORMULA) {
//                                cellValue = String.valueOf(cell.getCellFormula());
//                            }
//                            //空值
//                            else if(cell.getCellTypeEnum()==CellType._NONE) {
//                                cellValue = "";
//                            }
//                            //故障
//                            else if(cell.getCellTypeEnum()==CellType.ERROR) {
//                                cellValue = "非法字符";
//                            }else {
//                                cellValue = "未知类型";
//                            }
//                            if(cellNum==3||cellNum==6){
//                                cells[cellNum] = cellValue;
//                            }else{
//                                cells[cellNum] = cellValue;
//                            }
//                        }
//                    Arrs.add(cells);
//                    }
//                for(String[] i:Arrs){
////                    Integer position=equipmentInfMapper.selectPositionByName(i[11],i[12]);
////                    equipmentInfMapper.insertIntoEquipmentInfAll(i,Integer.parseInt(i[3]),Integer.parseInt(i[6]),position);
//                }
//            } catch (IOException e1) {
//                e1.printStackTrace();
//            }
//        return null;
//    }

    @Override
    public ResultMap<BoEquipmentInfList> selectEquipmentList(BoEquipmentInfLimit boEquipmentInfLimit) {

        boEquipmentInfLimit.setPageNum(boEquipmentInfLimit.getPageNum()-1);
        boEquipmentInfLimit.setPageSize(boEquipmentInfLimit.getPageSize()-1);
        boEquipmentInfList.setAllNum(equipmentInfMapper.selectEquipmentListAll(boEquipmentInfLimit));
        boEquipmentInfList.setBoEquipmentInfs(equipmentInfMapper.selectEquipmentList(boEquipmentInfLimit));
        return new ResultMap<>(200,"",boEquipmentInfList);
    }



    @Override
    public ResultMap<Integer> editequipmentInf(BoEquipmentInfAdd boEquipmentInfAdd) {
        SysEquipmentSys sysEquipmentSys=equipmentInfMapper.selectEquipmentSysById(boEquipmentInfAdd.getEquipmentSysId());
        BoUser boUser=userMapper.selectBoUserById(boEquipmentInfAdd.getBelongTo());
        String content=
                "设备名称："+boEquipmentInfAdd.getEquipmentName()+";       "+
                        "设备编号:"+boEquipmentInfAdd.getEquipmentCode()+";       "+
                        "所属系统："+sysEquipmentSys.getEsysName()+";       "+
                        "系统描述："+sysEquipmentSys.getEasyDesc()+";       "+
                        "负责人："+boUser.getUserNameCn()+";       "+
                        "联系方式："+boUser.getPhone()+";       "
                ;
        if (QRCodeUtil.zxingCodeCreate(content,500,null,boEquipmentInfAdd.getEquipmentCode())){
            int code=equipmentInfMapper.updateEquipmentInf(boEquipmentInfAdd)>0?200:201;
            return new ResultMap<>(code,"",null);
        }
        return new ResultMap<>(201,"",null);
    }



    @Override
    public ResultMap<Integer>  deleteequipmentInf(Integer id) {
        int code=equipmentInfMapper.deleteequipmentInf(id)>0?200:201;
        return new ResultMap<>(code,"",null);
    }

    @Override
    public ResultMap<BoMaintenanceEquipmentInf> selectBoMaintenanceEquipmentInfByNum(String inf) {
        poEquipmentInfMainyenance=equipmentInfMapper.selectBoMaintenanceEquipmentInf(inf);
        if(poEquipmentInfMainyenance!=null){
            boMaintenanceEquipmentInf.setId(poEquipmentInfMainyenance.getId());
            boMaintenanceEquipmentInf.setEquipment_type(poEquipmentInfMainyenance.getEquipment_des());
            boMaintenanceEquipmentInf.setEquipment_position(equipmentInfMapper.getPosition(poEquipmentInfMainyenance.getEquipment_position_id()));
        }
        return new ResultMap<>(200,"",boMaintenanceEquipmentInf);
    }

    @Override
    public ResultMap<Integer>  checkEquipmentCode(String equipmentCode) {
        return new ResultMap<>(equipmentInfMapper.selectEquipmentCountByCode(equipmentCode)>0?200:201,"",null);
    }

    @Override
    public ResultMap<SysEquipmentInfo> getSysEquipmentInfById(int id) {
        SysEquipmentInfo sysEquipmentInf=equipmentInfMapper.selectSysEquipmentInfByid(id);
        return new ResultMap(200,"",sysEquipmentInf);
    }


}
