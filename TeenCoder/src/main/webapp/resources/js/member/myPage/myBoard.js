console.log("myBoard.js 진입");

function searchBoard(){

console.log('searchBoard() 진입');

var search = document.getElementById('search').value;
var keyword = document.getElementById('keyword').value;

console.log(search);
console.log(keyword);

//검색 내용 확인
if(keyword == null){
	alert('검색내용을 작성해주세요');
	return false;
}

location.href='boardList?search='+search+'&keyword='+keyword	




}
