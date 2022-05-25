<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<body>
	<header id="header">
        <div id="header_logo">
            <a href="/teen">TeenCoder</a>
        </div>
        <nav id="header_nav">
            <ul>
                <li><a href="/teen">Home</a></li>
                <li><a href="#">Community</a></li>
                <li><a href="#">Q&amp;A</a></li>
                <li><a href="#">Notice</a></li>
            </ul>
        </nav>
        <!-- 로그인 전 : 세션 값이 없을 경우 -->
        <c:if test="${sessionScope.member_no == null}">
	        <div id="header_menu">
	            <ul>
	                <li><a href="/teen/member/login" class="log">로그인</a></li>
	                <li><a href="/teen/member/joinForm" class="btn_com btn_join">가입</a></li>
	            </ul>
	        </div>
        </c:if>
        <!-- 로그인 후 : 세션 값이 있을 경우 -->
        <c:if test="${sessionScope.member_no != null}">
	        <div id="header_menu">
	            <ul>
	            	<li><a href="/teen/member/logout" class="log" onCLick="logout()">로그아웃</a></li>
	                <li><a href="/teen/member/member" class="log">마이페이지</a></li>
	                <li><a href="#"><img src="/teen/resources/images/icon/icon_alarm_n.svg"></a></li>
	                <li><a href="#"><img src="/teen/resources/images/icon/icon_badge.png"></a></li>
	            </ul>
	        </div>
        </c:if>
    </header>
</body>
</html>