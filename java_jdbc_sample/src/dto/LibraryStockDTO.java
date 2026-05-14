package dto;

import java.util.Date;

public class LibraryStockDTO {

	private int stockId;
	private int bookId;
	private int stockCount;
	private Date createdDate;
	private Date updatedDate;
	private int createdAdmin;
	private int updatedAdmin;
	private String isDeleted;

	public LibraryStockDTO() {
	}

	public LibraryStockDTO(int stockId, int bookId, int stockCount, Date createdDate, Date updatedDate,
			int createdAdmin, int updatedAdmin, String isDeleted) {

		this.stockId = stockId;
		this.bookId = bookId;
		this.stockCount = stockCount;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.createdAdmin = createdAdmin;
		this.updatedAdmin = updatedAdmin;
		this.isDeleted = isDeleted;
	}

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getStockCount() {
		return stockCount;
	}

	public void setStockCount(int stockCount) {
		this.stockCount = stockCount;
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

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String toString() {
		return stockId + " " + bookId + " " + stockCount + " " + createdDate + " " + updatedDate + " " + createdAdmin
				+ " " + updatedAdmin + " " + isDeleted;
	}

}
