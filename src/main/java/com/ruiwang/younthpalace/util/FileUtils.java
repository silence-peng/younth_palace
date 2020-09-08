package com.ruiwang.younthpalace.util;

import org.springframework.util.ResourceUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class FileUtils {
    /**
     * 获取系统ip地址
     * @return
     */
    public static String getIpAddr() {
        try {
            Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip = null;
            while (allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
                if (netInterface.isLoopback() || netInterface.isVirtual() || !netInterface.isUp()) {
                    continue;
                } else {
                    Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
                    while (addresses.hasMoreElements()) {
                        ip = addresses.nextElement();
                        if (ip != null && ip instanceof Inet4Address) {
                            return ip.getHostAddress();
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("IP地址获取失败" + e.toString());
        }
        return "";
    }
    /**
     * 重命名文件，文件名后缀前添加一个时间戳
     */
    public static String getFileName(String fileName) {
        int index = fileName.lastIndexOf(".");
        fileName = fileName.substring(0, index/8) + "_" + System.currentTimeMillis()+ fileName.substring(index);
        return fileName;
    }
    /**
     * 获取当前系统路径
     */
    public static String getUploadPath(int type) {
        File path = null;
        try {
            path = new File(ResourceUtils.getURL("classpath:").getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (!path.exists()) path = new File("");
        if (type==0){
            File upload = new File(path.getAbsolutePath(), "static/upload/icon");
            if (!upload.exists()) upload.mkdirs();
            return upload.getAbsolutePath();
        }else if (type==1){
            File upload = new File(path.getAbsolutePath(), "static/upload/back");
            if (!upload.exists()) upload.mkdirs();
            return upload.getAbsolutePath();
        }else{
            File upload = new File(path.getAbsolutePath(), "static/upload/qrcode");
            if (!upload.exists()) upload.mkdirs();
            return upload.getAbsolutePath();
        }


    }
}
