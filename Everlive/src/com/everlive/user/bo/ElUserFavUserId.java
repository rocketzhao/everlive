package com.everlive.user.bo;

// Generated 2014-1-5 15:12:46 by Hibernate Tools 3.2.2.GA

/**
 * ElUserFavUserId generated by hbm2java
 */
public class ElUserFavUserId implements java.io.Serializable {

	private int id;
	private int userId;
	private int type;
	private int favId;

	public ElUserFavUserId() {
	}

	public ElUserFavUserId(int id, int userId, int type, int favId) {
		this.id = id;
		this.userId = userId;
		this.type = type;
		this.favId = favId;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getFavId() {
		return this.favId;
	}

	public void setFavId(int favId) {
		this.favId = favId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ElUserFavUserId))
			return false;
		ElUserFavUserId castOther = (ElUserFavUserId) other;

		return (this.getId() == castOther.getId())
				&& (this.getUserId() == castOther.getUserId())
				&& (this.getType() == castOther.getType())
				&& (this.getFavId() == castOther.getFavId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getId();
		result = 37 * result + this.getUserId();
		result = 37 * result + this.getType();
		result = 37 * result + this.getFavId();
		return result;
	}

}