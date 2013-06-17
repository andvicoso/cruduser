<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<ul class="nav nav-pills pull-right">
	<c:set var="login" value="${loginInfo.logged ? 'logout': 'login'}" />
	<c:set var="loginText" value="${loginInfo.logged ? 'Logout': 'Login'}" />
	<li><a href="">Início</a></li>
	<li><a href="login/${login}">${loginText}</a></li>
	<li><a href="user/add">Cadastrar</a></li>
	<li><a href="user/list">Listar</a></li>
</ul>
