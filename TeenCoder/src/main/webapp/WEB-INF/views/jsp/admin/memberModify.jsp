<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TeenCoder 관리자 회원 관리 > 회원정보 수정</title>
<link rel="stylesheet" type="text/css" href="/teen/resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/common.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/board.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/memberForm.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/admin.css">
</head>
<body>
	<!-- Header -->
	<jsp:include page="../template/header.jsp" flush="false" />

	<!-- Contents -->
    <div id="contents">
        <div id="contents_title">
            <h1>회원 관리</h1>
            <h2>회원 리스트 조회 및 회원정보 수정 및 탈퇴</h2>
        </div>
        <div id="contents_detail">
            <div id="contents_wrap">
                <!-- Category -->
                <ul id="contents_category">
                    <li><a href="/teen/admin/memberList" class="select">회원 관리</a></li>
                    <li><a href="/teen/admin/noticeBoard">공지글 관리</a></li>
                    <li><a href="/teen/admin/adminBoard">게시글 관리</a></li>
                    <li><a href="/teen/admin/reportBoard">신고글 관리</a></li>
                    <li><a href="/teen/admin/reportCmtList">댓글 관리</a></li>
                    <li><a href="/teen/admin/reportAnsList">답글 관리</a></li>
                </ul>
                <!-- Board -->
                <div id="board_list">
                    <!-- Title -->
                    <div id="board_list_title">
                        <h2>회원 관리 > 회원정보 수정</h2>
                    </div>
                	<!-- Form -->
                	<div id="admin_form">
                        <form id="join_form" action="memberModify" method="post">
                            <table>
                                <tbody>
                               		<c:forEach items="${member}" var="member">
	                                    <tr>
	                                        <th>아이디</th>
	                                        <td>${member.member_id}</td>
	                                    </tr>
	                                    <tr>
	                                        <th>비밀번호</th>
	                                        <td>
	                                            <input type="password" name="member_pw" placeholder="비밀번호">
	                                        </td>
	                                    </tr>
	                                    <tr>
	                                        <th>닉네임</th>
	                                        <td>
	                                            <input type="text" name="member_nick" placeholder="닉네임">
	                                        </td>
	                                    </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <div id="btn_wrap">
                                <input type="button" value="취소" class="btn_com btn_main" onClick="goMemberList()">
                                <input type="submit" value="수정" class="btn_com btn_main">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
	<!-- Footer -->
	<jsp:include page="../template/footer.jsp" flush="false" />
	
	<!-- JS -->
	<script type="text/javascript" src="/teen/resources/js/member/member.js"></script>
	<script type="text/javascript" src="/teen/resources/js/admin/admin.js"></script>
</body>
</html>