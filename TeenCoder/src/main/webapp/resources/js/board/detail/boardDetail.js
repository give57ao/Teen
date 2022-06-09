/*$(document).ready(function() {
	$("#comment_list .answer_list").hide();	
	
	$(".getAnswerBtn").click(function(){
		alert("클릭 됨");
		$(this).find("#comment_list .answer_list").toogle(500);
	})
})
*/

function dis(num) {
	console.log(num);
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
	
$("#btn_recommend").click(function() {
	if (confirm("해당 글을 추천하시겠습니까?")) {
		location.href="/teen/board/recommend"
		alert("해당 글을 추천하였습니다.")
	}
});