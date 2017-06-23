<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Board</title>
<script type="text/javascript" src="/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#gotomain').on('click',function(){
		location.href="/board";
	});
	$('#btnInsert').on('click',function(){
		if (!valCheck()){
			alert("입력값을 확인해 주세요.");
			return false;
		}
		
		var title = $('input[name="title"]').val();
		var txt = $('textarea[name="txt"]').val();
		var formData = {
			"title":title,
			"txt":txt
		};
		
		$.ajax({
			url:"/board/insert.ajax",
			type:"POST",
			dataType:"json",
			data:formData,
			success : function(resData){
				if (resData.result == "success"){
					alert("추가되었습니다.");
					location.href="/board";
				}
			},
			error : function(e){
				alert("error");
				location.reload();
			}
		});
	});
});

function valCheck(){
	var title = $('input[name="title"]').val();
	var txt = $('textarea[name="txt"]').val();
	
	//제목
	if(title.length <= 0){ //입력된 값이 없을경우
		return false;
	} else if (title.trim().length <= 0){ //입력된 값이 공백인 경우
		return false;
	}
	
	//내용
	if(txt.length <= 0){ //입력된 값이 없을경우
		return false;
	} else if (txt.trim().length <= 0){ //입력된 값이 공백인 경우
		return false;
	}
	
	return true;
}
</script>
</head>
<body>
<form action="" id="insertForm" method="post">
	<table>
		<tr>
			<td>제목 : <input type="text" name="title" maxlength="10"></td>
		</tr>
		<tr>
			<td>내용 : <textarea rows="5" cols="50" name="txt"></textarea></td>
		</tr>
	</table>
	<button id="btnInsert">게시글 등록</button>
</form>
<br>
<button id="gotomain">main</button>
</body>
</html>