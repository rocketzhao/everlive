package com.everlive.user.bo;

// Generated 2014-1-5 15:12:46 by Hibernate Tools 3.2.2.GA

import java.util.Date;

/**
 * ElPostPublic generated by hbm2java
 */
public class ElPostPublic implements java.io.Serializable {

	private Integer id;
	private int postId;
	private int active;
	private Date createDate;
	private Date updateDate;
	private int userId;
	private String title;
	private String content;
	private String file;
	private int mode;
	private int type;

	public ElPostPublic() {
	}

	public ElPostPublic(int postId, int active, Date createDate, int userId,
			int mode, int type) {
		this.postId = postId;
		this.active = active;
		this.createDate = createDate;
		this.userId = userId;
		this.mode = mode;
		this.type = type;
	}

	public ElPostPublic(int postId, int active, Date createDate,
			Date updateDate, int userId, String title, String content,
			String file, int mode, int type) {
		this.postId = postId;
		this.active = active;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.file = file;
		this.mode = mode;
		this.type = type;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getPostId() {
		return this.postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getActive() {
		return this.active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFile() {
		return this.file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public int getMode() {
		return this.mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
