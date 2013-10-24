<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Entrar</title>
</head>
<body>
	<div class="page-header">
		<h1>Entrar</h1>
	</div>
	<br />

	<form action="login/doLogin" method="post">
		<label for="login">Login:</label>
		<input type="text" name="login" id="login" required>
		<br />
		<label for="password">Senha:</label>
		<input type="password" name="password" id="password" required>
		<br /> <br />
		<input type="submit" class="btn btn-primary" value="Entrar">
	</form>
</body>
</html>