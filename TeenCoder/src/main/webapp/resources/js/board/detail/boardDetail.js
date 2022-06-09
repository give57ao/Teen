
function fn_fileDown(fileNo) {
	var formObj = $("form[name='downFile']");
	$("#FILE_NO").attr("value", fileNo);
	formObj.attr("action", "/teen/board/downFile");
	formObj.submit();
}


$(document).ready(function() {
	$(".answerDiv").hide();
	
	$(".getAnswerBtn").click(function() {
		$(".answerDiv").slideDown();
	})
})


$("#btn_delete").click(function(){
	var board_no = document.getElementById("board_no").value
		if(confirm("게시글을 삭제하시겠습니까?")){
			
			location.href="/teen/board/delete?board_no=" + board_no
			
			alert("게시글이 삭제되었습니다.")
		}
	});
