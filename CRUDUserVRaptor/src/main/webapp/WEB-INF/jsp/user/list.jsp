<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<title>Usuários Cadastrados</title>
</head>
<body>
	<div class="page-header">
		<h1>Usuários cadastrados</h1>
	</div>

	<table class="table table-bordered table-striped">
		<thead>
			<tr>
				<th align="center"><b>Usuário</b></th>
				<th align="center"><b>Telefone</b></th>
				<c:if test="${loginInfo.logged}">
					<th align="center"><b>Ações</b></th>
				</c:if>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${userList}">
				<tr>
					<td>${user.name}</td>
					<td>${user.phone}</td>
					<c:if test="${loginInfo.logged}">
						<td><a href="user/edit?id=${user.id}">Editar</a></td>
					</c:if>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>