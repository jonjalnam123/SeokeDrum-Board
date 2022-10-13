<%@page import="dto.qa"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ include file="/layout/header.jsp"%>

<%	List<qa> qaList = (List) request.getAttribute("qaList"); %>


<title>Q&A</title>
</head>
<body>

<h1>게시판</h1>

<table>
<tr>
	<th>글번호</th>
	<th>제목</th>
	<th>내용</th>
	<th>작성일</th>
</tr>

<%	for(int i=0; i<qaList.size(); i++) { %>
<tr>
	<td><%=qaList.get(i).getBoardno() %></td>
	<td><%=qaList.get(i).getTitle() %></td>
	<td><%=qaList.get(i).getContent() %>
	<td><%=qaList.get(i).getWritedate() %></td>
</tr>

<%	} %>
</table>

</body>
</html>