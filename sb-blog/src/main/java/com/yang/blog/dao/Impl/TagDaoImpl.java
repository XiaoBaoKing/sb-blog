package com.yang.blog.dao.Impl;

import org.springframework.stereotype.Repository;

import com.yang.blog.dao.ITagDao;
import com.yang.blog.model.Tag;

/**  
 * @Title: TagDaoImpl.java
 * @Prject: sb-blog
 * @Package: com.yang.blog.dao.Impl
 * @Description: TODO
 * @author: Sue2Yang 
 * @date: 2016年10月13日 下午4:50:08
 * @version: V1.0  
 */
@Repository
public class TagDaoImpl extends SpringJdbcBaseDaoImpl<Tag> implements ITagDao{

}
