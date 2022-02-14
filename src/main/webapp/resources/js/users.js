/**
 * 
 */
//
$(document).ready(function(){
	
function user() {				
		$.ajax({										
			type: 'json',
		    url: "/apis/users",	
			success : function(data) {
				alert("통신성공")
			},
			error : function() {
				alert("error")
			}
		})													
	}			
	user();
})