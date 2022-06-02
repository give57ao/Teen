// 파일을 찾기위한 주석문
//Id 찾기
function IdFormChk() {
	var in_name = document.getElementById("inName").value;
	var in_email = document.getElementById("inEmail").value;


	if (in_name == "") {
		alert("이름 입력");
		return false;
	}
	if (in_email == "") {
		alert("Email 입력");
		return false;
	}

	return true;
}

//Pw 찾기
function PwFormChk() {
	var in_id = document.getElementById("inId").value;
	var in_email = document.getElementById("inEmail").value;


	if (in_id == "") {
		alert("ID 입력");
		return false;
	}
	if (in_email == "") {
		alert("Email 입력");
		return false;
	}

	return true;
}