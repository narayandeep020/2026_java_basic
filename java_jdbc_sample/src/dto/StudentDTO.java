package dto;

import java.sql.Date;

public class StudentDTO {
	private int studentId;
	private String studentName;
	private String studentCode;
	private String studentAddress;
	private String studentEmail;
	private String studentPhone;
	private int studentCredit;
	private int bookId;
	private int createdAdmin;
	private int updatedAdmin;
	private Date createdDate;
	private Date updatedDate;
	private String isDeleted;

	public StudentDTO() {
	}

	public StudentDTO(int studentId, String studentName, String studentCode, String studentAddress, String studentEmail,
			String studentPhone, int studentCredit, int bookId, int createdAdmin, int updatedAdmin, Date createdDate,
			Date updatedDate, String isDeleted) {
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getStudentPhone() {
		return studentPhone;
	}

	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}

	public int getStudentCredit() {
		return studentCredit;
	}

	public void setStudentCredit(int studentCredit) {
		this.studentCredit = studentCredit;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getCreatedAdmin() {
		return createdAdmin;
	}

	public void setCreatedAdmin(int createdAdmin) {
		this.createdAdmin = createdAdmin;
	}

	public int getUpdatedAdmin() {
		return updatedAdmin;
	}

	public void setUpdatedAdmin(int updatedAdmin) {
		this.updatedAdmin = updatedAdmin;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
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

	@Override
	public String toString() {
		return studentId + " " + studentName + " " + studentCode + " " + studentAddress + " " + studentEmail + " "
				+ studentPhone + " " + studentCredit + " " + bookId + " " + createdAdmin + " " + updatedAdmin + " "
				+ createdDate + " " + updatedDate + " " + isDeleted;
	}

}
