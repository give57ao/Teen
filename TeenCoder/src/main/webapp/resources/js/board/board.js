// 게시글 리스트로 이동
function goBoard() {
	location.href = "/teen/board?board_group_no=1";
}

// 게시글 작성
var files_count = 1;

$(document).ready(function() {
	$("#addFile").on("click", function(e) {
		e.preventDefault();
		fn_addFile();
	});
	
	$("a[name='deleteFile']").on("click", function(e) {
		e.preventDefault();
		fn_deleteFile($(this));
	});
	
	$('#summernote').summernote();
});

// 파일 추가
function fn_addFile() {
	var str = "<tr><th></th><td><div><label class='btn_com btn_sel_file' for='file'>파일 선택</label><input type='file' id='file' name='file_"+(files_count++)+"'/><a href='#this' class='btn_com btn_del_file' id='deleteFile'>파일 삭제</a></div></td></tr>";
	
	$("#fileDiv").after(str);
	$("a[id='deleteFile']").on("click", function(e) {
		e.preventDefault();
		fn_deleteFile($(this));
	});
}

// 파일 삭제
function fn_deleteFile(obj){
	obj.parent().remove();
}