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
	            <h1>프로필사진 수정</h1>
	            <h2>프로필 사진을 수정할 수  있습니다.</h2>
	        </div>
	        <div id="contents_detail">
	            <div id="contents_wrap">
	                <!-- Category -->
	                <ul id="contents_category">
	                    <li><a href="/teen/member/" class="select">마이페이지</a></li>
	                    <li><a href="/teen/member/boardList">내가 작성한 게시글</a></li>
	                    <li><a href="/teen/member/commentList">내가 작성한 댓글</a></li>
	                    <li><a href="#">나의 포인트</a></li>
	                    <li><a href="/teen/follow/followList">팔로잉</a></li>
	                    <li><a href="/teen/scrap/scrapList">스크랩</a></li>
	                </ul>
	                <!-- My Page -->
	                <div id="board_list" class="my_page">
	                	<div class="profile">
	                		<div class="member_info">
	                			
	                			<form action="/teen/member/updateProfile" enctype="multipart/form-data" method="post" onSubmit="return checkValue()">    
	                			<!-- 기존 프로필 이미지 , 이미지 변경 시 바로 보여져야 함-->
	                				<c:forEach items="${profile}" var="profile">
									
									<c:choose>
									<c:when test="${profile.member_profile eq 'N'}">
								<!-- 프로필 사진이 없을 경우 -->
	                				<div class="image-container">
										<img id="preview-image" src="/teen/resources/images/icon/icon_profile.svg" class="badge">
										<input style="display: block;" type="file" id="input-image" accept=".jpg" name="file">
									</div>	                			
									</c:when>
									<c:otherwise>
	                			<!-- 프로필 사진이 있을 경우 -->	
	                			<div class="image-container">
										<img id="preview-image" src="${path}${profile.member_profile}" class="badge">
										<input style="display: block;" type="file" id="input-image" accept=".jpg" name="file">
									</div>
									</c:otherwise>
								</c:choose>
								</c:forEach>
	                			
	                			<input type="submit" value="이미지저장"/>
	                			</form>
	                            
	                		</div>

	                	</div>
	                </div>

	                    
	                </div>
	            </div>
	        </div>
	
    
	<!-- Footer -->
	<jsp:include page="../template/footer.jsp" flush="false" />
	<!-- JS -->
	<script type="text/javascript" src="/teen/resources/js/member/myPage/profile.js"></script>
	
</body>
</html>