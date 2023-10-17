<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 추가</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

<%-- jquery는 원본으로 --%>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>즐겨찾기 추가하기</h1>
		
		<div class="form-group">
			<label for="url">URL</label>
			<input type="text" id="url" class="form-control">
		</div>
		<button type="button" id="addBtn" class="btn btn-success btn-block">추가</button>
	</div>
	<script>
	$(document).ready(function(){
		$('#addBtn').on('click', function(){
			//alert("클릭");
			
			//validation
			let name = $('#name').val().trim();
			let url = $('#url').val().trim();
			
			console.log(name);
			console.log(url);
			
			if(!name){
				alert("제목을 입력하세요.");
				return;
			}
			if(!url){
				alert("주소를 입력하세요")
				return;
			}
			
			if(url.stratsWith("http://") == false &&
					url.stratsWith("https://") == false){
				alert("주소 형식이 잘못 되었습니다.");
				return;
			}
			//AJAX 통신
			$.ajax({
				//request
				type:"POST"
				,url:"/lesson06/quiz/add-bookmark"
				,data:{"name":name , "url":url}
				//response
				,success:function(data){ //data: response 응답값(JSON String) => Dictory Object
					// data는 JSON String -> Object 변환된 형태로 사용할 수 있다. 
					// jquery의 ajax 함수 가능
					alert(data.code);
					alert(data.result);
					if(data.result == "success"){
						location.href = "/lesson06/quiz01/bookmark-list"
					}
				}
				, error:function(request, status, error){
					alert("추가에 실패했습니다. 관리자에게 문의해주세요.");
				}
			});
		});
	})
	</script>
</body>
</html>