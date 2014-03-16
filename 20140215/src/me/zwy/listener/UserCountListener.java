package me.zwy.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import me.zwy.web.WebContent;

public class UserCountListener implements HttpSessionAttributeListener,HttpSessionListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		if(se.getName().equals("user")){
			WebContent.userCount++;
			WebContent.userList.add(se.getValue());
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {

	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {

	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		WebContent.userCount--;
		WebContent.userList.remove(se.getSession().getAttribute("user"));
	}

}
