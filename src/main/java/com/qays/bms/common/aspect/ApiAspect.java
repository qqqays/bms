package com.qays.bms.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * Created by Q-ays.
 * 11-29-2017 9:06
 */
@Aspect
@Component
@Slf4j
public class ApiAspect {

    @Pointcut("execution(public * com.qays.bms.controller.api.*.*(..)) @org.springframework.web.bind.annotation.*Mapping")
    public void apiMethod() {
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void apiAnnotation() {
    }


    @Before("apiMethod()")
    public void doBefore(JoinPoint joinPoint){
//        RequestMapping rm = (RequestMapping) joinPoint.getSignature().getDeclaringType().getAnnotation(RequestMapping.class);
//        InvocationHandler h = Proxy.getInvocationHandler(rm);
//        Field hField = h.getClass().getDeclaredField("memberValues");
//        hField.setAccessible(true);
//        Map<String,String> memberValues = (Map) hField.get(h);
//        memberValues.put("value", "/api" + memberValues.get("value"));

        log.info(joinPoint.getSignature().getName());
    }

//    @Before("apiLog()")
//    public void doBefore4api(JoinPoint joinPoint) {
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//
//        //url
//        logger.info("\nurl={}", request.getRequestURL());
//
//        //method
//        logger.info("request_method={}", request.getMethod());
//
//        //ip
//        logger.info("ip={}", request.getRemoteAddr());
//
////        api
//        logger.info("api={}", request.getRequestURI());
//
//        //类方法
////        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
////        logger.info("class_method={}", joinPoint.getSignature());
//
//        if (!request.getMethod().toUpperCase().equals(RequestMethod.GET.toString())) {
//            try {
//                logService.apiLogInsert(
//                        ((UserEntity) SecurityUtils.getSubject().getPrincipal()).getUserName(),
//                        request.getRemoteAddr(),
//                        request.getRequestURI(),
//                        request.getMethod(),
//                        joinPoint.getSignature().toString(),
//                        "");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }

}
