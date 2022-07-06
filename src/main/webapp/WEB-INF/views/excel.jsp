<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src='//cdnjs.cloudflare.com/ajax/libs/jquery-throttle-debounce/1.1/jquery.ba-throttle-debounce.min.js'></script>
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
<title>Insert title here</title>
</head>
<body>
<div>
	<div style="display:flex;">
		<div>시작일 : <input type="text" id="start"></div>&nbsp&nbsp&nbsp
		<div>종료일 : <input type="text" id="end"></div>
		<button id="click">조회</button>
	</div>
	<p>${text}</p>
</div>
</body>
<script type="text/javascript">
	$("#click").click(function(){
		
		$.ajax({
			url:"/excel",
			success : function(data){
				download(data);
			},
			error : function() {
			
				console.log("error");
			}	
		})
	})
</script>
</html>