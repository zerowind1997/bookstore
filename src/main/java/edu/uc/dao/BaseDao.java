package edu.uc.dao;

import java.util.List;

/**
 * 设计导层的基类，抽取数据层的方法
 * @author linshao
 *
 * @param <T>
 */
public interface BaseDao<T> {
	//查询所有的数据
	List<T> list();
	//增
	Long insert(T bean);
	//删
	Long delete(Long id);
	//改
	Long update(T bean);
	//根据主键查找信息
	T load(Long id);
	//根据hql计算数目
	Long count();
	//对传入的数量以及分页的大小进行分页
	List<T> pager(Long pageNum,Long pageSize);
	//通过hql 姓名查询
	T loadByName(String name);
	//通过hql 姓名查询
	Long countByName(String name);
	//通过条件过滤分页
	List<T> pagerByName(String name,Long pageNum,Long pageSize);
}
