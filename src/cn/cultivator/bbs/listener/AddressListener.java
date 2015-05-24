package cn.cultivator.bbs.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.cultivator.bbs.domain.Address;
import cn.cultivator.bbs.service.BbsService;

public class AddressListener implements ServletRequestListener{

	public void requestDestroyed(ServletRequestEvent sre) {
		try {
			HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
			HttpSession session = request.getSession();
			Address address = (Address) session.getAttribute("address");
			if(address==null){
				String ip = request.getRemoteAddr();
				BbsService bbsService = new BbsService();
				address = bbsService.getAddress(ip);
				session.setAttribute("address", address);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void requestInitialized(ServletRequestEvent arg0) {
		
	}

}
