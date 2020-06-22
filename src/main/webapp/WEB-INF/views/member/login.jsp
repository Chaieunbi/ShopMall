<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>  
<%@ include file="../header.jsp" %>  
<%@ include file="sub_menu.jsp" %>       
  <article id="loginarticle">
    <h1>로그인</h1>
    <form method="post" action="login">
        <fieldset>
        <legend>Member Login</legend>
          <label id="labelid">ID</label>
          <input name="id" id="id" type="text" value="${id}"><br> 
          <label id="labelpwd">PASSWORD</label> 
          <input name="pwd" id="pwd" type="password"><br> 
        </fieldset>
        <div class="clear"></div>
        <div id="buttons">
            <input type="submit" value="로그인" class="submit1">
            <input type="button" value="아이디/비밀번호 찾기" class="submit1" onclick="find_id_form()">
        </div>
    </form>  
  </article>
<%@ include file="../footer.jsp" %>      