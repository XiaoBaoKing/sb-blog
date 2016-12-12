package com.yang.blog.dao.Impl;

import org.springframework.stereotype.Repository;

import com.yang.blog.dao.IUserDao;
import com.yang.blog.model.User;

/**  
 * @Title: UserDaoImpl.java
 * @Prject: sb-blog
 * @Package: com.yang.blog.dao.Impl
 * @Description: TODO
 * @author: Sue2Yang 
 * @date: 2016年9月29日 下午10:50:38
 * @version: V1.0  
 */
@Repository
public class UserDaoImpl extends SpringJdbcBaseDaoImpl<User> implements IUserDao{
	
}
