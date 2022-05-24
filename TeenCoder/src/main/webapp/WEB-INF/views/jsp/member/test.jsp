<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test</title>
</head>

<body>
	<h1>테스트페이지입니다</h1>
	<c:out value="${list.MEMBER_ID }" default="null..."/>
</body>
</html>