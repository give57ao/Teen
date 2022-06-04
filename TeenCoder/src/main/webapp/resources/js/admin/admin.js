// 회원 리스트 화면으로 이동
function goMemberList() {
	location.href = "/teen/admin/memberList";
}

// 회원정보 삭제 경고 팝업
function memberDeletePopup(member_no) {
	var memberNo = member_no;
			console.log(memberNo);
	var del = confirm("해당 회원의 정보를 정말 삭제하시겠습니까?");
	
	if(del == true) {
			

			$.ajax({
				url : "/teen/admin/memberDelete",
				type : "post",
				dataType : "json",
				data : {
					"member_no" :memberNo
				},
				success : function(result) {
					if (result == 1) {
						alert("잘못된 접근입니다.");
					} else if (result == 0) {
					   	alert("해당 회원의 정보를 삭제하였습니다.");
					}
				}
			})
   		};
	}
