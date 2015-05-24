<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'head.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
 		function init(){
 			window.setInterval("updateTime()",1000);
 		}
 		function updateTime(){
 			var now = new Date().toLocaleString();
 			var time = document.getElementById("show");
 			time.innerHTML = now;
 		}
	</script>
  </head>
  
  <body onload="init()"> 
	欢迎
	<font color="blue">
		${!empty user ? user.username :"<font color='bule'>游客</font>" }
	</font>
		 光临！当前时间是: 
	<span id = "show"></span>
	<div style="position:absolute;left:80%;top:0%;font-size:17px">
		你的ip地址:${address.ip }<br/>
		归属地:${address.location }<br/>
		在线人数:${!empty onlineCount?onlineCount:''}<br/>
	</div>
	<br/>
	<a href="${pageContext.request.contextPath}/welcome.jsp" style="text-decoration:none">首页</a>
	<c:if test="${empty user}">
		<a href="${pageContext.request.contextPath}/BbsServlet?method=toLogin" style="text-decoration:none">登录</a>
		<a href="${pageContext.request.contextPath}/BbsServlet?method=toRegister" style="text-decoration:none">注册</a>
	</c:if>
		<a href="${pageContext.request.contextPath}/BbsServlet?method=exit" style="text-decoration:none">退出</a>
  </body>
</html>
