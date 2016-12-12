package com.yang.blog.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yang.blog.dao.IGroupDao;
import com.yang.blog.dao.Impl.SpringJdbcBaseDaoImpl;
import com.yang.blog.model.Group;
import com.yang.blog.service.IGroupService;

/**  
 * @Title: IGroupServiceImpl.java
 * @Prject: sb-blog
 * @Package: com.yang.blog.service.Impl
 * @Description: TODO
 * @author: Sue2Yang 
 * @date: 2016年12月2日 下午4:09:58
 * @version: V1.0  
 */
@Service
public class GroupServiceImpl extends BaseServiceImpl<Group> implements IGroupService{
	@Resource
	IGroupDao iGroupDao;
	public GroupServiceImpl() {
	}
}
