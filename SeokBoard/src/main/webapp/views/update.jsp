<%@page import="dto.qa"%>
<%@page import="dto.BoardFile"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/layout/header.jsp" %>

<%	qa updateBoard = (qa) request.getAttribute("updateBoard"); %>
<%	BoardFile boardFile = (BoardFile) request.getAttribute("boardFile"); %>

<!-- 스마트 에디터2 설치 -->
<script type="text/javascript" src="/resources/se2/js/service/HuskyEZCreator.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	
	//작성버튼
	$("#btnUpdate").click(function() {
		
		//작성된 내용을 <textarea>에 적용하기
		updateContents()

		$("form").submit();
	})
	
	//취소버튼
	$("#btnCancel").click(function() {
		history.go(-1)
	})
	
	//파일이 없을 경우
	if(<%=boardFile != null %>) {
		$("#beforeFile").show();
		$("#afterFile").hide();
	}
	
	//파일이 있을 경우
	if(<%=boardFile == null %>) {
		$("#beforeFile").hide();
		$("#afterFile").show();
	}
	
	//파일 삭제 버튼(X) 처리
	$("#delFile").click(function() {
		$("#beforeFile").toggle();
		$("#afterFile").toggle();
	})
	
})

function updateContents() {
	
	//스마트 에디터에 작성된 내용을 #content에 반영한다
	oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", [])
	
}

</script>

<style type="text/css">
#update {

    position: absolute;
    top: 55%;
    left: 50%;
    transform: translate(-50%,-50%);
    width: 800px;

}

</style>


<div id="update">
<form action="./update" method="post" enctype="multipart/form-data">

<input type="hidden" name="boardno" value="<%=updateBoard.getBoardno() %>">

<table class="table table-bordered">
<tr><td class="info" style="background-color:silver;">아이디</td><td><%=updateBoard.getUserid() %></td></tr>
<tr><td class="info" style="background-color:silver;">닉네임</td><td><%=request.getAttribute("writerNick") %></td></tr>
<tr><td class="info" style="background-color:silver;">제목</td><td><input type="text" name="title" style="width:100%;" value="<%=updateBoard.getTitle() %>"></td></tr>
<tr><td class="info" colspan="2" style="background-color:silver;">본문</td></tr>
<tr><td colspan="2"><textarea id="content" name="content" style="width: 100%;"><%=updateBoard.getContent() %></textarea></td></tr>
</table>

<!-- 첨부파일 -->

<div>

<div id="beforeFile">
	<%	if( boardFile != null ) { %>
	<a href="<%=request.getContextPath() %>/upload/<%=boardFile.getStoredname() %>"
	 download="<%=boardFile.getOriginname() %>">
		<%=boardFile.getOriginname() %>
	</a>
	<span id="delFile" style="color: red; font-weight: bold; cursor: pointer;">X</span>
	<%	} %>
</div>

<div id="afterFile">
	새 첨부파일 <input type="file" name="file">
</div>

</div>

</form>

<div class="text-center">
	<button id="btnUpdate" class="btn btn-primary">수정</button>
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


























