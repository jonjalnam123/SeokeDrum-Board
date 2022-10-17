<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/layout/header.jsp"%>

<title>Insert title here</title>

<script type="text/javascript">

$(document).ready(function() {

$("#btnCancel").click(function() {
//		history.go(-1) //뒤로가기
	$(location).attr('href', '/seok/main') //메인으로 가기
 })
 
 	$("#joinok").click(function() {
		alert("회원가입 성공!")
	})
})

</script>


<style type="text/css">

#join {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}
</style>

</head>
<body>


<div id="join">
<form action="/seok/join" method="post">

<label for ="userid">아이디</label><br>
<input type="text" name= "userid" id="userid"><br>

<label for ="userpw">비밀번호</label><br>
<input type="text" name= "userpw" id="userpw"><br>

<label for ="usernick">닉네임</label><br>
<input type="text" name= "usernick" id="usernick"><br>

<button id="joinok" class="btn btn-primary">가입</button>
<button type="button" class="btn btn-danger" id="btnCancel">취소</button>

</form>
</div>
</body>
</html>