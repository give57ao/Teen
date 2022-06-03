<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TeenCoder 관리자 댓글 관리</title>
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
            <h1>댓글 관리</h1>
            <h2>댓글 관리 및 신고 접수된 댓글 삭제</h2>
        </div>
        <div id="contents_detail">
            <div id="contents_wrap">
                <!-- Category -->
                <ul id="contents_category">
                    <li><a href="#">회원 관리</a></li>
                    <li><a href="#">공지글 관리</a></li>
                    <li><a href="#">게시글 관리</a></li>
                    <li><a href="#">신고글 관리</a></li>
                    <li><a href="#" class="select">댓글 관리</a></li>
                    <li><a href="#">답글 관리</a></li>
                </ul>
                <!-- Board -->
                <div id="board_list">
                    <!-- Title -->
                    <div id="board_list_title">
                        <h2>댓글 관리</h2>
                        <ul id="board_list_menu" class="side_menu">
                            <li><a href="#">최신순</a></li>
                            <li><a href="#">추천순</a></li>
                            <li><a href="#">신고순</a></li>
                        </ul>
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
	                                    <td>추천</td>
	                                    <td>신고</td>
	                                    <td>첨부파일</td>
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
	                                   <td>0</td>
	                                   <td>Y</td>
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
	<script type="text/javascript" src="/teen/resources/js/member/member.js"></script>
	<script type="text/javascript" src="/teen/resources/js/admin/admin.js"></script>
</body>
</html>