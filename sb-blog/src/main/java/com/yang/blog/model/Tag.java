package com.yang.blog.model;

import com.yang.blog.annotation.Id;
import com.yang.blog.annotation.Varchar;

/**  
 * @Title: Tag.java
 * @Prject: sb-blog
 * @Package: com.yang.blog.model
 * @Description: TODO
 * @author: Sue2Yang 
 * @date: 2016年9月13日 下午5:26:36
 * @version: V1.0  
 */
public class Tag {
	private Integer tag_id;
	@Varchar(Length=50)
	private String name;
	@Id
	private Integer artic_id;
	/**
	 * @return the tag_id
	 */
	public int getTag_id() {
		return tag_id;
	}
	/**
	 * @param tag_id the tag_id to set
	 */
	public void setTag_id(int tag_id) {
		this.tag_id = tag_id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	
}
