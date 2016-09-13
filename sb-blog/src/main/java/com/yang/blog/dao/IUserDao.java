package com.yang.blog.dao;

import java.util.List;

import com.yang.blog.model.User;

/**
 * @Title: IUserDao.java
 * @Prject: sb-blog
 * @Package: com.yang.blog.dao
 * @Description: TODO
 * @author: Sue2Yang
 * @date: 2016年9月13日 下午6:19:06
 * @version: V1.0
 */
public interface IUserDao {
	public int create();

	public int save(User user);

	public User getUser(User user);

	public List<User> getAll();
}
