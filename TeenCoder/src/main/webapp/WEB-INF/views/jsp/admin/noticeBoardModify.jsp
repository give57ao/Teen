<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TeenCoder 관리자 공지글 관리 > 공지글 수정</title>
<link rel="stylesheet" type="text/css" href="/teen/resources/css/board.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/memberForm.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/admin.css">
</head>
<body>
	<!-- Header -->
	<jsp:include page="../template/header.jsp" flush="false" />

	<!-- Contents -->
    <div id="contents">
        <div id="contents_title">
            <h1>공지글 관리</h1>
            <h2>공지글 작성 / 수정 / 삭제</h2>
        </div>
        <div id="contents_detail">
            <div id="contents_wrap">
                <!-- Category -->
                <ul id="contents_category">
                    <li><a href="/teen/admin/memberList">회원 관리</a></li>
                    <li><a href="/teen/admin/noticeBoard" class="select">공지글 관리</a></li>
                    <li><a href="/teen/admin/adminBoard">게시글 관리</a></li>
                    <li><a href="/teen/admin/reportBoard">신고글 관리</a></li>
                    <li><a href="/teen/admin/reportCmtList">댓글 관리</a></li>
                    <li><a href="/teen/admin/reportAnsList">답글 관리</a></li>
                </ul>
                <!-- Board -->
                <div id="board_list">
                    <!-- Title -->
                    <div id="board_list_title">
                        <h2>공지글 관리 > 공지글 수정</h2>
                    </div>
                	<!-- Form -->
                	<div id="admin_form">
                        <form id="board_form" class="admin_board_form">
                            <table>
                                <tbody>
                                    <tr>
                                        <th>제목</th>
                                        <td>
                                           <input type="text" name="title" placeholder="제목"> 
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>내용</th>
                                        <td>
                                            <textarea name="contents" placeholder="내용"></textarea>
                                        </td>
                                    </tr>
                                    <tr class="file_upload">
                                        <th>첨부파일</th>
                                        <td>
                                            <input type="file" name="file_add" value="파일 추가" class="btn_add_file">
                                            <input type="button" name="file_del" value="파일 삭제" class="btn_com btn_del_file">
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                            <div id="btn_wrap">
                                <input type="submit" value="공지글 수정" class="btn_com btn_main">
                                <input type="button" value="취소" class="btn_com btn_main" onClick="goNoticeBoard()">
                            </div>
                        </form>
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