<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TeenCoder 아이디 찾기</title>
<link rel="stylesheet" type="text/css" href="/teen/resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/common.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/memberForm.css">
<script src="../resources/js/login.js"></script>
<script type="text/javascript">
	function formChk() { 
		var in_name = document.getElementById("inName").value;
		var in_email = document.getElementById("inEmail").value;
		
		
		if (in_name == "") {
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
			<h1>아이디 찾기</h1>
			<h2>이름과 이메일을 입력하시면 아이디를 찾으실 수 있습니다.</h2>
		</div>
		<div id="contents_detail">
			<!-- Form -->
			<form id="join_form" class="find_form" action="findId" method="post" onsubmit="return formChk()">
                <table>
                	<tbody>
	                    <tr>
	                        <th>이름</th>
	                        <td>
	                            <input type="text" id="inName" name="MEMBER_NAME" placeholder="이름">
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>이메일</th>
	                        <td>
	                            <input type="text" id="inEmail" name="MEMBER_EMAIL" placeholder="이메일">
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