<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<script type="text/javascript">

</script>
<article><br><br><br><br><br><br><br><br>
<h1>공지사항</h1>
<h3>공지사항 수정</h3>
<form name="form" method="post" enctype="multipart/form-data">
<input type="hidden" name="nseq" value="${noticeVO.nseq }">
<input type="hidden" name="Nonmakeimg" value="${noticeVO.image}">
<table id="orderList">
	<tr>
		<th>제목</th>
		<td colspan="5">
		<input type="text" name="subject"  size="55" value="${noticeVO.subject}"><br>
		</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td colspan="5">${noticevo.id}</td>
	</tr>
	<tr>
		<th>내용</th>
		<td colspan="5">
		<textarea rows="3" cols="70" name="content">${noticeVO.content}</textarea><br>
		</td>
	</tr>
	<tr>
		<th>이미지</th>
		<td colspan="5">
			<img src="product_images/${noticeVO.image}" width="200pt">
			<br>
			<input type="file" name="notice_image">
			<input type="hidden" name="image" value="${noticeVO.image}">
		</td>
	</tr>
</table>
<input class="btn" type="button" value="수정" onclick="go_mode_save('${noticeVO.nseq}')">
<input class="btn" type="reset" value="취소">
<input class="btn" type="button" value="목록" onclick="go_List()">
</form>
</article> 