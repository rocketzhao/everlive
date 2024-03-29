package com.everlive.user.bo;

// Generated 2014-1-5 15:12:46 by Hibernate Tools 3.2.2.GA

import java.util.Date;

/**
 * ElUserMeteor generated by hbm2java
 */
public class ElUserMeteor implements java.io.Serializable {

	private Integer id;
	private boolean activeA;
	private boolean activeB;
	private boolean activeC;
	private int userId;
	private Date deadline;
	private int contactA;
	private int contactB;
	private Date lastConfirmA;
	private Date lastConfirmB;

	public ElUserMeteor() {
	}

	public ElUserMeteor(boolean activeA, boolean activeB, boolean activeC,
			int userId, Date deadline, int contactA, int contactB,
			Date lastConfirmA, Date lastConfirmB) {
		this.activeA = activeA;
		this.activeB = activeB;
		this.activeC = activeC;
		this.userId = userId;
		this.deadline = deadline;
		this.contactA = contactA;
		this.contactB = contactB;
		this.lastConfirmA = lastConfirmA;
		this.lastConfirmB = lastConfirmB;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isActiveA() {
		return this.activeA;
	}

	public void setActiveA(boolean activeA) {
		this.activeA = activeA;
	}

	public boolean isActiveB() {
		return this.activeB;
	}

	public void setActiveB(boolean activeB) {
		this.activeB = activeB;
	}

	public boolean isActiveC() {
		return this.activeC;
	}

	public void setActiveC(boolean activeC) {
		this.activeC = activeC;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getDeadline() {
		return this.deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public int getContactA() {
		return this.contactA;
	}

	public void setContactA(int contactA) {
		this.contactA = contactA;
	}

	public int getContactB() {
		return this.contactB;
	}

	public void setContactB(int contactB) {
		this.contactB = contactB;
	}

	public Date getLastConfirmA() {
		return this.lastConfirmA;
	}

	public void setLastConfirmA(Date lastConfirmA) {
		this.lastConfirmA = lastConfirmA;
	}

	public Date getLastConfirmB() {
		return this.lastConfirmB;
	}

	public void setLastConfirmB(Date lastConfirmB) {
		this.lastConfirmB = lastConfirmB;
	}

}
