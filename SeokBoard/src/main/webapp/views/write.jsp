<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ include file="/layout/header.jsp"%>    

<script type="text/javascript">
$(document).ready(function() {
	
	//작성버튼
	$("#btnWrite").click(function() {
		$("form").submit();
	})
	
	//취소버튼
	$("#btnCancel").click(function() {
		history.go(-1)
	})
	
})
</script>

<style type="text/css">
#write {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%,-50%);
    text-align: center;
    width: 500px;
    
}



</style>


<div id="write">
<form action="/seok/write" method="post">

<table class="table table-bordered">
<tr><td class="info">아이디</td><td><%=session.getAttribute("userid") %></td></tr>
<tr><td class="info">닉네임</td><td><%=session.getAttribute("usernick") %></td></tr>
<tr><td class="info">제목</td><td><input type="text" name="title" style="width:100%;"></td></tr>
<tr><td class="info" colspan="2">본문</td></tr>
<tr><td colspan="2"><textarea id="content" name="content" style="width: 100%;"></textarea></td></tr>
</table>

</form>

<div class="text-center">
	<button id="btnWrite" class="btn btn-primary">작성</button>
	<button id="btnCancel" class="btn btn-danger">취소</button>
</div>

</div>