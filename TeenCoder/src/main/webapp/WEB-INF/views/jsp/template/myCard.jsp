<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<body>
<%
int member_no = (Integer)session.getAttribute("member_no");
%>
<input type="hidden" id="member_no" name="member_no" value="<%=member_no %>">
<form id="myCard" name="myCard">
	<div id="my_card">
		<div class="my_card_wrap">
			<!-- Info -->
			<c:forEach items="${list}" var="my">
				<img src="/teen/resources/images/icon/icon_badge.png" class="card_badge">
				<div class="card_info_box">
					<h4>나의 등급 <span class="rank"></span></h4>
					<h3>${my.member_nick}</h3>
					<p>포인트 ${my.member_point}p</p>
				</div>
			 </c:forEach>
			
				<ul class="card_info_icon number" id="test">
	                <li><a href="#"><img src="/teen/resources/images/icon/icon_message.svg" class="i_msg">쪽지 0</a></li>
	                <li><a href="#"><img src="/teen/resources/images/icon/icon_follow.svg" class="i_follow">${allFollowCount}개</a></li>
	                <li><a href="#"><img src="/teen/resources/images/icon/icon_scrap.svg" class="i_scrap">${allScrapCount}개 </a></li>
	            </ul>
		</div>
		
        <!-- Tab -->
        <ul class="card_tap">
        	<li><a>글</a></li>
        	<li><a>쪽지</a></li>
        	<li><a>팔로잉</a></li>
        	<li><a>스크랩</a></li>
        </ul>
        <div class="card_tap_contents">
        
        	<!-- Tab: Board -->
            <div class="tap_c tap_board">
	           	<ul>
					<li>내가 작성한 게시글<a href="/teen/member/boardList">${allBoardCount}개</a></li>
	              	<li>내가 작성한 댓글<a href="/teen/member/commentList">${allCommentCount}개</a></li>
				</ul>
            </div>
            
            <!-- Tab: Message -->
            <div class="tap_c tap_message">
            	<div class="tap_side_menu tap_wrap">
            		<ul class="side_menu">
	            		<li><a href="#">전체</a></li>
	            		<li><a href="#">받은쪽지</a></li>
	            		<li><a href="#">보낸쪽지</a></li>
	            	</ul>
	            	<input type="button" name="del_all" value="전체삭제">
	           	</div>
	           	<ul class="tap_list">
	           		<!-- 반복문 필요 부분 -->
	           		<c:forEach items="${recvChatList}" var="chat">
	           		<li class="tap_wrap">
	           			<div class="view_active">
		           			<div class="tap_list_top tap_overtext">
		            			<h4 class="row_top"><span class="rank">[Expert]</span> ${chat.send_nick }</h4>
		            			<span class="row_top date">2022-06-22</span>
		           			</div>
		           			<p class="tap_overtext">쪽지가 도착하였습니다. 쪽지가 도착하였습니다.</p>
	           			</div>
	           			<div class="tap_list_del">
	           				<a href="#"><img src="/teen/resources/images/icon/icon_delete.svg"></a>
	           			</div>
	           		</li>
	           		</c:forEach>
	           	</ul>
            </div>
            
            <!-- Tab: Follow -->
            <div class="tap_c tap_follow">
            	<ul class="tap_list">
	           		<!-- 반복문 필요 부분 -->
	           		<c:forEach items="${followList }" var="follow" >
	           		<c:choose>
	           		<c:when test="${follow.follow_no eq sessionScope.member_no}">
	           		<li class="tap_wrap">
	           			<div class="view_active">
		           			<div class="tap_list_top tap_overtext">
		            			<h4 class="row_top"><span class="rank">[Expert]</span> ${follow.follow_nick}</h4>
		            			<span class="row_top date"><fmt:formatDate value="${follow.follow_date}" pattern="yyyy.MM.dd"/></span>
		           			</div>
		           			<p class="tap_overtext">${follow.follow_nick }님을 팔로우 했습니다.</p>
	           			</div>
	           			<div class="tap_list_del">
	           				<a href="#"><img src="/teen/resources/images/icon/icon_delete.svg"></a>
	           			</div>
	           		</li>
	           		</c:when>
	           		<c:when test="${follow.follow_no ne sessionScope.member_no}">
	           		<li class="tap_wrap">
	           			<div class="view_active">
		           			<div class="tap_list_top tap_overtext">
		            			<h4 class="row_top"><span class="rank">[Expert]</span> ${follow.member_nick }</h4>
		            			<span class="row_top date"><fmt:formatDate value="${follow.follow_date}" pattern="yyyy.MM.dd"/></span>
		           			</div>
		           			<p class="tap_overtext">${follow.member_nick }님이 회원님을 팔로우 했습니다.</p>
	           			</div>
	           		</li>
	           		</c:when>
	           		<c:otherwise>
	           		팔로우한 회원이 없습니다.
	           		</c:otherwise>
	           		</c:choose>
	           		</c:forEach>
	        	</ul>
            </div>
            
            <!-- Tab: Scrap -->
            <div class="tap_c tap_scrap">
            	<ul class="tap_list">
	           		<!-- 반복문 필요 부분 -->
	           		<c:forEach items="${scrapList }" var="scrap" >
	           		<li class="tap_wrap">
	           			<div class="view_active">
		           			<div class="tap_list_top tap_overtext">
		            			<h4 class="row_top"><span class="rank">[Expert]</span> ${scrap.member_nick }</h4>
		            			<span class="row_top date"><fmt:formatDate value="${scrap.scrap_date}" pattern="yyyy.MM.dd"/></span>
		           			</div>
		           			<a class="overtext" href="/teen/board/detail?board_no=${scrap.board_no}"> 
		           			${scrap.board_title }
		           			</a>
	           			</div>
	           			<div class="tap_list_del">
	           				<a href="#" onclick="deleteScrap(${scrap.scrap_no})"><img src="/teen/resources/images/icon/icon_delete.svg"></a>
	           			</div>
	           		</li>
	           		</c:forEach>
	        	</ul>
            </div>
        </div>
        
		<div class="my_card_wrap">
			<a href="/teen/member/" class="btn_com btn_mypage">마이페이지</a>
		</div>
	</div>
</form>
<script type="text/javascript">
function deleteScrap(num) {
	var chk = confirm("해당 게시물 스크랩을 취소하시겠습니까?")
	if(chk) {
		location.href='/teen/scrap/deleteCardScrap?scrap_no='+num
		location.reload(true);
	}
}
</script>
</body>
</html>  