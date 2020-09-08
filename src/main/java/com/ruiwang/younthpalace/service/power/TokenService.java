package com.ruiwang.younthpalace.service.power;


import com.alibaba.fastjson.JSONObject;
import com.ruiwang.younthpalace.entity.power.SysUser;
import com.ruiwang.younthpalace.util.RedisUtil;

import nl.bitwalker.useragentutils.UserAgent;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Service("tokenService")
public class TokenService {
    @Autowired
    private RedisUtil redisUtil;
    //生成token(格式为token:设备-加密的用户名-时间-六位随机数)
    public String generateToken(String userAgent, String username){
        StringBuilder token = new StringBuilder();
        //加token:
        token.append("token:");
        //加设备
        UserAgent userAgent1 = UserAgent.parseUserAgentString(userAgent);
        if (userAgent1.getOperatingSystem().isMobileDevice()){
            token.append("MOBILE-");
        } else {
            token.append("PC-");
        }
        //加加密的用户名
        token.append(DigestUtils.md5Hex(username) + "-");
        //加时间
        token.append(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + "-");
        //加六位随机数111111-999999
        token.append(new Random().nextInt((999999 - 111111 + 1)) + 111111);
        return token.toString();
    }

    //保存token
    public void saveToken(String token, SysUser user){
        //如果是PC，那么token保存两个小时；如果是MOBILE
        if (token.startsWith("token:PC")) {
            System.out.println(redisUtil.set(token,user,2*60*60));
    } else {
        redisUtil.set(token, JSONObject.toJSONString(user));
    }
    }

}