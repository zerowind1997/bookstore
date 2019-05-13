package edu.uc.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="bookcategory")
public class BookCategory {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="categoryId",length=50)
	private Long categoryId;
	@Column(name="categoryName",length=50)
	private String categoryName;
	@Column(name="categoryParentId",length=50)
	private Long categoryParentId;
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Long getCategoryParentId() {
		return categoryParentId;
	}
	public void setCategoryParentId(Long categoryParentId) {
		this.categoryParentId = categoryParentId;
	}
	
}
