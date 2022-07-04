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
		return false;
	}
}

// 회원정보수정 체크박스
$(document).on('click', "#pro input[type='checkbox']", function() {
    if(this.checked) {
        var pro = $("#pro input[type='checkbox']");
        for(var i = 0; i < pro.length; i++){
            pro[i].checked = false;
        }
        this.checked = true;
    } else {
        this.checked = false;
    }
});

$(document).on('click', "#admin input[type='checkbox']", function() {
    if(this.checked) {
        var admin = $("#admin input[type='checkbox']");
        for(var i = 0; i < admin.length; i++){
            admin[i].checked = false;
        }
        this.checked = true;
    } else {
        this.checked = false;
    }
});

// 공지글 리스트 화면으로 이동
function goNoticeBoard() {
	location.href = "/teen/admin/noticeBoard";
}