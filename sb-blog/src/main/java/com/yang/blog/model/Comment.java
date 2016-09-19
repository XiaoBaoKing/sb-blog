package com.yang.blog.model;
/**  
 * @Title: Comment.java
 * @Prject: sb-blog
 * @Package: com.yang.blog.model
 * @Description: TODO
 * @author: Sue2Yang 
 * @date: 2016年9月13日 下午5:28:03
 * @version: V1.0  
 */
public class Comment {
	private Integer comment_id;
	private String content;
	private Integer artic_id;
	private Integer user_id;
	/**
	 * @return the comment_id
	 */
	public int getComment_id() {
		return comment_id;
	}
	/**
	 * @param comment_id the comment_id to set
	 */
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the artic_id
	 */
	public int getArtic_id() {
		return artic_id;
	}
	/**
	 * @param artic_id the artic_id to set
	 */
	public void setArtic_id(int artic_id) {
		this.artic_id = artic_id;
	}
	/**
	 * @return the user_id
	 */
	public int getUser_id() {
		return user_id;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
}
