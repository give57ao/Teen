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

// 마이카드 탭 전환
$(window).on('load', function() {
	$('.card_tap li:nth-child(1) a').addClass('active');
	$('.tap_c').hide();
	$('.tap_board').show();
	
	// 글
	$('.card_tap li:nth-child(1) a').click(function() {
		$('.card_tap li a').removeClass('active');
		$('.tap_c').hide();
		$(this).addClass('active');
		$('.tap_board').show();
	})
	
	// 쪽지
	$('.card_tap li:nth-child(2) a').click(function() {
		$('.card_tap li a').removeClass('active');
		$('.tap_c').hide();
		$(this).addClass('active');
		$('.tap_message').show();
	})
	
	// 팔로잉
	$('.card_tap li:nth-child(3) a').click(function() {
		$('.card_tap li a').removeClass('active');
		$('.tap_c').hide();
		$(this).addClass('active');
		$('.tap_follow').show();
	})
	
	// 스크랩
	$('.card_tap li:nth-child(4) a').click(function() {
		$('.card_tap li a').removeClass('active');
		$('.tap_c').hide();
		$(this).addClass('active');
		$('.tap_scrap').show();
	})
});


// 쪽지, 팔로잉, 스크랩 리스트 클릭 시 비활성화
$(function() {
	$('.tap_list li').click(function() {
		$(this).addClass('active');
	});
});