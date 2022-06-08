<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>TeenCoder 게시판 상세</title>
<link rel="stylesheet" type="text/css"
	href="/teen/resources/css/reset.css">
<link rel="stylesheet" type="text/css"
	href="/teen/resources/css/common.css">
<link rel="stylesheet" type="text/css"
	href="/teen/resources/css/board.css">
</head>

<body>


	<!-- Header -->
	<jsp:include page="../template/header.jsp" flush="false" />
	<!-- aJax -->
	<script type="text/javascript">
	$("#btn_recommend").click(function(){
	    if(confirm("해당 글을 추천하시겠습니까?")){
	        document.form.action="/teen/board/recommend";
	        document.form.submit();
	        
	        alert("해당 글을 추천하였습니다.")
	        
	        }
	    });
	</script>
	<!-- Contents -->
	<div id="contents">
		<div id="contents_title">
			<h1>커뮤니티</h1>
			<h2>커뮤니티를 통해 IT 정보를 공유하고 소통할 수 있습니다.</h2>
		</div>
		<div id="contents_detail">
			<div id="contents_wrap">
				<!-- Category -->

				<!-- Board -->
				<div id="board_list">
					<!-- Title -->
					<div id="board_list_title">


						<!-- List Row -->
						<c:forEach items="${boardDetail}" var="boardDetail"
							varStatus="status">

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
												<img src="/teen/resources/images/icon/icon_badge.png"
													class="i_badge"> <span class="rank">[Expert]</span>${boardDetail.member_nick}
											</h4>
										</div>
										<span class="row_top date">${boardDetail.board_date}</span>
									</div>
									<div class="row_title">
										<h3>
											<a href="../jsp/board/boardDetail.jsp"> <span
												class="tag_hit">[추천]</span> ${boardDetail.board_title} <img
												src="/teen/resources/images/icon/icon_image.svg"
												class="i_image"> <img
												src="/teen/resources/images/icon/icon_file.svg"
												class="i_file">
											</a>
										</h3>
									</div>
									<div class="row_contents">
										<h1>${boardDetail.board_content}</h1>
										<p>${status.current}</p>

										<!--*********************************************************** 파일 구간********************************************************************* -->

										<form name="downFile" role="form" method="post">
											<input type="hidden" id="FILE_NO" name="FILE_NO" value="">
											<c:forEach var="file" items="${file }">
												<span><a href="#"
													onclick="fn_fileDown(${file.FILE_NO}); return false;">${file.ORG_FILE_NAME }</a>(${file.FILE_SIZE }kb)</span>
											</c:forEach>
										</form>
									</div>

									<ul class="row_top number">
										<li><img src="/teen/resources/images/icon/icon_hit.svg"
											class="i_hit">"${boardDetail.board_hit_count}"</li>
										<li><img
											src="/teen/resources/images/icon/icon_comment.svg"
											class="i_cmt">"${boardDetail.board_comment_count}"</li>
										<li><img src="/teen/resources/images/icon/icon_like.svg"
											class="i_like">"${boardDetail.board_like_count}"</li>
									</ul>
									<div class="btn_group">
										<input type="button" value="스크랩" class="btn_com btn_board">
										<input type="button" value="신고" class="btn_com btn_board">
										<input type="button" value="추천" class="btn_com btn_board"
											id="btn_recommend">
									</div>
								</div>
								<hr>
							</div>
						</c:forEach>
						<h2>
							<a href="../jsp/board/mainBoard.jsp">리스트로 이동</a>
						</h2>
					</div>





					<!-- @@@@@ 댓글창 시작 @@@@@ -->
					<c:forEach items="${boardComment}" var="boardComment"
						varStatus="status">

						<div id="comment_list">

							<div class="comment_box">
								<div class="row">
									<div class="row_info">
										<div class="row_top member">
											<h4>
												<img src="/teen/resources/images/icon/icon_badge.png"
													class="i_badge"> <span class="rank">[Expert]</span>"${boardComment.member_nick}"
											</h4>
										</div>
										<span class="row_top date">${boardComment.bcomment_date}</span>
									</div>
									<div class="row_contents">
										<p>${boardComment.bcomment_content}</p>
									</div>
									<ul class="row_top number">
										<li><img
											src="/teen/resources/images/icon/icon_comment.svg"
											class="i_cmt"> ${boardComment.ref_level}</li>
										<li><img src="/teen/resources/images/icon/icon_like.svg"
											class="i_like">${boardComment.bcomment_like_count }</li>
									</ul>
									<div class="btn_group">
										<input type="button" value="신고" class="btn_com btn_board">
										<input type="button" value="추천" class="btn_com btn_board">
										<input type="button" value="답글" class="btn_com btn_board"
											onClick="answerInsert()">
									</div>
								</div>
							</div>
						</div>

						<div class="answerDiv">

							<c:forEach items="${boardAnswer}" var="boardAnswer"
								varStatus="status">
								<c:if test="${boardComment.ref_step eq boardAnswer.ref_step }">
									<div id="comment_list" class="answer_list">
										<div class="comment_box answer_box">
											<div class="row">
												<div class="row_info">
													<div class="row_top member">
														<h4>
															<img src="/teen/resources/images/icon/icon_badge.png"
																class="i_badge"> <span class="rank">[Expert]</span>${boardAnswer.member_nick}
														</h4>
													</div>
													<span class="row_top date">${boardAnswer.bcomment_date}</span>
												</div>
												<div class="row_contents">
													<p>${boardAnswer.bcomment_content}</p>
												</div>
												<ul class="row_top number">
													<li><img
														src="/teen/resources/images/icon/icon_like.svg"
														class="i_like">${boardAnswer.bcomment_like_count}</li>
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
						<input type="button" value="답글 더 보기..." class="getAnswerBtn" />
					</c:forEach>
					<!-- Answer Form  -->
					<form action="comment" method="post">
						<div id="answer">
							<div id="answer_form">
								<textarea name="answer" placeholder="답글 작성"
									id="bcomment_content"></textarea>
								<input type="hidden" value="${boardcomment.board_no }" /> <input
									type="button" value="취소" class="btn_com btn_board btn_cmt">
								<input type="submit" value="작성"
									class="btn_com btn_board btn_cmt">


							</div>
						</div>
					</form>
				</div>

				<!-- Member Info -->
				<div id="member_info">
					<a href="../jsp/board/boardWrite.jsp" class="btn_com btn_main">게시글
						작성</a>
					<div class="mycard"></div>
				</div>
			</div>
		</div>
	</div>

	<!-- Footer -->
	<jsp:include page="../template/footer.jsp" flush="false" />
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script type="text/javascript"
		src="/teen/resources/js/board/detail/boardDetail.js"></script>


</body>
</html>