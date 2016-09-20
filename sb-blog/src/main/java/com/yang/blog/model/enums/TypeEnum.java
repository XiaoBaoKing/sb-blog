package com.yang.blog.model.enums;

import java.lang.reflect.Field;

import com.yang.blog.Exception.ModelTypeException;

/**
 * @Title: TypeEnum.java
 * @Prject: sb-blog
 * @Package: com.yang.blog.model.enums
 * @Description: TODO
 * @author: Sue2Yang
 * @date: 2016年9月20日 下午2:42:28
 * @version: V1.0
 */
public enum TypeEnum {
	LIST("List", 0), INTEGER("Integer", 1), STRING("String", 2), DATE("Date", 2);
	private String content;
	private int sign;

	private TypeEnum(String content, int sign) {
		this.content = content;
		this.sign = sign;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return this.content;
	}

	public static String getSQLFieldString(Field param, Object obj)
			throws ModelTypeException, IllegalArgumentException, IllegalAccessException {
		String sqlFieldString = "";
		for (TypeEnum t : TypeEnum.values()) {
			if (param.getClass().getSimpleName() == t.toString()) {
				switch (t.sign) {
				case 0:
					throw new ModelTypeException("List类型");
				case 1:
					sqlFieldString += param.get(obj) == null ? null : param.get(obj).toString();
					break;
				case 2:
					sqlFieldString += param.get(obj) == null ? null : "'" + param.get(obj).toString() + "'";
					break;
				default:
					throw new ModelTypeException("内部错误");
				}
			} else {
				throw new ModelTypeException("错误的类型");
			}
		}
		return sqlFieldString;
	}

}
