<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test</title>
<script type="text/javascript">
	function formChk() { 
		var in_id = document.getElementById("inId").value;	
		var db_id = '<c:out value="${list.MEMBER_ID }"/>'; 
		
		alert(in_id);
		alert(db_id);
		
		if (in_id != 'testId') {
			alert("id 불일치");
			return false;
		}
		if (in_id == null) {
			alert("null");
			return false;
		}
		
		return true;

	}
</script>
</head>

<body>
	<form action="testOk" method="post" onsubmit="return formChk()">
		<input type="text" id="inId" name="testId"/> 
		<input type="submit" value="확인" />
	</form>
	<h1>테스트페이지입니다</h1>
	<c:out value="${list.MEMBER_ID }" default="null..." />

</body>
</html>