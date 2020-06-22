<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<article><br><br>
<h1>공지사항 리스트</h1>
<form name="frm" method="post">
<table style="margin-left:120px">
	<tr>
		<td>
		<input class="btn" type="button" name="btn_write" value="공지사항 등록" onclick="go_write()">
		</td>
	</tr>
</table>

<table id="orderList" style="margin-left:120px">
	<tr>
		<th>번호</th>	 <th>제목</th> <th>작성자</th> <th>작성일</th>
	</tr>
	<c:forEach items="${noticeList}" var="noticeVO">
	<tr style="text-align:center;">
		<td>${noticeVO.nseq}</td>
		<td><a href="admin_notice_detail?nseq=${noticeVO.nseq}">${noticeVO.subject}</a></td>
		<td> ${noticeVO.id} </td>
		<td> <fmt:formatDate value="${noticeVO.indate}"/></td>
	</tr>
	</c:forEach>
</table>
</form>
</article>
<%@ include file="../footer.jsp" %>
