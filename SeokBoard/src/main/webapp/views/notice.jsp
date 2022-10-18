<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/layout/header.jsp"%>

<style>
.collapsible {
	background-color: #777;
	color: white;
	cursor: pointer;
	padding: 18px;
	width: 100%;
	border: none;
	text-align: left;
	outline: none;
	font-size: 15px;
}

.active, .collapsible:hover {
	background-color: #555;
}

.content {
	padding: 0 18px;
	max-height: 0;
	overflow: hidden;
	transition: max-height 0.2s ease-out;
	background-color: #f1f1f1;
}

.collapsible:after {
	content: '\002B';
	color: white;
	font-weight: bold;
	float: right;
	margin-left: 5px;
}

.active:after {
	content: "\2212";
}

#menu {
	width: 500px;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}
</style>

<script>
	function collapse(element) {
		var before = document.getElementsByClassName("active")[0] // 기존에 활성화된 버튼
		if (before && document.getElementsByClassName("active")[0] != element) { // 자신 이외에 이미 활성화된 버튼이 있으면
			before.nextElementSibling.style.maxHeight = null; // 기존에 펼쳐진 내용 접고
			before.classList.remove("active"); // 버튼 비활성화
		}
		element.classList.toggle("active"); // 활성화 여부 toggle

		var content = element.nextElementSibling;
		if (content.style.maxHeight != 0) { // 버튼 다음 요소가 펼쳐져 있으면
			content.style.maxHeight = null; // 접기
		} else {
			content.style.maxHeight = content.scrollHeight + "px"; // 접혀있는 경우 펼치기
		}
	}
</script>


<body>
	<div id="menu">
		<button type="button" class="collapsible" onclick="collapse(this);">커뮤니티에 글쓰기</button>
		<div class="content">
			<p>회원가입을 하시고 로그인 필수!</p>
		</div>
		
		<button type="button" class="collapsible" onclick="collapse(this);">11월 24일 강의 휴강</button>
		<div class="content">
			<p>개인적인 사정으로 휴강합니다!</p>
		</div>
		
		<button type="button" class="collapsible" onclick="collapse(this);">레슨 시간 공지!</button>
		<div class="content">
			<p>레슨시간이 40분에서 45분으로 늘어났습니다!</p>
		</div>
		
		<button type="button" class="collapsible" onclick="collapse(this);">부모님 참여 수업 진행!</button>
		<div class="content">
			<p>10월 24일까지 부모님 참여 수업 진행 중!!</p>
		</div>
		
		<button type="button" class="collapsible" onclick="collapse(this);">노래 연주는 1달 후 부터!</button>
		<div class="content">
			<p>노래 연주는 드럼 배운지 1달이 지나야 가능합니다 ^^</p>
		</div>
	</div>
</body>
</html>