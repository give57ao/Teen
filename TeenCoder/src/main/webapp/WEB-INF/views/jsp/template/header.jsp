<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<body>
	<header id="header">
        <div id="header_logo">
            <a href="<%= request.getContextPath() %>/jsp/main.jsp">TeenCoder</a>
        </div>
        <nav id="header_nav">
            <ul>
                <li><a href="<%= request.getContextPath() %>/jsp/main.jsp">Home</a></li>
                <li><a href="<%= request.getContextPath() %>/jsp/board/mainBoard.jsp">Community</a></li>
                <li><a href="<%= request.getContextPath() %>/jsp/board/qnaBoard.jsp">Q&A</a></li>
                <li><a href="<%= request.getContextPath() %>/jsp/board/noticeBoard.jsp">Notice</a></li>
            </ul>
        </nav>
        <!-- 로그인 전 -->
        <div id="header_menu">
            <ul>
                <li><a href="<%= request.getContextPath() %>/jsp/member/loginForm.jsp" class="log">로그인</a></li>
                <li><a href="<%= request.getContextPath() %>/jsp/member/joinForm.jsp" class="btn_com btn_join">가입</a></li>
            </ul>
        </div>
        <!-- 로그인 후 -->
        <!--
        <div id="header_menu">
            <ul>
            	<li><a href="#" class="log">로그아웃</a></li>
                <li><a href="<%= request.getContextPath() %>/jsp/member/myPage.jsp" class="log">마이페이지</a></li>
                <li><a href="#"></a><img src="<%= request.getContextPath() %>/images/icon/icon_alarm_n.svg"></li>
                <li><a href="#"></a><img src="<%= request.getContextPath() %>/images/icon/icon_badge.png"></li>
            </ul>
        </div>
        -->
    </header>
</body>
</html>