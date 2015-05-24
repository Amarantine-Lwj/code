<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
 	<jsp:include page="head.jsp"></jsp:include>
	  <form action="${pageContext.request.contextPath }/BbsServlet?method=Login" method="post">
	  	<table border="1" align="center" style="position:absolute;left:40%;top:20%">
	  		<caption><h2 align="center">用户名登录</h2></caption>
	  		<tr>
	  			<th>用户名</th>
	  			<td><input type="text" name="username"/></td>
	  		</tr>
	  		<tr>
	  			<th>密码</th>
	  			<td><input type="password" name="password"/></td>
	  		</tr>
	  		<tr >
	  			<td colspan="2" align="center"><input type="submit" value="提交"/></td>
	  		</tr>
	  	</table>
	  </form>  
    <jsp:include page="foot.jsp"></jsp:include>
  </body>
</html>
