package edu.uc.util;


//非常重要，说明HibernateCallback是在spring相关jar包中
import org.springframework.orm.hibernate5.HibernateCallback; 

/**
 * 【Spring与Hibernate整合的工具类】
 * 
 * 
 * @author Liuvei
 * @Copyright: 2018 Liuvei.com
 *
 */
public final class SpringHibUtil {

	/**
	 * 获取回调对象：返回单行单例的Object对象
	 * 
	 * @param hql
	 * @param params
	 * @return
	 */
	public static HibernateCallback<Object> getCallbackScalar(String hql,
			Object... params) {

		HibernateCallback<Object> callback = null;
		callback = new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(org.hibernate.Session arg0) throws org.hibernate.HibernateException {
				// TODO Auto-generated method stub
				org.hibernate.query.Query<Object> query = null;
				query = HibernateUtil.createQuery(Object.class, arg0, hql, params);
				return query.uniqueResult();
			}

		};

		return callback;

	}

	/**
	 * 获取回调对象：返回单行单例的Long对象
	 * 
	 * @param hql
	 * @param params
	 * @return
	 */
	public static HibernateCallback<Long> getCallbackScalarLong(String hql,
			Object... params) {

		HibernateCallback<Long> callback = null;
		callback = new HibernateCallback<Long>() {

			@Override
			public Long doInHibernate(org.hibernate.Session arg0) throws org.hibernate.HibernateException {
				// TODO Auto-generated method stub
				org.hibernate.query.Query<Long> query = null;
				query = HibernateUtil.createQuery(Long.class, arg0, hql, params);
				return query.uniqueResult();
			}

		};

		return callback;

	}

	/**
	 * 获取回调对象：返回实体对象
	 * 
	 * @param clazzBean
	 *            实体类型
	 * @param hql
	 *            HQL语句
	 * @param params
	 *            参数列表
	 * @return
	 */
	public static <E> HibernateCallback<E> getCallbackBean(Class<E> clazzBean,
			String hql, Object... params) {

		HibernateCallback<E> callback = null;
		callback = new HibernateCallback<E>() {

			@Override
			public E doInHibernate(org.hibernate.Session arg0) throws org.hibernate.HibernateException {
				// TODO Auto-generated method stub

				org.hibernate.query.Query<E> query = null;
				query = HibernateUtil.createQuery(clazzBean, arg0, hql, params);

				java.util.List<E> tmpList = query.list();
				E bean = null;
				if (tmpList != null && tmpList.size() > 0) {
					bean = tmpList.get(0);
				}

				return bean;

			}

		};

		return callback;

	}

	/**
	 * 获取回调对象：返回多行多列的列表对象
	 * 
	 * @param clazzBean
	 *            实体类型
	 * @param hql
	 *            HQL语句
	 * @param params
	 *            参数列表
	 * 
	 * @return
	 */
	public static <E> HibernateCallback<java.util.List<E>> getCallbackList(
			Class<E> clazzBean, String hql, Object... params) {

		HibernateCallback<java.util.List<E>> callback = null;
		callback = new HibernateCallback<java.util.List<E>>() {

			@Override
			public java.util.List<E> doInHibernate(org.hibernate.Session arg0) throws org.hibernate.HibernateException {
				// TODO Auto-generated method stub
				org.hibernate.query.Query<E> query = null;
				query = HibernateUtil.createQuery(clazzBean, arg0, hql, params);
				return query.list();
			}

		};

		return callback;

	}

	/**
	 * 获取回调对象：返回分页后的多行多列的列表对象
	 * 
	 * @param clazzBean
	 *            实体类型
	 * @param startIndex
	 *            起始下标
	 * @param pageSize
	 *            每页大小
	 * @param hql
	 *            HQL语句
	 * @param params
	 *            参数列表
	 * @return
	 */
	public static <E> HibernateCallback<java.util.List<E>> getCallbackPager(
			Class<E> clazzBean, Long startIndex, Long pageSize, String hql, Object... params) {

		HibernateCallback<java.util.List<E>> callback = null;
		callback = new HibernateCallback<java.util.List<E>>() {

			@Override
			public java.util.List<E> doInHibernate(org.hibernate.Session arg0) throws org.hibernate.HibernateException {
				// TODO Auto-generated method stub
				org.hibernate.query.Query<E> query = null;
				query = HibernateUtil.createQuery(clazzBean, arg0, hql, params);
				return query.setFirstResult(startIndex.intValue()).setMaxResults(pageSize.intValue()).list();

			}

		};

		return callback;

	}

}
