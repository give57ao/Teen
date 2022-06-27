function readImage(input) {
	    // 인풋 태그에 파일이 있는 경우
	    if(input.files && input.files[0]) {
	        // FileReader 인스턴스 생성
	        const reader = new FileReader()
	        // 이미지가 로드가 된 경우
	        reader.onload = e => {
	            const previewImage = document.getElementById("preview-image")
	            previewImage.src = e.target.result
	        }
	        // reader가 이미지 읽도록 하기
	        reader.readAsDataURL(input.files[0])
	    }
	}
	// input file에 change 이벤트 부여
	const inputImage = document.getElementById("input-image")
	inputImage.addEventListener("change", e => {
	    readImage(e.target)
	})
	
	function checkValue() {

	var ext = $('#input-image').val().split('.').pop().toLowerCase();
	console.log(ext);
	if(ext == ""){
		alert("프로필을 선택해주세요");
		return false;
	}
	
	if ($.inArray(ext, ['jpg']) == -1) {
		alert(ext + ' 확장자는 업로드 할 수 없습니다.');
		$("#input-image").val("");
		return false;
	}


}
