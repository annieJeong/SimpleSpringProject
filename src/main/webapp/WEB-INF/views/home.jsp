<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session = "true" %>
<%
 String chkVal = request.getParameter("result");
%>
<html>
<head>
	<title>Home</title>
	<script type="text/javascript" src="/resources/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$('#gotoBoard').on('click',function(){
				location.href="/board";
			});
			$('#btnUserAdmin').on('click',function(){
				location.href="/user";
			});
			$('button[name=btnLogOut]').on('click',function(){
				location.href="/logout";
			})
		});
	</script>
</head>
<body>
<c:choose>
	<c:when test="${empty USER}">
		<h2>로그인 하세요.</h2>
		<form action="/login" method="post" id="loginForm">
			<table>
				<tr>
					<td>ID :</td>
					<td><input type="text" name="iptId"></td>
					<td rowspan="2">
						<button type="submit">LOGIN</button>
					</td>
				</tr>
				<tr>
					<td>PW :</td>
					<td><input type="password" name="iptPw"></td>
				</tr>
			</table>
		</form>
		<%if(chkVal != null){ %>
			<p>오류가 발생하였습니다. 재시도 하세요.</p>
		<%} %>
	</c:when>
	<c:when test='${USER.ID eq "ADMIN"}'>
		<h2>로그인---ADMIN</h2>
		<table>
			<tr>
				<td>ID :</td>
				<td>${USER.ID}</td>
			</tr>
			<tr>
				<td>PW :</td>
				<td>${USER.PASSWORD}</td>
			</tr>
		</table>
		<button type="button" name="btnLogOut">로그아웃</button>
		<button type="button" id="btnUserAdmin">회원관리</button>
	</c:when>
	<c:otherwise>
	<h2>로그인---USER</h2>
	<table>
		<tr>
			<td>ID :</td>
			<td>asdfasdf</td>
		</tr>
		<tr>
			<td>PW :</td>
			<td>123123123</td>
		</tr>
	</table>
	<button type="button" name="btnLogOut">로그아웃</button>
	<button type="button" id="gotoBoard">게시판 이용</button>
	</c:otherwise>
</c:choose>
</body>
</html>
