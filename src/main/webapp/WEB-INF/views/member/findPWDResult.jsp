<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<link href="CSS/subpage.css" rel="stylesheet">
<style type="text/css">
body{   
  background-color:#ffffff;
  font-family: Verdana;
}
#wrap{     
  margin: 0 20px;
}
h1 {
  font-family: "Times New Roman", Times, serif;
  font-size: 45px;
  color: #000000;
  font-weight: normal;
  text-align:center;
}
input[type=button], input[type=submit] {
  float: right;
}
</style>
<script type="text/javascript">
function idok(){
  self.close();
}
</script>
</head>
<body>
<div id="wrap">
  <h1>비밀번호 찾기 결과</h1>
  <form method=post name=formm style="margin-right:0 "
  		action="pwd_check_form" >
    	<!-- 아이디 <input type=text name="id" value="${id}">--> 
    <div style="margin-top: 20px">   
      <c:if test="${message == 1}">
        <script type="text/javascript">
          opener.document.formm.pwd.value="";
        </script>
             요청하신 아이디는 ${pwd}입니다.
      </c:if>
      <c:if test="${message==-1}">
             가입하지 않은 아이디입니다.
      </c:if>
    </div>
    <input type="button" value="확인" class="cancel" onclick="idok()">
  </form>
</div>  
</body>
</html>