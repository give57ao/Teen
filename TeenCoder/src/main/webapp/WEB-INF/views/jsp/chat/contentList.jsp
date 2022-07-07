<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<c:forEach var="tmp" items="${clist }">
	
	<c:choose>
		<c:when test="${sessionScope.member_nick ne tmp.send_nick }">
		<!-- 받은 메세지 -->
		<div class="incoming_msg">
			<div class="incoming_msg_img">
					<a href="other_profile.do?other_nick=${tmp.send_nick }">
					 <c:choose>
							<c:when test="${tmp.member_profile eq 'N'}">
								<!-- 프로필 사진이 없을 경우 -->
								<img src="/teen/resources/images/icon/icon_profile.svg"
									class="badge">
							</c:when>
							<c:otherwise>
								<!-- 프로필 사진이 있을 경우 -->
								<img src="${path}${tmp.member_profile}" class="badge">
							</c:otherwise>
						</c:choose>
					</a>
				</div>
			<div class="received_msg">
				<div class="received_withd_msg">
					<p>${tmp.content }</p>
					<span class="time_date"> ${tmp.send_time }</span>
				</div>
			</div>
		</div>
		</c:when>
		
		<c:otherwise>
		<!-- 보낸 메세지 -->
		<div class="outgoing_msg">
			<div class="sent_msg">
				<p>${tmp.content }</p>
				<span class="time_date"> ${tmp.send_time }</span>
			</div>
		</div>
		</c:otherwise>
	</c:choose>


</c:forEach>