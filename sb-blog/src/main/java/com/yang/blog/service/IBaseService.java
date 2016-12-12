package com.yang.blog.service;

import java.util.List;

/**
 * @Title: IBaseService.java
 * @Prject: sb-blog
 * @Package: com.yang.blog.service
 * @Description: TODO
 * @author: Sue2Yang
 * @date: 2016年12月2日 下午3:04:58
 * @version: V1.0
 */
public interface IBaseService<M> {
	public void save(M model) throws Exception;

	public void saveOrUpdate(M model) throws Exception;

	public void update(M model) throws Exception;

	public void merge(M model) throws Exception;

	public void delete(M model) throws Exception;

	M get(M model) throws Exception;

	public int countAll() throws Exception;

	public List<M> listAll() throws Exception;

	public List<M> listAll(int pn, int pageSize) throws Exception;
}
