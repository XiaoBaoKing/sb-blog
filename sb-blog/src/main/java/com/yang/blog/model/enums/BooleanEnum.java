package com.yang.blog.model.enums;

/**
 * @Title: BooleanEnum.java
 * @Prject: sb-blog
 * @Package: com.yang.blog.model.enums
 * @Description: TODO
 * @author: Sue2Yang
 * @date: 2016年9月14日 下午2:49:35
 * @version: V1.0
 */
public enum BooleanEnum {
	TRUE(Boolean.TRUE, "是"), FALSE(Boolean.FALSE, "否");

	private final Boolean value;
	private final String info;

	private BooleanEnum(Boolean value, String info) {
		this.value = value;
		this.info = info;
	}

	public String getInfo() {
		return info;
	}

	public Boolean getValue() {
		return value;
	}
}
