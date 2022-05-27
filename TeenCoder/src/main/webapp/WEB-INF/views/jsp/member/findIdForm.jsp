<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TeenCoder 아이디 찾기</title>
<script src="../resources/js/member/login/login.js"></script>
<link rel="stylesheet" type="text/css" href="/teen/resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/common.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/memberForm.css">
</head>

<body>
	<!-- Header -->
	<jsp:include page="../template/header.jsp" flush="false" />

	<!-- Contents -->
	<div id="contents">
		<div id="contents_title">
			<h1>아이디 찾기</h1>
			<h2>이름과 이메일을 입력하시면 아이디를 찾으실 수 있습니다.</h2>
		</div>
		<div id="contents_detail">
			<!-- Form -->
			<form id="join_form" class="find_form" action="findId" method="post"
				onsubmit="return IdFormChk()">
				<table>
					<tbody>
						<tr>
							<th>이름</th>
							<td><input type="text" id="inName" name="member_name"
								placeholder="이름"></td>
						</tr>
						<tr>
							<th>이메일</th>
							<td><input type="text" id="inEmail" name="member_email"
								placeholder="이메일"></td>
						</tr>
					</tbody>
				</table>
				<div id="btn_wrap">
					<input type="button" value="취소" class="btn_com btn_main"> <input
						type="submit" value="확인" class="btn_com btn_main">
				</div>
			</form>
		</div>
	</div>

	<!-- Footer -->
	<jsp:include page="../template/footer.jsp" flush="false" />
</body>
</html>