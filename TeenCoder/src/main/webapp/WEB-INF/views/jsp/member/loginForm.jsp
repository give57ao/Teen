<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TeenCoder 로그인</title>
<link rel="stylesheet" type="text/css" href="../resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="../resources/css/common.css">
<link rel="stylesheet" type="text/css" href="../resources/css/memberForm.css">
<script src="../resources/js/login.js"></script>
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
                <input type="text" name="member_id" placeholder="아이디">
                <input type="password" name="member_pw" placeholder="비밀번호">
                <ul id="login_menu" class="side_menu">
                    <li><a href="findIdForm">아이디 찾기</a></li>
                    <li><a href="findPwForm">비밀번호 찾기</a></li>
                    <li><a href="join">회원가입</a></li>
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