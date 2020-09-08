package com.ruiwang.younthpalace.service.file.impl;

import com.ruiwang.younthpalace.entity.file.SysImgInfo;
import com.ruiwang.younthpalace.entity.map.SysEditPageInfo;
import com.ruiwang.younthpalace.mapper.file.ImgInfoMapper;
import com.ruiwang.younthpalace.service.file.IImgInfoService;
import com.ruiwang.younthpalace.util.FileUtils;

import com.ruiwang.younthpalace.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.*;

@Service
public class ImgInfoServiceImpl implements IImgInfoService {
    @Autowired
    private ImgInfoMapper imgInfoMapper;
    @Value("${port}")
    String port;
    /**
     * 添加背景图片
     */
    public ResultMap<String> addBackImg(MultipartFile file,Integer type,String descName){
        int code=201;
        String fileName="";
        String msg="";
        try{
            if (file!=null){
                String path= FileUtils.getUploadPath(1);
                String realName=file.getOriginalFilename();
                String  suffix=realName.substring(realName.lastIndexOf(".")).toLowerCase();
                fileName=descName+suffix;
                if (imgInfoMapper.selectImgInfByName(fileName)==0){
                    SysImgInfo sysImgInfo=new SysImgInfo();
                    sysImgInfo.setImgUrl(fileName);
                    sysImgInfo.setDescName(descName);
                    sysImgInfo.setType(type);
                    code=imgInfoMapper.addImgInf(sysImgInfo)>0?200:201;
                }
                if (suffix.equals(".jpg") || suffix.equals(".png") || suffix.equals(".gif")){
                    OutputStream os=new FileOutputStream(path+File.separator+fileName);
                    //获取输入流 MultipartFile 中可以直接得到文件的流
                    InputStream is=file.getInputStream();
                    byte[] bts = new byte[1024];
                    //一个一个字节的读取并写入
                    while(is.read(bts)!=-1)
                    {
                        os.write(bts);
                    }
                    os.flush();
                    os.close();
                    is.close();
                    msg="上传成功";
                }else{
                    msg="图片类型错误";
                    code=201;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResultMap<String>(code,msg,"http://"+FileUtils.getIpAddr()+":"+port+File.separator+"upload/back" + File.separator+fileName);
    }
    /**
     * 添加图标图片
     */
    @Override
    public ResultMap<String> addIconImg(MultipartFile file, Integer type, String groupType, String descName) {
        int code=201;
        String fileName="";
        String msg="";
        try{
            if (file!=null){
                String path=FileUtils.getUploadPath(0);
                String realName=file.getOriginalFilename();
                String  suffix=realName.substring(realName.lastIndexOf(".")).toLowerCase();
                fileName=FileUtils.getFileName(realName);
                if (suffix.equals(".jpg") || suffix.equals(".png") || suffix.equals(".gif")){
                    OutputStream os=new FileOutputStream(path+File.separator+fileName);
                    //获取输入流 MultipartFile 中可以直接得到文件的流
                    InputStream is=file.getInputStream();
                    byte[] bts = new byte[1024];
                    //一个一个字节的读取并写入
                    while(is.read(bts)!=-1)
                    {
                        os.write(bts);
                    }
                    os.flush();
                    os.close();
                    is.close();
                    SysImgInfo sysImgInfo=new SysImgInfo();
                    sysImgInfo.setGroupType(groupType);
                    sysImgInfo.setImgUrl(fileName);
                    sysImgInfo.setDescName(descName);
                    sysImgInfo.setType(type);
                    code=imgInfoMapper.addImgInf(sysImgInfo)>0?200:201;
                    msg="上传成功";
                }else{
                    msg="图片类型错误";
                    code=201;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
        return new ResultMap<String>(code,msg,"http://"+FileUtils.getIpAddr()+":"+port+File.separator+"upload/icon" + File.separator+fileName);
    }

    @Override
    public ResultMap<List<SysImgInfo>> selectImgInf(SysImgInfo sysImgInfo) {
        //获取本机IP地址
        String ip= FileUtils.getIpAddr();
        List<SysImgInfo> list=imgInfoMapper.selectImgInf(sysImgInfo);
        for (SysImgInfo  s:list) {
            if (!s.getImgUrl().isEmpty()) {
                s.setImgUrl("http://"+ip+":"+port+File.separator+"upload" + File.separator+s.getImgUrl());
            } else {
                s.setImgUrl("/");
            }
        }
        return new ResultMap<>(200,"",list);
    }

    @Override
    @Transactional
    public ResultMap<Integer> deleteImgInf(String ids) {
        List<String> list= Arrays.asList(ids.split(","));
        int code=0;
        int result=0;
        try {
            List<SysImgInfo> names=imgInfoMapper.selectImgInfByIds(list);
            code=imgInfoMapper.deleteImgInf(list)>0?200:201;
            for (SysImgInfo s: names) {
                if (s!=null){
                    //获取本地服务器文件地址
                    String filepath=FileUtils.getUploadPath(s.getType());
                    String realUrl=filepath+File.separator+s.getImgUrl();
                    File file = new File(realUrl);
                    if (file.exists()) {//文件是否存在
                        //删除文件
                        file.delete();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
        return new ResultMap<>(code,"",null);
    }





}
