<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Cache-Control" content="no-cache">
<title>UserTest</title>
<script type="text/javascript" src="/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
var delNum = new Array();
$(document).ready(function(){
	$('#btnUsrInsert').on('click',function(){
		location.href="/user/insert";
	});
	$('#btnUsrDel').on('click',function(e){
		//e.preventdefault();
		var chkBtn = $('tbody tr[id^=user]');
		var chkbool = false;
		chkBtn.each(function(i,e){
			var _this = $('tbody').children().eq(i+1).find("input[name=chkBtnUsr]");
			var chkYN = _this.is(":checked");
			console.log("chk:"+chkYN+"// value:"+_this.attr("value"));
			if (chkYN){
				delNum.push(_this.attr("value"));
				chkbool= true;
			}
		});
		if (chkbool){
			alert(delNum+"");
			setPop("삭제하시겠습니까?")
		}else{
			alert("선택된 사용자가 없습니다.");
		}
	});
});

function setPop(msg){
	$('#popMsg').text(msg);
	$('#popYes').on('click',function(){
		userDel();
	});
	$('#popNo').on('click',function(){
		closePop();
	});
	$('#popup').show();
}

function closePop(){
	//초기화
	delNum=[];
	$('#popup').hide();
}

function userDel(){
	$.ajax({
		url:"/user/del.ajax",
		type:"POST",
		dataType:"json",
		data:{"index" : delNum},
		success : function(resData){
			if(resData.result == "success"){
				alert("삭제완료.");
				location.reload();
			}
		},
		error : function(){
			alert("error");
			location.reload();
		}
			
	});
}
</script>
<style type="text/css">
.wrap { position:relative; /*감싸는 레이어에 포지션 속성을 잡아주는 게 필수!(relative, absolute, fixed 중 택1*/ text-align:center; margin:0 auto;  color:#000; font-size:12px; }
.over { position:absolute; top:100px; left:100px;/*위에 올라가는 레이어의 포지션은 top, bottom 둘 중 하나, left, right 둘 중 하나의 속성을 선택하여 잡아준다.*/ width:200px; height:100px; background:#FFFFCC; valign:center; text-align:center;}
</style>

</head>
<body>
<div id="document" class="wrap">
	<div>
		<table>
			<thead>
				<tr>
					<td colspan="5" align="center"><h3>user List</h3></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>INDEX</td>
					<td>PNUMBER</td>
					<td>USERNAME</td>
					<td>PASSWORD</td>
					<td>PHONENUM</td>
				</tr>
				<c:forEach items="${userList}" var="i" varStatus="stat">
					<tr id="user${stat.index}">
						<td>${i.index}</td>
						<td>${i.PNUMBER}</td>
						<td>${i.USERNAME}</td>
						<td>${i.PASSWORD}</td>
						<td>${i.PHONENUM}</td>
						<td><input type="checkbox" name="chkBtnUsr" value="${i.index }"></td>
					</tr>
				</c:forEach>
				<tr>
					<td><button id="btnUsrInsert">insert</button></td>
					<td><button id="btnUsrDel">delete</button></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div id="popup" style="display:none;" class="over">
		<div>
			<span id="popMsg"></span>
		</div>
		<div>
			<button id="popNo">No</button>
			<button id="popYes">Yes</button>
		</div>
	</div>
</div>
</body>
</html>