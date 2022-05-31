// 로그인 화면으로 이동
function goLogin() {
	location.href = "/teen/member/login";
}

// 로그인 프로세스
function loginProcess() {
	var id = document.getElementById('member_id').value;
	var pw = document.getElementById('member_pw').value;
	
	if(id == "") {
   		alert("아이디를 입력해주세요.");
    	return false;
	}
	
	if(pw == "") {
	    alert("비밀번호를 입력해주세요.");
	    return false;
	}
}

// 로그아웃
function logout() {
	alert("로그아웃을 하시겠습니까?");
}