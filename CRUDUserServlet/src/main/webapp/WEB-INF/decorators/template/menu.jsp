<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="menu">
	<ul>
		<c:set var="logged" value="${not empty sessionScope.userId}" />
		<li><a href="index.jsp">Home</a></li>
		<c:if test="${logged}">
			<li><a href="view/login/logout.do">Logout</a></li>
		</c:if>
		<c:if test="${not logged}">
			<li><a href="view/login/login.jsp">Login</a></li>
		</c:if>
		<li><a href="view/user/add.jsp">Cadastrar</a></li>
		<li><a href="view/user/list.do">Listar</a></li>
	</ul>
</div>