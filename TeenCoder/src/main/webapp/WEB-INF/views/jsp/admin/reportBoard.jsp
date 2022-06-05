<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TeenCoder 관리자 신고글 관리</title>
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
            <h1>신고글 관리</h1>
            <h2>신고된 게시글 리스트 조회 및 삭제</h2>
        </div>
        <div id="contents_detail">
            <div id="contents_wrap">
                <!-- Category -->
                <ul id="contents_category">
                    <li><a href="/teen/admin/memberList">회원 관리</a></li>
                    <li><a href="/teen/admin/noticeBoard">공지글 관리</a></li>
                    <li><a href="/teen/admin/adminBoard">게시글 관리</a></li>
                    <li><a href="/teen/admin/reportBoard" class="select">신고글 관리</a></li>
                    <li><a href="/teen/admin/reportCmtList">댓글 관리</a></li>
                    <li><a href="/teen/admin/reportAnsList">답글 관리</a></li>
                </ul>
                <!-- Board -->
                <div id="board_list">
                    <!-- Title -->
                    <div id="board_list_title">
                        <h2>신고글 관리</h2>
                        <ul id="board_list_menu" class="side_menu">
                            <li><a href="#">최신순</a></li>
                            <li><a href="#">신고순</a></li>
                        </ul>
                    </div>
                    <!-- Search -->
                    <div id="board_list_search">
                        <select class="dropdown">
                            <option value="all" id="search" selected>전체</option>
                            <option value="title" id="search">제목</option>
                            <option value="id" id="search">아이디</option>
                            <option value="nick" id="search">닉네임</option>
                        </select>
                        <div class="search">
                            <input type="text" id="keyword" placeholder="검색">
                            <button class="btn_search"></button>
                        </div>
                    </div>
                	<!-- List Row -->
                    <div id="admin_board_list">
                    	<form>
	                        <table>
	                            <thead>
	                                <tr class="row_title">
	                                    <td>번호</td>
	                                    <td>제목</td>
	                                    <td>작성자</td>
	                                    <td>작성일</td>
	                                    <td>신고</td>
	                                    <td>글 관리</td>
	                                </tr>
	                            </thead>
	                            <br>
	                            <!-- List Row -->
	                            <tbody>
	                                <!-- Row1 -->
	                                <tr class="row">
	                                   <td>1</td>
	                                   <td>게시글 제목</td>
	                                   <td>TeenCoder</td>
	                                   <td>2022-05-25</td>
	                                   <td>0</td>
	                                    <td><a href="#">삭제</a></td>
	                                </tr>
	                            </tbody>
	                        </table>
                        </form>
                    </div>
                    <!-- Pagination -->
                    <div id="board_list_pagination">
                        <ul>
                            <li class="prev"><a href="#"></a></li>
                            <li><a href="#" class="select">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li class="next"><a href="#"></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
	<!-- Footer -->
	<jsp:include page="../template/footer.jsp" flush="false" />
	
	<!-- JS -->
	<script type="text/javascript" src="/teen/resources/js/admin/admin.js"></script>
</body>
</html>