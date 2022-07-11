<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TeenCoder 공지사항</title>
<link rel="shortcut icon" href="/teen/resources/images/icon/icon_favicon.ico" type="image/x-icon"> <!-- favicon -->
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/common.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/board.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/summernote.css">
</head>
<body>
	<!-- Header -->
	<jsp:include page="../template/header.jsp" flush="false" />

	<!-- Contents -->
    <div id="contents">
        <div id="contents_title">
            <h1>공지사항</h1>
            <h2>공지사항을 확인할 수 있습니다.</h2>
        </div>
        <div id="contents_detail">
            <div id="contents_wrap">
            <!-- Category -->
                <ul id="contents_category">
                	<li><a href="/teen/board/notice" class="select">NOTICE</a></li>
                </ul>
                <!-- Board -->
                <c:forEach items="${noticeDetail}" var="noticeDetail" varStatus="status">
	                <div id="board_list">
	                    <!-- Title -->
	                    <div id="board_list_title">
	                        <h2><a href="../notice">< 리스트로 이동</a></h2>
	                    </div>
	                	<!-- List Row -->
		                    <div id="board_list_row">
		                        <div class="row">
		                        <div class="row_info">
		                        	<div class="row_top member">
	                                    <h4>
	                                         ${noticeDetail.member_nick}
	                                    </h4>
	                                </div>
	                                <span class="row_top date"><fmt:formatDate value="${noticeDetail.noti_date}" pattern="yyyy.MM.dd"/></span>
	                             </div>
	                            <div class="row_title">
	                                <h3>
	                                    <a>
	                                        <span class="tag_notice">[공지]</span> ${noticeDetail.noti_title}
											<c:if test="${noticeDetail.noti_file_check == 'Y' }">
	                                       		<img src="/teen/resources/images/icon/icon_file.svg" class="i_file">
	                                       	</c:if>
	                                    </a>
	                                </h3>
	                            </div>
	                            <div class="row_contents">
	                         		<p>${noticeDetail.noti_content}</p>
	                            	<form name="downFile" role="form" method="post">
	                            		<input type="hidden" id="FILE_NO" name="FILE_NO" value="">
										<c:forEach var="file" items="${file}">
											<span><a href="#" onClick="fn_fileDown(${file.FILE_NO}); return false;">${file.ORG_FILE_NAME}</a>(${file.FILE_SIZE}kb)</span>
										</c:forEach>
									</form>
	                            </div>
	                            <ul class="row_top number">
	                                <li><img src="/teen/resources/images/icon/icon_hit.svg" class="i_hit">${noticeDetail.noti_hit_count}</li>
	                            </ul>
	                        </div>
	                        <hr>
	                    </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
    
	<!-- Footer -->
	<jsp:include page="../template/footer.jsp" flush="false" />
	
</body>
</html>