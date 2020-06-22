<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ include file="../header.jsp" %>   
<%@ include file="sub_img.html"%> 
<%@ include file="sub_menu.jsp" %>   
  <article id="loginarticle">
  	<br><br><br><br><br><br><br><br>
    <h2>회원가입</h2>
    <form id="join" action="join" method="post" name="formm">
      <fieldset id="mustfieldset">
        <legend>필수 정보입력</legend>
        <label id="joinlabelid">아이디</label>
        <input type="text"      name="id"        size="12" id="joinid" >
        <input type="hidden"    name="reid">
        <input type="button"    value="중복 체크"  class="dup" onclick="idcheck()"><br>
        
        <label class="joinlogin">비밀번호</label> 
        <input type="password"  name="pwd" class="joinlogin"><br> 
        <label class="joinlogin">비밀번호 확인</label> 
        <input type="password"  name="pwdCheck" class="joinlogin"><br> 
        <label class="joinlogin">이름</label>
        <input type="text"      name="name" class="joinlogin"><br> 
        <label class="joinlogin">이메일</label>
        <input type="email"    name="mail" class="joinlogin"><br>
      </fieldset>
      
      <fieldset style="margin-top: 50px">
        <legend>선택 정보입력</legend>
        <label class="joinzipnum">우편번호</label> 
        <input type="text"       name="zip_num"   size="10" class="joinzipnum">      
        <input type="button"     value="주소 찾기" class="dup" onclick="post_zip()"><br>
        
        <label id="joinaddr">주소</label> 
        <input type="text"        name="addr1"   size="25" id="joinaddr1"><br>
        <input type="text"        name="addr2"   size="25" id="joinaddr2"> <br>
        
        <label class="joinphone">전화번호</label> 
        <input  type="text"       name="phone" class="joinphone"><br>
      </fieldset>
      <div class="clear"></div>
      <div id="buttons" style="margin-top: 30px">
        <input type="button"    value="회원가입"   class="submit" onclick="go_save()"> 
        <input type="reset"      value="취소"     class="cancel">
      </div>
      <br>
    </form>
  </article>
<%@ include file="../footer.jsp" %>
  