<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TeenCoder 내가 팔로우한 사람의 게시글</title>
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
			<h1>나의 팔로우 목록</h1>
			<h2>내가 팔로우한 사람들의 게시글을 확인할 수 있습니다.</h2>
		</div>
		<div id="contents_detail">
			<div id="contents_wrap">
				<!-- Category -->
				<ul id="contents_category">
					<li><a href="/teen/member/">마이페이지</a></li>
					<li><a href="/teen/member/boardList" >내가 작성한 게시글</a></li>
					<li><a href="/teen/member/commentList">내가 작성한 댓글</a></li>
					<li><a href="#">나의 포인트</a></li>
					<li><a href="/teen/follow/myFollowPage" class="select" >팔로잉</a></li>
					<li><a href="/teen/scrap/scrapList">스크랩</a></li>
				</ul>
				<!-- Board -->
				<div id="board_list">
					<!-- Title -->
					<div id="board_list_title">
						<h2>나의 팔로우 목록</h2>
					</div>
					<!-- Search -->
					<!-- List Row -->
					<div id="board_list_row">
						<!-- Row1 -->
						<c:choose>
							<c:when test="${paging.total > 0}">
								<c:forEach items="${followBoardList}" var="follow" varStatus="status">
									<div class="row">
										<div class="row_info">
											<ul class="row_top tag_category">
												<li>#${follow.board_tag_name}</li>
											</ul>
											<div class="row_top member">
												<h4>
													<img src="/teen/resources/images/icon/icon_badge.png"
														class="i_badge">
													<button  id="dropdown-menu" onclick="dp_menu()" style="text-decoration: underline;" >${follow.member_nick}</button>
												</h4>
												<div style="display: none; position: absolute;" id="drop-content">
													<input type="hidden" id="member_nick" value="${follow.member_nick }">
													<input type="hidden" id="member_no" value="${follow.member_no }">
													<div><button onclick="follow()" >팔로우 하기</button></div> 
													<div><button onclick="msg()" >쪽지 보내기</button></div> 
													<div><button onclick="board()" >게시글 보기</button></div>
												</div>
											</div>
											<span class="row_top date"><fmt:formatDate value="${follow.board_date}" pattern="yyyy.MM.dd"/></span>
											<ul class="row_top number">
												<li><img src="/teen/resources/images/icon/icon_hit.svg" class="i_hit">${follow.board_hit_count}</li>
												<li><img src="/teen/resources/images/icon/icon_comment.svg" class="i_cmt">${follow.board_comment_count}</li>
												<li><img src="/teen/resources/images/icon/icon_like.svg" class="i_like">${follow.board_like_count}</li>
											</ul>
										</div>
										<div class="row_title">
											<h3>
												<a class="overtext" href="/teen/board/detail?board_no=${follow.board_no}"> 
														<c:choose>
														<c:when test="${follow.member_pro_check == 'Y' }">
															<span class="rank">[Expert]</span>
														</c:when>
														<c:when test="${follow.member_admin == 'Y'}">
															<span class="rank" style="color: #FF0105;">[Admin]</span>
														</c:when>
														<c:otherwise>
															<span class="rank" style="color: #111;">[TeenCoder]</span>
														</c:otherwise>
													</c:choose>${follow.board_title}
													<c:if test="${follow.board_file_check eq 'Y'}">
														<img src="/teen/resources/images/icon/icon_file.svg" class="i_file">
													</c:if>
												</a>
											</h3>
										</div>
									</div>
									<hr>
								</c:forEach>
							</c:when>
							
							<c:otherwise>
								<p>해당 내용이 없습니다.</p>
							</c:otherwise>
						</c:choose>
					</div>
					<!-- Pagination -->
					<div id="board_list_pagination">
						<ul>
							<!-- 왼쪽 버튼 -->
							<!-- 시작페이지가 1이 아닐 때 -->
							<c:if test="${paging.nowPage != 1}">
								<li><a class="prev" href="/teen/follow/followList?sort=${sort}&search=${paging.search}&keyword=${paging.keyword}&nowPage=${paging.nowPage - 1}&cntPerPage=${paging.cntPerPage}"></a></li>
							</c:if>
							<!-- 페이징 숫자가 나오는 부분 -->
							<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="p">
								<c:choose>
									<c:when test="${p == paging.nowPage}">
										<li><a class="select">${p}</a></li>
									</c:when>
									<c:when test="${p != paging.nowPage}">
										<li><a href="/teen/follow/followList?sort=${sort}&search=${paging.search}&keyword=${paging.keyword}&nowPage=${p}&cntPerPage=${paging.cntPerPage}">${p}</a></li>
									</c:when>
								</c:choose>
							</c:forEach>
							<!-- 오른쪽 버튼 -->
							<c:if test="${paging.startPage < paging.endPage}">
								<li><a class="next" href="/teen/follow/followList?sort=${sort}&search=${paging.search}&keyword=${paging.keyword}&nowPage=${paging.nowPage + 1}&cntPerPage=${paging.cntPerPage}"></a></li>
							</c:if>
						</ul>
					</div>
				</div>
				<!-- Member Info -->
				<div id="member_info">
                    <a href="/teen/board/boardWrite" class="btn_com btn_main">게시글 작성</a>
					<!-- My Card -->
						<jsp:include page="../template/myCard.jsp" flush="false" />
				</div>
			</div>
		</div>
	</div>
	
	<!-- Footer -->
	<jsp:include page="../template/footer.jsp" flush="false" />
	
	<!-- JS -->
	<script type="text/javascript" src="/teen/resources/js/member/myPage/myFollow.js"></script>
</body>
</html>