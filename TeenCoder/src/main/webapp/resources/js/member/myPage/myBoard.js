console.log("myBoard.js 진입");

var params = {	
	"recent" : null, //document.getElementById("recent").value
	"view" : null, //document.getElementById("view").value
	"recommend" : null, //document.getElementById("recommend").value
	"comment" : null //document.getElementById("comment").value
};

function boardSearchRecent(){
	console.log("boardSearchRecent 실행");
	params.recent = document.getElementById("recent").value;
	console.log(params);
	
	$.ajax({ 
		url:"/teen/member/boardList/search", 
		type:"post", 
		dataType:"json", 
		data:params
	})
}




