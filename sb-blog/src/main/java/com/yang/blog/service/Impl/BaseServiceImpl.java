package com.yang.blog.service.Impl;

import java.util.List;

import com.yang.blog.Lifecycle.SpringContextHolder;
import com.yang.blog.dao.IBaseDao;
import com.yang.blog.dao.Impl.SpringJdbcBaseDaoImpl;
import com.yang.blog.service.IBaseService;
import com.yang.blog.utils.Common;

/**
 * @Title: IBaseServiceImpl.java
 * @Prject: sb-blog
 * @Package: com.yang.blog.service.Impl
 * @Description: TODO
 * @author: Sue2Yang
 * @date: 2016年12月2日 下午3:12:28
 * @version: V1.0
 */
public  class BaseServiceImpl<M> implements IBaseService<M> {
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yang.blog.service.IBaseService#save(java.lang.Object)
	 */
	static String BeanName ;
	IBaseDao iBaseDao ;
	public BaseServiceImpl(){
		String tempName = this.getClass().getSimpleName();
		BeanName =tempName.substring(0,tempName.indexOf("ServiceImpl")) ;
		BeanName = Common.toLowerCaseFirstOne(BeanName);
		iBaseDao = (IBaseDao<M>) SpringContextHolder.getBean(BeanName+"DaoImpl");
	}
	
	@Override
	public void save(M model) throws Exception {
		iBaseDao.save(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yang.blog.service.IBaseService#saveOrUpdate(java.lang.Object)
	 */
	@Override
	public void saveOrUpdate(M model) throws Exception {
		iBaseDao.saveOrUpdate(model);
	
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yang.blog.service.IBaseService#update(java.lang.Object)
	 */
	@Override
	public void update(M model) throws Exception {
		iBaseDao.update(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yang.blog.service.IBaseService#merge(java.lang.Object)
	 */
	@Override
	public void merge(M model) throws Exception {
		iBaseDao.merge(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yang.blog.service.IBaseService#delete()
	 */
	@Override
	public void delete(M model) throws Exception {
		iBaseDao.delete(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yang.blog.service.IBaseService#get(java.lang.Object)
	 */
	@Override
	public M get(M model) throws Exception {
		return (M) iBaseDao.get(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yang.blog.service.IBaseService#countAll()
	 */
	@Override
	public int countAll() throws Exception {
		return iBaseDao.countAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yang.blog.service.IBaseService#listAll()
	 */
	@Override
	public List<M> listAll() throws Exception {
		
		System.out.println();
		return iBaseDao.listAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yang.blog.service.IBaseService#listAll(int, int)
	 */
	@Override
	public List<M> listAll(int pn, int pageSize) throws Exception {
		return iBaseDao.listAll(pn, pageSize);
	}

}
