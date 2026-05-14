package dto;

import java.util.Date;

public class BookDTO {

	private int bookId;
	private String bookTitle;
	private String isbn;
	private int authorId;
	private int publisherId;
	private Date publicationDate;
	private float price;
	private String genre;
	private int pages;
	private String language;
	private int createAdmin;
	private int updateAdmin;
	private Date createDate;
	private Date updateDate;
	private String isDeleted;

	public BookDTO(int bookId, String bookTitle, String isbn, int authorId, int publisherId, Date publicationDate,
			float price, String genre, int pages, String language, int createAdmin, int updateAdmin, Date createDate,
			Date updateDate, String isDeleted) {
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.isbn = isbn;
		this.authorId = authorId;
		this.publisherId = publisherId;
		this.publicationDate = publicationDate;
		this.price = price;
		this.genre = genre;
		this.pages = pages;
		this.language = language;
		this.createAdmin = createAdmin;
		this.updateAdmin = updateAdmin;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public BookDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getCreateAdmin() {
		return createAdmin;
	}

	public void setCreateAdmin(int createAdmin) {
		this.createAdmin = createAdmin;
	}

	public int getUpdateAdmin() {
		return updateAdmin;
	}

	public void setUpdateAdmin(int updateAdmin) {
		this.updateAdmin = updateAdmin;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "BookDTO [bookId=" + bookId + ", bookTitle=" + bookTitle + ", isbn=" + isbn + ", authorId=" + authorId
				+ ", publisherId=" + publisherId + ", publicationDate=" + publicationDate + ", price=" + price
				+ ", genre=" + genre + ", pages=" + pages + ", language=" + language + ", createAdmin=" + createAdmin
				+ ", updateAdmin=" + updateAdmin + ", createDate=" + createDate + ", updateDate=" + updateDate
				+ ", isDeleted=" + isDeleted + "]";
	}

//	public String toString() {
//		return bookId + " " + bookTitle + " " + isbn + " " + authorId + " " + publisherId + " " + publicationDate + " "
//				+ price + " " + genre + " " + pages + " " + language + " " + createAdmin + " " + updateAdmin + " "
//				+ createDate + " " + updateDate;
		
		
	}


