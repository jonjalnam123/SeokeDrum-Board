<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/layout/header.jsp"%>

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

#vid{
	position: absolute;
    top: 60%;
    left: 50%;
    transform: translate(-50%,-50%);
    text-align: center;
}

/* 메인 메뉴의 항목 */
ul.nav>li {
	/* 수평으로 일렬 배치하기  */
	float: left;
	line-height: 40px;
	width: 200px;
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

<%	if( session.getAttribute("login") == null ) { %>
	<ul class="nav">
		<li><a href="/seok/intro">Introduce</a></li>

		<li><a href="/seok/notice">Notice</a></li>

		<li><a href="/seok/cont">Contact</a></li>
		
		<li><a href="/seok/join">Join</a></li>	
		
		<li><a href="/seok/login">Login</a></li>	
		
		<li><a href="/seok/domain">Go Main</a></li>
	</ul>
<%	} %>

<%	if( session.getAttribute("login") != null && (boolean) session.getAttribute("login") ) { %>
	<ul class="nav">
		<li><a href="/seok/intro">Introduce</a></li>

		<li><a href="/seok/notice">Notice</a></li>
		
		<li><a href="/qa">Community</a></li>

		<li><a href="/seok/cont">Contact</a></li>
		
		<li><a href="/seok/logout">Logout</a></li>
		
		<li><a href="/seok/domain">Go Main</a></li>
	</ul>
<%	} %>

<div id= "vid">
<iframe width="560" height="315" src="https://www.youtube.com/embed/J96xvH723_g" title="YouTube video player" 
frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>


</body>
</html>



