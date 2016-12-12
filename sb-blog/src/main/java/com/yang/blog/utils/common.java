package com.yang.blog.utils;

import java.lang.reflect.Field;

import com.yang.blog.annotation.Varchar;
import com.yang.blog.exception.ModelTypeException;

/**
 * @Title: common.java
 * @Prject: sb-blog
 * @Package: com.yang.blog.utils
 * @Description: TODO
 * @author: Sue2Yang
 * @date: 2016年9月20日 下午9:21:17
 * @version: V1.0
 */
public class Common {
	/**
	 * 截取0~length-1
	 * 
	 * @param content
	 * @return
	 */
	public static String substrStringExceptLastOne(String content) {
		return content.substring(0, content.length() - 1);
	}

	/**
	 * 首字母大写
	 * 
	 * @param s
	 * @return
	 */
	public static String toUpperCaseFirstOne(String s) {
		if (Character.isUpperCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
	}
	/**
	 * 首字母小写
	 * 
	 * @param s
	 * @return
	 */
	public static String toLowerCaseFirstOne(String s) {
		if (Character.isLowerCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
	}

	public static String  typeMapper(Field field) throws Exception {
		String type = field.getType().getName();
		String dbType = "";
		if (type.equals("java.lang.String")) {
			Varchar Varchar = (Varchar)field.getAnnotation(Varchar.class);
			dbType="varchar("+Varchar.Length()+")";
		} else if (type.equals("int") || type.equals("java.lang.Integer")) {
			dbType="int";
		} else if (type.equals("long") || type.equals("java.lang.Long")) {
			dbType="int";
		} else if (type.equals("boolean") || type.equals("java.lang.Boolean")) {
			dbType = "tinyint(1)";
		} else if (type.equals("java.util.Date")) {
			dbType = "date";
		} else if(type.equals("java.util.List")||type.equals("List")){
			throw new ModelTypeException("不允许的类型");
		}
		else {
			dbType = "varchar(255)";
		}
		return dbType;
	}
}
