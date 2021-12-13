/**
 * 
 */

$(document).ready(function(){
	
function user() {				
				// 매개변수는 사용자에게 필요한 것들
//		alert('aaa'+user);
		$.ajax({											// ajax 시작
			type: 'post',
		    url: "/apis/users",	// from 태그의 action과 같은 서버 주소
			data : JSON.stringify(user),
			contentType : "application/json; charset=utf-8",
			success : function(data) {
				alert("통신성공")
			},
			error : function() {
				alert("error")
			}
		})													// ajax 끝
	}			
	user();
function userg() {				
				// 매개변수는 사용자에게 필요한 것들
//		alert('aaa'+user);
		$.ajax({											// ajax 시작
			type: 'get',
		    url: "/apis/users",	// from 태그의 action과 같은 서버 주소
			data : JSON.stringify(user),
			contentType : "application/json; charset=utf-8",
			success : function(data) {
				alert("통신성공")
			},
			error : function() {
				alert("error")
			}
		})													// ajax 끝
	}			
	user();
})