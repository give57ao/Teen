function fn_fileDown(fileNo) {
	var formObj = $("form[name='downFile']");
	$("#FILE_NO").attr("value", fileNo);
	formObj.attr("action", "/teen/board/downFile");
	formObj.submit();
}

let subToggle = true;
$("#getAnswerBtn").click(() => {
	if (subToggle) {
		$("#answerDiv").slideDown(1000);
	} else {
		$("#answerDiv").slideUp(1000);
	}
	subToggle = !subToggle;
});

$("#btn_recommend").click(function() {
	if (confirm("해당 글을 추천하시겠습니까?")) {
		location.href="/teen/board/recommend"

		alert("해당 글을 추천하였습니다.")

	}
});
