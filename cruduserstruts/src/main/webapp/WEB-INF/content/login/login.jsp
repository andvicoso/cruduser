<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<h1>Entrar</h1>
<br />
<s:actionerror />
<s:actionmessage/>
<form action="login/doLogin" method="post" class="forms">
	<label for="login">Login:</label>
	<input type="text" name="login" id="login">
	<br />
	<label for="password">Senha:</label>
	<input type="password" name="password" id="password">
	<br /> <br />
	<input type="submit" class="button" value="Entrar">
</form>