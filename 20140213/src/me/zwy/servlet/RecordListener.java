package me.zwy.servlet;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class RecordListener implements HttpSessionListener,
		HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub

	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub

	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("�Ự" + se.getSession().getId() + "������");
		WebContent.count++;
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("�Ự" + se.getSession().getId() + "������");
		WebContent.count--;
	}

}
