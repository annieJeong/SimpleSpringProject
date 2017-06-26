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
		$('#btnUpdt, #btnChkOverlap').show();
		$(this).hide();
		$('input[type=text]').removeAttr("readonly");
	});
	$('#btnChkOverlap').on('click',function(){
		alert("ID중복체크 // 미개발");
		$('input[name=ID]').attr("chk","true");
	});
	$('#btnUpdt').on('click',function(){
		var valChk = validation();
		if (valChk != 0){
			var alertStr = "";
			if (valChk == 1){
				alertStr = "입력값을 확인해주세요.";
			}else if (valChk == 2){
				alertStr = "공백만 입력 불가능합니다.";
			}else if (valChk == 3){
				alertStr = "ID중복을 확인해주세요.";
			}
			alert(alertStr);
			return false;
		}
		
		var formData = {
			"index": <c:out value="${user.index}"></c:out>,
			"id":$('input[name=ID]').val(),
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

function validation(){
	var chkID = $('input[name=ID]');
	var chkPNum = $('input[name=PNumber]').val();
	var chkUsrName = $('input[name=UserName]').val();
	var chkPW = $('input[name=Password]').val();
	var chkPhNum = $('input[name=PhoneNum]').val();
	//ID
	if (chkID.attr("chk") != "true"){ //ID중복체크
		return 3;
	}
	
	if(chkID.val().length <= 0){ //입력값 없음
		return 1;
	} else if (chkID.val().trim().length <= 0){ //입력한 값이 공백
		return 2;
	}
	
	//PNUMBER
	if(chkPNum.length <= 0){ //입력값 없음
		return 1;
	} else if (chkPNum.trim().length <= 0){ //입력한 값이 공백
		return 2;
	}
	
	//USERNAME
	if(chkUsrName.length <= 0){ //입력값 없음
		return 1;
	} else if (chkUsrName.trim().length <= 0){ //입력한 값이 공백
		return 2;
	}
	
	//PASSWORD
	if(chkPW.length <= 0){ //입력값 없음
		return 1;
	} else if (chkPW.trim().length <= 0){ //입력한 값이 공백
		return 2;
	}
	
	//PHONENUM
	if(chkPhNum.length <= 0){ //입력값 없음
		return 1;
	} else if (chkPhNum.trim().length <= 0){ //입력한 값이 공백
		return 2;
	}
	
	return 0;
}

</script>
</head>
<body>
<form action="" id="insertForm" method="post">
	<table>
		<tr>
			<td>index : <c:out value="${user.index}"></c:out></td>
		</tr>
		<tr>
			<td>ID : <input type="text" name="ID" readonly value="${user.ID }" chk="false"><button id="btnChkOverlap" style="display:none;">중복확인</button></td>
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