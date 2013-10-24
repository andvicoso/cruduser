<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Início</title>
</head>
<body>
	<div class="jumbotron">
		<h1>Bem vindo ao cadastro de usuários!</h1>
		<p class="lead">Web site para cadastro de usuários e seus
			telefones.</p>
		<c:if test="${not loginInfo.logged}">
			<a class="btn btn-large btn-success" href="login/login">Cadastre-se!</a>
		</c:if>
	</div>

	<hr>

	<div class="row-fluid marketing">
		<div class="span6">

			<h4>
				<a href="login/login">Login</a>
			</h4>
			<p>Já é cadastrado? Faça o seu login!</p>

			<h4>
				<a href="user/add">Cadastro</a>
			</h4>
			<p>Não é cadastrado? Cadastre-se!</p>

			<h4>Subheading</h4>
			<p>Maecenas sed diam eget risus varius blandit sit amet non
				magna.</p>
		</div>

		<div class="span6">
			<h4>
				<a href="user/list">Usuários cadastrados</a>
			</h4>
			<p>Lista com os usuários já cadastrados no sistema.</p>

			<h4>Subheading</h4>
			<p>Morbi leo risus, porta ac consectetur ac, vestibulum at eros.
				Cras mattis consectetur purus sit amet fermentum.</p>

			<h4>Subheading</h4>
			<p>Maecenas sed diam eget risus varius blandit sit amet non
				magna.</p>
		</div>
	</div>

</body>
</html>