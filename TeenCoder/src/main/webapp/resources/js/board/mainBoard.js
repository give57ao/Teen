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
	location.href = '/teen/board?search='+optionVal+'&keyword='+ keyword;
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
		location.href = '/teen/board?search=' + optionVal + '&keyword=' + keyword;
		}
	}
}
