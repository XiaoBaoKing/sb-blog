package com.yang.blog.model;

import java.util.List;

import com.yang.blog.annotation.Id;
import com.yang.blog.annotation.Varchar;

/**
 * @Title: Permission.java
 * @Prject: sb-blog
 * @Package: com.yang.blog.model
 * @Description: TODO
 * @author: Sue2Yang
 * @date: 2016年9月13日 下午5:04:58
 * @version: V1.0
 */
public class Permission extends BaseDao{
	@Id
	private Integer permission_id;
	@Varchar(Length=50)
	private String name;
	private List<Menu> menu;
	/**
	 * @return the permission_id
	 */
	public int getPermission_id() {
		return permission_id;
	}
	/**
	 * @param permission_id the permission_id to set
	 */
	public void setPermission_id(int permission_id) {
		this.permission_id = permission_id;
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
	 * @return the menu
	 */
	public List<Menu> getMenu() {
		return menu;
	}
	/**
	 * @param menu the menu to set
	 */
	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}
	

}
