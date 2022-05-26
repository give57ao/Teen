<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TeenCoder 로그인</title>
<link rel="stylesheet" type="text/css" href="/teen/resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/common.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/memberForm.css">
<script src="/teen/resources/js/member.js"></script>
<script type="text/javascript">
	function formChk() { 
		var in_id = document.getElementById("id").value;
		var in_pw = document.getElementById("password").value;
		
		var db_id = '<c:out value="${login.MEMBER_ID }"/>'; 
		var db_pw = '<c:out value="${login.MEMBER_ID }"/>'; 
		
		alert(db_id);
		alert(db_pw);
		
		if (in_id != db_id) {
			alert("id 불일치");
			return false;
		}
		if (in_id != db_pw) {
			alert("pw 불일치");
			return false;
		}
		
		alert("다 안됨!");
		return true;

	}
</script>
</head>

<body>
	<!-- Header -->
	<jsp:include page="../template/header.jsp" flush="false" />

	<!-- Contents -->
	<div id="contents">
        <div id="contents_title">
            <h1>로그인</h1>
            <h2>로그인 후 커뮤니티 이용이 가능합니다.</h2>
        </div>
        <div id="contents_detail">
            <h1>TeenCoder</h1>
            <!-- Form -->
            <form id="login_form" name="login_form" action="login" method="post" onSubmit="return loginProcess()">
                <input id="member_id" type="text" name="member_id" placeholder="아이디">
                <input type="password" name="member_pw" placeholder="비밀번호">
		<div id="contents_title">
			<h1>로그인</h1>
			<h2>로그인 후 커뮤니티 이용이 가능합니다.</h2>
		</div>
		<div id="contents_detail">
			<h1>TeenCoder</h1>
			<!-- Form -->
			<form id="login_form" action="testCheck" method="post" onsubmit="return formChk()">
				<input type="text" name="id" id ="id" placeholder="아이디"> 
				<input type="password" name="password" id="password" placeholder="비밀번호">			
                <ul id="login_menu" class="side_menu">
                    <li><a href="/teen/member/findIdForm">아이디 찾기</a></li>
                    <li><a href="/teen/member/findPwForm">비밀번호 찾기</a></li>
                    <li><a href="/teen/member/joinForm">회원가입</a></li>
                </ul>
				<div id="btn_wrap">
					<input type="submit" value="로그인" class="btn_com btn_main">
				</div>
			</form>
		</div>
	</div>
	<!-- Footer -->
	<jsp:include page="../template/footer.jsp" flush="false" />
</body>
</html>