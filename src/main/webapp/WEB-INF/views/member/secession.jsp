<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>   
<%@ include file="sub_img.html"%> 
<%@ include file="sub_menu.jsp" %>  
<script type="text/javascript">
	function go_secession(){
		if(document.dlscs.pwd.value == "") {
			alert("비밀번호를 입력해 주세요.");
			document.dlscs.pwd.focus();
		} else if(document.dlscs.pwdch.value == "") {
			alert("비밀번호를 입력해 주세요.");
			document.dlscs.pwdch.focus();
		} else if(document.dlscs.pwd.value == document.dlscs.pwdch.value) {
			alert("비밀번호가 일치하지 않습니다.");
			document.dlscs.pwdch.focus();
		} else{
			document.dlscs.action = "secession";
			document.dlscs.submit();
		}
	}
</script>
<article id="loginarticle"><br><br><br><br><br>
	<h2>회원탈퇴</h2><hr>
	<form method="post" name="dlscs">
		<fieldset id="mustfieldset">
			<label id="labelid">비밀번호</label>
			<input type="password" name="pwd" size="12" id="pwd"><br>
			<label id="labelpwd">비밀번호 확인</label>
			<input type="password" name="pwdch" size="12" id="pwdch">
		</fieldset>
		<div class="clear"></div>
		<div id="buttons" style="margin-top: 30px">
			<input type="button" value="탈퇴하기" class="submit" onclick="go_secession()">
			<input type="reset" value="취소" class="cancel">
			<input type="button" value="메인페이지로" class="submit" onclick="location.href='index'">
		</div>
	</form><br><br><br><br><br>
</article>
<%@ include file="../footer.jsp" %>
