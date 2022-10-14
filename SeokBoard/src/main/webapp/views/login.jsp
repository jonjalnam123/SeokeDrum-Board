<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/layout/header.jsp"%>

<title>Insert title here</title>

<script type="text/javascript">
$(document).ready(function() {
	
	//아이디 입력창에 포커스주기
	$("input").eq(0).focus()
	
	//패스워드 입력창에 엔터키 입력 시 submit
	$("input").eq(1).keydown(function(e) {
		if( e.keyCode == 13 ) { //엔터키
			$("#btnLogin").click();
		}
	})
	
	//로그인 버튼
	$("#btnLogin").click(function() {
		$(this).parents("form").submit();
	})
	
	//취소 버튼
	$("#btnCancel").click(function() {
// 		history.go(-1) //뒤로가기
		$(location).attr('href', '/seok/main') //메인으로 가기
	})
})
</script>

<style type="text/css">

#login{
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%,-50%);
}


</style>
</head>
<body>

<form action="/seok/login" method="post">


<div id="login">
	<div>
		<label for="userid">아이디</label><br>
			<input type="text" id="userid" name="userid">
		
	</div>

	<div>
		<label for="userpw">패스워드</label><br>
			<input type="text" id="userpw" name="userpw">		
	</div><br>

	<div>
		<button type="button" class="btn btn-primary" id="btnLogin">로그인</button>
		<button type="button" class="btn btn-danger" id="btnCancel">취소</button>
	</div>
</div>
</form>

</body>
</html>

