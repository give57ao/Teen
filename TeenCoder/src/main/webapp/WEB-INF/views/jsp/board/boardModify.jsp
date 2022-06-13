<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TeenCoder 게시글 작성</title>
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/common.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/board.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/boardForm.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/summernote.css">
<script>
  
</script>
</head>
<body>
	<!-- Header -->
	<jsp:include page="../template/header.jsp" flush="false" />

	<!-- Contents -->
    <div id="contents">
        <div id="contents_title">
            <h1>게시글 수정</h1>
            <h2>게시글을 수정할 수 있습니다.</h2>
        </div>
        <div id="contents_detail">
            <div id="contents_wrap">
                <!-- Board 작성 -->
                <div id="board_list">
                    <!-- Title -->
                    <div id="board_list_title">
                        <h2>게시글 수정</h2>
                    </div>
                    <!-- Form -->
                    <form id="board_form" method="post" enctype="multipart/form-data">
		                <table>
		                	<tbody>
			                    <tr>
			                        <th>카테고리</th>
			                        <td>
			                            <select class="dropdown" id="board_group_no" name="board_group_no">
			                            	<option value="1" selected>Community</option>
				                            <option value="2">Q&amp;A</option>
				                            <option value="3">Notice</option>
				                        </select>
			                        </td>
			                    </tr>
			                    <c:forEach items="${updateBoard}" var="updateBoard">
			                    <tr>
			                        <th>제목</th>
			                        <td>
			                           <input type="text" name="board_title" value="${updateBoard.board_title}" placeholder="제목"> 
			                        </td>
			                    </tr>
			                    <tr class="contents_title">
			                        <th>내용</th>
			                        <td >
			                            <textarea class="summernote" name="board_content" id="content" placeholder="내용">
			                            ${updateBoard.board_content}
			                            </textarea>
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
			                            <input type="checkbox" name="board_tag_name" value="JAVA" id="java">
			                            <label for="java">Java</label>
			                            <input type="checkbox" name="board_tag_name" value="C Language" id="c">
			                            <label for="c">C&nbsp;Language</label>
			                            <input type="checkbox" name="board_tag_name" value="PYTHON" id="python">
			                            <label for="python">Python</label>
			                            <input type="checkbox" name="board_tag_name" value="SQL" id="sql">
			                            <label for="sql">SQL</label>
			                            <input type="hidden" id="board_tag_name value" name="board_tag_name" value="${updateBoard.board_tag_name}">
			                        </td>
			                    </tr>
			                    </c:forEach>
			                    <tr id="fileDiv" class="file_upload">
			                        <th>첨부파일&nbsp;&nbsp;&nbsp;<a href="#this" class="btn_com btn_add_file" id="addFile" onclick="addFile()">+</a></th>
			                        <td>
			                        	<c:forEach var="file" items="${file}">
										<div id="fileGroup">
											<label class="btn_com btn_sel_file" for="file">파일 선택</label>
											<span><a href="#" onClick="fn_fileDown(${file.FILE_NO}); return false;">${file.ORG_FILE_NAME}</a>(${file.FILE_SIZE}kb)</span>
											 <input type="hidden" name="FILE_${file.FILE_NO}" value="true">
			                            	<input type="file" id="file" name="file_0">
			                            	<a href="#this" class="btn_com btn_del_file" id="deleteFile" name="deleteFile">파일 삭제</a>
				                        </div>
				                        </c:forEach>
			                        </td>
			                    </tr>
		                    </tbody>
		                </table>
		                <div id="btn_wrap">
		                	<input type="button" value="취소" class="btn_com btn_main" onClick="goBoard()">
		                    <input type="submit" value="게시글 작성" class="btn_com btn_main">
		                </div>
		            </form>
                </div>
            </div>
        </div>
    </div>
    
	<!-- Footer -->
	<jsp:include page="../template/footer.jsp" flush="false" />
	
	<!-- JS -->
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
	<script type="text/javascript" src="/teen/resources/js/board/board.js"></script>
	<script>
		const values = document.getElementsByName("board_tag_name");
		for (let i = 0; i < values.length; i++) {
			if (i == 1) {
				values[i].checked = true;
			}
		}
		
		$(document).ready(function() {
			        $("a[name='deleteFile']").on("click", function(e) {
			            e.preventDefault();
			            deleteFile($(this));
			        });
			    })
			
		function addFile() {
        var str = "<div id="fileGroup"><label class="btn_com btn_sel_file" for="file">파일 선택
				  <input type="file" id="file" name="file_0">
		<a href="#this" class="btn_com btn_del_file" id="deleteFile" name="deleteFile">파일 삭제</a></div></label>";
		
        $("#fileGroup").append(str);
        $("a[name='deleteFile']").on("click", function(e) {
            e.preventDefault();
            deleteFile($(this));
        });
    }
	</script>
</body>
</html>