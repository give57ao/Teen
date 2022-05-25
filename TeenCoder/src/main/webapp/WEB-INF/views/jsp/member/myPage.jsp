<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TeenCoder 마이페이지</title>
<link rel="stylesheet" type="text/css" href="/teen/resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/common.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/board.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/myInfo.css">
</head>
<body>
	<!-- Header -->
	<jsp:include page="../template/header.jsp" flush="false" />

	<!-- Contents -->
    <div id="contents">
        <div id="contents_title">
            <h1>마이페이지</h1>
            <h2>마이페이지에서 회원정보를 확인할 수 있습니다.</h2>
        </div>
        <div id="contents_detail">
            <div id="contents_wrap">
                <!-- Category -->
                <ul id="contents_category">
                    <li><a href="<%= request.getContextPath() %>/jsp/member/myPage.jsp" class="select">마이페이지</a></li>
                    <li><a href="<%= request.getContextPath() %>/jsp/member/myBoard.jsp">내가 작성한 게시글</a></li>
                    <li><a href="<%= request.getContextPath() %>/jsp/member/myCmt.jsp">내가 작성한 댓글</a></li>
                    <li><a href="#">나의 포인트</a></li>
                    <li><a href="#">팔로잉</a></li>
                    <li><a href="#">스크랩</a></li>
                </ul>
                <!-- My Page -->
                <div id="board_list" class="my_page">
                	<div class="profile">
                		<div class="member_info">
                			<img src="resources/images/icon/icon_badge.png" class="badge">
                			<div class="info_box">
	                			<h4>나의 등급<span class="rank">[Expert]</span></h4>
	                			<h3>TeenCoder</h3>
	                			<p>
	                				환영합니다! <b>${list[0].member_name}</b>님 (ID : ${list[0].member_id} )<br>
	                				가입일 : <fmt:formatDate value="${list[0].member_date}" pattern="yyyy.MM.dd"/> | 이메일 : ${list[0].member_email}
	                			</p>
                			</div>
                			<ul class="info_icon number">
                                <li><img src="resources/images/icon/icon_message.svg" class="i_msg">0</li>
                                <li><img src="resources/images/icon/icon_follow.svg" class="i_follow">0</li>
                                <li><img src="resources/images/icon/icon_scrap.svg" class="i_scrap">0</li>
                            </ul>
                			<a href="<%= request.getContextPath() %>/jsp/member/modifyForm.jsp" class="btn_com btn_mod_member">회원정보 수정</a>
                		</div>
                		<div class="member_board">
	                		<hr>
		                	<ul>
								<li><a href="/teen/member">마이페이지</a></li>
								<li><a href="/teen/member/boardList" class="select">내가작성한 게시글</a></li>
								<li><a href="/teen/member/comment">내가 작성한 댓글</a></li>
							</ul>
		                	<hr>
	                	</div>
	                	<a href="<%= request.getContextPath() %>/jsp/member/deleteForm.jsp" class="btn_del_member">회원탈퇴</a>
                	</div>
                </div>
                <!-- Member Info -->
                <div id="member_info">
                    <a href="<%= request.getContextPath() %>/jsp/board/boardWrite.jsp" class="btn_com btn_main">게시글 작성</a>
                    <div class="mycard"></div>
                </div>
            </div>
        </div>
    </div>
    
	<!-- Footer -->
	<jsp:include page="../template/footer.jsp" flush="false" />
</body>
</html>