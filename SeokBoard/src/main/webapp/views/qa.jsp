<%@page import="dto.qa"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ include file="/layout/header.jsp"%>

<%	List<qa> qaList = (List) request.getAttribute("qaList"); %>


<title>Q&A</title>
<style type="text/css">
th, td {
	text-align: center;
}
td:nth-child(2) {
	text-align: justify;
}
</style>

<script type="text/javascript">
$(document).ready(function() {
	$("#btnWrite").click(function() {
		location.href = "/seok/write"
	})
})
</script>

<style type="text/css">

#list {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%,-50%);
    text-align: center;
}

</style>

<div id="list">
<table class="table table-striped table-hover table-condensed">
<tr>
	<th style="width: 15%">글번호</th>
	<th style="width: 30%">제목</th>
	<th style="width: 20%">아이디</th>
	<th style="width: 15%">조회수</th>
	<th style="width: 20%">작성일</th>
</tr>

<%	for(int i=0; i<qaList.size(); i++) { %>
<tr>
	<td><%=qaList.get(i).getBoardno() %></td>
	<td>
		<a style="color:gray;" href="/seok/view?boardno=<%=qaList.get(i).getBoardno() %>">
			<%=qaList.get(i).getTitle() %>
		</a>
	</td>
	<td><%=qaList.get(i).getUserid() %></td>
	<td><%=qaList.get(i).getHit() %></td>
	<td><%=qaList.get(i).getWritedate()%></td>
</tr>
<%	} %>
</table>

<div id="btnBox" class="pull-right">
	<button id="btnWrite" class="btn btn-primary">글쓰기</button>
</div>

<div class="clearfix"></div>
</div>