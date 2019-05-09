package edu.uc.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring容器的辅助类库
 * 
 * @author Liuvei
 * @Copyright: Liuvei.com
 *
 */
public class SpringUtil{
	private static ApplicationContext applicationContext; // Spring应用上下文环境
	static {
		System.out.println("curr: " + SpringUtil.class.getName()+ "");
		// 读取applicationContext.xml来实例化应用上下文对象
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	/**
	 * 获得应用上下文对象
	 * @return
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	/**
	 * 【普通方式】从应用上下文得到某个对象
	 * @param name
	 * @return
	 * @throws BeansException
	 */
	public static Object getBean(String name) throws BeansException {
		return applicationContext.getBean(name);
	}

	/**
	 * 【泛型方式】从应用上下文得到某个对象
	 * @param requiredType
	 * @return
	 */
	public static <T> T getBean(Class<T> requiredType) {
		System.out.println("curr: getBean - " + SpringUtil.class.getName()+ "");
		return applicationContext.getBean(requiredType);
	}

	
	
	public static <T> T getBean(String name, Class<T> requiredType) throws BeansException {
		return applicationContext.getBean(name, requiredType);
	}

	public static boolean containsBean(String name) {
		return applicationContext.containsBean(name);
	}

	public static boolean isSingleton(String name) throws NoSuchBeanDefinitionException {
		return applicationContext.isSingleton(name);
	}

	@SuppressWarnings("rawtypes")
	public static Class getType(String name) throws NoSuchBeanDefinitionException {
		return applicationContext.getType(name);
	}

	public static String[] getAliases(String name) throws NoSuchBeanDefinitionException {
		return applicationContext.getAliases(name);
	}
}