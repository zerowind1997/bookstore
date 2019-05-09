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
@Table(name="OrderComment")
public class OrderComment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",length=50)
	private Long id;
	@Column(name="userId",length=50)
	private Integer userId;
	@Column(name="userNick",length=50)
	private String userNick;
	@Column(name="praise",length=3)
	private Integer praise;
	@Column(name="comment",length=255)
	private String comment;
	@Column(name="star",length=3)
	private Integer star;
	@Column(name="commentDate")
	private Date commentDate;
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
	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	public Integer getPraise() {
		return praise;
	}
	public void setPraise(Integer praise) {
		this.praise = praise;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Integer getStar() {
		return star;
	}
	public void setStar(Integer star) {
		this.star = star;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	
}
