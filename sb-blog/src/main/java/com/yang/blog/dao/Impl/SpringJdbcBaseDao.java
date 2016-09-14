package com.yang.blog.dao.Impl;

import java.io.Serializable;

import com.yang.blog.dao.IBaseDao;

/**  
 * @Title: SpringJdbcBaseDao.java
 * @Prject: sb-blog
 * @Package: com.yang.blog.dao.Impl
 * @Description: TODO
 * @author: Sue2Yang 
 * @date: 2016年9月14日 上午10:00:01
 * @version: V1.0  
 */
public abstract class SpringJdbcBaseDao <M extends Serializable,PK extends Serializable> implements IBaseDao<M,PK> {
	
}
