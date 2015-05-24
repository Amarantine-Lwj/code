<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addTopic.jsp' starting page</title>
    
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
	<form action="${pageContext.request.contextPath}/BbsServlet?method=addTopic" method="post">
		<table border="1" style="position:absolute;top:10%;left:40%">
			<caption><h2>发表主题</h2></caption>
			 <tr>
  				<td>
  					<input type="hidden" name="typeId" value="${param.typeId}"/>
  				</td>
  			</tr>
			<tr>
				<th>主题名</th>
				<td><input type="text" name="name" maxlength="10"/></td>
			</tr>
			<tr>
				<th>作者</th>
				<td><input type="text" name="author" value="${user.username}" readonly/></td>
			</tr>
			<tr>
				<th>内容</th>
				<td>
					<textarea name="content" rows="5" cols="20"></textarea> 
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="提交" />
				</td>
			</tr>
		</table>	
	</form>
	<jsp:include page="foot.jsp"></jsp:include>
  </body>
</html>
