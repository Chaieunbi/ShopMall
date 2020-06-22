/**
 * 
 */

//하단 페이지 수
function fn_paging(curPage) {
	location.href="admin_notice_list?curPage"+curPage;
}

/*
noticeDatail.jsp에서 사용한다.
function go_list(pageNum, numPerPage) {
		document.frm.action="admin_notice_list?pageNum"+pageNum+"&numPerPage"+numPerPage;
		document.frm.submit();
}
*/
 
 function go_notice_detail(nseq){
	 document.form.action = "admin_notice_detail?nseq"+nseq;
	 document.form.submit();
 }
 
 function go_list(pageNum, numPerPage) {
		var theForm = document.frm;
		//공지사항 리스트로 이동하되 현재 페이지를 쿼리 스트링으로 넘긴다.
		theForm.action = "admin_notice_list?pageNum="+pageNum+"&numPerPage="+numPerPage;
		theForm.submit();
 } 
 
 
 
 
 function go_mode_save(nseq){
		if (document.form.subject.value == '') {
			alert('공지사항 제목을 입력해주세요.');
			document.form.subject.focus();
		} else if(document.form.content.value == ''){
			alert('공지사항 내용을 입력해주세요.');
			document.form.content.focus();
		}  else {
			document.form.encoding = "multipart/form-data";
			document.form.action = "admin_notice_update";
			document.form.submit();
		}
	}
	
	function go_notice_save(){
		if (document.form.subject.value == '') {
			alert('공지사항 제목을 입력해주세요.');
			document.form.subject.focus();
		} else if(document.form.content.value == ''){
			alert('공지사항 내용을 입력해주세요.');
			document.form.content.focus();
		} else if(document.form.notice_image.value == ''){
			alert('이미지를 선택해주세요.');
			document.form.notice_image.focus();
		} else {
			document.form.encoding = "multipart/form-data";
			document.form.action = "admin_notice_write";
			document.form.submit();
		}
	}
	
	function go_write() {
		document.frm.action="admin_notice_write_form";
		document.frm.submit();
	}
	
	function go_list(){
		document.frm.action="admin_notice_list";
		document.frm.submit();
	}
	
	function go_List(){
		document.form.action="admin_notice_list";
		document.form.submit();
	}
	
	function go_mod(nseq) {
		document.frm.action= "admin_notice_update_form?nseq"+nseq;
		document.frm.submit();
	}