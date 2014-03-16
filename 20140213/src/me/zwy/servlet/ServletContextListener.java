package me.zwy.servlet;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;

public class ServletContextListener implements
		javax.servlet.ServletContextListener, ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent scab) {
		System.out.println("属性：" + scab.getName() + "添加了");
		System.out.println(scab.getName() + ":" + scab.getValue());
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent scab) {
		System.out.println("属性：" + scab.getName() + "删除了");
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent scab) {
		System.out.println("属性：" + scab.getName() + "修改了");
		System.out.println(scab.getName() + ":" + scab.getValue());
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("servlet:" + sce.getServletContext().getContextPath() + "初始化中");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("servlet:" + sce.getServletContext().getContextPath() + "销毁了");
	}

}
