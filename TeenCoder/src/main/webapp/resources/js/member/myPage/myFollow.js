function searchBoard() {
	var keyword = document.getElementById('keyword').value;
	var selectedElement = document.getElementById("selectBoxTest");    
	var optionVal = selectedElement.options[selectedElement.selectedIndex].value; 
	console.log(keyword);
	// 검색 내용 확인 
	if (optionVal == '' || keyword == "") {
		alert('검색 설정을 확인 해주세요.');
		return false;
	}
	location.href = '/teen/follow/followList?search='+optionVal+'&keyword='+ keyword;
}




//팔로우 버튼 숨기기 보이기 기능
function dp_menu(){
	let click = document.getElementById("drop-content");
	if(click.style.display == "none"){
		click.style.display = "block";
		
	} else {
		click.style.display = "none";
	}
}
//팔로우 하기
function follow() {
	var member_nick = document.getElementById('member_nick').value;
	var member_no = document.getElementById('member_no').value;

	if(confirm("해당 유저를 팔로우 하시겠습니까?")){
	$.ajax({
		url : "/teen/follow/insertFollow",
		type : "post",
		dataType : "json",
		data : {member_no, member_nick},
		success : function(data) {
		if(data == 1){
			alert("해당 회원을 팔로우 목록에 추가하였습니다.");
		
		} else if(data == 0) {
			alert("이미 팔로우한 회원입니다.")
			}
		}
	});
	}
}

function deleteFollow(following_member_no) {
	var chk = confirm("해당 게시물 스크랩을 취소하시겠습니까?")
	if(chk) {
		location.href='/teen/follow/myFollowDelete?following_member_no='+following_member_no;
	}	
		
		/*if(confirm("해당 유저를 언팔하시겠습니까?")){
		$.ajax({
			url : "/teen/follow/myFollowDelete",
			type : "post",
			dataType : "json",
			data : {following_member_no},
			success : function() {
				
			}
		});
	}*/
}
	