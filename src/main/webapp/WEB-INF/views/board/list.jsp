<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Board</title>
	<script type="text/javascript" src="/resources/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$('#btnBoardIst').on('click',function(){
				location.href="/board/insert";
			});
			$('#gotoMain').on('click',function(){
				location.href="/";
			});
			$('tr[id^=board]').on('click',function(){
				var idx = $(this).children().eq(0).text();				
				location.href="/board/detail?idx="+idx;
			});
		});
	</script>
</head>
<body>
<h1>
	게시판  
</h1>
<table>
	<tr>
		<td>index</td>
		<td>제목</td>
		<td>게시일</td>
		<td>게시자</td>
	</tr>
	<c:forEach items="${board}" var="i">
		<tr id="board${i.BOARD_IDX }">
			<td>${i.BOARD_IDX}</td>
			<td>${i.BOARD_TITLE }</td>
			<td>${i.BOARD_SETDATE }</td>
			<td>${i.BOARD_USRNAME }</td>
		</tr>
	</c:forEach>
</table>
<button id="btnBoardIst">insert</button>
<button id="gotoMain">main</button>

</body>
</html>
