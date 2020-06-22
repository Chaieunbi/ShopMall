/**
 * 
 */
function go_review() {
	if(document.formm.subject.value == "") {
		alert("제목을 입력해주세요.");
		document.formm.subject.focus();
		return false;
	} else if(document.formm.content.value == "") {
		alert("내용을 입력해주세요.");
		document.formm.content.focus();
		return false;
	} else if(document.formm.image.value == "") {
		alert("사진을 선택해주세요.");
		return false;
	}else {
		document.formm.action = "review_write";
		document.formm.submit();
	}return true;
}

function go_review_view(rseq){
	document.formm.action = "review_view?rseq"+rseq;
	document.formm.submit();
}

function go_review_save(rseq) {
	if(document.formm.subject.value == "") {
		alert("제목을 입력해주세요.");
		document.formm.subject.focus();
		//return false;
	} else if(document.formm.content.value == "") {
		alert("내용을 입력해주세요.");
		document.formm.content.focus();
		//return false;
	} else if(document.formm.image.value == "") {
		alert("이미지을 선택해주세요.");
		//return false;
	}else {
		document.formm.encoding = "multipart/form-data";
		document.formm.action = "review_update";
		document.formm.submit();
	}//return true;
}

function go_review_mod(rseq){
	var theForm = document.formm;
	theForm.action = "review_update_form?rseq"+rseq;
	theForm.submit();
}

function go_review() {
	if(document.formm.subject.value == "") {
		alert("제목을 입력해주세요.");
		document.formm.subject.focus();
		//return false;
	} else if(document.formm.content.value == "") {
		alert("내용을 입력해주세요.");
		document.formm.content.focus();
		//return false;
	} else if(document.formm.image.value == "") {
		alert("이미지을 선택해주세요.");
		//return false;
	}else {
		document.formm.action = "review_write";
		document.formm.submit();
	}//return true;
}
