<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="sub_menu.jsp" %>


   <article><br><br><br><br><br><br><br><br>
   		<h2>리뷰</h2>
   		<form name="formm" method="post">
   		<input type="hidden" name="rseq" value="${reviewVO.rseq}">
   		<table id="notice">
	   		<tr>
	   			<th>이미지</th>
	   			<td>
	   				<img src="product_images/${reviewVO.image}" width="200pt">
	   			</td>
	   		</tr>
	   		<tr>
	  	  		<th>제목</th>
	  	  		<td>${reviewVO.subject }</td>
	  	  	</tr>
	  	  	<tr>
				<th>작성자</th>
				<td>${reviewVO.id}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${reviewVO.content}</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td> <fmt:formatDate value="${reviewVO.indate}" type="date"/> </td>
			</tr>
  	  </table>
  	  
  	  <div class="clear"></div>
	    <div id="buttons" style="float:right">
	    	<br><input type="button" value="수정" class="submit" onclick="go_review_mod('${reviewVO.rseq}')">
	      	<input type="button"  value="목록으로" class="submit" onclick="history.go(-1);">
	    </div>
  	  </form>
  </article>
  <%@ include file="../footer.jsp" %>   