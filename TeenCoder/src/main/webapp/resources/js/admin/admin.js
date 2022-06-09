// 회원관리 리스트 화면으로 이동
function goMemberList() {
	location.href = "/teen/admin/memberList";
}

// 회원정보 삭제 경고 팝업
function memberDeletePopup(member_no) {
	var memberNo = member_no;
	var del = confirm("해당 회원의 정보를 정말 삭제하시겠습니까?");
	
	if(del == true) {
		$.ajax({
			url : "/teen/admin/memberDelete",
			type : "post",
			dataType : "json",
			data : {
				"member_no" : memberNo
			},
			success : function(result) {
				if(result == 1) {
					alert("잘못된 접근입니다.");
				} else if(result == 0) {
				   	alert("해당 회원의 정보를 삭제하였습니다.");
				}
			}
		});
	}
}

// 공지글 리스트 화면으로 이동
function goNoticeBoard() {
	location.href = "/teen/admin/noticeBoard";
}

function searchBoard() {
	var keyword = document.getElementById('keyword').value;
	var selectedElement = document.getElementById("selectBoxTest");    
	var optionVal = selectedElement.options[selectedElement.selectedIndex].value; 
	console.log(keyword);
	// 검색 내용 확인 
	if (optionVal == '' || keyword == "") {
		alert('검색 설정을 확인 해주세요.');
		return false;
	}
	location.href = '/teen/admin/memberList?search='+optionVal+'&keyword='+ keyword;
}