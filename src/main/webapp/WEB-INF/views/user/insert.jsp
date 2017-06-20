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
	$('#btnInsert').on('click',function(){
		if (!valCheck()){
			alert("입력값을 확인해 주세요.");
			return false;
		}
		
		var pNumber = $('input[name="PNumber"]').val();
		var userName = $('input[name="UserName"]').val();
		var password = $('input[name="Password"]').val();
		var phoneNum = $('input[name="PhoneNum"]').val();
		var formData = {
			"pNumber":pNumber,
			"userName":userName,
			"passWord":password,
			"phoneNum":phoneNum
		};
		
		$.ajax({
			url:"/user/insert.ajax",
			type:"POST",
			dataType:"json",
			data:formData,
			success : function(resData){
				if (resData.result == "success"){
					alert("추가되었습니다.");
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

function valCheck(){
	var pNumber = $('input[name="PNumber"]').val();
	var userName = $('input[name="UserName"]').val();
	var password = $('input[name="Password"]').val();
	var phoneNum = $('input[name="PhoneNum"]').val();
	
	//고객번호
	if(pNumber.length <= 0){ //입력된 값이 없을경우
		return false;
	} else if (pNumber.trim().length <= 0){ //입력된 값이 공백인 경우
		return false;
	}
	
	//고객이름
	if(userName.length <= 0){ //입력된 값이 없을경우
		return false;
	} else if (userName.trim().length <= 0){ //입력된 값이 공백인 경우
		return false;
	}
	
	//비밀번호
	if(password.length <= 0){ //입력된 값이 없을경우
		return false;
	} else if (password.trim().length <= 0){ //입력된 값이 공백인 경우
		return false;
	}
	
	//전화번호
	if(phoneNum.length <= 0){ //입력된 값이 없을경우
		return false;
	} else if (phoneNum.trim().length <= 0){ //입력된 값이 공백인 경우
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
			<td>고객번호 : <input type="text" name="PNumber"></td>
		</tr>
		<tr>
			<td>성&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;명 : <input type="text" name="UserName"></td>
		</tr>
		<tr>
			<td>비밀번호 : <input type="text" name="Password"></td>
		</tr>
		<tr>
			<td>전화번호 : <input type="text" name="PhoneNum"></td>
		</tr>
	</table>
	<button id="btnInsert">고객 추가</button>
</form>
<br>
<button id="gotomain">main</button>
</body>
</html>