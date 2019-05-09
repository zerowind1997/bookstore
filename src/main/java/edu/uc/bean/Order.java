package edu.uc.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="ordergoods")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",length=50)
	private Long id;
	@Column(name="userId",length=50)
	private Integer userId;
	@Column(name="bookId",length=50)
	private Integer bookId;
	@Column(name="orderDate")
	private Date orderDate;
	@Column(name="bookNum",length=11)
	private Integer bookNum;
	@Column(name="orderPrice",length=3)
	private Double orderPrice;
	@Column(name="receiver",length=50)
	private String receiver;
	@Column(name="address",length=128)
	private String address;
	@Column(name="phone",length=11)
	private String phone;
	@Column(name="state",length=1)
	private Integer state;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Integer getBookNum() {
		return bookNum;
	}
	public void setBookNum(Integer bookNum) {
		this.bookNum = bookNum;
	}
	public Double getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(Double orderPrice) {
		this.orderPrice = orderPrice;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
}
