package cn.cultivator.bbs.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import cn.cultivator.bbs.domain.Topic;
import cn.cultivator.bbs.domain.Type;
import cn.cultivator.bbs.domain.User;
import cn.cultivator.bbs.exception.PasswordErrorException;
import cn.cultivator.bbs.service.BbsService;

public class BbsServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		this.doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		if("findAllType".equals(method)){
			this.listAllType(request, response);
		}else if("toLogin".equals(method)){
			request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
		}else if("Login".equals(method)){
			this.Userlogin(request, response);
		}else if ("toRegister".equals(method)) {
			request.getRequestDispatcher("jsp/register.jsp").forward(request, response);
		}else if ("register".equals(method)) {
			this.UserRegister(request, response);
		}else if("exit".equals(method)){
			this.exit(request, response);
		}else if("listTopic".equals(method)){
			this.ListAllTopic(request, response);
		}else if("toAddTopic".equals(method)){
			request.getRequestDispatcher("jsp/addTopic.jsp").forward(request, response);
		}else if("addTopic".equals(method)){
			this.addTopic(request, response);
		}
	}
	
	private void listAllType(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		try {
			BbsService bbsService = new BbsService();
			List<Type> typeList = bbsService.listAllType();
			request.setAttribute("typeList",typeList);
			request.getRequestDispatcher("jsp/listAllType.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "查询版块出错");
			request.getRequestDispatcher("jsp/message.jsp").forward(request, response);
		}
	}
	private void Userlogin(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		try {
			User user = new User();
			Enumeration<String> enums =  request.getParameterNames();
			while(enums.hasMoreElements()){
				String name = enums.nextElement();
				String[] values = request.getParameterValues(name);
				BeanUtils.setProperty(user, name, values);
			}
			BbsService bbsService = new BbsService();
			User u = bbsService.login(user);
			/*System.out.println(request.getContentType());*/
			if(u!=null){
				request.getSession().setAttribute("user", user);
				response.sendRedirect(request.getContextPath()+"/welcome.jsp");
			}else {
				throw new PasswordErrorException();
				}
			} catch (PasswordErrorException e) {
				e.printStackTrace();
				request.setAttribute("message", "You hava a fault");
				request.getRequestDispatcher("jsp/message.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("message", "登录失败");
				request.getRequestDispatcher("jsp/message.jsp").forward(request, response);
				
			}
	}	
	private void UserRegister(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		try {
			User user = new User();
			Enumeration<String> enumerations = request.getParameterNames();
			while (enumerations.hasMoreElements()) {
				String name = enumerations.nextElement();
				Object[] value = request.getParameterValues(name);
				BeanUtils.setProperty(user, name, value);
			}
				BbsService bbsService = new BbsService();
				bbsService.register(user);
				request.setAttribute("message", "register succeed!");
				request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void exit(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect(request.getContextPath()+"/welcome.jsp");
	}
	private void ListAllTopic(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		try {
			Integer typeId = Integer.valueOf(request.getParameter("typeId"));
			String tokenId1 = request.getParameter("tokenId"); 
			String tokenId2 =  (String) request.getSession().getAttribute("token");
//			System.out.println(tokenId1);
//			System.out.println(tokenId2);
			BbsService bbsService = new BbsService();
			if(tokenId1!=null&&tokenId2!=null&&tokenId1.equals(tokenId2)){
				bbsService.updateClickNum(typeId);
				request.getSession().removeAttribute("tokenId2");
			} 
			List<Topic> topicList = bbsService.listAllTopic(typeId);
			request.setAttribute("topicList", topicList);
			request.getRequestDispatcher("jsp/listAllTopic.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void addTopic(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {	
			try {
				Topic topic = new Topic();
				Enumeration<String> enums = request.getParameterNames();
				while(enums.hasMoreElements()){
					String name = enums.nextElement();
					String[] value = request.getParameterValues(name);
					BeanUtils.setProperty(topic, name, value);
				}
				BbsService bbsService = new BbsService();
				bbsService.addTopic(topic);
				request.setAttribute("message", "success to add");
				request.getRequestDispatcher("jsp/message.jsp").forward(request, response);
			} catch (Exception e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("message", "fail to add");
				request.getRequestDispatcher("jsp/message.jsp").forward(request, response);
			} 

	}
}