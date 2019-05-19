package edu.uc.dao;

import java.util.List;

import edu.uc.bean.OrderComment;

public interface OrderCommentDao extends BaseDao<OrderComment> {
	public Long countById(Long bookId);
	public Long countByPraise(String praise,Long bookId);
	public List<OrderComment> pagerById(Long bookId,Long pageNum, Long pageSize);
}
