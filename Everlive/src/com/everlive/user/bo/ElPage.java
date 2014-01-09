package com.everlive.user.bo;

// Generated 2014-1-5 15:12:46 by Hibernate Tools 3.2.2.GA

import java.util.Date;

/**
 * ElPage generated by hbm2java
 */
public class ElPage implements java.io.Serializable {

	private Integer id;
	private String title;
	private String content;
	private Date createDate;
	private boolean active;

	public ElPage() {
	}

	public ElPage(String title, String content, Date createDate, boolean active) {
		this.title = title;
		this.content = content;
		this.createDate = createDate;
		this.active = active;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
