<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'listAllTopic.jsp' starting page</title>

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
		<jsp:include page="head.jsp" />
		<c:if test="${!empty user}">
			<a
				href="${pageContext.request.contextPath}/BbsServlet?method=toAddTopic&typeId=${param.typeId}"
				style="text-decoration: none"> 发表主题 </a>
		</c:if>
		<table border="1" align="center" width="80%">
			<caption>
				<h2>
					论坛系统
				</h2>
			</caption>
			<tr>
				<th></th>
				<th>
					名称
				</th>
				<th>
					作者
				</th>
				<th>
					回贴数
				</th>
				<th>
					时间
				</th>
				<th>
					操作
				</th>
			</tr>
			<c:forEach items="${topicList}" var="topic" varStatus="list">
				<tr>
					<td>
						${list.count==1?'<img src="luntan/images/flag.gif"/>':'' }
					</td>
					<td>
						${topic.name}
					</td>
					
					<td>
						${topic.author }
					</td>
					<td> 
						3
					</td> 
					<td>
						${topic.time }
					</td>
					<td align="center">
						<c:if test="${!empty user and user.username==topic.author}">
							<a href="#" style="text-decoration:none">[编辑]</a>
						</c:if>
					</td>
				</tr>
			</c:forEach>

		</table>
		<jsp:include page="foot.jsp" />
	</body>
</html>
