<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="sub_menu.jsp" %>
   <article><br><br><br><br><br><br><br><br>
   		<h2>공지사항</h2>
   		<form name="formm" method="post">
   			<table id="notice">
   				<tr>
   					<th>제목</th>
   					<td>${noticeVO.subject}</td>
   				</tr>
   				<tr>
   					<th>작성자</th>
   					<td>${noticeVO.id}</td>
   				</tr>
   				<tr>
   					<th>내용</th>
   					<td>${noticeVO.content }</td>
   				</tr>
   				<tr>
   					<th>작성일</th>
   					<td><fmt:formatDate value="${noticeVO.indate}" type="date"/></td>
   				</tr>
   			</table>
   			<div class="clear"></div>
   			<div id="buttons">
   				<input type="button" value="목록보기" class="submit" onclick="location.href='notice_list'">
   			</div>
   		</form>
   		<!-- 상품평 처리 -->
<%@ include file="comment.jsp" %>
   </article>
<%@ include file="../footer.jsp" %>