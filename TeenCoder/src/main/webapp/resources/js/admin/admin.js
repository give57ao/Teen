// 회원관리 리스트 화면으로 이동
function goMemberList() {
	location.href = "/teen/admin/memberList";
}

// 회원정보 삭제 경고 팝업
function memberDelete() {
	if(confirm("해당 회원의 정보를 정말 삭제하시겠습니까?")) {
		alert("삭제되었습니다.");
		return true;
	} else {
		alert("잘못된 로직입니다.");
		return false;
	}
}

// 공지글 리스트 화면으로 이동
function goNoticeBoard() {
	location.href = "/teen/admin/noticeBoard";
}