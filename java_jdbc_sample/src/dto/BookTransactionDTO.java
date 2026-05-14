package dto;

import java.util.Date;

public class BookTransactionDTO {

	private int bookIssueId;
	private int bookId;
	private int studentId;
	private int issueAdmin;
	private Date issueDate;
	private Date dueDate;
	private Date returnDate;
	private float fineAmount;
	private String issueStatus;

	public BookTransactionDTO() {
	}

	public BookTransactionDTO(int bookIssueId, int bookId, int studentId, int issueAdmin, Date issueDate, Date dueDate,
			Date returnDate, float fineAmount, String issueStatus) {

		this.bookIssueId = bookIssueId;
		this.bookId = bookId;
		this.studentId = studentId;
		this.issueAdmin = issueAdmin;
		this.issueDate = issueDate;
		this.dueDate = dueDate;
		this.returnDate = returnDate;
		this.fineAmount = fineAmount;
		this.issueStatus = issueStatus;
	}

	public int getBookIssueId() {
		return bookIssueId;
	}

	public void setBookIssueId(int bookIssueId) {
		this.bookIssueId = bookIssueId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getIssueAdmin() {
		return issueAdmin;
	}

	public void setIssueAdmin(int issueAdmin) {
		this.issueAdmin = issueAdmin;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public float getFineAmount() {
		return fineAmount;
	}

	public void setFineAmount(float fineAmount) {
		this.fineAmount = fineAmount;
	}

	public String getIssueStatus() {
		return issueStatus;
	}

	public void setIssueStatus(String issueStatus) {
		this.issueStatus = issueStatus;
	}

	public String toString() {
		return bookIssueId + " " + bookId + " " + studentId + " " + issueAdmin + " " + issueDate + " " + dueDate + " "
				+ returnDate + " " + fineAmount + " " + issueStatus;
	}

}
