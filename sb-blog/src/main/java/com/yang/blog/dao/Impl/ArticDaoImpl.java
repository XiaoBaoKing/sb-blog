package com.yang.blog.dao.Impl;

import org.springframework.stereotype.Repository;

import com.yang.blog.dao.IArticDao;
import com.yang.blog.model.Artic;

/**  
 * @Title: ArticDaoImpl.java
 * @Prject: sb-blog
 * @Package: com.yang.blog.dao.Impl
 * @Description: TODO
 * @author: Sue2Yang 
 * @date: 2016年10月13日 下午4:33:57
 * @version: V1.0  
 */
@Repository
public class ArticDaoImpl  extends SpringJdbcBaseDaoImpl<Artic> implements IArticDao{

}
