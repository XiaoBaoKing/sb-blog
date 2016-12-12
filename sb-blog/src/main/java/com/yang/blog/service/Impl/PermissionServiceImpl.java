package com.yang.blog.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yang.blog.dao.IPermissionDao;
import com.yang.blog.dao.Impl.SpringJdbcBaseDaoImpl;
import com.yang.blog.model.Comment;
import com.yang.blog.model.Permission;
import com.yang.blog.service.ICommentService;
import com.yang.blog.service.IPermissionService;

/**  
 * @Title: IPermissionService.java
 * @Prject: sb-blog
 * @Package: com.yang.blog.service.Impl
 * @Description: TODO
 * @author: Sue2Yang 
 * @date: 2016年12月2日 下午4:10:36
 * @version: V1.0  
 */
@Service
public class PermissionServiceImpl extends BaseServiceImpl<Permission> implements IPermissionService{
	@Resource
	IPermissionDao iPermissionDao;
	public PermissionServiceImpl() {
	}
}
