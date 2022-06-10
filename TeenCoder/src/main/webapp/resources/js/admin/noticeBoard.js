function searchBoard() {
	var keyword = document.getElementById('keyword').value;
	var selectedElement = document.getElementById("selectBoxTest");    
	var optionVal = selectedElement.options[selectedElement.selectedIndex].value; 
	console.log(keyword);
	// 검색 내용 확인 
	if (optionVal == '' || keyword == "") {
		alert('검색 설정을 확인해주세요.');
		return false;
	}
	location.href = '/teen/admin/noticeBoard?search='+optionVal+'&keyword='+ keyword;
}

// 공지글 삭제 경고 팝업
function noticeDeletePopup(noti_no) {
	var notiNo = noti_no;
	var del = confirm("해당 공지글을 정말 삭제하시겠습니까?");
	
	if(del == true) {
		$.ajax({
			url : "/teen/admin/noticeBoardDelete",
			type : "post",
			dataType : "json",
			data : {
				"noti_no" : notiNo
			},
			success : function(result) {
				if(result == 1) {
					alert("잘못된 접근입니다.");
				} else if(result == 0) {
				   	alert("해당 공지글을 삭제하였습니다.");
				}
			}
		});
	}
}