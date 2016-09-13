package com.yang.blog.model;

import com.google.gson.Gson;

/**
 * @Title: baseDao.java
 * @Prject: sb-blog
 * @Package: com.yang.blog.model
 * @Description: TODO
 * @author: Sue2Yang
 * @date: 2016年9月13日 下午4:25:43
 * @version: V1.0
 */
public class BaseDao {
	private static Gson gson = new Gson();
	public String toJson() {
		return gson.toJson(this);
	}

}
