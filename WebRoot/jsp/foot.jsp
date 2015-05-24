<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'foot.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  	<div style="position:absolute;top:80%">
		<marquee direction="right" scrollamount="2" >
			<img src="${pageContext.request.contextPath }/ads/ejb.jpg" height="50px">
			<img src="${pageContext.request.contextPath }/ads/j2ee.jpg" height="50px">
			<img src="${pageCOntext.request.contextPath }/ads/java.gif" height="50px">
			<img src="${pageContext.request.contextPath }/ads/javamail.gif" height="50px">
			<img src="${pageContext.request.contextPath }/ads/javascript.gif" height="50px">
			<img src="${pageContext.request.contextPath }/ads/javaweb1.gif"  height="50px"/>
			<img src="${pageContext.request.contextPath }/ads/javaweb2.gif"  height="50px"/>
			<img src="${pageContext.request.contextPath }/ads/jsf.jpg"  height="50px"/>
			<img src="${pageContext.request.contextPath }/ads/oracle.gif"  height="50px"/>
			<img src="${pageContext.request.contextPath }/ads/spring.gif"  height="50px"/>
		</marquee>
	</div>
  <body>
	    
  </body>
</html>
