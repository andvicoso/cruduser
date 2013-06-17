<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<title>Cadastro de Usuário</title>
</head>
<body>

	<h1>Cadastro de Usuário</h1>
	<br>
	<form action="user/put" method="post" class="forms">
		<label for="name">Nome: </label>
		<input type="text" name="name" id="name">
		<br />
		<label for="phone">Telefone: </label>
		<input type="text" name="phone" id="phone">
		<br />
		<label for="login">Login:</label>
		<input type="text" name="login" id="login">
		<br />
		<label for="password">Senha:</label>
		<input type="text" name="password" id="password">
		<br />
		<input type="submit" class="button" value="Salvar">
	</form>
</body>
</html>

