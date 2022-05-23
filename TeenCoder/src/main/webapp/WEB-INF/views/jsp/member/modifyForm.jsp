<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TeenCoder 회원정보 수정</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/reset.css">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/common.css">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/memberForm.css">
</head>
<body>
	<!-- Header -->
	<jsp:include page="/jsp/template/header.jsp" flush="false" />

	<!-- Contents -->
	<div id="contents">
        <div id="contents_title">
            <h1>회원정보 수정</h1>
            <h2>회원정보를 수정할 수 있습니다.</h2>
        </div>
        <div id="contents_detail">
            <!-- Form -->
            <form id="join_form" class="modify_form">
                <table>
                	<tbody>
	                    <tr>
	                        <th>아이디</th>
	                        <td>
	                            TeenCoder
	                            <%-- <%= request.getParameter("id") %> --%>
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>비밀번호</th>
	                        <td>
	                            <input type="password" name="password" placeholder="비밀번호">
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>비밀번호 확인</th>
	                        <td>
	                            <input type="password" name="password2" placeholder="비밀번호 확인">
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>이름</th>
	                        <td>
	                            TeenCoder
	                            <%-- <%= request.getParameter("name") %> --%>
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>닉네임</th>
	                        <td>
	                        	TeenCoder
	                            <%-- <%= request.getParameter("nick") %> --%>
	                        </td>
	                    </tr>
	                    <tr class="check">
	                        <th>이메일</th>
	                        <td>
	                            <input type="text" name="email" placeholder="이메일">
	                            <input type="submit" value="인증" class="btn_com btn_check">
	                        </td>
	                    </tr>
	                    <tr class="checkbox">
	                        <th>개발직군 유무</th>
	                        <td>
	                            <input type="checkbox" name="dev" value="yes" id="yes">
	                            <label for="yes">네</label>
	                            <input type="checkbox" name="dev" value="no" id="no">
	                            <label for="no">아니오</label>
	                            <input type="submit" value="인증" class="btn_com btn_check">
	                        </td>
	                    </tr>
                    </tbody>
                </table>
                <div id="btn_wrap">
                    <input type="button" value="취소" class="btn_com btn_main" onClick="location.href='loginForm.jsp'">
                    <input type="submit" value="수정" class="btn_com btn_main">
                </div>
            </form>
        </div>
    </div>
    
	<!-- Footer -->
	<jsp:include page="/jsp/template/footer.jsp" flush="false" />
</body>
</html>