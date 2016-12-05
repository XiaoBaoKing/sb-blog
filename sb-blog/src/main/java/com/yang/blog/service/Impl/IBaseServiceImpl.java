package com.yang.blog.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import com.yang.blog.dao.Impl.SpringJdbcBaseDaoImpl;
import com.yang.blog.service.IBaseService;

/**
 * @Title: IBaseServiceImpl.java
 * @Prject: sb-blog
 * @Package: com.yang.blog.service.Impl
 * @Description: TODO
 * @author: Sue2Yang
 * @date: 2016年12月2日 下午3:12:28
 * @version: V1.0
 */
public  class IBaseServiceImpl<M> implements IBaseService<M> {

	SpringJdbcBaseDaoImpl SpringJdbcBaseDaoImpl;
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yang.blog.service.IBaseService#save(java.lang.Object)
	 */
	@Override
	public void save(M model) throws Exception {
		SpringJdbcBaseDaoImpl.save(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yang.blog.service.IBaseService#saveOrUpdate(java.lang.Object)
	 */
	@Override
	public void saveOrUpdate(M model) throws Exception {
		SpringJdbcBaseDaoImpl.saveOrUpdate(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yang.blog.service.IBaseService#update(java.lang.Object)
	 */
	@Override
	public void update(M model) throws Exception {
		SpringJdbcBaseDaoImpl.update(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yang.blog.service.IBaseService#merge(java.lang.Object)
	 */
	@Override
	public void merge(M model) throws Exception {
		SpringJdbcBaseDaoImpl.merge(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yang.blog.service.IBaseService#delete()
	 */
	@Override
	public void delete(M model) throws Exception {
		SpringJdbcBaseDaoImpl.delete(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yang.blog.service.IBaseService#get(java.lang.Object)
	 */
	@Override
	public M get(M model) throws Exception {
		return (M) SpringJdbcBaseDaoImpl.get(model);
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yang.blog.service.IBaseService#countAll()
	 */
	@Override
	public int countAll() throws Exception {
		return SpringJdbcBaseDaoImpl.countAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yang.blog.service.IBaseService#listAll()
	 */
	@Override
	public List<M> listAll() throws Exception {
		return SpringJdbcBaseDaoImpl.listAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yang.blog.service.IBaseService#listAll(int, int)
	 */
	@Override
	public List<M> listAll(int pn, int pageSize) throws Exception {
		return SpringJdbcBaseDaoImpl.listAll(pn, pageSize);
	}

}
