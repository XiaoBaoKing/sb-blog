package com.yang.blog.model;

import java.util.Date;

import com.yang.blog.annotation.Id;
import com.yang.blog.annotation.Varchar;

/**
 * @Title: user.java
 * @Prject: sb-blog
 * @Package: com.yang.blog.model
 * @Description: TODO
 * @author: Sue2Yang
 * @date: 2016年9月13日 下午4:23:03
 * @version: V1.0
 */
public class User extends BaseDao {
	@Id
	private Integer user_id;
	@Varchar(Length=50)
	private String userName;
	@Varchar(Length=50)
	private String passWord;
	@Varchar(Length=80)
	private String Email;
	private Date lastLoginTime;
	private Date createTime;
	private Integer group_Id;

	/**
	 * @return the user_id
	 */
	public int getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id
	 *            the user_id to set
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the passWord
	 */
	public String getPassWord() {
		return passWord;
	}

	/**
	 * @param passWord
	 *            the passWord to set
	 */
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return Email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		Email = email;
	}

	/**
	 * @return the lastLoginTime
	 */
	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	/**
	 * @param lastLoginTime
	 *            the lastLoginTime to set
	 */
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime
	 *            the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the group_Id
	 */
	public int getGroup_Id() {
		return group_Id;
	}

	/**
	 * @param group_Id
	 *            the group_Id to set
	 */
	public void setGroup_Id(int group_Id) {
		this.group_Id = group_Id;
	}

}
