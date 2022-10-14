<%@page import="dto.qa"%>
<%@page import="dto.BoardFile"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%	qa viewBoard = (qa) request.getAttribute("viewBoard"); %>
<%	BoardFile boardFile = (BoardFile) request.getAttribute("boardFile"); %>

<%@ include file="../layout/header.jsp" %>

<script type="text/javascript">
$(document).ready(function() {
	
	
	//목록 버튼
	$("#btnList").click(function() { 
		$(location).attr('href', '/qa'); 
	})

	//수정 버튼
	$("#btnUpdate").click(function() {
		
		$(location).attr('href', './update?boardno=<%=viewBoard.getBoardno() %>');
	})

	//삭제버튼
	$("#btnDelete").click(function() {
		$(location).attr('href', './delete?boardno=<%=viewBoard.getBoardno() %>');
	})

})
</script>

<style type="text/css">
#view{
    position: absolute;
    top: 55%;
    left: 50%;
    transform: translate(-50%,-50%);
    width: 800px;
}
</style>



<div id= "view">
<table class="table table-bordered">

<tr>
<td class="info">글번호</td><td><%=viewBoard.getBoardno() %></td>
<td class="info">작성일</td><td><%=viewBoard.getWritedate()%></td>
</tr>

<tr>
<td class="info">제목</td><td colspan="3"><%=viewBoard.getTitle() %></td>
</tr>

<tr>
<td class="info">아이디</td><td><%=viewBoard.getUserid() %></td>
<td class="info">닉네임</td><td><%=request.getAttribute("writerNick") %></td>
</tr>

<tr>
<td class="info">조회수</td><td colspan="3"><%=viewBoard.getHit() %></td>
</tr>

<tr>
<td class="info" colspan="4">본문</td>
</tr>
<tr><td colspan="4"><%=viewBoard.getContent() %></td></tr>

</table>

<!-- 첨부파일 -->
<div>
<%	if( boardFile != null ) { %>
<a href="<%=request.getContextPath() %>/upload/<%=boardFile.getStoredname() %>"
 download="<%=boardFile.getOriginname() %>">S
	<%=boardFile.getOriginname() %>
</a>
<%	} %>
</div>

<div class="text-center">
	<button id="btnList" class="btn btn-primary">목록</button>
	<button id="btnUpdate" class="btn btn-info">수정</button>
	<button id="btnDelete" class="btn btn-danger">삭제</button>
</div>
</div>














