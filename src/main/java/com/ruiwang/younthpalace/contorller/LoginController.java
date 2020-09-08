package com.ruiwang.younthpalace.contorller;


import com.ruiwang.younthpalace.bojo.UrlInf;
import com.ruiwang.younthpalace.bojo.power.Dto;
import com.ruiwang.younthpalace.entity.power.SysUser;
import com.ruiwang.younthpalace.service.power.IUserService;
import com.ruiwang.younthpalace.service.power.TokenService;
import com.ruiwang.younthpalace.util.RedisUtil;
import com.ruiwang.younthpalace.util.ResultMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
@Api(description = "登录接口")
@Controller
@RequestMapping("/")
public class LoginController {
    @Autowired
    IUserService userService;
    @Autowired
    UrlInf urlInf;
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    private TokenService tokenService;
//    @CrossOrigin
//    @RequestMapping("/")
//    public String tologin() {
//        return "login";
//    }
//
//    @CrossOrigin
//    @RequestMapping("/login")
//    public String login() {
//        return "login";
//    }
//
//    @CrossOrigin
//    @RequestMapping("/404")
//    public String error() {
//        return "404";
//    }
//    @CrossOrigin
//    @RequestMapping("/loginDo")
//    public void loginDo(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        Cookie[] cookies=request.getCookies();
//        boolean isTrue=false;
//        LoginInf loginInf=userService.loginReady(request.getParameter("userName"));
//        System.out.println(loginInf.getMenuList().toString());
//        if(loginInf.getUserName()!=null) {
//            request.getSession().setAttribute("loginInf",loginInf);
//        }
//        for(String urlkey:urlInf.getUrlInf()){
//            if(request.getParameter("toUrl").contains(urlkey)){
//                response.sendRedirect(urlkey);
//                return;
//            }
//        }
//        response.sendRedirect("power/userManage");
//    }

    @ApiOperation(value = "登录接口",notes = "登录用户保存到redis")
    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "login.do")
    public Object login(String userName,String password,HttpServletRequest request){
        Dto dto = new Dto();
        ResultMap<SysUser> map= userService.selectByName(userName);
        SysUser sysUser= (SysUser) map.getData();
        if (null==sysUser){
            return new ResultMap<>(201,"用户不存在",null);
        }else if (sysUser.getUserPassword().equals(password)){
            String userAgent = request.getHeader("user-agent");
            String token = this.tokenService.generateToken(userAgent, userName);
            this.tokenService.saveToken(token, sysUser);
            dto.setIsLogin("true");
            dto.setToken(token);
            dto.setTokenCreatedTime(System.currentTimeMillis());
            dto.setTokenExpiryTime(System.currentTimeMillis() + 2*60*60*1000);
            return new ResultMap<>(200,"登录成功",token);
        }else{
            dto.setIsLogin("false");
            return new ResultMap<>(201,"账户和密码不一致",null);
        }
    }
    @ApiOperation(value = "退出登录",notes = "退出登录")
    @CrossOrigin
    @ResponseBody
    @GetMapping(value = "loginOut.do")
    public void loginOut(HttpServletRequest request){
        String tokenId=request.getHeader("token");
        redisUtil.del(tokenId);
    }
    @ApiOperation(value = "获取登录用户信息",notes = "从redis获取登录用户信息")
    @CrossOrigin
    @ResponseBody
    @GetMapping(value = "getLoginInfo")
    public Object getLoginInfo(HttpServletRequest request){
        String tokenId=request.getHeader("token");
        return new ResultMap<>(200,"",redisUtil.get(tokenId));
    }
}
