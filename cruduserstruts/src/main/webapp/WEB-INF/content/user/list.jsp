<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<body>

	<h1>Lista de usuários cadastrados</h1>
	<br>

	<table class="zebra">
		<thead>
			<tr>
				<th align="center"><b>Usuário</b></th>
				<th align="center"><b>Telefone</b></th>
				<c:if test="${not empty sessionScope.userId}">
					<th align="center"><b>Ações</b></th>
				</c:if>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${users}">
				<tr>
					<td>${user.name}</td>
					<td>${user.phone}</td>
					<c:if test="${not empty sessionScope.userId}">
						<td><a href="user/edit?id=${user.id}">Editar</a></td>
					</c:if>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>