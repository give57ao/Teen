<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TeenCoder 회원탈퇴</title>
<link rel="shortcut icon" href="/teen/resources/images/icon/icon_favicon.ico" type="image/x-icon"> <!-- favicon -->
<link rel="stylesheet" type="text/css" href="/teen/resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/common.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/memberForm.css">
</head>
<body>
	<!-- Header -->
	<jsp:include page="../template/header.jsp" flush="false" />
	<script type="text/javascript">
		$(document).ready(function(){
			// 취소
			$(".btn_com").on("click", function(){
				
				location.href = "/teen/member/";
						    
			})
		
			$("#submit").on("click", function(){
				//비밀번호 미 입력시
				if($("#member_pw").val()== ""){
					alert("비밀번호를 입력해주세요.");
					$("#member_pw").focus();
					location.href = "/teen/member/delete";
					return false;
				}
				// 비밀번호 입력 시 검증 함수
				$.ajax({
					url : "/teen/member/passChk",
					type : "POST",
					dataType : "json",
					data : {"member_pw" : document.getElementById("member_pw").value},
					async: false,
					success: function(result){
						console.log(result);
						if(result == 0){
							alert("비밀번호가 틀렸습니다.");
							location.href="/teen/member/delete";
						}else{
							 if (!confirm("회원탈퇴하시겠습니까?")) {
								 return false;
							 } else {
								 location.href="/teen/member/deleteMember"
							    }
							
						}
					}
				})
			});
		})
	</script>
	<!-- Contents -->
	<div id="contents">
        <div id="contents_title">
            <h1>회원탈퇴</h1>
            <h2>회원탈퇴를 할 수 있습니다.</h2>
        </div>
        <div id="contents_detail">
            <!-- Form -->
            <form id="join_form" class="find_form">
                <table>
                	<tbody>
	                    <tr>
	                        <th>비밀번호</th>
	                        <td>
	                             <input type="password" name="member_pw" id="member_pw" placeholder="비밀번호">
	                        </td>
	                    </tr>
                    </tbody>
                </table>
                <div id="btn_wrap">
                    <input type="button" value="취소" class="btn_com btn_main" onClick="goMyPage()">
                    <input type="button" value="탈퇴" class="btn_com btn_main" id="submit">
                </div>
            </form>
        </div>
    </div>
    
	<!-- Footer -->
	<jsp:include page="../template/footer.jsp" flush="false" />
	
	<!-- JS -->
</body>
</html>