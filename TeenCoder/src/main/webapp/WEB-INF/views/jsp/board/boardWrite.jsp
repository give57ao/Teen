<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TeenCoder 게시글 작성</title>
<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<link rel="stylesheet" type="text/css" href="/teen/resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/common.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/board.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/boardForm.css">
</head>
<body>
	<!-- Header -->
	<jsp:include page="../template/header.jsp" flush="false" />

	<!-- Contents -->
    <div id="contents">
        <div id="contents_title">
            <h1>커뮤니티</h1>
            <h2>커뮤니티를 통해 IT 정보를 공유하고 소통할 수 있습니다.</h2>
        </div>
        <div id="contents_detail">
            <div id="contents_wrap" class="">
                <!-- Category 좌측 화면 고정 카테고리------------------------------------------------>
                <ul id="contents_category">
                    <li><a href="#" class="select">COMMUNITY</a></li>
                    <li><a href="#">#HTML</a></li>
                    <li><a href="#">#CSS</a></li>
                    <li><a href="#">#JS</a></li>
                    <li><a href="#">#Java</a></li>
                    <li><a href="#">#C</a></li>
                    <li><a href="#">#Python</a></li>
                    <li><a href="#">#SQL</a></li>
                </ul>
                <!-- Category 좌측 화면 고정 카테고리 끝-->
                
                <!-- Board 작성 메인화면 시작------------------------------------------------------->
                <div id="board_list">
                    <!-- Title -->
                    <div id="board_list_title">
                        <h2>게시글 작성</h2>
                    </div>
                    <!-- Form -->
                    <form id="board_form" method="post" enctype="multipart/form-data" >
		                <table>
		                	<tbody>
			                    <tr>
			                        <th>카테고리</th>
			                        <td>
			                            <select class="dropdown" id="board_group_no" name="board_group_no">
			                            	<option value="1" selected>HTML</option>
				                            <option value="2">CSS</option>
				                            <option value="3">JS</option>
				                            <option value="4">Java</option>
				                            <option value="5">C</option>
				                            <option value="6">Python</option>
				                            <option value="7">SQL</option>
				                        </select>
			                        </td>
			                    </tr>
			                    <tr>
			                        <th>제목</th>
			                        <td>
			                           <input type="text" name="board_title" placeholder="제목"> 
			                        </td>
			                    </tr>
			                    <tr>
			                        <th>내용</th>
			                        <td>
			                            <textarea id="summernote" name="board_content" placeholder="내용"></textarea>
			                        </td>
			                    </tr>
			                    <tr class="checkbox">
			                        <th>태그</th>
			                        <td>
			                            <input type="checkbox" name="board_tag_name" value="HTML" id="html">
			                            <label for="html">HTML</label>
			                            <input type="checkbox" name="board_tag_name" value="CSS" id="css">
			                            <label for="css">CSS</label>
			                            <input type="checkbox" name="board_tag_name" value="JS" id="js">
			                            <label for="js">JS</label>
			                            <input type="checkbox" name="board_tag_name" value="Java" id="java">
			                            <label for="java">Java</label>
			                            <input type="checkbox" name="board_tag_name" value="C" id="c">
			                            <label for="c">C</label>
			                            <input type="checkbox" name="board_tag_name" value="Python" id="pyton">
			                            <label for="python">Python</label>
			                            <input type="checkbox" name="board_tag_name" value="SQL" id="sql">
			                            <label for="sql">SQL</label>
			                        </td>
			                    </tr>
			                    <tr class="file_upload">
			                        <th>첨부파일</th>
			                        <td>
			                            <input type="file" name="file" class="btn_add_file">
			                            <input type="button" name="file_del" value="파일 삭제" class="btn_com btn_del_file">
			                        </td>
			                    </tr>
		                    </tbody>
		                </table>
		                <div id="btn_wrap">
		                	<input type="button" value="취소" class="btn_com btn_main" onClick="location.href='mainBoard.jsp'">
		                    <input type="submit" value="게시글 작성" class="btn_com btn_main">
		                </div>
		            </form>
                </div>
                <!-- Member Info -->
                <div id="member_info">
                    <a href="/teen/board/boardWrite" class="btn_com btn_main">게시글 작성</a>
                    <div class="mycard"></div>
                </div>
            </div>
        </div>
    </div>
    
	<!-- Footer -->
	<jsp:include page="../template/footer.jsp" flush="false" />
	
<script type="text/javascript">
$(document).ready(function(){
	$('#summernote').summernote();
});
</script>
</body>
</html>