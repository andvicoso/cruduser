<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<title>Cadastro</title>
</head>
<body>

	<div class="page-header">
		<h1>Cadastro</h1>
	</div>
	<form action="user/put" method="post" class="forms">
		<label for="name">Nome:</label>
		<input type="text" name="user.name" id="name" required/>
		<br />
		<label for="phone">Telefone:</label>
		<input type="text" name="user.phone" id="phone" required/>
		<br />
		<label for="login">Login:</label>
		<input type="text" name="user.login" id="login" required/>
		<br />
		<label for="password">Senha:</label>
		<input type="password" name="user.password" id="password" required />
		<br />
		<input type="submit" class="btn btn-primary" value="Salvar">
	</form>
</body>
</html>

