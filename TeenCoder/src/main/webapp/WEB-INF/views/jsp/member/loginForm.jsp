<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TeenCoder 로그인</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/reset.css">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/common.css">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/memberForm.css">
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
            <form id="login_form">
                <input type="text" name="id" placeholder="아이디">
                <input type="password" name="password" placeholder="비밀번호">
                <ul id="login_menu" class="side_menu">
                    <li><a href="<%= request.getContextPath() %>/jsp/member/findIdForm.jsp">아이디 찾기</a></li>
                    <li><a href="<%= request.getContextPath() %>/jsp/member/findPwForm.jsp">비밀번호 찾기</a></li>
                    <li><a href="<%= request.getContextPath() %>/jsp/member/joinForm.jsp">회원가입</a></li>
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