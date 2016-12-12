package com.yang.blog.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**  
 * @Title: Varchar.java
 * @Prject: sb-blog
 * @Package: com.yang.blog.annotation
 * @Description: TODO
 * @author: Sue2Yang 
 * @date: 2016年9月26日 下午2:38:48
 * @version: V1.0  
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Varchar {
	public int Length() default 255;
}
