<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/assets/css/board.css" rel="stylesheet" type="text/css">

</head>


<body>
	<div id="wrap">

		<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
		<!-- //header -->

		<c:import url="/WEB-INF/views/includes/nav.jsp"></c:import>
		<!-- //nav -->

		<div id="container" class="clearfix">
			<c:import url="/WEB-INF/views/includes/boardAside.jsp"></c:import>
			<!-- //aside -->

			<div id="content">

				<div id="content-head">
					<h3>게시판</h3>
					<div id="location">
						<ul>
							<li>홈</li>
							<li>게시판</li>
							<li class="last">일반게시판</li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				<!-- //content-head -->
	
				<div id="board">
					<div id="list">
						<form action="search" method="get">
							<div class="form-group text-right">
								<input type="text" name=keyword>
								<button type="submit" id=btn_search>검색</button>
							</div>
						</form>
						<table >
							<thead>
								<tr>
									<th>번호</th>
									<th>제목</th>
									<th>글쓴이</th>
									<th>조회수</th>
									<th>작성일</th>
									<th>group_no</th>
									<th>order_no</th>
									<th>depth</th>
									<th>관리</th>
								</tr>
							</thead>
							<c:forEach items="${rboardList }" var="bList">
								<tbody>
									<tr>
										<td>${bList.no }</td>
										<td class="text-left"><a href="./read?no=${bList.no }">${bList.title }</a></td>
										<td>${bList.name }</td>
										<td>${bList.hit }</td>
										<td>${bList.regDate }</td>
										<td>${bList.groupNo }</td>
										<td>${bList.orderNo }</td>
										<td>${bList.depth }</td>
										<!-- 자신의 글에만 노출 -->
										<c:if test="${authUser.no == bList.userNo }">
											<td><a href="">[삭제]</a></td>
										</c:if>
										
									</tr>
								</tbody>
							</c:forEach>
						</table>
			
						<div id="paging">
							<ul>
								<li><a href="">◀</a></li>
								<li><a href="">1</a></li>
								<li><a href="">2</a></li>
								<li><a href="">3</a></li>
								<li><a href="">4</a></li>
								<li class="active"><a href="">5</a></li>
								<li><a href="">6</a></li>
								<li><a href="">7</a></li>
								<li><a href="">8</a></li>
								<li><a href="">9</a></li>
								<li><a href="">10</a></li>
								<li><a href="">▶</a></li>
							</ul>
							
							
							<div class="clear"></div>
						</div>
						<!-- 로그인 했을 때 만 노출 -->
						<%-- <c:if test="${authUser != null }">  --%>
							<a id="btn_write" href="${pageContext.request.contextPath}/rboard/writeForm">글쓰기</a>
						<%-- </c:if> --%>
					</div>
					<!-- //list -->
				</div>
				<!-- //board -->
			</div>
			<!-- //content  -->

		</div>
		<!-- //container  -->
		

		<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
		<!-- //footer -->
	</div>
	<!-- //wrap -->

</body>

</html>
