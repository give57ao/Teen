function checkOne(chk) {
	var obj = document.getElementsByName("member_pro_check");
	
	for(var i = 0; i<obj.length; i++) {
		if(obj[i] != chk) {
			obj[i].checked = false;
		}
	}
}

function checkValue() {
	var form = document.join_form;
	var test = $("input:checkbox[name='member_pro_check']").is(":checked");
	
	if(!form.member_pw.value) {
		alert("비밀번호를 입력하세요.");
		return false;
	}
	
	if(form.member_pw.value != form.member_pw1.value) {
		alert("동일한 비밀번호를 입력하세요.");
		return false;
	}
	
	if(!form.member_email.value) {
		alert("이메일을 입력하세요.");
		return false;
	}
	
	if(test == false) {
	alert("전문성 체크가 필요합니다.");
	return false;
	}	
	
			

	
}