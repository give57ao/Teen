<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TeenCoder</title>
<link rel="stylesheet" type="text/css" href="/teen/resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/common.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/main.css">
</head>
<body>
	<!-- Header -->
	<jsp:include page="template/header.jsp" flush="false" />

	<!-- Contents -->
    <div id="contents">
        <div id="contents_title">
            <h1>TeenCoder</h1>
            <h2>
            	환영합니다! 예비 개발자들을 위한 IT 정보 공유 커뮤니티 사이트 TeenCoder입니다.<br>
                TeenCoder 내 커뮤니티를 활용하여 사람들과 정보를 공유하고 소통할 수 있습니다.
            </h2>
            <div id="contents_pro">
            	<div class="circle c1">
            		<div class="chart" data-percent="${allMemberCount}">${allMemberCount}</div>
				    <h2>전체 사용자</h2> 
				</div>
				<div class="circle c2">
				 	<div class="chart" data-percent="${allBoardCount}">${allBoardCount}</div>
				    <h2>전체 게시글</h2>
				</div>
				<div class="circle c3">
				 	<div class="chart" data-percent="${allCommentCount}">${allCommentCount}</div>
				    <h2>전체 댓글</h2>
				</div>
            </div>
            <div id="btn_wrap">
                <a href="/teen/board?board_group_no=1" class="btn_com btn_main">커뮤니티로 이동</a>
            </div>
            <div id="particles-js"></div>
        </div>
    </div>

	<!-- Footer -->
	<jsp:include page="template/footer.jsp" flush="false" />
	
	<!-- JS -->
	<script type="text/javascript" src="/teen/resources/js/plugin/particles.min.js"></script>
	<script type="text/javascript" src="/teen/resources/js/plugin/app.js"></script>
	<script type="text/javascript" src="/teen/resources/js/member/member.js"></script>
</body>
</html>