<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TeenCoder 게시판</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/reset.css">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/common.css">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/board.css">
</head>
<body>
	<!-- Header -->
	<jsp:include page="/jsp/template/header.jsp" flush="false" />

	<!-- Contents -->
    <div id="contents">
        <div id="contents_title">
            <h1>커뮤니티</h1>
            <h2>커뮤니티를 통해 IT 정보를 공유하고 소통할 수 있습니다.</h2>
        </div>
        <div id="contents_detail">
            <div id="contents_wrap">
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
                        <h2>Community</h2>
                        <ul id="board_list_menu" class="side_menu">
                            <li><a href="#" class="select">최신순</a></li>
                            <li><a href="#">조회순</a></li>
                            <li><a href="#">추천순</a></li>
                            <li><a href="#">댓글순</a></li>
                        </ul>
                    </div>
                    <!-- Search -->
                    <div id="board_list_search">
                        <select class="dropdown">
                            <option value="all" selected>전체</option>
                            <option value="title">제목</option>
                            <option value="content">내용</option>
                            <option value="name">작성자</option>
                        </select>
                        <div class="search">
                            <input type="text" placeholder="검색">
                            <button class="btn_search"></button>
                        </div>
                    </div>
                	<!-- List Row -->
                    <div id="board_list_row">
                        <!-- Row1 -->
                        <div class="row">
                            <div class="row_info">
                                <ul class="row_top tag_category">
                                    <li>#HTML</li>
                                    <li>#CSS</li>
                                    <li>#JS</li>
                                    <li>#Java</li>
                                    <li>#C</li>
                                    <li>#Python</li>
                                    <li>#SQL</li>
                                </ul>
                                <div class="row_top member">
                                    <h4>
                                        <img src="<%= request.getContextPath() %>/images/icon/icon_badge.png" class="i_badge">
                                        <span class="rank">[Expert]</span>TeenCoder
                                    </h4>
                                </div>
                                <span class="row_top date">2022-05-10</span>
                                <ul class="row_top number">
                                    <li><img src="<%= request.getContextPath() %>/images/icon/icon_hit.svg" class="i_hit">0</li>
                                    <li><img src="<%= request.getContextPath() %>/images/icon/icon_comment.svg" class="i_cmt">0</li>
                                    <li><img src="<%= request.getContextPath() %>/images/icon/icon_like.svg" class="i_like">0</li>
                                </ul>
                            </div>
                            <div class="row_title">
                                <h3>
                                    <a href="<%= request.getContextPath() %>/jsp/board/boardDetail.jsp">
                                        <span class="tag_hit">[추천]</span>
                                        HTML / CSS 학습 중 궁금한 점이 있습니다.
                                        <img src="<%= request.getContextPath() %>/images/icon/icon_image.svg" class="i_image">
                                        <img src="<%= request.getContextPath() %>/images/icon/icon_file.svg" class="i_file">
                                    </a>
                                </h3>
                            </div>
                        </div>
                        <hr>
                    </div>
                    <!-- Pagination -->
                    <div id="board_list_pagination">
                        <ul>
                            <li class="prev"><a href="#"></a></li>
                            <li><a href="#" class="select">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li class="next"><a href="#"></a></li>
                        </ul>
                    </div>
                </div>
                <!-- Member Info -->
                <div id="member_info">
                    <a href="<%= request.getContextPath() %>/jsp/board/boardWrite.jsp" class="btn_com btn_main">게시글 작성</a>
                    <div class="mycard"></div>
                </div>
            </div>
        </div>
    </div>
    
	<!-- Footer -->
	<jsp:include page="/jsp/template/footer.jsp" flush="false" />
</body>
</html>