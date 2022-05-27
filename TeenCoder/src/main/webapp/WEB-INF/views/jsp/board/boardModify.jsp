<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TeenCoder 게시글 수정</title>
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
                <!-- Category -->
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
                <!-- Board -->
                <div id="board_list">
                    <!-- Title -->
                    <div id="board_list_title">
                        <h2>게시글 수정</h2>
                    </div>
                    <!-- Form -->
                    <form id="board_form">
		                <table>
		                	<tbody>
			                    <tr>
			                        <th>카테고리</th>
			                        <td>
			                            <select class="dropdown">
			                            	<option value="html" selected>HTML</option>
				                            <option value="css">CSS</option>
				                            <option value="js">JS</option>
				                            <option value="java">Java</option>
				                            <option value="c">C</option>
				                            <option value="python">Python</option>
				                            <option value="sql">SQL</option>
				                        </select>
			                        </td>
			                    </tr>
			                    <tr>
			                        <th>제목</th>
			                        <td>
			                           <input type="text" name="title" placeholder="제목"> 
			                        </td>
			                    </tr>
			                    <tr>
			                        <th>내용</th>
			                        <td>
			                            <textarea name="contents" placeholder="내용"></textarea>
			                        </td>
			                    </tr>
			                    <tr class="checkbox">
			                        <th>태그</th>
			                        <td>
			                            <input type="checkbox" name="lang" value="html" id="html">
			                            <label for="html">HTML</label>
			                            <input type="checkbox" name="lang" value="css" id="css">
			                            <label for="css">CSS</label>
			                            <input type="checkbox" name="lang" value="js" id="js">
			                            <label for="js">JS</label>
			                            <input type="checkbox" name="lang" value="java" id="java">
			                            <label for="java">Java</label>
			                            <input type="checkbox" name="lang" value="c" id="c">
			                            <label for="c">C</label>
			                            <input type="checkbox" name="lang" value="python" id="pyton">
			                            <label for="python">Python</label>
			                            <input type="checkbox" name="lang" value="sql" id="sql">
			                            <label for="sql">SQL</label>
			                        </td>
			                    </tr>
			                    <tr class="file_upload">
			                        <th>첨부파일</th>
			                        <td>
			                            <input type="file" name="file_add" value="파일 추가" class="btn_add_file">
			                            <input type="button" name="file_del" value="파일 삭제" class="btn_com btn_del_file">
			                        </td>
			                    </tr>
		                    </tbody>
		                </table>
		                <div id="btn_wrap">
		                    <input type="submit" value="게시글 수정" class="btn_com btn_main">
		                    <input type="button" value="취소" class="btn_com btn_main" onClick="location.href='mainBoard.jsp'">
		                </div>
		            </form>
                </div>
                <!-- Member Info -->
                <div id="member_info">
                    <a href="/teen/resources/jsp/board/boardWrite.jsp" class="btn_com btn_main">게시글 작성</a>
                    <div class="mycard"></div>
                </div>
            </div>
        </div>
    </div>
    
	<!-- Footer -->
	<jsp:include page="../template/footer.jsp" flush="false" />
</body>
</html>