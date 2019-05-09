package edu.uc.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;

import edu.uc.util.HibernateUtil;
import edu.uc.util.SpringHibUtil;

public abstract class BaseDaoImpl<T> {
	public BaseDaoImpl() {
		System.out.println(this);
	}

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Autowired
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public HibernateTemplate getTmpl() {
		return hibernateTemplate;
	}

	public SessionFactory getSessionFactory() {
		return hibernateTemplate.getSessionFactory();
	}

	public Session getSession() {
		return getSessionFactory().getCurrentSession();
	}

	public void closeSession(Session session) {
		if (session != null) {
			session.close();
		}
	}

	/**
	 * 
	 * @param clazz 类型
	 * @param session 会话
	 * @param hql hql语句
	 * @param params 参数列表
	 * @return Query对象
	 */
	public <E> org.hibernate.query.Query<E> createQuery(Class<E> clazz, org.hibernate.Session session, String hql,
			Object... params) {
		return HibernateUtil.createQuery(clazz, session, hql, params);
	}
	/**
	 * 获取回调对象 ：返回单行单列的Object对象
	 * @param hql
	 * @param params
	 * @return
	 */
	public  HibernateCallback<Object> getCallbackScalar(String hql,
			Object... params) {
		return SpringHibUtil.getCallbackScalar(hql, params);
	}
	/**
	 * 获取回调函数 返回单行单列的Long对象
	 * @param hql
	 * @param params
	 * @return
	 */
	public  HibernateCallback<Long> getCallbackScalarLong(String hql,
			Object... params) {
		return SpringHibUtil.getCallbackScalarLong(hql, params);
	}
	/**
	 *  获取回调对象：返回实体对象
	 * @param clazzBean 实体类型 
	 * @param hql
	 * @param params
	 * @return
	 */
	public  <E> HibernateCallback<E> getCallbackBean(Class<E> clazzBean,
			String hql, Object... params) {
		return SpringHibUtil.getCallbackBean(clazzBean, hql, params);
	}
	/**
	 * 获取回调对象： 返回多行多列对象
	 * @param clazzBean
	 * @param hql
	 * @param params
	 * @return
	 */
	public  <E> HibernateCallback<java.util.List<E>> getCallbackList(
			Class<E> clazzBean, String hql, Object... params) {
		return SpringHibUtil.getCallbackList(clazzBean, hql, params);
	}
	/**
	 * 获取回调对象，返回分页后的多行多列类表对象
	 * @param clazzBean
	 * @param startIndex
	 * @param pageSize
	 * @param hql
	 * @param params
	 * @return
	 */
	public static <E> HibernateCallback<java.util.List<E>> getCallbackPager(
			Class<E> clazzBean, Long startIndex, Long pageSize, String hql, Object... params) {
		return SpringHibUtil.getCallbackPager(clazzBean, startIndex, pageSize, hql, params);
	}
	
}
