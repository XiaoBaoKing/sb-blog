package com.yang.blog.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yang.blog.dao.ISelectInfoDao;
import com.yang.blog.dao.Impl.SpringJdbcBaseDaoImpl;
import com.yang.blog.model.Comment;
import com.yang.blog.model.SelectInfo;
import com.yang.blog.service.ICommentService;
import com.yang.blog.service.ISelectInfoService;

/**  
 * @Title: ISelectInfoServiceImpl.java
 * @Prject: sb-blog
 * @Package: com.yang.blog.service.Impl
 * @Description: TODO
 * @author: Sue2Yang 
 * @date: 2016年12月2日 下午4:10:55
 * @version: V1.0  
 */
@Service
public class SelectInfoServiceImpl extends BaseServiceImpl<SelectInfo> implements ISelectInfoService{
	@Resource
	ISelectInfoDao iSelectInfoDao;
	public SelectInfoServiceImpl() {
	}
}
