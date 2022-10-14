<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ include file="/layout/header.jsp"%>

<title>Introduce</title>

<style type="text/css">

#wrap {

    display: flex;
    align-items: center;
    position: absolute;
    top: 40%;
    left: 50%;
    transform: translate(-50%,-50%);
    text-align: center;  
}

#ex1 {
margin: 10px;
}

#ex2{
margin: 10px;
}

#session {
    display: flex;
    align-items: center;
      
    position: absolute;
    top: 75%;
    left: 50%;
    transform: translate(-50%,-50%);
    text-align: center;
    font-weight: bold;   
    }
#session > div > img{
	margin: 10px;
}
    
}



</style>
</head>
<body>

<div id="wrap">
    <div id="ex1">   
    <h2>이력</h2>
    <span>백석예술대학교 실용음악과 드럼전공</span><br>
    <span>육군부사관학교 셋드럼 전역</span><br>
    <span>실기교사 자격증 소지</span><br>
    <span>문화예술교육사 자격증 소지</span>   
    </div>

    <div id="ex2">    
    <h2>경력</h2>
    <span>잠실 퓨즈실용음악학원 드럼 강사</span><br>
    <span>회기 조이앤플레이음악학원 드럼 강사</span><br>
    <span>개봉 임마누엘뮤직아카데미 드럼 강사</span><br>
    <span>마곡 클라라음악학원 드럼 강사</span><br>
    <span>위례 위례사랑문화원 드럼 강사</span><br>
    <span>이천 JY실용음악학원 드럼 강사</span><br>
    <span>이천 드림실용음악학원 드럼 강사</span><br>
    <span>수원 아이엘음악학원 드럼 강사</span>    
    </div>
</div>

	<div id="session">	
	    <div><img src= "https://musicmeta-phinf.pstatic.net/album/002/744/2744787.jpg?type=r360Fll&v=20200224145710" ><br><span>Comeback tonight</span></div>
        <div><img src= "https://musicmeta-phinf.pstatic.net/album/002/529/2529674.jpg?type=r360Fll&v=20200220023710"  ><br><span>아이야</span></div>
		<div><img src= "https://musicmeta-phinf.pstatic.net/album/005/591/5591502.jpg?type=r480Fll&v=20210414115933" style="width: 360px;" ><br><span>겨울부터 밤까지</span></div>
        <div><img src= "https://musicmeta-phinf.pstatic.net/album/001/999/1999333.jpg?type=r480Fll&v=20220528152506" style="width: 360px;"><br><span>그리워해서</span></div>		
	</div>



    





</body>
</html>