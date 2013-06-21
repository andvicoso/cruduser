<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="masthead">
	<jsp:include page="menu.jsp" />

	<h3>Cadastro de Usuários ${loginInfo.logged ? '-':''}
		${loginInfo.logged ? loginInfo.userName : '' }</h3>
</div>
