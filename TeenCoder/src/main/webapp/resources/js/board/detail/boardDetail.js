//답글 작성 폼 생성/제거
function recomment(num){
	console.log('ref_step : '  + num);
	if ($('.answer_form-'+num).css('display') == 'none') {
		$('.answer_form-'+num).show();
    } else {
		$('.answer_form-'+num).hide();
    }
}

//댓글 접기 펼치기
function dis(num) {
	console.log('ref_step : '  + num);
	if ($('#comment_list .answer_list-'+num).css('display') == 'none') {
		$('#comment_list .answer_list-'+num).show();
    } else {
		$('#comment_list .answer_list-'+num).hide();
    }
}

function fn_fileDown(fileNo) {
	var formObj = $("form[name='downFile']");
	$("#FILE_NO").attr("value", fileNo);
	formObj.attr("action", "/teen/board/downFile");
	formObj.submit();
}

$("#btn_recommend").click(function() {
	if (confirm("해당 글을 추천하시겠습니까?")) {
		location.href="/teen/board/recommend"
		alert("해당 글을 추천하였습니다.")
	}
});