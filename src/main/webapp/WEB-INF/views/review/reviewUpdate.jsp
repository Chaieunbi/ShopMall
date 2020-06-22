<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>	 
<%@ include file="sub_menu.jsp" %>  


	<article><br><br><br><br><br><br><br><br>
	    <h2> 리뷰 </h2> 
		<form name="formm" method="post" enctype="multipart/form-data">
		<input type="hidden" name="rseq" value="${reviewVO.rseq}">
		<input type="hidden" name="nonmakeimg" value="${reviewVO.image}">
			<fieldset>	
				<legend>리뷰 작성</legend>		
				<label>이미지</label>
				<img src="product_images/${reviewVO.image}" width="200pt"><br>
			    <label>상품명</label>
			    <input type="text" name="subject"  size="55" value="${reviewVO.subject}"><br><br>
				<label>내용</label>
			    <textarea style="width:400px; height:100px;" rows="3" cols="30" name="content">${reviewVO.content}</textarea>
			    <label>첨부 파일</label>
			    <input type="file" name="review_image">
			    <input type="hidden" name="image" value="${reviewVO.image}"><br>
			</fieldset>
		<div class="clear"></div>
		 <div id="buttons" style="float:right">
			<input type="button"  value="수정"     class="submit" onclick="go_review_save('${reviewVO.rseq}')"> 
			<input type="reset"   value="취소"     class="cancel">
			<input type="button"  value="쇼핑 계속하기"  class="submit"  onclick="location.href='index'">	
		  </div>
		</form>
	</article>
<%@ include file="../footer.jsp" %>