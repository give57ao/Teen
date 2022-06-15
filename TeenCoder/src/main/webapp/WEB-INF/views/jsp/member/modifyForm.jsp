<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TeenCoder 회원정보 수정</title>
<link rel="shortcut icon" href="/teen/resources/images/icon/icon_favicon.ico" type="image/x-icon"> <!-- favicon -->
<link rel="stylesheet" type="text/css" href="/teen/resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/common.css">
<link rel="stylesheet" type="text/css" href="/teen/resources/css/memberForm.css">
</head>
<body>
   <!-- Header -->
   <jsp:include page="../template/header.jsp" flush="false" />

   <!-- Contents -->
   <div id="contents">
        <div id="contents_title">
            <h1>회원정보 수정</h1>
            <h2>회원정보를 수정할 수 있습니다.</h2>
        </div>
        <div id="contents_detail">
            <!-- Form -->
            <form id="join_form" class="modify_form" method="post">
                <table>
                   <tbody>
                      <c:forEach var="member" items="${list}">
                          <tr>
                              <th>아이디</th>
                              <td>${member.member_id}</td>
                          </tr>
                          <tr>
                              <th>비밀번호</th>
                              <td>
                                  <input type="password" name="member_pw" placeholder="비밀번호">
                              </td>
                          </tr>
                          <tr>
                              <th>비밀번호 확인</th>
                              <td>
                                  <input type="password" name="member_pw1" placeholder="비밀번호 확인">
                              </td>
                          </tr>
                          <tr>
                              <th>이름</th>
                              <td>${member.member_name}</td>
                          </tr>
                          <tr>
                              <th>닉네임</th>
                              <td>${member.member_nick}</td>
                          </tr>
                          <tr class="check">
                              <th>이메일</th>
                              <td>
                                  <input type="text" name="member_email" placeholder="이메일" value="${member.member_email}">
                                  <input type="submit" value="인증" class="btn_com btn_check">
                              </td>
                          </tr>
                          <tr class="checkbox">
                              <th>개발직군 유무</th>
                              <td>
                                  <input type="button" value="인증" class="btn_com btn_check" onclick="goMail()">
                                  <input type="checkbox" name="member_pro_check" value="N" id="no">
                                  <label for="no">아니오</label>
                              </td>
                          </tr>
                       </c:forEach>
                    </tbody>
                </table>
                <div id="btn_wrap">
                    <input type="button" value="취소" class="btn_com btn_main" onClick="goMyPage()">
                    <input type="submit" value="수정" class="btn_com btn_main">
                </div>
            </form>
        </div>
    </div>
    
   <!-- Footer -->
   <jsp:include page="../template/footer.jsp" flush="false" />
   
   <!-- JS -->
   <script type="text/javascript" src="/teen/resources/js/member/member.js"></script>
</body>
</html>
