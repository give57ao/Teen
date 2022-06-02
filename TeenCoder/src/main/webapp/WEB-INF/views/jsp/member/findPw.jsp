<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TeenCoder 비밀번호 찾기</title>
<link rel="stylesheet" type="text/css" href="/teen/resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/common.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/memberForm.css">
<script src="/teen/resources/js/member.js"></script>
</head>
<body>
	<!-- Header -->
	<jsp:include page="../template/header.jsp" flush="false" />
	<p>회원 PW:<c:out value="${findPw.member_pw }" default="null."/></p>
	<!-- Contents -->
	<%-- <div id="contents">
        <div id="contents_title">
            <h1>비밀번호 찾기</h1>
            <h2>아이디와 이메일을 입력하시면 비밀번호를 찾으실 수 있습니다.</h2>
        </div>
        <div id="contents_detail">
            <!-- Form -->
            <form id="join_form" class="find_form">
                <h2>해당 회원의 비밀번호는 <b><c:out value="${findPw.member_pw}" default="null"/></b> 입니다.</h2>
                <div id="btn_wrap">
                    <input type="button" value="로그인 화면으로 이동" class="btn_com btn_main" onClick="goLogin()">
                </div>
            </form>
        </div>
    </div> --%>
    
	<!-- Footer -->
	<jsp:include page="../template/footer.jsp" flush="false" />
</body>
</html>