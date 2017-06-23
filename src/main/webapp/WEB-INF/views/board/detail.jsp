<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UserTest</title>
<script type="text/javascript" src="/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#gotomain').on('click',function(){
		location.href="/board";
	});
	$('#btnShowUpdt').on('click',function(){
		$('#btnUpdt').show();
		$(this).hide();
		$('input, textarea').removeAttr("readonly");
	});
	
	$('#btnUpdt').on('click',function(){
		var formdata ={
			"idx":"${board.BOARD_IDX}",
			"title":$('input[name=title]').val(),
			"txt":$('textarea[name=txt]').val()
		}
		$.ajax({
			url:"/board/update.ajax",
			type:"POST",
			data:formdata,
			dataType:"json",
			success : function(resData){
				if(resData.result == "success"){
					alert("수정완료.");
					location.reload();
				}
			},
			error : function(){
				alert("error");
				location.reload();
			}
		});
	});
	$('#btnDel').on('click',function(){
		$.ajax({
			url : "/board/delete.ajax",
			type:"POST",
			data:{
				"idx":"${board.BOARD_IDX}"
			},
			dataType:"json",
			success : function(resData){
				if(resData.result == "success"){
					alert("삭제완료.");
					location.href="/board";
				}
			},
			error : function(){
				alert("error");
				location.reload();
			}
		});
	});
});

</script>
</head>
<body>
<table>
	<tr>
		<td>index : <c:out value="${board.BOARD_IDX}"></c:out></td>
	</tr>
	<tr>
		<td>제목 : <input type="text" name="title" readonly value="${board.BOARD_TITLE}"></td>
	</tr>
	<tr>
		<td>내용 : <textarea rows="5" cols="50" name="txt" readonly>${board.BOARD_STR}</textarea></td>
	</tr>
	<tr>
		<td>등록일 : <c:out value="${board.BOARD_SETDATE }"></c:out></td>
	</tr>
	<tr>
		<td>수정일 : <c:out value="${board.BOARD_UPDATE }"></c:out></td>
	</tr>
	<tr>
		<td>등록자 : <c:out value="${board.BOARD_USRNAME }"></c:out></td>
	</tr>
</table>
<button id="btnUpdt" type="button" style="display:none;">정보 수정</button>
<br>
<button id="btnShowUpdt">수정하기</button>
<button id="btnDel">삭제하기</button>
<button id="gotomain">main</button>
</body>
</html>