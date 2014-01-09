package com.everlive.user.bo;

// Generated 2014-1-5 15:12:46 by Hibernate Tools 3.2.2.GA

/**
 * ElUserPlaceId generated by hbm2java
 */
public class ElUserPlaceId implements java.io.Serializable {

	private int id;
	private int userId;
	private String country;
	private String state;

	public ElUserPlaceId() {
	}

	public ElUserPlaceId(int id, int userId, String country, String state) {
		this.id = id;
		this.userId = userId;
		this.country = country;
		this.state = state;
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

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ElUserPlaceId))
			return false;
		ElUserPlaceId castOther = (ElUserPlaceId) other;

		return (this.getId() == castOther.getId())
				&& (this.getUserId() == castOther.getUserId())
				&& ((this.getCountry() == castOther.getCountry()) || (this
						.getCountry() != null && castOther.getCountry() != null && this
						.getCountry().equals(castOther.getCountry())))
				&& ((this.getState() == castOther.getState()) || (this
						.getState() != null && castOther.getState() != null && this
						.getState().equals(castOther.getState())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getId();
		result = 37 * result + this.getUserId();
		result = 37 * result
				+ (getCountry() == null ? 0 : this.getCountry().hashCode());
		result = 37 * result
				+ (getState() == null ? 0 : this.getState().hashCode());
		return result;
	}

}
