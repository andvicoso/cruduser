<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="menu">
	<ul>
		<c:set var="logged" value="${not empty sessionScope.userId}" />
		<c:set var="login" value="${logged ? 'logout': 'login'}" />
		<c:set var="loginText" value="${logged ? 'Logout': 'Login'}" />
		<li><a href="view/login/${login}.xhtml">${loginText}</a></li>
		<li><a href="view/user/add.xhtml">Cadastrar</a></li>
		<li><a href="view/user/list.xhtml">Listar</a></li>
	</ul>
</div>