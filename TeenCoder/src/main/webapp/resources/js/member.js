// 로그인 화면으로 이동
function goLogin() {
	location.href = "/teen/member/login";
}

// 로그인 프로세스
function loginProcess() {
	var id = document.login_form.member_id.value;
	var pw = document.login_form.member_pw.value;
	
	/*
	var member_id = '<c:out value="${member.meber_id}">';
	var member_pw = '<c:out value="${member.meber_pw}">';
	*/
	

	if(id == "") {
   		alert("아이디를 입력해주세요.");
    	return false;
	}
	
	if(pw == "") {
	    alert("비밀번호를 입력해주세요.");
	    return false;
	}
	
	/*
	if(id == member_id && pw == member_pw) {
		alert("로그인 성공");
	} else {
		alert("로그인 실패");
	}
	*/
}

// 로그아웃
function logout() {
	alert("로그아웃 하시겠습니까?");
}