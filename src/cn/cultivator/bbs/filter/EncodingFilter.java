package cn.cultivator.bbs.filter;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodingFilter implements Filter{

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		MyRequest myRequest = new MyRequest(request);
		HttpServletRequest mm = myRequest.getRequest();
		chain.doFilter(mm, response);
	}

	class MyRequest {
		private HttpServletRequest request;
		public MyRequest(HttpServletRequest request) {
			this.request=request;
		}
		public HttpServletRequest getRequest(){
			return (HttpServletRequest) Proxy.newProxyInstance(MyRequest.class.getClassLoader(), 
					request.getClass().getInterfaces(),
					new InvocationHandler(){
						public Object invoke(Object proxy,//指被代理的对象 要调用的方法 方法调用所要用的参数 
								Method method,Object[] args)throws Throwable {
								
							String name = method.getName();//要增强的方法名
							Object returnVal = null;
							if("getParameter".equals(name)){
								String methodType = request.getMethod();
								if("get".equalsIgnoreCase(methodType)){
									String result = (String) method.invoke(request, args);
									returnVal = new String(result.getBytes("ISO8859-1"),"UTF-8");
								}else if ("post".equalsIgnoreCase(methodType)) {
									request.setCharacterEncoding("UTF-8");
									returnVal = method.invoke(request, args);
								}
							}else {
								returnVal = method.invoke(request, args);
							}
							
							return returnVal;
						}
					
			});
		}
	}


}

