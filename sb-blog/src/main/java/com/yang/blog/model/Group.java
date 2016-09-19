package com.yang.blog.model;

import java.util.List;

/**
 * @Title: Group.java
 * @Prject: sb-blog
 * @Package: com.yang.blog.model
 * @Description: TODO
 * @author: Sue2Yang
 * @date: 2016年9月13日 下午4:43:03
 * @version: V1.0
 */
public class Group extends BaseDao {
	private Integer group_Id;
	private String name;
	private List<User> user;

	/**
	 * @return the group_Id
	 */
	public int getGroup_Id() {
		return group_Id;
	}

	/**
	 * @param group_Id
	 *            the group_Id to set
	 */
	public void setGroup_Id(int group_Id) {
		this.group_Id = group_Id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the user
	 */
	public List<User> getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(List<User> user) {
		this.user = user;
	}

}
