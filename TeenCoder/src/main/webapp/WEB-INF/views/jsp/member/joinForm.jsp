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
	                    <tr class="check emailChk" >
	                        <th>이메일</th>
	                        <td>
	                            <input type="text" id= "member_email" name="member_email" placeholder="이메일">
	                            <span id="emailChk" class="doubleChk">인증번호 전송</span>
								<input id="member_emailChk" type="text" id= "member_email" name="member_emailChk" placeholder="인증번호 입력">
								<span id="emailChk2" class="doubleChk">이메일인증</span></br>
								<span class="point successEmailChk">이메일 입력후 인증번호 보내기를 해주십시오.</span>
								<input type="hidden" id="emailDoubleChk"/>
								<br><br><br>
	                        </td>
	                    </tr>
	                    
	                   <tr class="checkbox">
	                        <th>개발직군 유무</th>
	                        <td>
	                           <p>회원가입 후 회원정보 수정 시 인증이 가능합니다.</p>
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
	<script>
	var code = "";
	$("#emailChk").click(function(){
		var member_email = $("#member_email").val();
		
		$.ajax({
	        type:"GET",
	        url:"mailCheck?member_email=" + member_email,
	        cache : false,
	        success:function(data){
	        	if(data == "error"){
	        		alert("이메일 주소가 올바르지 않습니다. 유효한 이메일 주소를 입력해주세요.");
					$("#member_email").attr("autofocus",true);
					$(".successEmailChk").text("유효한 이메일 주소를 입력해주세요.");
	        	}else{	        		
					alert("인증번호 발송이 완료되었습니다.\n입력한 이메일에서 인증번호 확인을 해주십시오.");
	        		$("#member_emailChk").attr("disabled",false);
	        		$("#emailChk2").css("display","inline-block");
	        		$(".successEmailChk").text("인증번호를 입력한 뒤 이메일 인증을 눌러주십시오.");
	        		code = data;
	        	}
	        }
	    });
	});
	
	$("#emailChk2").click(function(){
		if($("#member_emailChk").val() == code){
			$(".successEmailChk").text("인증번호가 일치합니다.");
			$(".successEmailChk").css("color","green");
			$("#emailDoubleChk").val("true");
			$("#member_emailChk").attr("disabled",true);
			//$("#sm_email").attr("disabled",true);
		}else{
			$(".successEmailChk").text("인증번호가 일치하지 않습니다. 확인해주시기 바랍니다.");
			$(".successEmailChk").css("color","red");
			$("#emailDoubleChk").val("false");
			$("#member_emailChk").attr("autofocus",true);
		}
	});
	</script>
	
	
</body>
</html>