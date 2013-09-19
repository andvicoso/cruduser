<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="andvicoso">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="Content-Language" content="pt-BR" />

<base href="${pageContext.request.contextPath}/" />
<link type="image/x-icon" rel="shortcut icon"
	href="static/imgs/favicon.ico" />

<link href="static/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="static/bootstrap/css/bootstrap-responsive.css"
	rel="stylesheet">

<link href="static/styles/default.css" rel="stylesheet">
<link href="static/styles/normalize.css" rel="stylesheet">
<link href="static/styles/sticky_footer.css" rel="stylesheet">

<title>CRUD USER - <sitemesh:write property="title" /></title>
<sitemesh:write property="head" />
</head>
<body>

	<jsp:include page="template/header.jsp" />

	<hr>

	<div id="wrap" class="container">
		<div class="row-fluid">
			<div class="span2"></div>
			<div class="span8">

				<c:if test="${not empty errors}">
					<c:forEach var="error" items="${errors}">
						<span class="alert alert-${error.category}"
							style="display: inline-block">${error.message}</span>
						<br />
					</c:forEach>
					<hr>
				</c:if>

				<sitemesh:write property="body" />
				<div class="span2"></div>
			</div>
		</div>
	</div>

	<div id="push"></div>

	<jsp:include page="template/footer.jsp" />
	<!-- /container -->

	<script src="static/scripts/jquery/jquery.js" type="text/javascript"></script>
	<script src="static/scripts/jquery/jquery.tablesorter.js"
		type="text/javascript"></script>
	<script src="static/scripts/jquery/jquery.tablesorter.widgets.js"
		type="text/javascript"></script>
	<script src="static/scripts/jquery/jquery.tablesorter.bootstrap.js"
		type="text/javascript"></script>

	<script src="static/bootstrap/js/bootstrap.js" type="text/javascript"></script>

	<script type="text/javascript">
		var url = window.location;
		// Will only work if string in href matches with location
		$('ul.nav a[href="' + url + '"]').parent().addClass('active');

		// Will also work for relative and absolute hrefs
		$('ul.nav a').filter(function() {
			return this.href == url;
		}).parent().addClass('active');
	</script>

</body>
</html>