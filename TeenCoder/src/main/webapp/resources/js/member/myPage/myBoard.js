function searchBoard() {

	var keyword = document.getElementById('keyword').value;

	//검색 내용 확인
	if (keyword == null) {
		alert('검색내용을 작성해주세요');
		return false;
	}
}


function deleteBoard() {

	var board_no = document.getElementById('board_no').innerHTML;
	console.log(board_no);

//	location.href = 'teen/board/delete?' + board_no
}