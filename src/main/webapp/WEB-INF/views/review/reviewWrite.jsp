<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>	 
<%@ include file="sub_menu.jsp" %>  
<script type="text/javascript">

</script> 
	<article><br><br><br><br><br>
	    <h2> 리뷰 </h2> 
		<form name="formm" method="post">
			<fieldset>	
				<legend>리뷰 작성</legend>		
			    <label>상품명</label>
			    <input type="text" name="subject"  size="55" /><br><br>
			    <label>작성자</label>
			    ${reviewVO.id }<br><br>
				<label>내용</label>
				<textarea rows="3" cols="30" style="width:400px; height:100px;" id="content" name="content"></textarea><br><br>
			    <label>첨부 파일</label>
			    <input type="file" name="image"><br>
			</fieldset>   
		<div class="clear"></div>
		 <div id="buttons" style="float:right">
			<input type="button"  value="리뷰 등록"     class="submit" onclick="go_review()"> 
			<input type="reset"   value="취소"     class="cancel">
			<input type="button"  value="쇼핑 계속하기"  class="submit"  onclick="location.href='index'">	
		  </div>
		</form>
	</article>
<%@ include file="../footer.jsp" %>