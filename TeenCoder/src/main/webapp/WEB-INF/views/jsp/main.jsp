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
                <ul>
                    <li>
                        <div><span>${allMemberCount}</span></div>
                        <h2>전체 사용자</h2>
                    </li>
                    <li>
                        <div><span>${allBoardCount}</span></div>
                        <h2>전체 게시글</h2>
                    </li>
                    <li>
                        <div><span>${allCommentCount}</span></div>
                        <h2>전체 댓글</h2>
                    </li>
                </ul>
            </div>
        </div>
        <div id="contents_detail">
            <div id="btn_wrap">
                <a href="/teen/board/" class="btn_com btn_main">카테고리로 이동</a>
            </div>
        </div>
    </div>

	<!-- Footer -->
	<jsp:include page="template/footer.jsp" flush="false" />
	
	<!-- JS -->
	<script type="text/javascript" src="/teen/resources/js/member/member.js"></script>
</body>
</html>