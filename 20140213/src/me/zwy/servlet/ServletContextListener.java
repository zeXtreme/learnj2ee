package me.zwy.servlet;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;

public class ServletContextListener implements
		javax.servlet.ServletContextListener, ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent scab) {
		System.out.println("���ԣ�" + scab.getName() + "�����");
		System.out.println(scab.getName() + ":" + scab.getValue());
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent scab) {
		System.out.println("���ԣ�" + scab.getName() + "ɾ����");
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent scab) {
		System.out.println("���ԣ�" + scab.getName() + "�޸���");
		System.out.println(scab.getName() + ":" + scab.getValue());
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("servlet:" + sce.getServletContext().getContextPath() + "��ʼ����");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("servlet:" + sce.getServletContext().getContextPath() + "������");
	}

}
