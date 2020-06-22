<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>	 
<%@ include file="sub_menu.jsp" %>   
	<article><br><br><br><br><br>
	    <h2> Q&A 게시판 </h2>
		<form name="formm" method="post" 
		action="qna_write">
			<fieldset>	
				<legend>Q&A 작성</legend>		
			    <label>제목</label>
			    <input type="text" name="subject"  size="55" /><br><br>
				<label>문의하실 내용</label>
			    <input type="text" name="content" style="width:400px; height:100px;"><br>
			    
			</fieldset>   
		<div class="clear"></div>
		 <div id="buttons" style="float:right">
			<input type="submit"  value="등록"     class="submit"> 
			<input type="reset"   value="취소"     class="cancel" onclick="history.go(-1)">
			<input type="button"  value="쇼핑 계속하기"  class="submit"  onclick="location.href='index'">	
		  </div>
		</form>
	</article>
<%@ include file="../footer.jsp" %>