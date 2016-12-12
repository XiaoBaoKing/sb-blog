package com.yang.blog.model.enums;

/**
 * @Title: AvailableEnum.java
 * @Prject: sb-blog
 * @Package: enums
 * @Description: TODO
 * @author: Sue2Yang
 * @date: 2016年9月14日 下午2:47:53
 * @version: V1.0
 */
public enum AvailableEnum {
	TRUE(Boolean.TRUE, "可用"), FALSE(Boolean.FALSE, "不可用");
	private final Boolean value;
	private final String info;

	private AvailableEnum(Boolean value, String info) {
		this.value = value;
		this.info = info;
	}

	public String getInfo() {
		return info;
	}
}
