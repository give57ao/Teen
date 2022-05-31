<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
                    <li><a href="#" class="select">회원 관리</a></li>
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
                	<!-- List Row -->
                    <div id="admin_board_list">
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
                            <!-- List Row -->
                            <tbody>
                                <!-- Row1 -->
                                <tr class="row">
                                   <td>TeenCoder</td>
                                   <td>TeenCoder</td>
                                   <td>TeenCoder</td>
                                   <td>TeenCoder@gmail.com</td>
                                   <td>2022-05-25</td>
                                   <td>Y</td>
                                   <td><a href="#">수정</a> / <a href="#">삭제</a></td>
                                </tr>
                            </tbody>
                        </table>
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
</body>
</html>