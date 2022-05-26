<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TeenCoder 비밀번호 찾기</title>
<link rel="stylesheet" type="text/css"
	href="<%= request.getContextPath() %>/css/reset.css">
<link rel="stylesheet" type="text/css"
	href="<%= request.getContextPath() %>/css/common.css">
<link rel="stylesheet" type="text/css"
	href="<%= request.getContextPath() %>/css/memberForm.css">

<script type="text/javascript">
	function formChk() { 
		var in_id = document.getElementById("inid").value;
		var in_email = document.getElementById("inEmail").value;
		
		
		if (in_id == "") {
			alert("이름 입력");
			return false;
		}
		if (in_email == "") {
			alert("이메일입력");
			return false;
		}
		
		return true;

	}
</script>
</head>
<body>
	<!-- Header -->
	<jsp:include page="../template/header.jsp" flush="false" />

	<!-- Contents -->
	<div id="contents">
		<div id="contents_title">
			<h1>비밀번호 찾기</h1>
			<h2>아이디와 이메일을 입력하시면 비밀번호를 찾으실 수 있습니다.</h2>
		</div>
		<div id="contents_detail">
			<!-- Form -->
			<form id="join_form" class="find_form" action="findPw" method="post" onsubmit="return formChk()">
				<table>
					<tbody>
						<tr>
							<th>아이디</th>
							<td><input type="text" name="MEMBER_ID" id="inId"placeholder="아이디">
							</td>
						</tr>
						<tr>
							<th>이메일</th>
							<td><input type="text" name="MEMBER_EMAIL" id="inEmail"placeholder="이메일">
							</td>
						</tr>
					</tbody>
				</table>
				<div id="btn_wrap">
					<input type="button" value="취소" class="btn_com btn_main">  
					<input type="submit" value="확인" class="btn_com btn_main">
				</div>
			</form>
		</div>
	</div>

	<!-- Footer -->
	<jsp:include page="../template/footer.jsp" flush="false" />
</body>
</html>