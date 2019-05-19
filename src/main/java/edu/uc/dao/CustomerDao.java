package edu.uc.dao;

import edu.uc.bean.Customer;

public interface CustomerDao extends BaseDao<Customer> {
	Customer loadByUserId(String userId);
}
