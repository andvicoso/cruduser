<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<html>

<head>
<title>Erro</title>
</head>
<body>
	<h1>Erro - ${error}!</h1>
	<br /> Tente
	<a href="${pageContext.request.contextPath}/index.jsp">isso</a>!
</body>
</html>