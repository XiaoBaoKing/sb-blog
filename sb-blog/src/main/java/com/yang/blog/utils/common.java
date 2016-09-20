package com.yang.blog.utils;

/**
 * @Title: common.java
 * @Prject: sb-blog
 * @Package: com.yang.blog.utils
 * @Description: TODO
 * @author: Sue2Yang
 * @date: 2016年9月20日 下午9:21:17
 * @version: V1.0
 */
public class common {
	/**
	 * 截取0~length-1
	 * @param content
	 * @return
	 */
	public static String substrStringExceptLastOne(String content) {
		return content.substring(0, content.length() - 1);
	}
	
	/**
	 * 首字母大写
	 * @param s
	 * @return
	 */
	public static String toUpperCaseFirstOne(String s) {
		if (Character.isUpperCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
	}
}
