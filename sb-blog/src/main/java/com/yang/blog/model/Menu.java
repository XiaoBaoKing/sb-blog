package com.yang.blog.model;

import com.yang.blog.annotation.Id;
import com.yang.blog.annotation.Varchar;

/**
 * @Title: Menu.java
 * @Prject: sb-blog
 * @Package: com.yang.blog.model
 * @Description: TODO
 * @author: Sue2Yang
 * @date: 2016年9月13日 下午5:17:27
 * @version: V1.0
 */
public class Menu extends BaseDao {
	@Varchar(Length=50)
	private String name;
	@Id
	private Integer menu_id;
	private Integer parentId;
	private Integer level;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the menu_id
	 */
	public int getMenu_id() {
		return menu_id;
	}

	/**
	 * @param menu_id
	 *            the menu_id to set
	 */
	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}

	/**
	 * @return the parentId
	 */
	public int getParentId() {
		return parentId;
	}

	/**
	 * @param parentId
	 *            the parentId to set
	 */
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param level
	 *            the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}

}
