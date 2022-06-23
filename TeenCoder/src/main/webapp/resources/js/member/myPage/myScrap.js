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
	location.href = '/teen/scrap/scrapList?search='+optionVal+'&keyword='+ keyword;
}


function deleteScrap(num) {
	var chk = confirm("해당 게시물 스크랩을 취소하시겠습니까?")
	if(chk) {
		location.href='/teen/scrap/deleteScrap?scrap_no='+num
	}
}