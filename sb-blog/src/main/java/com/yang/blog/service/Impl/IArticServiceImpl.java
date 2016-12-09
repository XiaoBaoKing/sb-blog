package com.yang.blog.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yang.blog.dao.IArticDao;
import com.yang.blog.dao.Impl.SpringJdbcBaseDaoImpl;
import com.yang.blog.model.Artic;
import com.yang.blog.service.IArticService;

/**
 * @Title: IArticServiceImpl.java
 * @Prject: sb-blog
 * @Package: com.yang.blog.service.Impl
 * @Description: TODO
 * @author: Sue2Yang
 * @date: 2016年12月2日 下午4:01:47
 * @version: V1.0
 */
@Service
public class IArticServiceImpl extends IBaseServiceImpl<Artic> implements IArticService {
	@Resource
	IArticDao iArticDao;
	public IArticServiceImpl() {
		
	}
}
