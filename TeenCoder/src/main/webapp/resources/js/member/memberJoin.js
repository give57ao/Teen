
$(function() {
$('#join_form').submit(function() {
		var captcha = 1;
		$.ajax({
            url: '/teen/member/VerifyRecaptcha',
            dataType : 'json',
            type: 'post',
            data: {
                recaptcha: $('.g-recaptcha-response').val()
            },
            success: function(data) {
                if(data = 0){
				alert("자동 가입 방지 봇 통과");
				captcha = 0;
				return true;
				}else if(data = 1){
				alert("자동 가입 방지 봇을 확인 한뒤 진행 해 주세요.");
				return false;
				}else{
				alert("자동 가입 방지 봇을 실행 하던 중 오류가 발생 했습니다. [Error bot Code : " + Number(data) + "]");
                return false;	
				}
                             
            }
        });
		if(captcha != 0) {
			return false;
		} 
});
});