<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>Test</h2>
	<c:forEach var="list" items="${list}">
		<div>
			<p><c:out value="${list.name}" /></p>
			<p><c:out value="${list.id}" /></p>
		</div>
	</c:forEach>
</body>
</html>