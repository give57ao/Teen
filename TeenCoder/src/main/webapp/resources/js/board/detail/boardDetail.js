
function fn_fileDown(fileNo) {
	var formObj = $("form[name='downFile']");
	$("#FILE_NO").attr("value", fileNo);
	formObj.attr("action", "/teen/board/downFile");
	formObj.submit();
}


$(document).ready(function() {
	$("#answerDiv0").hide();
	$("#answerDiv1").hide();
	
	$(".getAnswerBtn0").click(function() {
		$("#answerDiv0").toggle();
	})
	$(".getAnswerBtn1").click(function() {
		$("#answerDiv1").toggle();
	})
})




$("#btn_recommend").click(function() {
	if (confirm("해당 글을 추천하시겠습니까?")) {
		location.href="/teen/board/recommend"

		alert("해당 글을 추천하였습니다.")

	}
});
