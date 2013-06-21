<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Cadastro de Usuário</title>
</head>
<body>

	<h1>Cadastro de Usuário</h1>
	<br>
	<s:fielderror fieldName="user.password"></s:fielderror>
	<s:actionerror />
	<s:actionmessage />
	<form action="user/put" method="post" class="forms">
		<label for="name">Nome:</label>
		<input type="text" name="user.name" id="name" />
		<br />
		<label for="phone">Telefone:</label>
		<input type="text" name="user.phone" id="phone">
		<br />
		<label for="login">Login:</label>
		<input type="text" name="user.login" id="login" />
		<br />
		<label for="password">Senha:</label>
		<s:password name="user.password" id="password"  />
		<br />
		<input type="submit" class="button" value="Salvar">
	</form>
</body>
</html>

