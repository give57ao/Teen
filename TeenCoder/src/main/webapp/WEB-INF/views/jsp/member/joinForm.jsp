<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TeenCoder 회원가입</title>
<link rel="shortcut icon" href="/teen/resources/images/icon/icon_favicon.ico" type="image/x-icon"> <!-- favicon -->
<link rel="stylesheet" type="text/css" href="/teen/resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/common.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/memberForm.css">
</head>
<body>
	<!-- Header -->
	<jsp:include page="../template/header.jsp" flush="false" />
<script src="https://www.google.com/recaptcha/api.js"></script>

	<!-- Contents -->
	<div id="contents">
        <div id="contents_title">
            <h1>회원가입</h1>
            <h2>회원가입을 하고 TeenCoder 커뮤니티를 이용하세요.</h2>
        </div>
        <div id="contents_detail">
            <!-- Form -->
            <form id="join_form" name="userInfo" method="post" onSubmit="return checkValue()">
                <table>
                	<tbody>
	                    <tr class="check">
	                        <th>아이디</th>
	                        <td>
	                            <input type="text" name="member_id" id="member_id" placeholder="아이디">
	                            <button class="btn_com btn_check" type="button" name="checkId" id="checkId">중복 체크</button>
	                            <input type="hidden" name="idDuplication" id="idDuplication"/>
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>비밀번호</th>
	                        <td>
	                            <input type="password" name="member_pw" placeholder="비밀번호">
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>비밀번호 확인</th>
	                        <td>
	                            <input type="password" name="member_pw1" placeholder="비밀번호 확인">
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>이름</th>
	                        <td>
	                            <input type="text" name="member_name" placeholder="이름">
	                        </td>
	                    </tr>
	                    <tr class="check">
	                        <th>닉네임</th>
	                        <td>
	                            <input type="text" name="member_nick" id="member_nick" placeholder="닉네임">
	                            <button class="btn_com btn_check" type="button" name="checkNick" id="checkNick">중복 체크</button>
	                            <input type="hidden" name="nickDuplication" id="nickDuplication"/>
	                        </td>
	                    </tr>
	                    <tr >
	                        <th>이메일</th>
	                        <td>
	                            <input type="text" name="member_email" placeholder="이메일">
	                        </td>
	                    </tr>
	                    <tr class="checkbox">
	                        <th>개발직군 유무</th>
	                        <td>
	                            <input type="checkbox" name="member_pro_check" id="member_pro_check1" value="Y" onClick="checkOne(this)">
	                            <label for="yes">네</label>
	                            <input type="checkbox" name="member_pro_check" id="member_pro_check2" value="N" onClick="checkOne(this)">
	                            <label for="no">아니오</label>
	                        </td>
	                    </tr>
	                    <tr class="captcha">
	                        <th></th>
	                        <td>
	                            <div id="g-recaptcha" class="g-recaptcha" data-sitekey="6Lda52AgAAAAAPkgal4uFLTpngYX6W0PeT5uf0vX"></div>
	                        </td>
	                    </tr>
                    </tbody>
                </table>
                <div id="btn_wrap">
                    <input type="button" value="취소" class="btn_com btn_main" onClick="goLogin()">
                    <input type="submit" value="가입" class="btn_com btn_main">
                </div>
            </form>
        </div>
    </div>
    
	<!-- Footer -->
	<jsp:include page="../template/footer.jsp" flush="false" />
	
	<!-- JS -->
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script type="text/javascript" src="/teen/resources/js/member/member.js"></script>
	<script type="text/javascript" src="/teen/resources/js/member/memberJoin.js"></script>
	
	
</body>
</html>