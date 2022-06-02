<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TeenCoder 관리자 회원 관리</title>
<link rel="stylesheet" type="text/css" href="/teen/resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/common.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/board.css">
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
                    <li><a href="#">공지글 관리</a></li>
                    <li><a href="#">게시글 관리</a></li>
                    <li><a href="#">신고글 관리</a></li>
                    <li><a href="#">댓글 관리</a></li>
                    <li><a href="#">답글 관리</a></li>
                </ul>
                <!-- Board -->
                <div id="board_list">
                    <!-- Title -->
                    <div id="board_list_title">
                        <h2>회원 관리</h2>
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
                    <div id="admin_board_list">
                    	<form action="memberLogin" method="post">
	                        <table>
	                            <thead>
	                                <tr class="row_title">
	                                    <td>아이디</td>
	                                    <td>이름</td>
	                                    <td>닉네임</td>
	                                    <td>이메일</td>
	                                    <td>가입일</td>
	                                    <td>개발직군</td>
	                                    <td>회원정보</td>
	                                </tr>
	                            </thead>
	                            <br>
	                            <!-- List Row! -->
	                            <tbody>
	                                <!-- Row1 -->
	                                <tr class="row">
	                                   <td>${member_id}</td>
	                                   <td>${member_name}</td>
	                                   <td>${member_nick}</td>
	                                   <td>${member_email}</td>
	                                   <td>${member_date}</td>
	                                   <td>${member_pro_check}</td>
	                                   <td><a href="#">수정</a> / <a href="#">삭제</a></td>
	                                </tr>
	                            </tbody>
	                        </table>
                        </form>
                    </div>
                    <!-- Pagination -->
					<div id="board_list_pagination">
						<ul>
							<!-- 왼쪽 버튼 -->
							<!-- 시작페이지가 1이 아닐 때 -->
							<c:if test="${paging.nowPage != 1 }">
								<li class="prev"><a
									href="/teen/admin/memberList?sort=${sort}&search=${paging.search}&keyword=${paging.keyword}&nowPage=${paging.nowPage - 1 }&cntPerPage=${paging.cntPerPage}">&nbsp;</a></li>
							</c:if>
							<!-- 페이징 숫자가 나오는 부분 -->
							<c:forEach begin="${paging.startPage }" end="${paging.endPage }"
								var="p">
								<c:choose>
									<c:when test="${p == paging.nowPage }">
										<li><a class="select">${p }</a></li>
									</c:when>
									<c:when test="${p != paging.nowPage }">
										<li><a href="/teen/admin/memberList?sort=${sort}&search=${paging.search}&keyword=${paging.keyword}&nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p }</a></li>
									</c:when>
								</c:choose>
							</c:forEach>
							<!-- 오른쪽 버튼 -->
							<c:if test="${paging.startPage < paging.endPage}">
								<li class="next"><a
									href="/teen/admin/memberList?sort=${sort}&search=${paging.search}&keyword=${paging.keyword}&nowPage=${paging.nowPage+1 }&cntPerPage=${paging.cntPerPage}">&nbsp;</a></li>
							</c:if>
						</ul>
					</div>
                </div>
            </div>
        </div>
    </div>
    
	<!-- Footer -->
	<jsp:include page="../template/footer.jsp" flush="false" />
	
	<script src="/teen/resources/js/member/member.js"></script>
	<script src="/teen/resources/js/member/myPage/myBoard.js"></script>
</body>
</html>