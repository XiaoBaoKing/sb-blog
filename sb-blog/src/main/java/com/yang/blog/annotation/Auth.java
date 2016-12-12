package com.yang.blog.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Title: Auth.java
 * @Prject: sb-blog
 * @Package: com.yang.blog.annotation
 * @Description: TODO
 * @author: Sue2Yang
 * @date: 2016年12月9日 下午4:36:50
 * @version: V1.0
 */
@Documented
@Inherited
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Auth {
	boolean validate() default true;
}
