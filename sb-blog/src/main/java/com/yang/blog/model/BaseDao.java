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
	private int pn;
	private int pageSize;

	private static Gson gson = new Gson();

	public String toJson() {
		return gson.toJson(this);
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize
	 *            the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the pn
	 */
	public int getPn() {
		return pn;
	}

	/**
	 * @param pn
	 *            the pn to set
	 */
	public void setPn(int pn) {
		this.pn = pn;
	}

}
