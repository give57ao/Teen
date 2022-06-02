<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TeenCoder 게시판 상세</title>
<link rel="stylesheet" type="text/css" href="/teen/resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/common.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/board.css">
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
                    <li><a href="#" class="select">COMMUNITY</a></li>
                    <li><a href="#">#HTML</a></li>
                    <li><a href="#">#CSS</a></li>
                    <li><a href="#">#JS</a></li>
                    <li><a href="#">#Java</a></li>
                    <li><a href="#">#C</a></li>
                    <li><a href="#">#Python</a></li>
                    <li><a href="#">#SQL</a></li>
                </ul>
                <!-- Board -->
                <div id="board_list">
                    <!-- Title -->
                    <div id="board_list_title">
                        <h2><a href="../jsp/board/mainBoard.jsp">< 리스트로 이동</a></h2>
                    </div>
                	<!-- List Row -->
                    <div id="board_list_row">
                        <div class="row">
                            <div class="row_info">
                                <ul class="row_top tag_category">
                                    <li>#HTML</li>
                                    <li>#CSS</li>
                                    <li>#JS</li>
                                    <li>#Java</li>
                                    <li>#C</li>
                                    <li>#Python</li>
                                    <li>#SQL</li>
                                </ul>
                                <div class="row_top member">
                                    <h4>
                                        <img src="/teen/resources/images/icon/icon_badge.png" class="i_badge">
                                        <span class="rank">[Expert]</span>TeenCoder
                                    </h4>
                                </div>
                                <span class="row_top date">2022-05-10</span>
                            </div>
                            <div class="row_title">
                                <h3>
                                    <a href="../jsp/board/boardDetail.jsp">
                                        <span class="tag_hit">[추천]</span>
                                        HTML / CSS 학습 중 궁금한 점이 있습니다.
                                        <img src="/teen/resources/images/icon/icon_image.svg" class="i_image">
                                        <img src="/teen/resources/images/icon/icon_file.svg" class="i_file">
                                    </a>
                                </h3>
                            </div>
                            <div class="row_contents">
                            	<p>
	                            	"${content.board_content }"
                            	</p>
                            	<img src="/teen/resources/images/bg/bg_sample.jpg">
                            	<span><a href="#">첨부파일 다운로드</a></span>
                            </div>
                            <ul class="row_top number">
                                <li><img src="/teen/resources/images/icon/icon_hit.svg" class="i_hit">0</li>
                                <li><img src="/teen/resources/images/icon/icon_comment.svg" class="i_cmt">0</li>
                                <li><img src="/teen/resources/images/icon/icon_like.svg" class="i_like">0</li>
                            </ul>
                            <div class="btn_group">
                            	<input type="button" value="스크랩" class="btn_com btn_board">
	                			<input type="button" value="신고" class="btn_com btn_board">
	                			<input type="button" value="추천" class="btn_com btn_board">
                            </div>
                        </div>
                        <hr>
                    </div>
                	<!-- Comment From -->
	                <div id="comment_form">
	                	<textarea name="comment" placeholder="댓글 작성"></textarea>
	                	<input type="button" value="취소" class="btn_com btn_board btn_cmt">
	                	<input type="submit" value="작성" class="btn_com btn_board btn_cmt">
	                </div>
	                <!-- Comment List -->
	                <div id="comment_list">
	                	<h2><b>2</b>개의 댓글</h2>
	                	<div class="comment_box">
	                		<div class="row">
	                            <div class="row_info">
	                                <div class="row_top member">
	                                    <h4>
	                                        <img src="/teen/resources/images/icon/icon_badge.png" class="i_badge">
	                                        <span class="rank">[Expert]</span>TeenCoder
	                                    </h4>
	                                </div>
	                                <span class="row_top date">2022-05-10</span>
	                            </div>
	                            <div class="row_contents">
	                            	<p>
		                            	Text Text Text Text Text Text Text Text Text Text
		                            	Text Text Text Text Text Text Text Text Text Text
	                            	</p>
	                            </div>
	                            <ul class="row_top number">
                                    <li><img src="/teen/resources/images/icon/icon_comment.svg" class="i_cmt">0</li>
                                    <li><img src="/teen/resources/images/icon/icon_like.svg" class="i_like">0</li>
                                </ul>
                                <div class="btn_group">
	                            	<input type="button" value="신고" class="btn_com btn_board">
		                			<input type="button" value="추천" class="btn_com btn_board">
		                			<input type="button" value="답글" class="btn_com btn_board">
	                            </div>
                            </div>
	                	</div>
                	</div>
	                <!-- Comment List -->
	                <div id="comment_list">
	                	<div class="comment_box">
	                		<div class="row">
	                            <div class="row_info">
	                                <div class="row_top member">
	                                    <h4>
	                                        <img src="/teen/resources/images/icon/icon_badge.png" class="i_badge">
	                                        <span class="rank">[Expert]</span>TeenCoder
	                                    </h4>
	                                </div>
	                                <span class="row_top date">2022-05-10</span>
	                            </div>
	                            <div class="row_contents">
	                            	<p>
		                            	Text Text Text Text Text Text Text Text Text Text
		                            	Text Text Text Text Text Text Text Text Text Text
	                            	</p>
	                            </div>
	                            <ul class="row_top number">
                                    <li><img src="/teen/resources/images/icon/icon_comment.svg" class="i_cmt">0</li>
                                    <li><img src="/teen/resources/images/icon/icon_like.svg" class="i_like">0</li>
                                </ul>
                                <div class="btn_group">
	                            	<input type="button" value="신고" class="btn_com btn_board">
		                			<input type="button" value="추천" class="btn_com btn_board">
		                			<input type="button" value="답글" class="btn_com btn_board">
	                            </div>
                            </div>
	                	</div>
	                	<!-- Answer List -->
	                	<div id="comment_list" class="answer_list">
		                	<div class="comment_box answer_box">
		                		<div class="row">
		                            <div class="row_info">
		                                <div class="row_top member">
		                                    <h4>
		                                        <img src="/teen/resources/images/icon/icon_badge.png" class="i_badge">
		                                        <span class="rank">[Expert]</span>TeenCoder
		                                    </h4>
		                                </div>
		                                <span class="row_top date">2022-05-10</span>
		                            </div>
		                            <div class="row_contents">
		                            	<p>
			                            	Text Text Text Text Text Text Text Text Text Text
			                            	Text Text Text Text Text Text Text Text Text Text
		                            	</p>
		                            </div>
		                            <ul class="row_top number">
	                                    <li><img src="/teen/resources/images/icon/icon_comment.svg" class="i_cmt">0</li>
	                                    <li><img src="/teen/resources/images/icon/icon_like.svg" class="i_like">0</li>
	                                </ul>
	                                <div class="btn_group">
		                            	<input type="button" value="신고" class="btn_com btn_board">
			                			<input type="button" value="추천" class="btn_com btn_board">
		                            </div>
	                            </div>
		                	</div>
	                	</div>
	                	<!-- Answer Form -->
	                	<div id="answer">
		                	<div id="answer_form">
			                	<textarea name="answer" placeholder="답글 작성"></textarea>
			                	<input type="button" value="취소" class="btn_com btn_board btn_cmt">
			                	<input type="submit" value="작성" class="btn_com btn_board btn_cmt">
			                </div>
		                </div>
	                </div>
                </div>
                <!-- Member Info -->
                <div id="member_info">
                    <a href="../jsp/board/boardWrite.jsp" class="btn_com btn_main">게시글 작성</a>
                    <div class="mycard"></div>
                </div>
            </div>
        </div>
    </div>
    
	<!-- Footer -->
	<jsp:include page="../template/footer.jsp" flush="false" />
</body>
</html>