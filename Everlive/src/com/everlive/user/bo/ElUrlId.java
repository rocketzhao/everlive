package com.everlive.user.bo;

// Generated 2014-1-5 15:12:46 by Hibernate Tools 3.2.2.GA

/**
 * ElUrlId generated by hbm2java
 */
public class ElUrlId implements java.io.Serializable {

	private int id;
	private String shortUrl;
	private String url;

	public ElUrlId() {
	}

	public ElUrlId(int id, String shortUrl, String url) {
		this.id = id;
		this.shortUrl = shortUrl;
		this.url = url;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShortUrl() {
		return this.shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ElUrlId))
			return false;
		ElUrlId castOther = (ElUrlId) other;

		return (this.getId() == castOther.getId())
				&& ((this.getShortUrl() == castOther.getShortUrl()) || (this
						.getShortUrl() != null
						&& castOther.getShortUrl() != null && this
						.getShortUrl().equals(castOther.getShortUrl())))
				&& ((this.getUrl() == castOther.getUrl()) || (this.getUrl() != null
						&& castOther.getUrl() != null && this.getUrl().equals(
						castOther.getUrl())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getId();
		result = 37 * result
				+ (getShortUrl() == null ? 0 : this.getShortUrl().hashCode());
		result = 37 * result
				+ (getUrl() == null ? 0 : this.getUrl().hashCode());
		return result;
	}

}
