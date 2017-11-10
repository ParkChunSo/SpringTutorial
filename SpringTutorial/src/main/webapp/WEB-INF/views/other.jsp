<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
Other
<table>
	<tr>
		<th>no</th>
		<th>이름</th>
	</tr>
	<c:forEach items="${value3}" var="cosmos">
		<tr>
			<td>${cosmos.no}</td>
			<td><input type="button" value="${cosmos.name}"></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>