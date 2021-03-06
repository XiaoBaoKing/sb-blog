package com.yang.blog.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yang.blog.dao.ITagDao;
import com.yang.blog.dao.Impl.SpringJdbcBaseDaoImpl;
import com.yang.blog.model.SelectInfo;
import com.yang.blog.model.Tag;
import com.yang.blog.service.ISelectInfoService;
import com.yang.blog.service.ITagService;

/**  
 * @Title: ITagServiceImpl.java
 * @Prject: sb-blog
 * @Package: com.yang.blog.service.Impl
 * @Description: TODO
 * @author: Sue2Yang 
 * @date: 2016年12月2日 下午4:11:07
 * @version: V1.0  
 */
@Service
public class TagServiceImpl extends BaseServiceImpl<Tag> implements ITagService{
	@Resource
	ITagDao iTagDao;
	public TagServiceImpl() {
	}
}
