<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TeenCoder 마이페이지</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/reset.css">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/common.css">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/board.css">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/myInfo.css">
</head>
<body>
	<!-- Header -->
	<jsp:include page="/jsp/template/header.jsp" flush="false" />

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
                			<img src="<%= request.getContextPath() %>/images/icon/icon_badge.png" class="badge">
                			<div class="info_box">
	                			<h4>나의 등급<span class="rank">[Expert]</span></h4>
	                			<h3>TeenCoder</h3>
	                			<p>
	                				환영합니다! <b>TeenCoder</b>님 (ID : TeenCoder)<br>
	                				가입일 : 2022-05-10 | 이메일 : TeenCoder@gmail.com
	                			</p>
                			</div>
                			<ul class="info_icon number">
                                <li><img src="<%= request.getContextPath() %>/images/icon/icon_message.svg" class="i_msg">0</li>
                                <li><img src="<%= request.getContextPath() %>/images/icon/icon_follow.svg" class="i_follow">0</li>
                                <li><img src="<%= request.getContextPath() %>/images/icon/icon_scrap.svg" class="i_scrap">0</li>
                            </ul>
                			<a href="<%= request.getContextPath() %>/jsp/member/modifyForm.jsp" class="btn_com btn_mod_member">회원정보 수정</a>
                		</div>
                		<div class="member_board">
	                		<hr>
		                	<ul>
		                		<li>내가 작성한 게시글<a href="<%= request.getContextPath() %>/jsp/member/myBoard.jsp">1개</a></li>
		                		<li>내가 작성한 댓글<a href="<%= request.getContextPath() %>/jsp/member/myCmt.jsp">10개</a></li>
		                		<li>나의 포인트<a href="#">1000point</a></li>
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
	<jsp:include page="/jsp/template/footer.jsp" flush="false" />
</body>
</html>