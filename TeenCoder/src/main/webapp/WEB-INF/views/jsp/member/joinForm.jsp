<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TeenCoder 회원가입</title>
<link rel="stylesheet" type="text/css" href="/teen/resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/common.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/memberForm.css">
<script src="/teen/resources/js/member.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</head>
<body>
	<!-- Header -->
	<jsp:include page="../template/header.jsp" flush="false" />

	<!-- Contents -->
	<div id="contents">
        <div id="contents_title">
            <h1>회원가입</h1>
            <h2>회원가입을 하고 TeenCoder 커뮤니티를 이용하세요.</h2>
        </div>
        <div id="contents_detail">
            <!-- Form -->
            <form id="join_form" action="joinForm" method="post">
                <table>
                	<tbody>
	                    <tr class="check">
	                        <th>아이디</th>
	                        <td>
	                            <input type="text" name="member_id" id="memberId" placeholder="아이디">
	                            <button id="checkId" class="btn_com btn_check" name="check_id" value="N">중복 체크</button>
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
	                            <input type="text" name="member_nick" placeholder="닉네임">
	                            <button id="checkNick" class="btn_com btn_check" name="check_nick" value="N">중복 체크</button>
	                        </td>
	                    </tr>
	                    <tr class="check">
	                        <th>이메일</th>
	                        <td>
	                            <input type="text" name="member_email" placeholder="이메일">
	                            <input type="submit" value="인증" class="btn_com btn_check">
	                        </td>
	                    </tr>
	                    <tr class="checkbox">
	                        <th>개발직군 유무</th>
	                        <td>
	                            <input type="checkbox" name="member_pro_check" value="yes">
	                            <label for="yes">네</label>
	                            <input type="checkbox" name="member_pro_check" value="no">
	                            <label for="no">아니오</label>
	                            <input type="submit" value="인증" class="btn_com btn_check">
	                        </td>
	                    </tr>
                    </tbody>
                </table>
                <div id="btn_wrap">
                    <input type="button" value="취소" class="btn_com btn_main" onclick="goLogin()">
                    <input type="submit" value="가입" class="btn_com btn_main">
                </div>
            </form>
        </div>
    </div>
	<!-- Footer -->
	<jsp:include page="../template/footer.jsp" flush="false" />	
	<script type="text/javascript">
		$(document).ready(function() {
			$("#checkId").on("click", function(e) {
				e.preventDefault();
				fn_checkId();
			});
			
			$("#checkNick").on("click", function(e) {
				e.preventDefault();
				fn_checkNick();
			});
		});
		
		function fn_checkId(){ 
			var memberId = {memberId : $('#memberId').val()};
		
			if($("#memberId").val()==""){ 
				alert("아이디를 입력해주세요."); 
				$("#memberId").focus(); 
				return false;
			}
			$.ajax({ 
				url:"/teen/member/checkId", 
				type:"post", 
				dataType:"json", 
				data:{"member_id":$("#memberId").val()}, 
				success : function(data){ 
					if(data == 1){ 
						alert("중복된 아이디입니다."); 
					} else if(data ==0){ 
						$("#checkId").attr("value","Y"); 
						alert("사용가능한 아이디 입니다.") 
					} 
				}
			})
		}
		
		function fn_checkNick(){ 
			var memberNick = {memberNick : $('#memberNick').val()};
		
			if($("#memberNick").val()==""){ 
				alert("닉네임을 설정해 주세요."); 
				$("#memberNick").focus(); 
				return false;
			}
			$.ajax({ 
				url:"/teen/member/checkNick", 
				type:"post", 
				dataType:"json", 
				data:{"member_nick":$("#memberNick").val()}, 
				success : function(data){ 
					if(data == 1){ 
						alert("중복된 닉네임입니다."); 
					} else if(data ==0){ 
						$("#checkNick").attr("value","Y"); 
						alert("사용가능한 닉네임 입니다.") 
					} 
				}
			});
		}
	</script>
</body>
</html>