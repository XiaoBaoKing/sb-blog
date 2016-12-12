package com.yang.blog.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yang.blog.dao.IMenuDao;
import com.yang.blog.dao.Impl.SpringJdbcBaseDaoImpl;
import com.yang.blog.model.Menu;
import com.yang.blog.service.IMenuService;

/**  
 * @Title: IMenuServiceImpl.java
 * @Prject: sb-blog
 * @Package: com.yang.blog.service.Impl
 * @Description: TODO
 * @author: Sue2Yang 
 * @date: 2016年12月2日 下午4:10:12
 * @version: V1.0  
 */
@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements IMenuService{
	@Resource
	IMenuDao iMenuDao;
	public MenuServiceImpl() {
	}
}
