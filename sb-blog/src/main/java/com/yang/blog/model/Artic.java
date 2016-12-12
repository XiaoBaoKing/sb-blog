package com.yang.blog.model;

import java.util.Date;
import java.util.List;

import com.yang.blog.annotation.Id;
import com.yang.blog.annotation.Varchar;

/**
 * @Title: Artic.java
 * @Prject: sb-blog
 * @Package: com.yang.blog.model
 * @Description: TODO
 * @author: Sue2Yang
 * @date: 2016年9月13日 下午5:22:12
 * @version: V1.0
 */
public class Artic extends BaseDao {
	@Id
	private Integer artic_id;
	@Varchar(Length=50)
	private String title;
	@Varchar(Length=255)
	private String url;
	private List<Tag> tag;
	private Date lastModifyTime;
	private Date createTime;
	private Integer user_id;
	private Integer read_count;
	private Integer comment_count;
	private List<SelectInfo> selectInfo;

	/**
	 * @return the artic_id
	 */
	public int getArtic_id() {
		return artic_id;
	}

	/**
	 * @param artic_id
	 *            the artic_id to set
	 */
	public void setArtic_id(int artic_id) {
		this.artic_id = artic_id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the tag
	 */
	public List<Tag> getTag() {
		return tag;
	}

	/**
	 * @param tag
	 *            the tag to set
	 */
	public void setTag(List<Tag> tag) {
		this.tag = tag;
	}

	/**
	 * @return the lastModifyTime
	 */
	public Date getLastModifyTime() {
		return lastModifyTime;
	}

	/**
	 * @param lastModifyTime
	 *            the lastModifyTime to set
	 */
	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
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
	 * @return the read_count
	 */
	public int getRead_count() {
		return read_count;
	}

	/**
	 * @param read_count
	 *            the read_count to set
	 */
	public void setRead_count(int read_count) {
		this.read_count = read_count;
	}

	/**
	 * @return the comment_count
	 */
	public int getComment_count() {
		return comment_count;
	}

	/**
	 * @param comment_count
	 *            the comment_count to set
	 */
	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}

	/**
	 * @return the selectInfo
	 */
	public List<SelectInfo> getSelectInfo() {
		return selectInfo;
	}

	/**
	 * @param selectInfo
	 *            the selectInfo to set
	 */
	public void setSelectInfo(List<SelectInfo> selectInfo) {
		this.selectInfo = selectInfo;
	}

}
