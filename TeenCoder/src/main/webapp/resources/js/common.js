// 로그인 화면으로 이동
function goLogin() {
	location.href = "/teen/member/login";
}

// 로그아웃
function logout() {
	alert("로그아웃하였습니다.");
}

// 헤더 네비게이션 메뉴 클릭 시 활성화
var url = window.location.href;
    
$(window).on('load', function() {
    $('#header_nav a').siblings('a').removeClass('active');
    
    if(url.indexOf('board_group_no=1') > -1) {
        $('#header_nav a').eq(1).addClass('active');
    } else if(url.indexOf('board_group_no=2') > -1) {
        $('#header_nav a').eq(2).addClass('active');
    } else if(url.indexOf('board/notice') > -1) {
        $('#header_nav a').eq(3).addClass('active');
    }
});