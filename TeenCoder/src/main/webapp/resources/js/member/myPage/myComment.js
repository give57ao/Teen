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
	location.href = '/teen/member/commentList?search='+optionVal+'&keyword='+ keyword;
}




function deleteComment(bcomment_no) {
	// var board_no = document.getElementById('board_no').value;
	console.log(bcomment_no);

	//	location.href = 'teen/board/delete?' + board_no
}