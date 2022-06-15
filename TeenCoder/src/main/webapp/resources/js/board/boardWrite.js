function checkValue() {
	var form = document.board_form;
	var test = $("input:checkbox[name='board_tag_name']").is(":checked");

	if(test == false) {
		alert("말머리 태그를 설정해 주세요.");
		return false;
	}
	

}