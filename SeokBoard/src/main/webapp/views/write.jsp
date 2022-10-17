<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ include file="/layout/header.jsp"%>    

<!-- 스마트 에디터2 설치 -->
<script type="text/javascript" src="/resources/se2/js/service/HuskyEZCreator.js"></script>

<script type="text/javascript">
$(document).ready(function() {
			//알림버튼
	$("#btnWrite").click(function() {
		alert("작성되었습니다!")
	})
	
	//작성버튼
	$("#btnWrite").click(function() {
		
		//작성된 내용을 <textarea>에 적용하기
		updateContents()

		$("form").submit();
	})
	

	
	//취소버튼
	$("#btnCancel").click(function() {
		history.go(-1)
	})
	
})

function updateContents() {
	
	//스마트 에디터에 작성된 내용을 #content에 반영한다
	oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", [])
	
}

</script>


<style type="text/css">

#write {


    position: absolute;
    top: 55%;
    left: 50%;
    transform: translate(-50%,-50%);
    width: 800px;
}

</style>

<div id = "write">
<form action="./write" method="post" enctype="multipart/form-data">

<table class="table table-bordered">
<tr><td class="info" style="background-color:silver;" >아이디</td><td><%=session.getAttribute("userid") %></td></tr>
<tr><td class="info" style="background-color:silver;">닉네임</td><td><%=session.getAttribute("usernick") %></td></tr>
<tr><td class="info" style="background-color:silver;">제목</td><td><input type="text" name="title" style="width:100%;"></td></tr>
<tr><td class="info" colspan="2" style="background-color:silver;">본문</td></tr>
<tr><td colspan="2" ><textarea id="content" name="content" style="width: 100%;"></textarea></td></tr>
</table>

첨부파일 <input type="file" name="file">

</form>

<div class="text-center">
	<button id="btnWrite" class="btn btn-primary">작성</button>
	<button id="btnCancel" class="btn btn-danger">취소</button>
</div>
</div>
<script type="text/javascript">
var oEditors = [];
nhn.husky.EZCreator.createInIFrame({
	oAppRef: oEditors,
	elPlaceHolder: "content", //에디터가 적용될 <textarea>의 id 적기
	sSkinURI: "/resources/se2/SmartEditor2Skin.html",
	fCreator: "createSEditor2"
})
</script>