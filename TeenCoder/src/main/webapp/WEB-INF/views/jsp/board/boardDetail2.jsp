<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TeenCoder 게시판 상세</title>
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/common.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/board.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/summernote.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
</head>
<body>
	<!-- Header -->
	<jsp:include page="../template/header.jsp" flush="false" />

	<!-- Contents -->
    <div id="contents">
        <div id="contents_title">
            <h1>커뮤니티</h1>
            <h2>커뮤니티를 통해 IT 정보를 공유하고 소통할 수 있습니다.</h2>
        </div>
        <div id="contents_detail">
            <div id="contents_wrap">
                <!-- Board -->
                <div id="board_list">
                    <!-- Title -->
                    <div id="board_list_title">
                        <h2><a href="#">리스트로 이동</a></h2>
                    </div>
                	<!-- List Row -->
                	<c:forEach items="${boardDetail}" var="boardDetail"
							varStatus="status">
                    <div id="board_list_row">
                        <div class="row">
                            <div class="row_info">
                                <ul class="row_top tag_category">
                                    <li>${boardDetail.board_tag_name}</li>
                                    
                                </ul>
                                <div class="row_top member">
                                    <h4>
                                        <img src="/teen/resources/images/icon/icon_badge.png" class="i_badge">
                                        <span class="rank">[Expert]</span>${boardDetail.member_nick}
                                    </h4>
                                </div>
                                <span class="row_top date">${boardDetail.board_date}</span>
                            </div>
                            <div class="row_title">
                                <h3>
                                    <a href="#">
                                        <span class="tag_hit">[추천]</span>
                                        ${boardDetail.board_title}
                                        <img src="/teen/resources/images/icon/icon_image.svg" class="i_image">
                                        <img src="/teen/resources/images/icon/icon_file.svg" class="i_file">
                                    </a>
                                </h3>
                            </div>
                            <div class="row_contents">
                            	<p>
	                            	${boardDetail.board_content}
                            	</p>
                            	<span><a href="#">첨부파일 다운로드</a></span>
                            	<form name="downFile" role="form" method="post">
											<input type="hidden" id="FILE_NO" name="FILE_NO" value="">
											<c:forEach var="file" items="${file }">
												<span><a href="#"
													onclick="fn_fileDown(${file.FILE_NO}); return false;">${file.ORG_FILE_NAME }</a>(${file.FILE_SIZE }kb)</span>
											</c:forEach>
										</form>
                            </div>
                            <ul class="row_top number">
                                <li><img src="/teen/resources/images/icon/icon_hit.svg" class="i_hit">${boardDetail.board_hit_count}</li>
                                <li><img src="/teen/resources/images/icon/icon_comment.svg" class="i_cmt">${boardDetail.board_comment_count}</li>
                                <li><img src="/teen/resources/images/icon/icon_like.svg" class="i_like">${boardDetail.board_like_count}</li>
                            </ul>
                            <div class="btn_group">
                            	<input type="button" value="스크랩" class="btn_com btn_board">
	                			<input type="button" value="신고" class="btn_com btn_board">
	                			<input type="button" value="추천" class="btn_com btn_board">
                            </div>
                        </div>
                        <hr>
                    </div>
                    </c:forEach>
                	<!-- Comment From -->
	                <div id="comment_form">
	                	<textarea id="summernote" name="comment" placeholder="댓글 작성"></textarea>
	                	<input type="button" value="취소" class="btn_com btn_board btn_cmt">
	                	<input type="submit" value="작성" class="btn_com btn_board btn_cmt">
	                </div>
	                
	                <!-- Comment List -->
	                <c:forEach items="${boardComment}" var="boardComment"
							varStatus="status">
	                <div id="comment_list">
	                	<div class="comment_box">
	                		<div class="row">
	                            <div class="row_info">
	                                <div class="row_top member">
	                                    <h4>
	                                        <img src="/teen/resources/images/icon/icon_badge.png" class="i_badge">
	                                        <span class="rank">[Expert]</span>${boardComment.member_nick}
	                                    </h4>
	                                </div>
	                                <span class="row_top date">${boardComment.bcomment_date}</span>
	                            </div>
	                            <div class="row_contents">
	                            	<p>
		                            	${boardComment.bcomment_content}
	                            	</p>
	                            </div>
	                            <ul class="row_top number">
                                    <li><img src="/teen/resources/images/icon/icon_comment.svg" class="i_cmt">${boardComment.ref_level}</li>
                                    <li><img src="/teen/resources/images/icon/icon_like.svg" class="i_like">${boardComment.bcomment_like_count}</li>
                                </ul>
                                <div class="btn_group">
	                            	<input type="button" value="신고" class="btn_com btn_board">
		                			<input type="button" value="추천" class="btn_com btn_board">
		                			<input type="button" value="답글" class="btn_com btn_board">
	                            </div>
                            </div>
	                	</div>
	                	<!-- Answer List -->
	                	<c:forEach items="${boardAnswer}" var="boardAnswer"
							varStatus="status"> 
						<c:if test="${boardComment.ref_step eq boardAnswer.ref_step}">
						<c:set var="num" value="${boardAnswer.ref_step}" />
						<input type="hidden" id="refNo" value="${num}"/>
	                	<div id="comment_list" class="answer_list">
		                	<div class="comment_box answer_box">
		                		<div class="row">
		                            <div class="row_info">
		                                <div class="row_top member">
		                                    <h4>
		                                        <img src="/teen/resources/images/icon/icon_badge.png" class="i_badge">
		                                        <span class="rank">[Expert]</span>${boardAnswer.member_nick}
		                                    </h4>
		                                </div>
		                                <span class="row_top date">${boardAnswer.bcomment_date}</span>
		                            </div>
		                            <div class="row_contents">
		                            	<p>
			                            	${boardAnswer.bcomment_content}
		                            	</p>
		                            </div>
		                            <ul class="row_top number">
	                                    <li><img src="/teen/resources/images/icon/icon_comment.svg" class="i_cmt">0</li>
	                                    <li><img src="/teen/resources/images/icon/icon_like.svg" class="i_like">${boardAnswer.bcomment_like_count}</li>
	                                </ul>
	                                <div class="btn_group">
		                            	<input type="button" value="신고" class="btn_com btn_board">
			                			<input type="button" value="추천" class="btn_com btn_board">
		                            </div>
	                            </div>
		                	</div>
	                	</div>
	                	</c:if>
	                	</c:forEach>
	                	<!-- Answer Form -->
	                	<div id="answer">
		                	<div id="answer_form">
			                	<textarea name="answer" placeholder="답글 작성"></textarea>
			                	<input type="button" value="취소" class="btn_com btn_board btn_cmt">
			                	<input type="submit" value="작성" class="btn_com btn_board btn_cmt">
			                </div>
		                </div>
	                </div>
	                <input type="button" value="답글 더 보기..." class="getAnswerBtn" />
	                </c:forEach>
                </div>
                <!-- Member Info -->
                <div id="member_info">
                    <a href="/teen/board/boardWrite" class="btn_com btn_main">게시글 작성</a>
                    <div class="mycard"></div>
                </div>
            </div>
        </div>
    </div>
    
	<!-- Footer -->
	<jsp:include page="../template/footer.jsp" flush="false" />
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="/teen/resources/js/board/detail/boardDetail.js"></script>
</body>
</html>