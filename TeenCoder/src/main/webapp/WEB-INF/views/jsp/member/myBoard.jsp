<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TeenCoder 내가 작성한 게시글</title>
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
			<h1>내가 작성한 게시글</h1>
			<h2>내가 작성한 게시글 목록을 확인할 수 있습니다.</h2>
		</div>
		<div id="contents_detail">
			<div id="contents_wrap">
				<!-- Category -->
			<ul id="contents_category">
				<li><a href="/teen/member/	">마이페이지</a></li>
				<li><a href="/teen/member/boardList" class="select">내가 작성한 게시글</a></li>
				<li><a href="/teen/member/commentList">내가 작성한 댓글</a></li>
				<li><a href="#">나의 포인트</a></li>
				<li><a href="#">팔로잉</a></li>
				<li><a href="#">스크랩</a></li>
			</ul>
			<!-- Board -->
			<div id="board_list">
				<!-- Title -->
				<div id="board_list_title">
					<h2>내가 작성한 게시글</h2>
					<ul id="board_list_menu" class="side_menu">
						<li><a href="boardList?sort=recent&search=${paging.search}&keyword=${paging.keyword}">최신순</a></li>
						<li><a href="boardList?sort=view&search=${paging.search}&keyword=${paging.keyword}">조회순</a></li>
						<li><a href="boardList?sort=recommend&search=${paging.search}&keyword=${paging.keyword}">추천순</a></li>
						<li><a href="boardList?sort=comment&search=${paging.search}&keyword=${paging.keyword}">댓글순</a></li>
					</ul>
				</div>
				<!-- Search -->
				<div id="board_list_search">
					<select class="dropdown">
						<option value="all" id="search" selected>전체</option>
						<option value="title" id="search">제목</option>
						<option value="content" id="search">내용</option>
						<option value="name" id="search">작성자</option>
					</select>
					<div class="search">
						<input type="text" id="keyword" placeholder="검색">
						<button class="btn_search" onClick ="searchBoard()">&nbsp;</button>
					</div>
				</div>
				<!-- List Row -->
				<div id="board_list_row">
					<!-- Row1 -->
					<c:forEach items="${board}" var="board">
			
						<div class="row">
							<div class="row_info">
								<ul class="row_top tag_category">
									<li>#${board.tag_name}</li>
								</ul>
								<div class="row_top member">
									<h4>
										<img src="/teen/resources/images/icon/icon_badge.png"
											class="i_badge"> <span class="rank">[Expert]</span>${board.member_nick}
									</h4>
								</div>
								<span class="row_top date"><fmt:formatDate value="${board.board_date }" pattern="yyyy.MM.dd" /></span>
								<ul class="row_top number">
									<li><img src="/teen/resources/images/icon/icon_hit.svg" class="i_hit">${board.board_hit_count}</li>
									<li><img src="/teen/resources/images/icon/icon_comment.svg" class="i_cmt">${board.board_comment_count}</li>
									<li><img src="/teen/resources/images/icon/icon_like.svg" class="i_like">${board.board_like_count}</li>
								</ul>
							</div>
							<div class="row_title">
								<h3>
									<a href="/teen/board/detail?board_no=${board.board_no}"> 
									<span 	class="tag_hit">[추천]</span> ${board.board_title} 
										<!-- <img src="../resources/images/icon/icon_image.svg" class="i_image">  -->
										<c:if test="${board.board_file_check eq 'Y'}">
											<img src="/teen/resources/images/icon/icon_file.svg" class="i_file">
										</c:if>
									</a>
								</h3>
								<p id="board_no" style= display:none;>${board.board_no}</p>
								<input type="button" value="삭제" class="btn_com btn_del_list" onClick = "deleteBoard()" >
							</div>
						</div>
						<hr>
					</c:forEach>
				</div>
				<!-- Pagination -->
				<div id="board_list_pagination">
					<ul>
						<!-- 왼쪽 버튼 -->
						<!-- 시작페이지가 1이 아닐 때 -->
						<c:if test="${paging.nowPage != 1 }">
							<li class="prev"><a
								href="/teen/member/boardList?sort=${sort}&search=${paging.search}&keyword=${paging.keyword}&nowPage=${paging.nowPage - 1 }&cntPerPage=${paging.cntPerPage}">&nbsp;</a></li>
						</c:if>
	
						<!-- 페이징 숫자가 나오는 부분 -->
						<c:forEach begin="${paging.startPage }" end="${paging.endPage }"
							var="p">
							<c:choose>
								<c:when test="${p == paging.nowPage }">
									<li><a class="select">${p }</a></li>
								</c:when>
								<c:when test="${p != paging.nowPage }">
									<li><a href="/teen/member/boardList?sort=${sort}&search=${paging.search}&keyword=${paging.keyword}&nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p }</a></li>
								</c:when>
							</c:choose>
						</c:forEach>
						<!-- 오른쪽 버튼 -->
						<c:if test="${paging.startPage < paging.endPage}">
							<li class="next"><a
								href="/teen/member/boardList?sort=${sort}&search=${paging.search}&keyword=${paging.keyword}&nowPage=${paging.nowPage+1 }&cntPerPage=${paging.cntPerPage}">&nbsp;</a></li>
						</c:if>
					</ul>
				</div>
				</div>
				<!-- Member Info -->
				<div id="member_info">
                    <a href="/teen/board/boardWrite" class="btn_com btn_main">게시글 작성</a>
					<div class="mycard"></div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- Footer -->
	<jsp:include page="../template/footer.jsp" flush="false" />
	<script type="text/javascript" src="/teen/resources/js/member/myPage/myBoard.js"></script>
</body>
</html>