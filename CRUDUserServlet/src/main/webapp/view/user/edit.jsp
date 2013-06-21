<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Editar ${user.name}</title>
</head>
<body>

	<h1>Editar ${user.name}</h1>
	<br>
	<form action="view/user/update.do" method="post">
		<input type="hidden" name="id" value="${user.id}">
		<label for="name">Nome:</label>
		<input type="text" name="name" id="name" value="${user.name}">
		<br>
		<label for="phone">Telefone:</label>
		<input type="text" name="phone" id="phone" value="${user.phone}">
		<br />
		<label for="login">Login:</label>
		<input type="text" name="login" id="login" value="${user.login}">
		<br />
		<label for="password">Senha*:</label>
		<input type="text" name="password" id="password" value="">
		<br />
		<br />
		<small>*Deixe vazio se não quiser alterar.</small>
		<input type="submit" class="button" value="Salvar">
	</form>
	<form action="remove.do" method="post">
		<input type="hidden" value="${user.id}" name="id" />
		<input type="submit" class="button" value="Remover"
			onclick="javascript:return confirm('Tem certeza que deseja remover o usuario ${user.name}?')">
	</form>
</body>
</html>