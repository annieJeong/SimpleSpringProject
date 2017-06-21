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
		location.href="/user";
	});
	$('#btnShowUpdt').on('click',function(){
		$('#btnUpdt').show();
		$(this).hide();
		$('input[type=text]').removeAttr("readonly");
	});
	
	$('#btnUpdt').on('click',function(){
		var formData = {
			"index": <c:out value="${user.index}"></c:out>,
			"pNumber":$('input[name=PNumber]').val(),
			"userName":$('input[name=UserName]').val(),
			"passWord":$('input[name=Password]').val(),
			"phoneNum":$('input[name=PhoneNum]').val()
		};
		$.ajax({
			url:"/user/update.ajax",
			type:"POST",
			dataType:"json",
			data:formData,
			success : function(resData){
				if (resData.result == "success"){
					alert("수정완료.");
					location.href="/user";
				}
			},
			error : function(e){
				alert("error");
				location.reload();
			}
		});
	});
	
});

</script>
</head>
<body>
<form action="" id="insertForm" method="post">
	<table>
		<tr>
			<td>index : <c:out value="${user.index}"></c:out></td>
		</tr>
		<tr>
			<td>고객번호 : <input type="text" name="PNumber" readonly value="${user.PNUMBER }"></td>
		</tr>
		<tr>
			<td>성&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;명 : <input type="text" name="UserName" readonly value="${user.USERNAME }"></td>
		</tr>
		<tr>
			<td>비밀번호 : <input type="text" name="Password" readonly value="${user.PASSWORD }"></td>
		</tr>
		<tr>
			<td>전화번호 : <input type="text" name="PhoneNum" readonly value="${user.PHONENUM }"></td>
		</tr>
	</table>
	<button id="btnUpdt" type="button" style="display:none;">정보 수정</button>
</form>
<br>
<button id="btnShowUpdt">수정하기</button>
<button id="gotomain">main</button>
</body>
</html>