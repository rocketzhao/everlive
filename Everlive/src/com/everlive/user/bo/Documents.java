package com.everlive.user.bo;

// Generated 2014-1-5 15:12:46 by Hibernate Tools 3.2.2.GA

import java.util.Date;

/**
 * Documents generated by hbm2java
 */
public class Documents implements java.io.Serializable {

	private Integer id;
	private String title;
	private String content;
	private Date dateAdded;
	private int authorId;
	private int groupId;

	public Documents() {
	}

	public Documents(String title, String content, Date dateAdded,
			int authorId, int groupId) {
		this.title = title;
		this.content = content;
		this.dateAdded = dateAdded;
		this.authorId = authorId;
		this.groupId = groupId;
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

	public Date getDateAdded() {
		return this.dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public int getAuthorId() {
		return this.authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getGroupId() {
		return this.groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

}