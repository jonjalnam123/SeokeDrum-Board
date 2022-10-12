<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>석이드럼</title>

<style type="text/css">

*{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

#main img {
	width : 30%;
	height: 30%;
}
#main {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%,-50%);
    text-align: center;
}

#main :hover img {
	width: 40%;
	height: 40%;
	transition: all 2s;
}

</style>


</head>
<body>

    <div id="main">        
    <a href="/views/main.jsp"><img src="https://dmmj3ljielax6.cloudfront.net/upload/profile/7c560c93-1382-4c32-ad97-1a236e504756.jpg?h=630&w=1200" alt="석이드럼로고"></a>
    <p>취미가 필요한 순간</p>
    <h3>석이드럼</h3>
    </div>

</body>
</html>