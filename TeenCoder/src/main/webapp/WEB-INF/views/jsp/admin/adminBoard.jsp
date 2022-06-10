<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TeenCoder 관리자 게시글 관리</title>
<link rel="stylesheet" type="text/css" href="/teen/resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/common.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/board.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/admin.css">
<script type="text/javascript" src="/teen/resources/js/admin/admin.js"></script>
</head>
<body>
	<!-- Header -->
	<jsp:include page="../template/header.jsp" flush="false" />

	<!-- Contents -->
    <div id="contents">
        <div id="contents_title">
            <h1>게시글 관리</h1>
            <h2>게시글 리스트 조회 및 삭제</h2>
        </div>
        <div id="contents_detail">
            <div id="contents_wrap">
                <!-- Category -->
                <ul id="contents_category">
                    <li><a href="/teen/admin/memberList" >회원 관리</a></li>
                    <li><a href="/teen/admin/noticeBoard">공지글 관리</a></li>
                    <li><a href="/teen/admin/adminBoard" class="select">게시글 관리</a></li>
                    <li><a href="/teen/admin/reportBoard">신고글 관리</a></li>
                    <li><a href="/teen/admin/reportCmtList">댓글 관리</a></li>
                    <li><a href="/teen/admin/reportAnsList">답글 관리</a></li>
                </ul>
                <!-- Board -->
                <div id="board_list">
                    <!-- Title -->
                    <div id="board_list_title">
                        <h2>게시글 관리</h2>
                    </div>
                    <!-- Search -->
                    <div id="board_list_search">
                        <select class="dropdown" id="selectBoxTest">
                        	<option value="" id="search" disabled>선택</option>
                            <option value="all" id="search" selected>전체</option>
                            <option value="title" id="search">제목</option>
                            <option value="nick" id="search">닉네임</option>
                        </select>
                        <div class="search">
                            <input type="text" id="keyword" placeholder="검색">
                            <button class="btn_search" onclick="searchBoard()"></button>
                        </div>
                    </div>
                	<!-- List Row -->
                    <div id="admin_board_list">
                    	<form action="adminBoard" method="post">
	                        <table>
	                            <thead>
	                                <tr class="row_title">
	                                	<td>번호</td>
	                                    <td>제목</td>
	                                    <td>닉네임</td>
	                                    <td>작성일</td>
	                                    <td>조회</td>
	                                    <td>추천</td>
	                                    <td>첨부파일</td>
	                                    <td>글관리</td>
	                                </tr>
	                            </thead>
	                            <br>
	                            <!-- List Row -->
	                            <tbody>
	                                <!-- Row1 -->
	                               	<c:forEach items="${adminBoard}" var="adminBoard" varStatus="status">
		                                <tr class="row">
		                                   <td style="width: 5%;">${adminBoard.board_no}</td>
		                                   <td style="width: 10%;  cursor:pointer;" onClick="location.href='../board/detail?board_no=${adminBoard.board_no}'">${adminBoard.board_title}</td>
		                                   <td style="width: 10%;">${adminBoard.member_nick}</td>
		                                   <td style="width: 10%;"><fmt:formatDate value="${adminBoard.board_date}" pattern="yyyy.MM.dd"/></td>
		                                   <td style="width: 20%;">${adminBoard.board_hit_count}</td>
		                                   <td style="width: 10%;">${adminBoard.board_like_count}</td>
		                                   <td style="width: 10%;">${adminBoard.board_file_check}</td>
		                                   <td style="width: 10%;">	       
		                                   	    <a href="" onClick="memberDeletePopup(${adminBoard.member_no})">삭제</a>
	                                   	   </td>
		                                </tr>
	                                </c:forEach>
	                            </tbody>
	                        </table>
                        </form>
                    </div>
                    <!-- Pagination -->
                    <div id="board_list_pagination">
                        <ul>
							<!-- 왼쪽 버튼 -->
							<!-- 시작페이지가 1이 아닐 때 -->
							<c:if test="${paging.nowPage != 1}">
								<li><a class="prev" href="/teen/board?sort=${sort}&search=${paging.search}&keyword=${paging.keyword}&board_group_no=${paging.board_group_no}&board_tag_name=${paging.board_tag_name}&nowPage=${paging.nowPage - 1}&cntPerPage=${paging.cntPerPage}"></a></li>
							</c:if>
							<!-- 페이징 숫자가 나오는 부분 -->
							<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="p">
								<c:choose>
									<c:when test="${p == paging.nowPage}">
										<li><a class="select">${p}</a></li>
									</c:when>
									<c:when test="${p != paging.nowPage}">
										<li><a href="/teen/board?sort=${sort}&search=${paging.search}&keyword=${paging.keyword}&board_group_no=${paging.board_group_no}&board_tag_name=${paging.board_tag_name}&nowPage=${p}&cntPerPage=${paging.cntPerPage}">${p}</a></li>
									</c:when>
								</c:choose>
							</c:forEach>
							<!-- 오른쪽 버튼 -->
							<c:if test="${paging.startPage < paging.endPage}">
								<li><a class="next" href="/teen/board?sort=${sort}&search=${paging.search}&keyword=${paging.keyword}&board_group_no=${paging.board_group_no}&board_tag_name=${paging.board_tag_name}&nowPage=${paging.nowPage + 1}&cntPerPage=${paging.cntPerPage}"></a></li>
							</c:if>
						</ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
 
	<!-- Footer -->
	<jsp:include page="../template/footer.jsp" flush="false" />
	
	<!-- JS -->
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script type="text/javascript" src="/teen/resources/js/admin/adminBoard.js"></script>
</body>
</html>