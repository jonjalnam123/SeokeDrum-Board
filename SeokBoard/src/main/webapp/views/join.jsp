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
 
 $(function(){
	$("#userid").on('keyup', chkId);
})
})



function chkId() {
    var id = $('#userid').val(); 
    
    $.ajax({
        url: '/check', //Controller에서 요청 받을 주소
        type: 'POST', //POST 방식으로 전달
        data: {
             "usereid": id
         },

        success: function(res) { //컨트롤러에서 넘어온 res값을 받는다 
            if (res == 0) { //res가 1이 아니면(0일 경우) -> 사용 가능한 아이디 
                $("#result").text("✔ 사용할 수 있는 아이디입니다").css("color", "#37a9f5");
                console.log(id);

            } else { // res가 1일 경우 -> 이미 존재하는 아이디
                $("#result").text("❌ 이미 존재하는 아이디입니다").css("color", "#e42f0a");
            } 
       	}
        });
}
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
<input type="text" name= "userid" id="userid"><p id="result">&nbsp;</p>

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