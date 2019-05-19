package edu.uc.service;

import java.util.List;

import edu.uc.bean.OrderComment;

public interface OrderCommentService extends BaseService<OrderComment> {
	public Long countById(Long bookId);
	public Long countByPraise(String praise,Long bookId);
	public List<OrderComment> pagerById(Long bookId,Long pageNum, Long pageSize);
}
