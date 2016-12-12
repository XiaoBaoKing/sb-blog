package com.yang.blog.dao.Impl;

import org.springframework.stereotype.Repository;

import com.yang.blog.dao.ICommentDao;
import com.yang.blog.model.Comment;

/**  
 * @Title: CommentDaoImpl.java
 * @Prject: sb-blog
 * @Package: com.yang.blog.dao.Impl
 * @Description: TODO
 * @author: Sue2Yang 
 * @date: 2016年10月13日 下午4:38:15
 * @version: V1.0  
 */
@Repository
public class CommentDaoImpl extends SpringJdbcBaseDaoImpl<Comment> implements ICommentDao{

}
