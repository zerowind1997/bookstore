package edu.uc.util;

public class HibernateUtil {
	private HibernateUtil() {
	}

	/**
	 * 内部函数，使用到才会加载并初始化
	 * 
	 * 
	 * @author Liuvei
	 * @Copyright: 2018 Liuvei.com
	 *
	 */
	public static class InnerFun {

		/**
		 * 0. (1) Hibernate 配置文件 : 默认
		 */
		private static String CONFIG_FILE_LOCATION = "/hibernate.cfg.xml";

		/**
		 * 0. (2) Hibernate 配置文件 : 当前
		 */
		private static String configFile = CONFIG_FILE_LOCATION;

		/**
		 * 1. (1) 配置文件对象 : Hibernate3需要，Hibernate4需要，Hibernate5不要
		 */
		private static org.hibernate.cfg.Configuration configuration;

		/**
		 * 1. (2) 服务注册对象： Hibernate3不要，Hibernate4需要，Hibernate5需要
		 */
		private static org.hibernate.boot.registry.StandardServiceRegistry serviceRegistry;

		/**
		 * 2. 对象工厂 ： Hibernate 创建Session对象的工厂
		 */
		private final static org.hibernate.SessionFactory sessionFactory;

		/**
		 * 3. 保存当前线程的Session对象
		 */
		private static final ThreadLocal<org.hibernate.Session> threadLocal = new ThreadLocal<org.hibernate.Session>();

		static {
			System.out.println("curr: init - " + HibernateUtil.class.getName() + "");

			try {

				/*************************************************************************************/
				/***** 真正的初始化Hibernate配置 *****/
				/*************************************************************************************/

				// Hibernate 5的配置
				serviceRegistry = new org.hibernate.boot.registry.StandardServiceRegistryBuilder().configure(configFile)
						.build();
				sessionFactory = new org.hibernate.boot.MetadataSources(serviceRegistry).buildMetadata()
						.buildSessionFactory();

				/**
				 * --------------------------------------------------------------------------------
				 **/

				/*******************************/
				/***** 1. Hibernate 3 的配置 *****/
				/*******************************/
				/*** 1.1. 解析配置文件，不传入，则默认的配置文件为类路径下的 hibernate.cfg.xml */
				// configuration= new org.hibernate.cfg.Configuration();//实例化配置对象
				// configuration.configure(configFile);
				/*** 1.2. 创建数据库访问会话工厂 */
				// sessionFactory = configuration.buildSessionFactory();
				/** ------------------------- **/

				/*******************************/
				/***** 2. Hibernate 4 的配置 *****/
				/*******************************/
				/*** 2.1. 解析配置文件，不传入，则默认的配置文件为类路径下的 hibernate.cfg.xml */
				// configuration= new org.hibernate.cfg.Configuration();//实例化配置对象
				// configuration.configure(configFile);
				/*** 2.2. 创建服务注册类,进一步注册初始化我们配置文件中的属性 */
				// serviceRegistry = new
				// org.hibernate.service.ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
				/*** 2.3. 创建数据库访问会话工厂 */
				// sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				/** ------------------------- **/

				/*******************************/
				/***** 3. Hibernate 5的配置 *****/
				/*******************************/
				/*** 3.1. 配置类型安全的准服务注册类，这是当前应用的单例对象，一般不作修改，可以声明为final */
				/** configure不传入配置文件，则默认的配置文件为类路径下的 hibernate.cfg.xml */
				// serviceRegistry = new
				// org.hibernate.boot.registry.StandardServiceRegistryBuilder().configure(configFile).build();
				/*** 3.2. 根据服务注册类创建一个元数据资源集，同时构建元数据并生成应用一般唯一的的session工厂 */
				// sessionFactory = new
				// org.hibernate.boot.MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
				/** ------------------------- **/

				/*************************************/
				/***** 4. 下面开始我们的数据库操作 *****/
				/*************************************/
				// Session session = sessionFactory.openSession();//从会话工厂获取一个session

				// Transaction transaction = session.beginTransaction();//开启一个新的事务
				// User user = new User();
				// user.setName("zengh");
				// session.save(user);
				// transaction.commit();//提交事务

			} catch (Throwable ex) {
				ex.printStackTrace();
				System.err.println("建立SessionFactory时，发生错误。" + ex);
				throw new ExceptionInInitializerError(ex);
			}
			System.out.println("curr: init end - " + HibernateUtil.class.getName() + "");

		}

	}

	/**
	 * Returns the ThreadLocal Session instance. Lazy initialize the
	 * <code>SessionFactory</code> if needed.
	 *
	 * @return Session
	 */
	public static org.hibernate.Session getSession() {
		org.hibernate.Session session = (org.hibernate.Session) InnerFun.threadLocal.get();

		if (session == null || !session.isOpen()) {
			if (InnerFun.sessionFactory == null) {
				return null;
			}
			session = (InnerFun.sessionFactory != null) ? InnerFun.sessionFactory.openSession() : null;
			InnerFun.threadLocal.set(session);
		}

		return session;
	}

	/**
	 * Close the single hibernate session instance.
	 *
	 */
	public static void closeSession() {
		org.hibernate.Session session = (org.hibernate.Session) InnerFun.threadLocal.get();
		InnerFun.threadLocal.set(null);

		if (session != null) {
			session.close();
		}
	}

	public static org.hibernate.SessionFactory getFactory() {
		return InnerFun.sessionFactory;
	}

	/**
	 * return hibernate configuration
	 *
	 */
	public static org.hibernate.cfg.Configuration getConfiguration() {
		return InnerFun.configuration;
	}

	/*
	 * ----------------------------------------------------------------
	 */

	/**
	 * 根据查询条件与参数列表创建Query对象
	 * 
	 * @param clazz
	 *            类型
	 * @param session
	 *            会话
	 * @param hql
	 *            HQL语句
	 * @param params
	 *            参数列表
	 * @return Query对象
	 */
	public static <E> org.hibernate.query.Query<E> createQuery(Class<E> clazz, org.hibernate.Session session,
			String hql, Object... params) {

		org.hibernate.query.Query<E> query = null;
		query = (org.hibernate.query.Query<E>) session.createQuery(hql, clazz);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		return query;
	}
}
