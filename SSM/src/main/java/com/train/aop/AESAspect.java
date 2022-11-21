package com.train.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


/**
 * Created by 符柱成 on 2017/8/3.
 */
@Component
@Aspect
public class AESAspect {

    @Before(value = "execution(public * com.train.controller.*.*(..))" )
    public void beforeShow(JoinPoint jp) {
        String className = jp.getThis().toString();
        String methodName = jp.getSignature().getName();
        System.out.println("执行方法：类"+className+"，方法："+methodName);
    }
}
