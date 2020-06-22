<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="sub_menu.jsp" %>
  <article>
  	<br><br><br><br><br><br><br><br>
  	<h2>리뷰</h2>
  	<form name="formm" method="post">
  		<table id="cartList">
  			<tr>
  			  <th>번호</th> <th>제목</th> <th>작성자</th> <th>작성일</th>
  			</tr>
  			<c:forEach items="${reviewList}" var="reviewVO">
  			<tr>
  			   <td>${reviewVO.rseq }</td>
  			   <td> <a href="review_view?rseq=${reviewVO.rseq}">${reviewVO.subject }</td>
  			   <td>${reviewVO.id }</td>
  			   <td> <fmt:formatDate value="${reviewVO.indate}" type="date"/> </td>
  			</tr>
  			</c:forEach>
  		</table>
  		<div class="clear"></div>
  		<div id="buttons" style="float:right">
      		<input type="button"  value="리뷰 작성하기"  class="submit" onclick="location.href='review_write_form'"> 
      		<input type="button"    value="쇼핑 계속하기"  class="cancel" onclick="location.href='index'"> 
		</div>
  	</form>
  </article>
<%@ include file="../footer.jsp" %>