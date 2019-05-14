package edu.uc.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="book")
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bookId",length=50)
	private Long bookId;
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="bookCategoryId",unique=true,nullable=true)
	private BookCategory bookCategory;
	@Column(name="bookName",length=50)
	private String bookName;
	@Column(name="bookCbs",length=50)
	private String bookCbs;
	@Column(name="ISBN",length=20)
	private String ISBN;
	@Column(name="bookPrice",length=11)
	private Double bookPrice;
	@Column(name="discountRate",length=11)
	private Double discountRate;
	@Column(name="bookAuthor",length=20)
	private String bookAuthor;
	@Column(name="bookNote",length=255)
	private String bookNote;
	@Column(name="bookPicPath",length=50)
	private String bookPicPath;
	@Column(name="enableStatus",length=1)
	private Integer enableStatus;
	@Column(name="bookNum",length=11)
	private Integer bookNum;
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public BookCategory getBookCategory() {
		return bookCategory;
	}
	public void setBookCategory(BookCategory bookCategory) {
		this.bookCategory = bookCategory;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookCbs() {
		return bookCbs;
	}
	public void setBookCbs(String bookCbs) {
		this.bookCbs = bookCbs;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public Double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(Double bookPrice) {
		this.bookPrice = bookPrice;
	}
	public Double getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(Double discountRate) {
		this.discountRate = discountRate;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookNote() {
		return bookNote;
	}
	public void setBookNote(String bookNote) {
		this.bookNote = bookNote;
	}
	public String getBookPicPath() {
		return bookPicPath;
	}
	public void setBookPicPath(String bookPicPath) {
		this.bookPicPath = bookPicPath;
	}
	public Integer getEnableStatus() {
		return enableStatus;
	}
	public void setEnableStatus(Integer enableStatus) {
		this.enableStatus = enableStatus;
	}
	public Integer getBookNum() {
		return bookNum;
	}
	public void setBookNum(Integer bookNum) {
		this.bookNum = bookNum;
	}
	
}
