package com.yang.blog.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yang.blog.dao.ICommentDao;
import com.yang.blog.dao.Impl.SpringJdbcBaseDaoImpl;
import com.yang.blog.model.Comment;
import com.yang.blog.service.ICommentService;

/**  
 * @Title: ICommentServiceImpl.java
 * @Prject: sb-blog
 * @Package: com.yang.blog.service.Impl
 * @Description: TODO
 * @author: Sue2Yang 
 * @date: 2016年12月2日 下午4:05:57
 * @version: V1.0  
 */

public class ICommentServiceImpl extends IBaseServiceImpl<Comment> implements ICommentService{
	@Resource
	ICommentDao iCommentDao;
	public ICommentServiceImpl() {
	}
}
