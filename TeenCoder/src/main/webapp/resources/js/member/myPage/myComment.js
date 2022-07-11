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

function enterkey() {
		var keyword = document.getElementById('keyword').value;
		var selectedElement = document.getElementById("selectBoxTest");
		var optionVal = selectedElement.options[selectedElement.selectedIndex].value;
		console.log(keyword);
		if (window.event.keyCode == 13) {
			if (optionVal == '' || keyword == "") {
				alert('검색 설정을 확인 해주세요.');
				return false;
			}else{
			location.href = '/teen/member/commentList?search=' + optionVal + '&keyword=' + keyword;
			}
		}
	}

function deleteComment(board_no, ref_step, ref_level) {
	var board_no = document.getElementById('board_no').value;
	var ref_step = document.getElementById('ref_step').value;
	var ref_level = document.getElementById('ref_level').value;
	if(confirm("해당 댓글을 삭제하시겠습니까?")) {
		alert("해당 댓글을 삭제하였습니다.");
		location.href='/teen/board/deleteComment?board_no='+board_no+'&ref_step='+ref_step+'&ref_level='+ref_level
	}else{
		return false;
	}
}