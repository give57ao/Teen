<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TeenCoder 아이디 찾기</title>
<link rel="stylesheet" type="text/css" href="/teen/resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/common.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/memberForm.css">
</head>
<body>
	<!-- Header -->
	<jsp:include page="../template/header.jsp" flush="false" />
	
	<p>회원ID:<c:out value="${findId.MEMBER_ID }" default="null."/></p>
	
	<!-- Contents -->
	<%-- <div id="contents">
        <div id="contents_title">
            <h1>아이디 찾기</h1>
            <h2>이름과 이메일을 입력하시면 아이디를 찾으실 수 있습니다.</h2>
        </div>
        <div id="contents_detail">
            <!-- Form -->
            <form id="join_form" class="find_form">
                <h2>해당 회원의 아이디는 <b>TeenCoder</b> 입니다.</h2>
                <!-- 해당 회원의 아이디는 <b><%= request.getParameter("id") %></b> 입니다. -->
                <div id="btn_wrap">
                    <input type="button" value="로그인 화면으로 이동" class="btn_com btn_main" onClick="location.href='loginForm.jsp'">
                </div>
            </form>
        </div>
    </div> --%>
    
	<!-- Footer -->
	<jsp:include page="../template/footer.jsp" flush="false" />
</body>
</html>