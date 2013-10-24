<%@ tag body-content="scriptless"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach var="error" items="${errors}">
    ${error.category} - ${error.message}<br />
</c:forEach>