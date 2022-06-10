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
            <!-- Category -->
                <ul id="contents_category">
                	<c:if test="${paging.board_group_no eq '1'}">
						<li><a href="/teen/board?board_group_no=1" class="select">COMMUNITY</a></li>
                    </c:if>
                    <c:if test="${paging.board_group_no eq '2'}">
						<li><a href="/teen/board?board_group_no=2" class="select">Q&amp;A</a></li>
                    </c:if>
                    
                    <li><a href="/teen/board?board_tag_name=html">#HTML</a></li>
                    <li><a href="/teen/board?board_tag_name=css">#CSS</a></li>
                    <li><a href="/teen/board?board_tag_name=js">#JS</a></li>
                    <li><a href="/teen/board?board_tag_name=java">#Java</a></li>
                    <li><a href="/teen/board?board_tag_name=c language">#C Language</a></li>
                    <li><a href="/teen/board?board_tag_name=python">#Python</a></li>
                    <li><a href="/teen/board?board_tag_name=sql">#SQL</a></li>
                </ul>
                <!-- Board -->
                <div id="board_list">
                    <!-- Title -->
                    <div id="board_list_title">
                        <h2><a href="../board?borad_group_no?=${boardNo}">< 리스트로 이동</a></h2>
                    </div>
                	<!-- List Row -->
                	<c:forEach items="${boardDetail}" var="boardDetail" varStatus="status">
	                    <div id="board_list_row">
	                        <div class="row">
	                            <div class="row_info">
	                                <ul class="row_top tag_category">
	                                    <li>${boardDetail.board_tag_name}</li>
	                                </ul>
	                                <div class="row_top member">
	                                    <h4>
	                                        <img src="/teen/resources/images/icon/icon_badge.png" class="i_badge">
	                                        <span class="rank">[Expert]</span> ${boardDetail.member_nick}
	                                    </h4>
	                                </div>
	                                <span class="row_top date"><fmt:formatDate value="${boardDetail.board_date}" pattern="yyyy.MM.dd"/></span>
	                            </div>
	                            <div class="row_title">
	                                <h3>
	                                    <a href="#">
	                                        <span class="tag_hit">[추천]</span> ${boardDetail.board_title}
												<c:if test="${boardDetail.board_file_check == 'Y' }">
	                                        	<img src="/teen/resources/images/icon/icon_file.svg" class="i_file">
	                                        	</c:if>
	                                    </a>
	                                </h3>
	                            </div>
	                            <div class="row_contents">
	                            	<p>${boardDetail.board_content}</p>
	                            	
	                            	<form name="downFile" role="form" method="post">
	                            		<input type="hidden" id="FILE_NO" name="FILE_NO" value="">
										<c:forEach var="file" items="${file}">
											<span><a href="#" onClick="fn_fileDown(${file.FILE_NO}); return false;">${file.ORG_FILE_NAME}</a>(${file.FILE_SIZE}kb)</span>
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
		                			<input type="button" value="수정" class="btn_com btn_board" onclick="location.href='/teen/board/modify?board_no=' + ${board_no}">
	                            </div>
	                        </div>
	                        <hr>
	                    </div>
                    </c:forEach>
                    
                	<!-- Comment From -->
	                <div id="comment_form">
	                	<form action="comment" method="post" enctype="multipart/form-data">
		                	<textarea class="summernote" name="bcomment_content" placeholder="댓글 작성"></textarea>
		                	<input type="hidden" name="board_no" value="${board_no}">
		                	<input type="reset" value="취소" class="btn_com btn_board btn_cmt">
		                	<input type="submit" value="작성" class="btn_com btn_board btn_cmt">
	                	</form>
	                </div>
	                <!-- Comment List -->
	                <c:forEach items="${boardComment}" var="boardComment" varStatus="status">
	                	<h2><b class="comment_count">2</b>개의 댓글</h2> <!-- 댓글 넘버 추가 -->
		                <div id="comment_list">
		                	<div class="comment_box">
		                		<div class="row">
		                            <div class="row_info">
		                                <div class="row_top member">
		                                    <h4>
		                                        <img src="/teen/resources/images/icon/icon_badge.png" class="i_badge">
		                                        <span class="rank">[Expert]</span> ${boardComment.member_nick}
		                                    </h4>
		                                </div>
		                                <span class="row_top date">${boardComment.bcomment_date}</span>
		                            </div>
		                            <div class="row_contents">
		                            	<p>${boardComment.bcomment_content}</p>
		                            </div>
		                            <ul class="row_top number">
	                                    <li><img src="/teen/resources/images/icon/icon_comment.svg" class="i_cmt">${boardComment.ref_level}</li>
	                                    <!-- boardCommen.ref_level 말고 count하는걸 새로 받아와야 할 것 같음 -->
	                                    <li><img src="/teen/resources/images/icon/icon_like.svg" class="i_like">${boardComment.bcomment_like_count}</li>
	                                </ul>
	                                <div class="btn_group">
		                            	<input type="button" value="신고" class="btn_com btn_board">
			                			<input type="button" value="추천" class="btn_com btn_board">
			                			<input type="button" value="답글" class="btn_com btn_board" onClick="recomment(${boardComment.ref_step})" >
		                            </div>
	                            </div>
		                	</div>
		                	<!-- Answer Form -->
		                	<div id=answer  class="answer_form-${boardComment.ref_step}" style="display : none;">
			                	<form id =answer_form action="recomment" method="post">
				                	<textarea name="bcomment_content" placeholder="답글 작성"></textarea>
				                	<input type="hidden" name="ref_step" value="${boardComment.ref_step}">
				                	<input type="hidden" name="board_no" value="${boardComment.board_no}">
				                	<input type="reset" value="취소" class="btn_com btn_board btn_cmt">
				                	<input type="submit" value="작성" class="btn_com btn_board btn_cmt">
				                </form>
			                </div>
		                	<input type="button" value="답글 더 보기" class="getAnswerBtn" onClick="dis(${boardComment.ref_step})">
		                	
		                	<!-- Answer List -->
		                	<c:forEach items="${boardAnswer}" var="boardAnswer" varStatus="status"> 
								<c:if test="${boardComment.ref_step eq boardAnswer.ref_step}">
								<c:set var="num" value="${boardAnswer.ref_step}" />
								<input type="hidden" id="refNo" value="${num}"/>
			                	<div id="comment_list" class="answer_list-${boardComment.ref_step}" style="display : none;" >
				                	<div class="comment_box answer_box">
				                		<div class="row">
				                            <div class="row_info">
				                                <div class="row_top member">
				                                    <h4>
				                                        <img src="/teen/resources/images/icon/icon_badge.png" class="i_badge">
				                                        <span class="rank">[Expert]</span> ${boardAnswer.member_nick}
				                                    </h4>
				                                </div>
				                                <span class="row_top date">${boardAnswer.bcomment_date}</span>
				                            </div>
				                            <div class="row_contents">
				                            	<p>${boardAnswer.bcomment_content}</p>
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

		                </div>
	                </c:forEach>
                </div>
            </div>
        </div>
    </div>
    
	<!-- Footer -->
	<jsp:include page="../template/footer.jsp" flush="false" />
	
	<!-- JS -->
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
	<script type="text/javascript" src="/teen/resources/js/board/detail/boardDetail.js"></script>
	<script type="text/javascript" src="/teen/resources/js/board/board.js"></script>
</body>
</html>