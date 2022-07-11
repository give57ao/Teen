<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TeenCoder 게시판 상세</title>
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
            <c:if test="${boardDetail.get(0).board_group_no eq '1'}">
            	<h1>커뮤니티</h1>
            	<h2>커뮤니티를 통해 IT 정보를 공유하고 소통할 수 있습니다.</h2>
            </c:if>
            <c:if test="${boardDetail.get(0).board_group_no eq '2'}">
            	<h1>Q&amp;A</h1>
            	<h2>전문가와의 Q&amp;A를 통해 더 유익한 IT 정보를 공유하고 소통할 수 있습니다.</h2>
            </c:if>
        </div>
        <div id="contents_detail">
            <div id="contents_wrap">
            <!-- Category -->
                <ul id="contents_category">
                	<c:if test="${boardDetail.get(0).board_group_no eq '1'}">
						<li><a href="/teen/board?board_group_no=1" class="select">COMMUNITY</a></li>
                    </c:if>
                    <c:if test="${boardDetail.get(0).board_group_no eq '2'}">
						<li><a href="/teen/board?board_group_no=2" class="select">Q&amp;A</a></li>
                    </c:if>
                    
                    <li><a href="/teen/board?board_group_no=${board_group_no}&board_tag_name=html">#HTML</a></li>
                    <li><a href="/teen/board?board_group_no=${board_group_no}&board_tag_name=css">#CSS</a></li>
                    <li><a href="/teen/board?board_group_no=${board_group_no}&board_tag_name=js">#JS</a></li>
                    <li><a href="/teen/board?board_group_no=${board_group_no}&board_tag_name=java">#Java</a></li>
                    <li><a href="/teen/board?board_group_no=${board_group_no}&board_tag_name=c language">#C Language</a></li>
                    <li><a href="/teen/board?board_group_no=${board_group_no}&board_tag_name=python">#Python</a></li>
                    <li><a href="/teen/board?board_group_no=${board_group_no}&board_tag_name=sql">#SQL</a></li>
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
	                                    <li>#${boardDetail.board_tag_name}</li>
	                                </ul>
	                                <div class="row_top member">
	                                    	<h4>
	                                        <button  id="dropdown-menu" onclick="dp_menu()" style="text-decoration: underline;" >${boardDetail.member_nick}</button>
											</h4>
												<div style="display: none; position: absolute;" id="drop-content">
													<input type="hidden" id="member_nick" name="member_nick"  value="${boardDetail.member_nick }">
													<input type="hidden" id="member_no" name="member_no" value="${boardDetail.member_no }">
	                            					<c:if test="${sessionScope.member_no != boardDetail.member_no }">
													<div><button class= "drop-button" id="drop-button1" onclick="follow()" >팔로우 하기</button></div> 
													<div><button class= "drop-button" id="drop-button2" onclick="msg()" >쪽지 보내기</button></div> 
													<div><button class= "drop-button" id="drop-button3" onclick="board()" >게시글 보기</button></div>
													</c:if>
												</div>
	                                </div>
	                                <span class="row_top date"><fmt:formatDate value="${boardDetail.board_date}" pattern="yyyy.MM.dd"/></span>
	                           		<ul class="detail_count">
										<li><a class="heart"><img id="heart" src="/teen/resources/images/icon/heart.svg"></a></li>
										<li><a class="report"><img id="report" src="/teen/resources/images/icon/siren.png"></a></li>
									</ul>
	                            </div>
	                            <div class="row_title">
	                                <h3>
	                                    <a>
	                                        	<c:if test="${boardDetail.board_like_count >= 5 }"><span class="tag_hit">[추천]</span> </c:if>
												${boardDetail.board_title}	                                        		
												<c:if test="${boardDetail.board_file_check == 'Y' }">
                                        		<img src="/teen/resources/images/icon/icon_file.svg" class="i_file">
                                        		</c:if>
	                                    </a>
	                                </h3>
	                            </div>
	                            <div class="row_contents">
                         			<p>${boardDetail.board_content}</p>
	                            	<form name="downFile" role="form" method="post">
	                            		<input type="hidden" class="FILE_NO" name="FILE_NO" value="">
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
	                            <c:if test="${sessionScope.member_no != null}">
	                            <div class="btn_group">
	                            <ul>
	                            	
		                			<!-- <li><input type="button" value="추천" class="btn_com btn_board"> -->
		                			<c:if test="${sessionScope.member_no == boardDetail.member_no }">
		                			<input type="button" value="삭제" class="btn_com btn_board" onClick="location.href='/teen/board/delete?board_no='+ ${board_no}">
		                			<li><input type="button" value="수정" class="btn_com btn_board" onclick="location.href='/teen/board/modify?board_no=' + ${board_no}">
		                			</c:if>
									<li><button onclick="scrap()" class="btn_com btn_board">스크랩</button>
									</ul>
	                            </div>
	                            </c:if>
	                        </div>
	                        <hr>
	                    </div>
                    </c:forEach>
                    
                	<!-- Comment From -->
	               	 <div id="comment_form">
	                	<form action="comment" method="post" enctype="multipart/form-data" onSubmit="return checkValue()" >
		                	<input type="hidden" id="board_no" name="board_no" value="${board_no}">
		                	<textarea class="summernote" name="bcomment_content" placeholder="댓글 작성" id="bcomment_content"></textarea>
	                		<div class="filebox">
							<input class="upload-name" value="첨부파일" placeholder="첨부파일">
							<label for="file">파일찾기</label> 
							<input type="file" id="file" name="file">
							</div>
		                	<input type="reset" value="취소" class="btn_com btn_board btn_cmt">
		                	<input type="submit" value="작성" class="btn_com btn_board btn_cmt">
	                	</form>	
	                	
	                </div>
	                
	 				<!-- 댓글갯수 -->
                    <h2><b class="comment_count">${commentCount}</b>개의 댓글</h2>
                    
	                <!-- Comment List -->
	                <c:forEach items="${boardComment}" var="boardComment" varStatus="status">
	                	 <!-- 댓글 넘버 추가 -->
		                <div id="comment_list">
		                
							<!-- modify form -->
							<div id="comment_form-${boardComment.ref_step}" style="display: none;">
								<form action="modifyComment" method="post" enctype="multipart/form-data" onSubmit="return modicheckValue()" >
									<input type="hidden" name="bcomment_no" value="${boardComment.bcomment_no}">
									<input type="hidden" name="board_no" value="${board_no}">

									<!-- 첨부파일 수정 값  -->
									<input type="hidden" id="fileNoDel" name="fileNoDel[]" value="">
									<input type="hidden" id="fileNameDel" name="fileNameDel[]" value="">

									<!-- <div class="row_contents"> -->
									<textarea class="summernote" name="bcomment_content">
									${boardComment.bcomment_content}
									</textarea>


									<!-- 첨부파일 -->
									<div id="makeFileBox">
									<div class="filebox -${boardComment.file_no}" id="filebox">				
										<input class="upload-name-m" value="" placeholder="${boardComment.org_file_name}"> 
										<label for="file-m">파일찾기</label> <input type="file" id="file-m"name="file"> <input type="hidden" name="file_no" value="${boardComment.file_no}">
									</div>
									</div>
									<div id="delbox" >
										<input type="button" value="파일삭제" class="btn_com btn_board btn_cmt" onclick="fn_del('${boardComment.file_no}','FILE_NO_0')">	
									</div>	
										<div id="makeBox" style="display : none;">
										<input type="button" value="파일추가"  class="btn_com btn_board btn_cmt" onclick="makeFileBox()" >
										</div>
									<input type="reset" value="취소" class="btn_com btn_board btn_cmt" onClick="modifyCancel(${boardComment.ref_step})">
									 <input type="submit" value="작성" class="btn_com btn_board btn_cmt">
								</form>
							</div>
							<!-- modify form end -->



							<div class="comment_box cb-${boardComment.ref_step}">
		                		<div class="row">
		                            <div class="row_info">
		                                <div class="row_top member">
		                                    <h4>
		                                        ${boardComment.member_nick}
		                                    </h4>
		                                </div>
		                                <span class="row_top date"><fmt:formatDate value="${boardComment.bcomment_date}" pattern="yyyy.MM.dd"/></span>
		                            </div>
		                            <div class="row_contents">
		                            	<p>${boardComment.bcomment_content}</p>
		                            	
<!-- ***************************************************************************************************************************************************** -->		                            	
		                            	<c:choose>
		                            	<c:when test="${boardComment.file_no eq 0}">
										</c:when>
										<c:otherwise>
										<c:if test="${boardComment.del_gb eq 'N'}">
										<form name="downFile" role="form" method="post">
	                            		<input type="hidden" class="FILE_NO" name="FILE_NO" value="${boardComment.file_no}">
										<span><a href="#" onClick="fn_fileDown(${boardComment.file_no}); return false;">${boardComment.org_file_name}</a>(${boardComment.file_size}kb)</span>										
										</form>
										</c:if>
										</c:otherwise>
										</c:choose>
						           </div>
<!-- ***************************************************************************************************************************************************** -->		                            
		                            <ul class="row_top number">
		                            	<c:forEach items="${answerCount}" var="answerCount">
		                            		<c:if test="${status.index+1 eq answerCount.ref_step}">
	                                    		<li><img src="/teen/resources/images/icon/icon_comment.svg" class="i_cmt">${answerCount.board_answer_count-1}</li>
	                                    		<li><img src="/teen/resources/images/icon/icon_like.svg" class="i_like">${boardComment.bcomment_like_count}</li>
	                                    	</c:if>
	                                    </c:forEach>
	                                </ul>
	                                <div class="btn_group">
			                             <c:if test="${sessionScope.member_nick == boardComment.member_nick}">
		                                 <input type="button" value="삭제" class="btn_com btn_board btn_cmt" onclick="deleteComment(${boardComment.board_no}, ${boardComment.ref_step}, ${boardComment.ref_level })">
		                                 <input type="button" value="수정" class="btn_com btn_board" onClick="modifyComment(${boardComment.ref_step})">
		                                 </c:if>
			                			<input type="button" value="답글" class="btn_com btn_board" onClick="recomment(${boardComment.ref_step}, ${boardComment.ref_level})" >
			                			
		                            </div>
	                            </div>
		                	</div>
		                	
		                	<!-- Answer Form -->
		                	<div id="answer"  class="answer_form-${boardComment.ref_step}-${boardComment.ref_level}" style="display : none;">
			                	<form id="answer_form" action="recomment" method="post">
				                	<textarea name="bcomment_content" placeholder="답글 작성"></textarea>
				                	<input type="hidden" name="ref_step" id="ref_step" value="${boardComment.ref_step}">
				                	<input type="hidden" name="board_no" id="board_no" value="${boardComment.board_no}">
				                	<input type="hidden" name="ref_level" id="ref_level" value="${boardComment.ref_level}">
				                	<input type="hidden" name="bcomment_no" id="bcomment_no" value="${boardComment.bcomment_no}">
				                	<input type="reset" value="취소" class="btn_com btn_board btn_cmt" onClick="recomment(${boardComment.ref_step}, ${boardComment.ref_level})">
				                	<input type="submit" value="작성" class="btn_com btn_board btn_cmt">
				                </form>
			                </div>
			                <c:forEach items="${answerCount}" var="answerCount">
			                	<c:if test="${status.index+1 eq answerCount.ref_step}">
			                		<c:if test="${answerCount.board_answer_count>1 }">
		                				<input type="button" value="답글 더 보기" class="getAnswerBtn" onClick="dis(${boardComment.ref_step}, ${boardComment.ref_level})">
		                			</c:if>
		                		</c:if>
		                	</c:forEach>
		                	<!-- Answer List -->
		                	<c:forEach items="${boardAnswer}" var="boardAnswer" varStatus="status"> 
								<c:if test="${boardComment.ref_step eq boardAnswer.ref_step}">
								<c:set var="num" value="${boardAnswer.ref_step}" />
								<input type="hidden" id="refNo" value="${num}"/>
								<!-- 답글 갯수에 따라 반복 -->
			                	<div id="comment_list-${boardAnswer.ref_step}-${boardAnswer.ref_level}" class="answer_list-${boardComment.ref_step}-${boardComment.ref_level}" style="display : none;" >
				                	<div class="comment_box answer_box">
				                		<div class="row">
				                            <div class="row_info">
				                                <div class="row_top member">
				                                    <h4>
				                                        ${boardAnswer.member_nick}
				                                    </h4>
				                                </div>
				                                <span class="row_top date"><fmt:formatDate value="${boardAnswer.bcomment_date}" pattern="yyyy.MM.dd"/></span>
				                            </div>
				                            <div class="row_contents">
				                            	<p>${boardAnswer.bcomment_content}</p>
				                            </div>
				                            <ul class="row_top number">
			                                    <li><img src="/teen/resources/images/icon/icon_comment.svg" class="i_cmt">0</li>
			                                    <li><img src="/teen/resources/images/icon/icon_like.svg" class="i_like">${boardAnswer.bcomment_like_count}</li>
			                                </ul>
			                                <div class="btn_group">
					                            <c:if test="${sessionScope.member_nick == boardAnswer.member_nick}">
					                            <input type="button" value="삭제" class="btn_com btn_board" onclick="deleteComment(${boardAnswer.board_no}, ${boardAnswer.ref_step}, ${boardAnswer.ref_level })">
				                                <input type="button" value="수정" class="btn_com btn_board" onClick="modifyReComment(${boardAnswer.ref_step} ,${boardAnswer.ref_level})">
				                                </c:if>
				                            </div>
			                            </div>
				                	</div>
			                	</div>
			                	
			                <!-- Answer Modify Form -->
		                	<div id="answer"  class="answer_form-${boardAnswer.ref_step}-${boardAnswer.ref_level}" style="display : none;">
			                	<form id="answer_form" action="modifyRecomment" method="post">
				                	<textarea name="bcomment_content" placeholder="답글 작성">${boardAnswer.bcomment_content}</textarea>
				                	<input type="hidden" name="ref_step" value="${boardAnswer.ref_step}">
				                	<input type="hidden" name="ref_level" value="${boardAnswer.ref_level}">
				                	<input type="hidden" name="board_no" value="${boardAnswer.board_no}">
				                	<input type="reset" value="취소" class="btn_com btn_board btn_cmt" onClick="reCommentCancel(${boardAnswer.ref_step} ,${boardAnswer.ref_level})">
				                	<input type="submit" value="작성" class="btn_com btn_board btn_cmt">
				                </form>
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
	<script>
   $(document).ready(function () {

        var heartval = ${boardLike};
		var heart = document.getElementById('heart').value;
		
        if(heartval>0) {
            console.log(heartval);
            $("#heart").prop("src", "/teen/resources/images/icon/heart-fill.svg");
            $(".heart").prop('name',heartval)
        }
        else {
            console.log(heartval);
            $("#heart").prop("src", "/teen/resources/images/icon/heart.svg");
            $(".heart").prop('name',heartval)
        }

        var reportval = ${boardReport};
    	var report = document.getElementById('report').value;
    	
        if(reportval>0) {
            console.log(report);
            $("#report").prop("src", "/teen/resources/images/icon/siren-fill.png");
            $(".report").prop('name',reportval)
        }
        else {
            console.log(report);
            $("#report").prop("src", "/teen/resources/images/icon/siren.png");
            $(".report").prop('name',reportval)
        }
    });
      
        $(".heart").on("click", function () {

            var that = $(".heart");
            var heartval = ${boardLike};
            var sendData = {'board_no' : '${boardModel.board_no}','heart' : that.prop('name')};
            console.log(sendData);
            $.ajax({
                url :'/teen/board/detail/like',
                type :'POST',
                data : sendData,
                success : function(){	
                    if(heartval==1) {
                    	alert('해당 게시글의 추천을 취소하였습니다');
                    	location.reload();
                        $("#heart").prop("src","/teen/resources/images/icon/heart-fill.svg");
                    }
                    else{
                    	alert('해당 게시글을 추천하였습니다');
                    	location.reload();
                        $("#heart").prop("src","/teen/resources/images/icon/heart.svg");
                    }
                }
            });
        });
    
  $(".report").on("click", function () {

        var that1 = $(".report");
        var reportval = ${boardReport};
        var report = document.getElementById('report').value;
        var sendData1 = {'board_no' : '${boardModel.board_no}','report' : that1.prop('name')};
        console.log(sendData1);
        $.ajax({
            url :'/teen/board/detail/report',
            type :'POST',
            data : sendData1,
            success : function(){	
                if(reportval==1) {
                	alert('해당 게시글의 신고를 취소하였습니다');
                	location.reload();
                    $("#report").prop("src","/teen/resources/images/icon/siren-fill.png");
                }
                else{
                	alert('해당 게시글을 신고하였습니다');
                	location.reload();
                    $("#report").prop("src","/teen/resources/images/icon/siren.png");
                }
            }
        });
    });
  
  $('#drop-button2').on("click",function(e){
		
		e.preventDefault();
		var nick = document.getElementById('member_nick').value;
		let popUrl = "/teen/chatMainList?nick="+nick;
		let popOption = "width = 650px, height=550px, top=300px, left=300px, scrollbars=";
		
		window.open(popUrl,"쪽지",popOption);
		
	});

</script>
</body>

</html>