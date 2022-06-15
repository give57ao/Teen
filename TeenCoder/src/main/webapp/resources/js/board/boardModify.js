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
		e.stopImmediatePropagation();
		fn_deleteFile($(this));
	});
	
	$('.summernote').summernote(
		{

				height: 300,                 // 에디터 높이
				minHeight: null,             // 최소 높이
				maxHeight: null,             // 최대 높이
				focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
				lang: "ko-KR",					// 한글 설정
				placeholder: '최대 2048자까지 쓸 수 있습니다',	//placeholder 설정
				callbacks: {	//여기 부분이 이미지를 첨부하는 부분 
					onImageUpload : function(files) {
						uploadSummernoteImageFile(files[0],this);
					}
					
				}
	});
        
        

	/**
	* 이미지 파일 업로드
	*/
	function uploadSummernoteImageFile(file, editor) {
		data = new FormData();
		data.append("file", file);
		$.ajax({
			data : data,
			type : "POST",
			url : "/teen/uploadSummernoteImageFile",
			cache : false,
			contentType : false,
			enctype : 'multipart/form-data',
			processData : false,
			success : function(url) {
            $(editor).summernote('insertImage', url, function($image) {
				$image.css('width', "25%");
			}
			
			);
			}
		});
	}		
	}
	);
/*============================================================================================================================*/
// 파일 추가
function fn_addFile() {
    var str = "<tr class='filerow'><th></th><td><input type='file' id='file' name='file"+(files_count++)+"'/><a href='#' class='btn_com btn_del_file' id='deleteFile'>파일 삭제</a></td></tr>";

    $("#fileDiv").after(str);
    $("a[id='deleteFile']").on("click", function(e) {
        e.preventDefault();
        fn_deleteFile($(this));
    });
}

var fileNoArry = new Array();
var fileNameArry = new Array();
function fn_del(value, name) {

	fileNoArry.push(value);
	fileNameArry.push(name);
	$("#fileNoDel").attr("value", fileNoArry);
	$("#fileNameDel").attr("value", fileNameArry);
}
 		
// 파일 삭제
function fn_deleteFile(obj){
    obj.parent().parent('.file_row').remove();
}

//글 수정 썸머노트 DB에서 데이터 불러오기
$(document).ready(function() {
		$('#content').summernote({
			height: 700,
			fontNames : [ '맑은고딕', 'Arial', 'Arial Black', 'Comic Sans MS', 'Courier New', ],
			fontNamesIgnoreCheck : [ '맑은고딕' ],
			focus: true
		});
	});	
