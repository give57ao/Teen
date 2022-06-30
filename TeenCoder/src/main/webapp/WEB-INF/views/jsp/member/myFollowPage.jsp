<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TeenCoder 마이페이지</title>
<link rel="shortcut icon" href="/teen/resources/images/icon/icon_favicon.ico" type="image/x-icon"> <!-- favicon -->
<link rel="stylesheet" type="text/css" href="/teen/resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/common.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/board.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/myPage.css">
</head>
<body>
	<!-- Header -->
	<jsp:include page="../template/header.jsp" flush="false" />
	
	<!-- Contents -->
	    <div id="contents">
	        <div id="contents_title">
	            <h1>팔로우 리스트</h1>
	            <h2>내가 팔로우한 사람의 정보를 확인할 수 있습니다.</h2>
	        </div>
	        <div id="contents_detail">
	            <div id="contents_wrap">
	                <!-- Category -->
	                <ul id="contents_category">
	                    <li><a href="/teen/member/" >마이페이지</a></li>
	                    <li><a href="/teen/member/boardList">내가 작성한 게시글</a></li>
	                    <li><a href="/teen/member/commentList">내가 작성한 댓글</a></li>
	                    <li><a href="#">나의 포인트</a></li>
	                    <li><a href="/teen/follow/myFollowPage" class="select">팔로잉</a></li>
	                    <li><a href="/teen/scrap/scrapList">스크랩</a></li>
	                </ul>
	                <!-- My Page -->
	                <div id="board_list" class="my_page">
	                	<div id="board_list_title">
						<h2>나의 팔로우 목록</h2>
						</div>
	                	<div class="profile">
	                		<div class="member_info">
	              				 <c:forEach items="${followPage}" var="board">

								<c:choose>
									<c:when test="${board.member_profile eq 'N'}">
								<!-- 프로필 사진이 없을 경우 -->
	                			<img src="/teen/resources/images/icon/icon_profile.svg" class="badge">	                			
									</c:when>
									<c:otherwise>
	                			<!-- 프로필 사진이 있을 경우 -->	
	                			<img src="${path}${board.member_profile}" class="badge">	
									</c:otherwise>
								</c:choose>
	                			<div class="info_box">
		                			<h4>등급 <span class="rank">[Expert]</span></h4>
		                			<h3>${board.member_nick}</h3>
		                			<p>
		                				<b>${board.member_nick}</b>님을 팔로우 합니다.<br>
		                				팔로우한 날짜 : <fmt:formatDate value="${board.follow_date}" pattern="yyyy.MM.dd"/>
		                			</p>
	                			</div>
	                            <button class="btn_com btn_mod_profile" onclick="location.href='/teen/follow/followList?member_no=${board.member_no }';">게시글 보러가기</button>
	                            <button class="btn_com btn_mod_member" onclick="deleteFollow(${board.member_no })" > 팔로우 취소하기 </button>
	                            </c:forEach>
	                		</div>
		                </div>
	                </div>
                </div>
	        </div>
	    </div>
	<!-- Footer -->
	<jsp:include page="../template/footer.jsp" flush="false" />
	<script type="text/javascript" src="/teen/resources/js/member/myPage/myFollow.js"></script>
</body>
</html>