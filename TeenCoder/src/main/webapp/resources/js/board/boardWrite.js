function checkValue() {
	var test = $("input:checkbox[name='board_tag_name']").is(":checked");

	if (test == false) {
		alert("말머리 태그를 설정해 주세요.");
		return false;
	}

	var ext = $('#file').val().split('.').pop().toLowerCase();
	if(ext != ""){ 
	if ($.inArray(ext, ['gif', 'png', 'jpg', 'jpeg', 'doc', 'docx', 'xls', 'xlsx', 'hwp', 'pdf', 'zip']) == -1) {
		alert(ext + ' 확장자는 업로드 할 수 없습니다.');
		$("#file").val("");
		return false;
	}
	
}else{
	return true;	
}
}
