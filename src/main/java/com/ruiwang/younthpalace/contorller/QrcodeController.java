package com.ruiwang.younthpalace.contorller;

import com.google.zxing.Result;
import com.ruiwang.younthpalace.util.QRCodeUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 二维码调用前端控制器
 */
@RequestMapping("/Qrcode")
@RestController
public class QrcodeController {

    /**
     * 生成二维码
     */
    @GetMapping("add")
    public void productcode() {
//
    }


    /**
     * 解析二维码
     */
    @GetMapping("/test")
    public void analysiscode() {
        Result result = QRCodeUtil.zxingCodeAnalyze("D:/116.jpg");
        System.err.println("二维码解析内容："+result.toString());
    }

}