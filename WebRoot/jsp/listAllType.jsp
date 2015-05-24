<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="cn.cultivator.bbs.util.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'listAllType.jsp' starting page</title>
    
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
	<form action="" method="post">
		<caption><h1 align="center">论坛系统</h1></caption>
		<table border="1" align="center" width="80%">
			<tr>
				<th>图片</th>			
				<th>名称</th>			
				<th>点击数</th>			
				<th>主题数</th>			
				<th>最新主题</th>			
				<th>版主</th>			
			</tr>
			<%
				String token = WebUtil.getRandom();
				session.setAttribute("token",token);
			 %>
			<c:forEach var="type" items="${typeList}">
				<tr>
					<td><img src="${type.imagepath}" width="50px" height="30px"/></td>
					<td>
						<a href="${pageContext.request.contextPath}/BbsServlet?method=listTopic&typeId=${type.id}&tokenId=${token}">${type.name }</a>
					</td>
					<td>${type.click }</td>
					<td>${type.topicNum }</td>
					<td>
						<div>
							主题:${type.newTopic.name }
							作者:${type.newTopic.author }<br/>
							时间:
							<fmt:formatDate
		  						value="${type.newTopic.time}"
		  						type="both"
		  						dateStyle="full"
		  						timeStyle="default"
  							/>	
						</div>
					</td>
					<td>${type.admin.name}</td>
				</tr>
			</c:forEach>

		</table>
	</form>
	<jsp:include page="foot.jsp"></jsp:include>    
  </body>
</html>
