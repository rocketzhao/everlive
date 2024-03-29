package com.everlive.user.bo;

// Generated 2014-1-5 15:12:46 by Hibernate Tools 3.2.2.GA

import java.util.Date;

/**
 * ElPostEntrustment generated by hbm2java
 */
public class ElPostEntrustment implements java.io.Serializable {

	private Integer id;
	private int active;
	private Date createDate;
	private Date updateDate;
	private int userId;
	private String title;
	private String content;
	private String file;
	private String tags;
	private int mode;
	private int type;
	private String receiver;
	private int receiverId;
	private Date deadline;
	private boolean imme;
	private String url;
	private int postId;

	public ElPostEntrustment() {
	}

	public ElPostEntrustment(int active, Date createDate, Date updateDate,
			int userId, String tags, int mode, int type, String receiver,
			int receiverId, boolean imme, String url, int postId) {
		this.active = active;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.userId = userId;
		this.tags = tags;
		this.mode = mode;
		this.type = type;
		this.receiver = receiver;
		this.receiverId = receiverId;
		this.imme = imme;
		this.url = url;
		this.postId = postId;
	}

	public ElPostEntrustment(int active, Date createDate, Date updateDate,
			int userId, String title, String content, String file, String tags,
			int mode, int type, String receiver, int receiverId, Date deadline,
			boolean imme, String url, int postId) {
		this.active = active;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.file = file;
		this.tags = tags;
		this.mode = mode;
		this.type = type;
		this.receiver = receiver;
		this.receiverId = receiverId;
		this.deadline = deadline;
		this.imme = imme;
		this.url = url;
		this.postId = postId;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getTags() {
		return this.tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
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

	public String getReceiver() {
		return this.receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public int getReceiverId() {
		return this.receiverId;
	}

	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}

	public Date getDeadline() {
		return this.deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public boolean isImme() {
		return this.imme;
	}

	public void setImme(boolean imme) {
		this.imme = imme;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getPostId() {
		return this.postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

}
