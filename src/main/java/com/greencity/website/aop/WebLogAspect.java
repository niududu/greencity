package com.greencity.website.aop;

import cn.hutool.extra.servlet.ServletUtil;
import com.greencity.website.VO.ResultVO;
import com.greencity.website.enums.ResultEnum;
import com.greencity.website.util.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * controlelr 日志
 *
 * @author 技术部
 */
@Aspect
@Component
@Slf4j
public class WebLogAspect {

    /**
     * 以 controller 包下定义的所有请求为切入点
     */
    @Pointcut("execution(public * com.greencity.website.controller..*.*(..))")
    public void webLog() {
    }


    /**
     * 在切点之前织入
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        Class<?> clazz = joinPoint.getTarget().getClass();
        Logger logger = LoggerFactory.getLogger(clazz);

        // 开始打印请求日志
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();

        // 打印请求相关参数
        logger.info("<-- {}, {}, {}, {}.{}",
                request.getMethod(),
                ServletUtil.getParamMap(request),
                request.getRequestURI(),
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName());
    }

    //使用@AfterReturning在切入点return内容之后切入内容（可以用来对处理返回值做一些加工处理）
    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) {
        // 处理完请求，返回内容
        log.info("响应RESPONSE : {}", ret);
    }

    @AfterThrowing(value = "com.greencity.website.aop.WebLogAspect.webLog()", throwing = "e")
    public ResultVO afterThrowing(Throwable e) {
        // 开始打印请求日志
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 打印请求相关参数
        log.error("<-- {},{},{}", request.getMethod(),request.getRequestURI(), e.getStackTrace());
        return ResultVOUtil.error(ResultEnum.ERROR);
    }
}
