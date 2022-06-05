function searchBoard() {
	var keyword = document.getElementById('keyword').value;

	// 검색 내용 확인 
	if (keyword == null) {
		alert('검색할 내용을 입력하세요.');
		return false;
	}
}

function deleteBoard(board_no) {
	// var board_no = document.getElementById('board_no').value;
	console.log(board_no);

	//	location.href = 'teen/board/delete?' + board_no
}