package cn.cultivator.bbs.filter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class CopyrightFilter implements Filter{
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	public void destroy() {
		
	}
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		MyResponse myResponse = new MyResponse(response);
		chain.doFilter(request,myResponse);
		byte[] date = myResponse.getBuffer();
		String content = new String(date,"UTF-8");
		content+="<h3><b><div style='position:absolute;top:95%;left:45%'>CopyRight-2015-2020-吴新杰</div></b></h3>";
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(content);
	}

}

class MyResponse extends HttpServletResponseWrapper{
	private HttpServletResponse response;
	public MyResponse(HttpServletResponse response) {
		super(response);
		this.response= response;
	}
	private ByteArrayOutputStream bout = new ByteArrayOutputStream();
	private PrintWriter pw;
	
	public byte[] getBuffer(){
		if(pw!=null){
			pw.flush();
		}
		return bout.toByteArray();
	}
	public PrintWriter getWriter() throws IOException{
		pw = new PrintWriter(new OutputStreamWriter(bout,"UTF-8"));
		return pw;
	}
}
