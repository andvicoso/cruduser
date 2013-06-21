<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<title>Lista de usuários</title>
</head>
<body>

	<h1>Lista de usuários</h1>
	<br>
	<c:set var="logged" value="${not empty sessionScope.userId}" />
	<table class="zebra">
		<thead>
			<tr>
				<th align="center"><b>Usuário</b></th>
				<th align="center"><b>Telefone</b></th>
				<c:if test="${logged}">
					<th align="center"><b>Ações</b></th>
				</c:if>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${users}">
				<tr>
					<td>${user.name}</td>
					<td>${user.phone}</td>
					<c:if test="${logged}">
						<td><a href="view/user/edit.do?id=${user.id}">Editar</a></td>
					</c:if>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>