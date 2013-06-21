<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<body>

	<h1>Editar ${user.name}</h1>
	<br>
	<s:actionerror />
	<s:actionmessage />
	<form action="user/save" method="post">
		<input type="hidden" name="user.id" value="${user.id}">
		<label for="name">Nome:</label>
		<input type="text" name="user.name" id="name" value="${user.name}">
		<br>
		<label for="phone">Telefone:</label>
		<input type="text" name="user.phone" id="phone" value="${user.phone}">
		<br />
		<label for="login">Login:</label>
		<input type="text" name="user.login" id="login" value="${user.login}"/>
		<br />
		<label for="password">Senha*:</label>
		<input type="password" name="password" id="password">
		<br />
		<small>*Deixe vazio se não quiser alterar.</small><br/>
		<input type="submit" class="button" value="Salvar">
	</form>
	<c:if test="${not empty sessionScope.userId}">
		<form action="user/remove.do" method="post">
			<input type="hidden" value="${user.id}" name="id" />
			<input type="submit" class="button" value="Remover"
				onclick="javascript:return confirm('Tem certeza que deseja remover o usuario ${user.name}?')">
		</form>
	</c:if>
</body>
</html>