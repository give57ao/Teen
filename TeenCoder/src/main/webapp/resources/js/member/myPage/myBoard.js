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
	location.href = '/teen/member/boardList?search='+optionVal+'&keyword='+ keyword;
}




function deleteBoard(board_no) {
	// var board_no = document.getElementById('board_no').value;
	console.log(board_no);

	//	location.href = 'teen/board/delete?' + board_no
}