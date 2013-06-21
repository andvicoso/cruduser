<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Editar ${user.name}</title>
</head>
<body>

	<div class="page-header">
		<h1>Editar ${user.name}</h1>
	</div>
	<form action="user/update" method="post">
		<input type="hidden" name="user.id" value="${user.id}">
		<label for="name">Nome:</label>
		<input type="text" name="user.name" id="name" value="${user.name}" required />
		<br>
		<label for="phone">Telefone:</label>
		<input type="text" name="user.phone" id="phone" value="${user.phone}" required />
		<br />
		<label for="login">Login:</label>
		<input type="text" name="user.login" id="login" value="${user.login}" required />
		<br />
		<label for="password">Senha*:</label>
		<input type="password" name="user.password" id="password" value="" required />
		<br />
		<small>*Deixe em branco para não alterar.</small>
		<br/>
		<input type="submit" class="btn btn-primary" value="Salvar">
	</form>
	<c:if test="${not empty sessionScope.userId}">
		<form action="user/remove" method="post">
			<input type="hidden" value="${user.id}" name="id" />
			<input type="submit" class="btn btn-danger" value="Remover"
				onclick="javascript:return confirm('Tem certeza que deseja remover o usuario ${user.name}?')">
		</form>
	</c:if>
</body>
</html>