<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<script type="text/javascript">
  function go_search(name)
  {
     document.frm.action="admin_member_list?name="+name; //AdminController에서 name으로 받음
     document.frm.submit();
  }
</script>

<article><br><br>
<h1>회원리스트</h1>  
<form name="frm" method="post">
<table style="margin-left:120px">
  <tr>
  <td> 
  회원 이름
  <input type="text" name="key">
  <input class="btn" type="button" value="검색" onclick="go_search(${key})"> <!-- 위의 회원이름을 넘김 -->
  </td>
  </tr>
</table>  
<br>
<table id="orderList" style="margin-left:120px">
  <tr>
    <th> 아디디(탈퇴여부) </th>    <th> 이름 </th>
    <th> 이메일 </th>             <th> 우편번호 </th>  
    <th> 주소 </th>  <th> 전화 </th>  <th> 가입일 </th>
  </tr>
  <c:forEach items="${memberList}" var="memberVO">  
  <tr>
    <td>${memberVO.id} 
    <c:choose>
      <c:when test='${memberVO.useyn=="y"}'>
        <input type="checkbox" name="useyn" disabled="disabled">
      </c:when>
      <c:otherwise>
        <input type="checkbox" name="useyn" 
checked="checked" disabled="disabled">
      </c:otherwise>
    </c:choose>
    </td>
    <td> ${memberVO.name} </td>
    <td> ${memberVO.mail} </td> 
    <td> ${memberVO.zip_num} </td>
    <td> ${memberVO.address} </td>
    <td> ${memberVO.phone} </td> 
    <td> <fmt:formatDate value="${memberVO.regdate}"/></td>
  </tr>
  </c:forEach>
</table>
</form>
</article>
<%@ include file="../footer.jsp"%>
</body>
</html>