package com.yang.blog.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**  
 * @Title: ExceptionAspect.java
 * @Prject: sb-blog
 * @Package: com.yang.blog.aspect
 * @Description: TODO
 * @author: Sue2Yang 
 * @date: 2016年12月12日 下午5:32:12
 * @version: V1.0  
 */
@Component
@Aspect
public class ExceptionAspect {
	
	 public void afterThrowing(JoinPoint jp,Exception exp){
	        System.out.println(jp.getSignature().getName());
	        System.out.println("异常消息："+exp.getMessage());
	        System.out.println("----------异常通知----------");
	    }
}
