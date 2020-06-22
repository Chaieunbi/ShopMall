<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<script type="text/javascript">

</script>
<article><br><br><br><br><br><br><br><br>
<h1>공지사항</h1>
<h3>공지사항 작성</h3>
<form name="form" method="post" enctype="multipart/form-data">
<table id="orderList">
	<tr>
		<th>제목</th>
		<td colspan="5"><input type="text" name="subject"  size="55" ><br></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td colspan="5">${noticeVO.id}</td>
	</tr>
	<tr>
		<th>내용</th>
		<td colspan="5"><textarea style="width:400px; height:100px;" rows="3" cols="30" id="content" name="content"></textarea><br></td>
	</tr>
	<tr>
		<th>첨부 파일</th>
		<td colspan="5">
			<input type="file" name="notice_image"><br>
		</td>
	</tr>
</table>
<input class="btn" type="button" value="등록" onclick="go_notice_save()">
<input class="btn" type="reset" value="취소">
<input class="btn" type="button" value="목록" onclick="go_List()">
</form>
</article> 