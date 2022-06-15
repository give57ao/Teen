<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TeenCoder 개발 직군 유무 인증</title>
<link rel="shortcut icon" href="/teen/resources/images/icon/icon_favicon.ico" type="image/x-icon"> <!-- favicon -->
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/common.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/board.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/boardForm.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/summernote.css">
</head>
<body>
	<!-- Header -->
	<jsp:include page="../template/header.jsp" flush="false" />

	<!-- Contents -->
    <div id="contents">
        <div id="contents_title">
            <h1>개발 직군 유무 인증</h1>
            <h2>개발 직군 유무 인증을 위해 이메일을 작성해주세요.</h2>
        </div>
        <div id="contents_detail">
            <div id="contents_wrap">
                <!-- Board -->
                <div id="board_list">
                    <!-- Title -->
                    <div id="board_list_title">
                        <h2>개발 직군 유무 이메일 작성</h2>
                    </div>
                    <!-- Form -->
                    <form id="board_form" method="post" action="/teen/mail/send">
		                <table>
		                	<tbody>
			                    <tr>
			                        <th>닉네임(ID)</th>
			                        <td>
			                           <input type="text" name="senderName" value="${member_nick}(${member_id})" disabled> 
			                        </td>
			                    </tr>
			                    <tr>
			                        <th>제목</th>
			                        <td>
			                           <input type="text" name="subject"> 
			                        </td>
			                    </tr>
			                    <tr class="contents_title">
			                        <th>내용</th>
			                        <td >
				                        <input type='hidden' name="senderMail" value="teencoder@naver.com">
										<input type='hidden' name="receiveMail" value="teencoder@naver.com">
				                        <textarea class="summernote" name="message"></textarea>
			                        </td>
			                    </tr>
		                    </tbody>
		                </table>
		                <div id="btn_wrap">
		                	<input type="button" value="취소" class="btn_com btn_main" onClick="goBoard()">
		                    <input type="submit" value="이메일 전송" class="btn_com btn_main">
		                </div>
		            </form>
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
	<script type="text/javascript" src="/teen/resources/js/mail.js"></script>
</body>
</html>