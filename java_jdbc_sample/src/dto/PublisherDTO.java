package dto;

import java.sql.Date;

public class PublisherDTO {

	private int publisherId;
	private String publisherName;
	private String publisherCode;
	private String publisherAddress;
	private String publisherEmail;
	private String publisherPhone;
	private int createAdmin;
	private int updatedAdmin;
	private Date createDate;
	private Date updatedDate;
	private String isDeleted;

	public PublisherDTO() {
	}

	public PublisherDTO(int publisherId, String publisherName, String publisherCode, String publisherAddress,
			String publisherEmail, String publisherPhone, int createAdmin, int updatedAdmin, Date createDate,
			Date updatedDate, String isDeleted) {
		super();
		this.publisherId = publisherId;
		this.publisherName = publisherName;
		this.publisherCode = publisherCode;
		this.publisherAddress = publisherAddress;
		this.publisherEmail = publisherEmail;
		this.publisherPhone = publisherPhone;
		this.createAdmin = createAdmin;
		this.updatedAdmin = updatedAdmin;
		this.createDate = createDate;
		this.updatedDate = updatedDate;
		this.isDeleted = isDeleted;
	}

	public int getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getPublisherCode() {
		return publisherCode;
	}

	public void setPublisherCode(String publisherCode) {
		this.publisherCode = publisherCode;
	}

	public String getPublisherAddress() {
		return publisherAddress;
	}

	public void setPublisherAddress(String publisherAddress) {
		this.publisherAddress = publisherAddress;
	}

	public String getPublisherEmail() {
		return publisherEmail;
	}

	public void setPublisherEmail(String publisherEmail) {
		this.publisherEmail = publisherEmail;
	}

	public String getPublisherPhone() {
		return publisherPhone;
	}

	public void setPublisherPhone(String publisherPhone) {
		this.publisherPhone = publisherPhone;
	}

	public int getCreateAdmin() {
		return createAdmin;
	}

	public void setCreateAdmin(int createAdmin) {
		this.createAdmin = createAdmin;
	}

	public int getUpdatedAdmin() {
		return updatedAdmin;
	}

	public void setUpdatedAdmin(int updatedAdmin) {
		this.updatedAdmin = updatedAdmin;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String toString() {
		return publisherId + " " + publisherName + " " + publisherCode + " " + publisherAddress + " " + publisherEmail
				+ " " + publisherPhone + " " + createAdmin + " " + updatedAdmin + " " + createDate + " " + updatedDate
				+ " " + isDeleted;
	}

}
