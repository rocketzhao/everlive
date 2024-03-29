package com.everlive.user.bo;

// Generated 2014-1-5 15:12:46 by Hibernate Tools 3.2.2.GA

/**
 * ElSessions generated by hbm2java
 */
public class ElSessions implements java.io.Serializable {

	private String sessionId;
	private String ipAddress;
	private String userAgent;
	private int lastActivity;
	private String userData;

	public ElSessions() {
	}

	public ElSessions(String sessionId, String ipAddress, String userAgent,
			int lastActivity, String userData) {
		this.sessionId = sessionId;
		this.ipAddress = ipAddress;
		this.userAgent = userAgent;
		this.lastActivity = lastActivity;
		this.userData = userData;
	}

	public String getSessionId() {
		return this.sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getIpAddress() {
		return this.ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getUserAgent() {
		return this.userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public int getLastActivity() {
		return this.lastActivity;
	}

	public void setLastActivity(int lastActivity) {
		this.lastActivity = lastActivity;
	}

	public String getUserData() {
		return this.userData;
	}

	public void setUserData(String userData) {
		this.userData = userData;
	}

}
