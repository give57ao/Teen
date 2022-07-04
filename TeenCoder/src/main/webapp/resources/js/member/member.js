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
	var id = document.getElementById("member_id").value;
	member_id = /^[a-z]+[a-z0-9]{5,19}$/g;

	if($("#member_id").val() == "") {
		alert("아이디를 입력하세요.");
		$("#member_id").focus();
		return false;
	}
	
	if(!member_id.test(id)) {
		alert("아이디는 영문자로 시작하는 최소6자 ~ 최대20자(영문자+숫자가능)로 입력해 주세요");
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
	var nick = document.getElementById("member_nick").value;

	member_nick = /^([a-zA-Z0-9ㄱ-ㅎ|ㅏ-ㅣ|가-힣]).{1,10}$/;
	
	if($("#member_nick").val() == "") {
		alert("닉네임을 입력하세요.");
		$("#member_nick").focus();
		return false;
	}
	if(!member_nick.test(nick)) {
		alert("닉네임은 한글, 영문, 숫자만 가능하며 2-10자리 가능합니다.");
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
	var email = document.getElementById("member_email").value;
	var id = document.getElementById("member_id").value;
	var pw = document.getElementById("member_pw").value;
	var nick = document.getElementById("member_nick").value;
	var name = document.getElementById("member_name").value;

	//이름 형식 : 한글만 입력
	member_name = /[ㄱ-힣].{1,10}$/;
	// 닉네임 형식 : 한글,영문,숫자 2~10자리
	member_nick = /^([a-zA-Z0-9ㄱ-ㅎ|ㅏ-ㅣ|가-힣]).{1,10}$/;
	// 이메일 형식 : 영문 +숫자 @ 영문 .com
	member_email =/^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
	// 아이디 형식 : 영문자로 시작하는 6~20자 영문자 + 숫자 
	member_id =/^[a-z]+[a-z0-9]{5,19}$/g;
	// 비밀번호 형식 : 8~16자 영문 + 숫자
	member_pw =/^(?=.*\d)(?=.*[a-zA-Z])[0-9a-zA-Z]{8,16}$/;
	
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
	
	if(!member_email.test(email)) {
		alert("이메일 형식이 잘못 되었습니다.");
		return false;
	}
	
	if(!member_id.test(id)) {
		alert("아이디는 영문자로 시작하는 최소6자 ~ 최대20자(영문자+숫자가능)로 입력해 주세요");
		return false;
	}
	
	if(!member_pw.test(pw)) {
		alert("비밀번호는 영문자 + 숫자로 조합된 최소 8자 ~ 최대 16자로 입력해 주세요.");
		return false;
	}
	
	if(!member_nick.test(nick)) {
		alert("닉네임은 한글, 영문, 숫자만 가능하며 2-10자리 가능합니다.");
		return false;
	}
	
	if(!member_name.test(name)) {
		alert("이름은 한글만 입력 가능합니다.");
		return false;
	}
	
	
    if (typeof(grecaptcha) != 'undefined') {
       if (grecaptcha.getResponse() == "") {
           alert("자동 가입 방지 봇을 확인 한뒤 진행 해 주세요.");
           return false;
       }
    }
    else {
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
//개발직군유무 인증 화면으로 이동
function goMail() {
	location.href = "/teen/mail/";
}


