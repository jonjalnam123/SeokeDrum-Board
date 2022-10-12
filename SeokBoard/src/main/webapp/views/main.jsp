<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/layout/header.jsp"%>

<title>석이드럼 메인</title>

<style type="text/css">


ul.nav {
	/* ul태그의 기본 리스트스타일(disc) 제거  */
	list-style-type: none;
	/*가운데 정렬*/
	display: flex;
	justify-content: center;
	position: absolute;
    top: 20%;
    left: 50%;
    transform: translate(-50%,-50%);
    text-align: center;
}

/* 메인 메뉴의 항목 */
ul.nav>li {
	/* 수평으로 일렬 배치하기  */
	float: left;
	line-height: 40px;
}

ul.nav>li>a {
	text-decoration: none;
	font-family: fantasy;
	font-size: 150%;
	color: black;
	padding: 20px 50px;
}

ul.nav>li>a:hover {
	background-color: black;
	color: white;
	transition: 0.7s;
}
</style>

</head>
<body>


	<ul class="nav">
		<li><a href="/views/intro.jsp">Introduce</a></li>

		<li><a href="#">Notice</a></li>

		<li><a href="#">Q&A</a></li>

		<li><a href="#">Contact</a></li>
	</ul>

</body>
</html>