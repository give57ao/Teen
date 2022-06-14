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
function noticeBoardDelete() {
	if(confirm("해당 공지글을 정말 삭제하시겠습니까?")) {
		alert("삭제되었습니다.");
		return true;
	} else {
		alert("잘못된 로직입니다.");
		return false;
	}
}