<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="menu">
	<ul>
		<c:set var="logged" value="${not empty sessionScope.userId}" />
		<c:set var="login" value="${logged ? 'logout': 'login'}" />
		<c:set var="loginText" value="${logged ? 'Logout': 'Login'}" />
		<li><a href="index">Home</a></li>
		<li><a href="login/${login}">${loginText}</a></li>
		<li><a href="user/add">Cadastrar</a></li>
		<li><a href="user/list">Listar</a></li>
	</ul>
</div>