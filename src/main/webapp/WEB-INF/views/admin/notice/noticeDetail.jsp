<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<script type="text/javascript">

</script>
<article><br><br><br><br><br><br><br><br>
<h1>공지사항</h1>
<form name="frm" method="post">
<input type="hidden" name="nseq" value="${noticeVO.nseq}">
<table id="orderList" style="text-align: center;">
    <tr>
    	<th>이미지</th>
    	<td> 
    		<img src="product_images/${noticeVO.image}" width="200pt">
    	</td>
    </tr>
    <tr>
        <th width="20%">제목</th>
        <td> ${noticeVO.subject}</td>
    </tr>
    <tr>
		<th>작성자</th>
		<td>${noticeVO.id}</td>
	</tr>
   <tr>
         <th>등록일</th>
         <td> <fmt:formatDate value="${noticeVO.indate}"/> </td>  
    </tr>
    <tr>
        <th>내용</th>
        <td> ${noticeVO.content}</td>  
    </tr>
</table>
<input type="button" class="btn" value="수정" onclick="go_mod('${noticeVO.nseq}')">
<input type="button" class="btn" value="목록" onclick="go_list()">
</form><br><br><br><br><br>
</article>
<%@ include file="../footer.jsp"%>