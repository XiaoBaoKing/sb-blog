package com.yang.blog.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @Title: IBaseDao.java
 * @Prject: sb-blog
 * @Package: com.yang.blog.dao
 * @Description: TODO
 * @author: Sue2Yang
 * @date: 2016年9月14日 上午9:55:56
 * @version: V1.0
 */
public interface IBaseDao<M extends Serializable, PK extends Serializable> {
	public void save(M model);

	public void saveOrUpdate(M model);

	public void update(M model);

	public void merge(M model);

	public void delete(PK id);

	public M get(PK id);

	public int countAll();

	public List<M> listAll();

	public List<M> listAll(int pn, int pageSize);
}
