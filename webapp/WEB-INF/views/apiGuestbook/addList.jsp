<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- css -->
<link href="${pageContext.request.contextPath }/assets/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/assets/css/guestbook.css" rel="stylesheet" type="text/css">


<!-- js -->
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.12.4.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/bootstrap/js/bootstrap.js"></script>

</head>

<body>
	<div id="wrap">

		<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
		<!-- //header -->

		<c:import url="/WEB-INF/views/includes/nav.jsp"></c:import>
		<!-- //nav -->
	
		<div id="container" class="clearfix">
			<div id="aside">
				<h2>방명록</h2>
				<ul>
					<li><a href="${pageContext.request.contextPath }/guestbook/addList">일반방명록</a></li>
					<li><a href="${pageContext.request.contextPath }/api/guestbook/addList">ajax방명록</a></li>
				</ul>
			</div>
			<!-- //aside -->

			<div id="content">
				
				<div id="content-head" class="clearfix">
					<h3>일반방명록</h3>
					<div id="location">
						<ul>
							<li>홈</li>
							<li>방명록</li>
							<li class="last">일반방명록</li>
						</ul>
					</div>
				</div>
				<!-- //content-head -->

				<div id="guestbook">
					<%-- <form action="${pageContext.request.contextPath }/api/guestbook/add" method="get"> --%>
						<table id="guestAdd">
							<colgroup>
								<col style="width: 70px;">
								<col>
								<col style="width: 70px;">
								<col>
							</colgroup>
							<tbody>
								<tr>
									<td><label class="form-text" for="input-uname">이름</label></td>
									<td><input id="input-uname" type="text" name="name"></td>
									<td><label class="form-text" for="input-pass">패스워드</label></td>
									<td><input id="input-pass"type="password" name="password"></td>
								</tr>
								<tr>
									<td colspan="4"><textarea name="content" cols="72" rows="5"></textarea></td>
								</tr>
								<tr class="button-area">
									<td colspan="4" class="text-center"><button id="btnSubmit" type="submit">등록</button></td>
								</tr>
							</tbody>
							
						</table>
						<!-- //guestWrite -->
						
					<!-- </form> -->
					
						
					<!-- 리스트영역 -->
					<div id="listArea">
					
					
					</div>
					
				</div>
				<!-- //guestbook -->
			
			</div>
			<!-- //content  -->
		</div>
		<!-- //container  -->

		<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
		<!-- //footer -->
	</div>
	<!-- //wrap -->

	<!-- *********************************************************** -->
	<!-- 삭제모달창 -->
	<div id="delModal" class="modal fade">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title">삭제</h4>
	      </div>
	      <div class="modal-body">
	        비밀번호<input type="text" name="password" value=""><br>
			<input type="text" name="no" value="" >


	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
	        <button id= "btnModalDelete" type="button" class="btn btn-danger">삭제</button>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
</body>
<script type="text/javascript">
//리스트요청
	$(document).ready(function(){
		console.log("jquery요청 진입")

	
	/*리스트요청*/
		$.ajax({//리스트오쳥+그리기
			
			url : "${pageContext.request.contextPath }/api/guestbook/list",		
			type : "post",
			//contentType : "application/json",
			//data : {name: ”홍길동"},
	
			dataType : "json",
			success : function(guestbookList){
				/*성공시 처리해야될 코드 작성*/
				//화면data + html 그린다
				for(var i = 0; i<guestbookList.length; i++){
					
					render(guestbookList[i]); // vo -> 그린다
					
				}
				
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});
	});	
	
	/* //테스트버튼 눌렀을 때
	$("#btnTest").on("click", function(){
		console.log("버튼클릭");
		
		$("#delModal").modal("show");
	});
	 */
	 
	 
	//삭제버튼 눌렀을 때
	$("#listArea").on("click",".btnDelete", function(){
		
		//this로 no값 불러오기
		var $this = $(this);
		var no = $this.data("no");
		
		
		//모달창에 값 입력
		$("#delMedal [name=password]").val("");
		$("[name=no]").val(no);
		
		
		$("#delModal").modal("show");
	 });
	 
	 //삭제확인을 눌렀을 때
	 $("#btnModalDelete").on("click", function(){
		
		// no랑 password 가져오기
		var no = $("#delModal [name=no]").val();
		var password = $("#delModal [name=password]").val();

		var guestbookVo = {};
		guestbookVo.no = no;
		guestbookVo.password = password;
		
		console.log(guestbookVo);
		
		//서버로 전송하기
		$.ajax({
		
			url : "${pageContext.request.contextPath }/api/guestbook/remove",		
			type : "post",
			//contentType : "application/json",
			data : guestbookVo,
	
			dataType : "json",
			success : function(result){
				/*성공시 처리해야될 코드 작성*/
				console.log(result);
				
				if(result == "success"){
					//테이블 삭제
					$("#t"+no+"").remove();
					//모달창 닫기
					$("delModal").modal("hide");
					
				}else{
					alert("비밀번호를 확인하세요");
				}
				
				
			
				
				
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});

		
		// 성공이면 삭제하고, 아니면 경고창 띄우기
		
		//모달창 닫기
		
		 
	 });
	 
	 
	
	 //저장버튼 눌렀을 때
	$("#btnSubmit").on("click", function(){
		
		console.log("저장클릭");
		//데이터수집
		var name = $("[name='name']").val();
		var password = $("[name='password']").val();
		var content = $("[name='content']").val();

		var guestVo = {
				name: name,
				password: password,
				content: content
		}
		
		$.ajax({
			
			//url : "${pageContext.request.contextPath }/api/guestbook/add?name="+name+"&password="+password+"&content="+content,		
			url : "${pageContext.request.contextPath }/api/guestbook/add",
			type : "post",
			//contentType : "application/json",
			data : guestVo,

			dataType : "json",
			success : function(result){
				/*성공시 처리해야될 코드 작성*/
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});
	});
		 
	
	
	function render(guestbookVo){
		console.log("render실행");

		//html문 작성
		var str = "";
		str += '<table id="t'+guestbookVo.no+'" class="guestRead">';
		str += '	<colgroup>';
		str += '		<col style="width: 10%;">';
		str += '		<col style="width: 40%;">';
		str += '		<col style="width: 40%;">';
		str += '		<col style="width: 10%;">';
		str += '	</colgroup>';
		str += '	<tr>';
		str += '		<td>'+guestbookVo.no+'</td>';
		str += '		<td>'+guestbookVo.name+'</td>';
		str += '		<td>'+guestbookVo.regDate+'</td>';
		str += '		<td><button class="btnDelete" type="button" data-no="'+guestbookVo.no+'">[삭제]</button></td>';
		str += '	</tr>';
		str += '	<tr>';
		str += '		<td colspan=4 class="text-left">'+guestbookVo.content+'</td>';
		str += '	</tr>';
		str += '</table>';
		
		
		$("#listArea").append(str); // 붙이기
		
	}
</script>

</html>