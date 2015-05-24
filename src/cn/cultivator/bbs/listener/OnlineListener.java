package cn.cultivator.bbs.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineListener implements HttpSessionListener{

	public void sessionCreated(HttpSessionEvent hse) {
		ServletContext context = hse.getSession().getServletContext();
		Integer onlineCount = (Integer) context.getAttribute("onlineCount");
		synchronized(context){
			if(onlineCount==null){
				context.setAttribute("onlineCount", 1);
			}else{
				onlineCount++;
				context.setAttribute("onlineCount", onlineCount);
			}
		}
		
	}

	public void sessionDestroyed(HttpSessionEvent hse) {
		ServletContext context = hse.getSession().getServletContext();
		Integer onlineCount = (Integer) context.getAttribute("onlineCount");
		synchronized(context){
			if(onlineCount!=null&&onlineCount>0){
				onlineCount--;
				context.setAttribute("onlineCount",onlineCount);
			}
		}
	}

}
