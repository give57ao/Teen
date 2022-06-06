<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TeenCoder 아이디 찾기</title>
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
			<form id="join_form" class="find_form" action="findId" method="post" onSubmit="return idCheck()">
				<table>
					<tbody>
						<tr>
							<th>이름</th>
							<td>
								<input id="member_name" type="text" name="member_name" placeholder="이름">
							</td>
						</tr>
						<tr>
							<th>이메일</th>
							<td>
								<input id="member_email" type="text" name="member_email" placeholder="이메일">
							</td>
						</tr>
					</tbody>
				</table>
				<div id="btn_wrap">
					<input type="button" value="취소" class="btn_com btn_main" onClick="goLogin()"> 
					<input type="submit" value="확인" class="btn_com btn_main">
				</div>
			</form>
		</div>
	</div>

	<!-- Footer -->
	<jsp:include page="../template/footer.jsp" flush="false" />
	
	<!-- JS -->
	<script type="text/javascript" src="/teen/resources/js/member/member.js"></script>
</body>
</html>