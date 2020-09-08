package com.ruiwang.younthpalace.log.aspect;


//import cn.pojo.Action;
//import cn.pojo.User;
//import cn.service.ActionService;
//import cn.utils.IpUtils;
//import cn.utils.JsonUtils;
import com.ruiwang.younthpalace.entity.power.SysUser;
import com.ruiwang.younthpalace.log.pojo.Log;
import com.ruiwang.younthpalace.log.target.SystemControllerLog;
import com.ruiwang.younthpalace.log.target.SystemServiceLog;
import com.ruiwang.younthpalace.service.power.impl.UserService;

import com.ruiwang.younthpalace.util.FileUtils;
import com.ruiwang.younthpalace.util.RedisUtil;
import com.ruiwang.younthpalace.util.ResultMap;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * Title: SystemControllerLog
 * @date 2018年8月31日
 * @version V1.0
 * Description: 切点类
 */
@Aspect
@Component
@SuppressWarnings("all")
public class SystemLogAspect {
    //注入Service用于把日志保存数据库，实际项目入库采用队列做异步
    @Resource
    private UserService userService;
    @Resource
    private RedisUtil redisUtil;
    //本地异常日志记录对象
    private static final Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);
    //Service层切点
    @Pointcut("@annotation(com.ruiwang.younthpalace.log.target.SystemServiceLog)")
    public void serviceAspect(){
    }

    @Pointcut("execution(public * com.ruiwang.younthpalace.contorller.files.*.*(..)) " +
            "|| execution(public * com.ruiwang.younthpalace.contorller.map.*.*(..))"+
            "|| execution(public * com.ruiwang.younthpalace.contorller.platform.*.*(..))"+
            "|| execution(public * com.ruiwang.younthpalace.contorller.power.*.*(..))"
    )
    public void point() {
    }

    //Controller层切点
    @Pointcut("@annotation(com.ruiwang.younthpalace.log.target.SystemControllerLog)")
    public void controllerAspect(){
    }

    /**
     * @Description  前置通知  用于拦截Controller层记录用户的操作
     * @date 2018年9月3日 10:38
     */

    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        //从请求头中获取tokenid
        String tokenId=request.getHeader("token");
        //读取redis中的用户
        SysUser user = (SysUser) redisUtil.get(tokenId);

        String ip = FileUtils.getIpAddr();

        try {
            //*========控制台输出=========*//
            System.out.println("==============前置通知开始==============");
            System.out.println("请求方法" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName()));
            System.out.println("方法描述：" + getControllerMethodDescription(joinPoint));
            System.out.println("请求人："+user.getUserName());
            System.out.println("请求ip："+ip);

            //*========数据库日志=========*//
            Log log=new Log();

//            Action action = new Action();
//            action.setActionDes(getControllerMethodDescription(joinPoint));
//            action.setActionType("0");
//            action.setActionIp(ip);
//            action.setUserId(user.getId());
//            action.setActionTime(new Date());
//            //保存数据库
//            actionService.add(action);

        }catch (Exception e){
            //记录本地异常日志
            logger.error("==前置通知异常==");
            logger.error("异常信息：{}",e.getMessage());
        }
    }

    /**
     * @Description  异常通知 用于拦截service层记录异常日志
     * @date 2018年9月3日 下午5:43
     */
    @AfterThrowing(pointcut = "serviceAspect()",throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint,Throwable e){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        String tokenId=request.getHeader("token");
        //读取redis中的用户
        SysUser user = (SysUser) redisUtil.get(tokenId);
        //获取请求ip
        String ip = FileUtils.getIpAddr();
        //获取用户请求方法的参数并序列化为JSON格式字符串
        String params = "";
        if (joinPoint.getArgs()!=null&&joinPoint.getArgs().length>0){
            for (int i = 0; i < joinPoint.getArgs().length; i++) {
                params+= JSONObject.fromObject(joinPoint.getArgs()[i])+";";
            }
        }
        try{
            /*========控制台输出=========*/
            System.out.println("=====异常通知开始=====");
            System.out.println("异常代码:" + e.getClass().getName());
            System.out.println("异常信息:" + e.getMessage());
            System.out.println("异常方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            System.out.println("方法描述:" + getServiceMethodDescription(joinPoint));
            System.out.println("请求人:" + user.getUserName());
            System.out.println("请求IP:" + ip);
            System.out.println("请求参数:" + params);
            /*==========数据库日志=========*/
//            Action action = new Action();
//            action.setActionDes(getServiceMethodDescription(joinPoint));
//            action.setActionType("1");
//            action.setUserId(user.getId());
//            action.setActionIp(ip);
//            action.setActionTime(new Date());
//            //保存到数据库
//            actionService.add(action);
        }catch (Exception ex){
            //记录本地异常日志
            logger.error("==异常通知异常==");
            logger.error("异常信息:{}", ex.getMessage());
        }
    }


    /**
     * @Description  获取注解中对方法的描述信息 用于service层注解
     * @date 2018年9月3日 下午5:05
     */
    public static String getServiceMethodDescription(JoinPoint joinPoint)throws Exception{
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method:methods) {
            if (method.getName().equals(methodName)){
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length==arguments.length){
                    description = method.getAnnotation(SystemServiceLog.class).description();
                    break;
                }
            }
        }
        return description;
    }



    /**
     * @Description  获取注解中对方法的描述信息 用于Controller层注解
     * @date 2018年9月3日 上午12:01
     */
    public static String getControllerMethodDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();//目标方法名
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method:methods) {
            if (method.getName().equals(methodName)){
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length==arguments.length){
                    description = method.getAnnotation(SystemControllerLog.class).description();
                    break;
                }
            }
        }
        return description;
    }
//    @Around("point()")
    public Object trackInfo(ProceedingJoinPoint pjp) throws Throwable {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        String tokenId = request.getHeader("token");
        SysUser user = (SysUser) redisUtil.get(tokenId);

        if (user == null) {
            logger.info("-------------没有登录-------------");
            return new ResultMap<>(203,"登录超时，请重新登录",null);
        } else {
            logger.info("-------------登录通过-------------");
        }
        return pjp.proceed();
    }
}