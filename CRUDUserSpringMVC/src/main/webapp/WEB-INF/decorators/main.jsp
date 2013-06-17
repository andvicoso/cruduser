<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.contextPath}/" />
<link href="static/css/default.css" rel="stylesheet" />
<title>CRUD USER - <sitemesh:write property="title" /></title>
<sitemesh:write property="head" />
</head>
<body>
	<jsp:include page="template/header.jsp" />
	<jsp:include page="template/menu.jsp" />

	<div class="content">
		<sitemesh:write property="body" />
	</div>
	<jsp:include page="template/footer.jsp" />
</body>
</html>