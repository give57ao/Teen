<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TeenCoder 관리자 공지글 수정</title>
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/common.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/board.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/boardForm.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/admin.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/summernote.css">
</head>
<body>
	<!-- Header -->
	<jsp:include page="../template/header.jsp" flush="false" />

	<!-- Contents -->
    <div id="contents">
        <div id="contents_title">
            <h1>공지글 수정</h1>
            <h2>공지글을 수정할 수 있습니다.</h2>
        </div>
        <div id="contents_detail">
            <div id="contents_wrap">
                <!-- Board -->
                <div id="board_list">
                    <!-- Title -->
                    <div id="board_list_title">
                        <h2>공지글 수정</h2>
                    </div>
                	<!-- Form -->
                	<div id="admin_form" class="board_form">
                        <form id="board_form" class="admin_board_form" method="post" enctype="multipart/form-data">
                            <table>
                                <tbody>
                                    <tr>
                                        <th>제목</th>
                                        <td>
                                           <input type="text" name="noti_title" placeholder="제목"> 
                                        </td>
                                    </tr>
                                    <tr class="contents_title">
				                        <th>내용</th>
				                        <td >
				                            <textarea id="summernote" name="noti_content" placeholder="내용"></textarea>
				                        </td>
				                    </tr>
                                    <tr id="fileDiv" class="file_upload">
				                        <th>첨부파일&nbsp;&nbsp;&nbsp;<a href="#this" class="btn_com btn_add_file" id="addFile">+</a></th>
				                        <td>
											<div>
				                            	<input type="file" id="file" name="file_0"/>
				                            	<a href="#this" class="btn_com btn_del_file" id="deleteFile">파일 삭제</a>
					                        </div>
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
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
	<script type="text/javascript" src="/teen/resources/js/board/board.js"></script>
	<script type="text/javascript" src="/teen/resources/js/admin/admin.js"></script>
</body>
</html>