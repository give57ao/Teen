// 로그인 프로세스
function loginProcess() {
	var id = document.getElementById('member_id').value;
	var pw = document.getElementById('member_pw').value;
	
	if(id == "") {
   		alert("아이디를 입력하세요.");
    	return false;
	}
	
	if(pw == "") {
	    alert("비밀번호를 입력하세요.");
	    return false;
	}
}

// Id 찾기
function idCheck() {
	var name = document.getElementById("member_name").value;
	var email = document.getElementById("member_email").value;

	if(name == "") {
		alert("이름을 입력하세요.");
		return false;
	}
	
	if(email == "") {
		alert("이메일을 입력하세요.");
		return false;
	}
}

// Pw 찾기
function pwCheck() {
	var id = document.getElementById("member_id").value;
	var email = document.getElementById("member_email").value;

	if(id == "") {
		alert("아이디를 입력하세요.");
		return false;
	}
	
	if(email == "") {
		alert("이메일을 입력하세요.");
		return false;
	}
}

// 회원가입
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

function fn_checkId() {
	var member_id = {member_id : $("#member_id").val()}

	if($("#member_id").val() == "") {
		alert("아이디를 입력하세요.");
		$("#member_id").focus();
		return false;
	}
	
	$.ajax({
		url : "/teen/member/checkId",
		type : "post",
		dataType : "json",
		data : {
			"member_id" : $("#member_id").val()
		},
		success : function(result) {
			if (result == 1) {
				alert("중복된 아이디입니다.");
			} else if (result == 0) {
				$("#idDuplication").attr("value", true);
				alert("사용가능한 아이디입니다.");
			}
		}
	});
}

function fn_checkNick() {
	var member_nick = {member_nick : $("#member_nick").val()}

	if($("#member_nick").val() == "") {
		alert("닉네임을 입력하세요.");
		$("#member_nick").focus();
		return false;
	}
	
	$.ajax({
		url : "/teen/member/checkNick",
		type : "post",
		dataType : "json",
		data : {"member_nick" : $("#member_nick").val()},
		success : function(data) {
			if (data == 1) {
				alert("중복된 닉네임입니다.");
			} else if (data == 0) {
				$("#nickDuplication").attr("value", true);
				alert("사용가능한 닉네임입니다.");
			}
		}
	});
}

function checkValue() {
	var form = document.userInfo;
	var test = $("input:checkbox[name='member_pro_check']").is(":checked");

	if(!form.member_id.value) {
		alert("아이디를 입력하세요.")
		return false;
	}
	
	if(form.idDuplication.value != "true") {
		alert("아이디 중복 체크가 필요합니다.");
		return false;
	}
	
	if(form.nickDuplication.value != "true") {
		alert("닉네임 중복 체크가 필요합니다.");
		return false;
	}
	
	if(!form.member_pw.value) {
		alert("비밀번호를 입력하세요.");
		return false;
	}
	
	if(form.member_pw.value != form.member_pw1.value) {
		alert("동일한 비밀번호를 입력하세요.");
		return false;
	}
	
	if(!form.member_name.value) {
		alert("이름을 입력하세요.");
		return false;
	}
	
	if(!form.member_email.value) {
		alert("이메일을 입력하세요.");
		return false;
	}		
	
	if(test == false) {
		alert("전문성 체크가 필요합니다.");
		return false;
	}
}

function checkOne(chk) {
	var obj = document.getElementsByName("member_pro_check");
	
	for(var i = 0; i<obj.length; i++) {
		if(obj[i] != chk) {
			obj[i].checked = false;
		}
	}
}

// 마이페이지 화면으로 이동
function goMyPage() {
	location.href = "/teen/member/";
}