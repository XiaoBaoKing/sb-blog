package com.yang.blog.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**  
 * @Title: IdAnnotation.java
 * @Prject: sb-blog
 * @Package: com.yang.blog.annotation
 * @Description: TODO
 * @author: Sue2Yang 
 * @date: 2016年9月20日 下午4:57:47
 * @version: V1.0  
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Id {
	public String name() default "";
}
