<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="sub_menu.jsp" %>
  <article>
  	<br><br><br><br><br><br><br><br>
  	<h2>공지사항</h2>
  	<form name="formm" method="post">
  		<table id="cartList">
  			<tr>
  			  <th>번호</th> <th>제목</th> <th>작성일</th> <th>조회수</th>
  			</tr>
  			<c:forEach items="${noticeList}" var="noticeVO">
  			<tr>
  			   <td>${noticeVO.nseq }</td>
  			   <td> <a href="notice_view?nseq=${noticeVO.nseq}">${noticeVO.subject}</td>
  			   <td>${noticeVO.id }</td>
  			   <td> <fmt:formatDate value="${noticeVO.indate}" type="date"/> </td>
  			</tr>
  			</c:forEach>
  		</table>
  		<div class="clear"></div>
  		<div id="buttons" style="float:right">
      		<input type="button"    value="쇼핑 계속하기"  class="cancel" onclick="location.href='index'">  
		</div>
  	</form>
  </article>
<%@ include file="../footer.jsp" %>