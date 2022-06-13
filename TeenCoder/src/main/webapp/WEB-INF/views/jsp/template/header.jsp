<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
    <header id="header">
        <div id="header_logo">
            <a href="/teen">TeenCoder</a>
        </div>
        <nav id="header_nav">
            <ul>
                <li><a href="/teen">Home</a></li>
                <li><a href="/teen/board?board_group_no=1">Community</a></li>
                <li><a href="/teen/board?board_group_no=2">Q&amp;A</a></li>
                <li><a href="/teen/board/notice">Notice</a></li>
            </ul>
        </nav>
        
        <!-- 로그인 전 : 세션 값이 없을 경우 -->
        <c:if test="${sessionScope.member_no == null}">
            <div id="header_menu">
                <ul>
                    <li><a href="/teen/member/login" class="log">로그인</a></li>
                    <li><a href="/teen/member/join" class="btn_com btn_join">가입</a></li>
                </ul>
            </div>
        </c:if>
        
        <!-- 로그인 후 : 세션 값이 있을 경우 -->
        <c:if test="${sessionScope.member_no != null}">
            <div id="header_menu">
                <ul>
                    <%-- <li><c:out value="${sessionScope.member_no}"/></li> 세션 값 확인 --%>
                    <!-- Admin 로그인 -->
                    <c:if test="${sessionScope.member_admin == 'Y'}">
                        <li><a href="/teen/admin/memberList" class="btn_com">관리자 페이지로 이동</a></li>
                    </c:if>
                    <li><a href="/teen/member/logout" class="log" onClick="logout()">로그아웃</a></li>
                    <li><a href="/teen/member/" class="log">마이페이지</a></li>
                    <li><a href="#"><img src="/teen/resources/images/icon/icon_alarm_n.svg"></a></li>
                    <li><a href="/teen/member/"><img src="/teen/resources/images/icon/icon_badge.png"></a></li>
                </ul>
            </div>
        </c:if>
    </header>
    
    <!-- JS -->
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script type="text/javascript" src="/teen/resources/js/common.js"></script>
</body>
</html>