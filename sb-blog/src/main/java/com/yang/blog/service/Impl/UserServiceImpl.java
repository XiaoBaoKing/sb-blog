package com.yang.blog.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yang.blog.dao.IUserDao;
import com.yang.blog.dao.Impl.SpringJdbcBaseDaoImpl;
import com.yang.blog.model.SelectInfo;
import com.yang.blog.model.User;
import com.yang.blog.service.ISelectInfoService;
import com.yang.blog.service.IUserService;

/**  
 * @Title: IUserService.java
 * @Prject: sb-blog
 * @Package: com.yang.blog.service.Impl
 * @Description: TODO
 * @author: Sue2Yang 
 * @date: 2016年12月2日 下午4:11:20
 * @version: V1.0  
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService{
	@Resource
	IUserDao iUserDao;
	public UserServiceImpl() {
	}
}
