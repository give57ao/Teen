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
					},
					onPaste: function (e) {
						var clipboardData = e.originalEvent.clipboardData;
						if (clipboardData && clipboardData.items && clipboardData.items.length) {
							var item = clipboardData.items[0];
							if (item.kind === 'file' && item.type.indexOf('image/') !== -1) {
								e.preventDefault();
							}
						}
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
			contentType : false,
			processData : false,
			success : function(data) {
            	//항상 업로드된 파일의 url이 있어야 한다.
				$(editor).summernote('insertImage', data.url);
			}
		});
	}		
	}
	);

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