package edu.uc.dto;

public class BookCategoryHandle {
	private Long categoryId;
	private String categoryName;
	private Long categoryParentId;
	private String categoryParentIdName;
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
	public String getCategoryParentIdName() {
		return categoryParentIdName;
	}
	public void setCategoryParentIdName(String categoryParentIdName) {
		this.categoryParentIdName = categoryParentIdName;
	}
	
}
