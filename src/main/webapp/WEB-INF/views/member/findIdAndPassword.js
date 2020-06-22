/**
 * 
 */
function find_id_form() {
	var url = "find_id_form";
	
	window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=400, height=400");
}

function findMemberId() {
	if (document.findId.name.value=="") {
		alert("이름을 입력해 주세요");
		document.findId.name.focus();
	} else if (document.findId.mail.value=="") {
		alert("이메일을 입력해 주세요");
		document.findId.mail.focus();
	} else {
		document.findId.action = "find_id";
		document.findId.submit();
	}
}

function findPassword() {
	if (document.findPW.Id.value=="") {
		alert("아이디를 입력해 주세요");
		document.findPW.Id.focus();
	} else if (document.findPW.name.value=="") {
		alert("이름을 입력해 주세요");
		document.findPW.name.focus();
	} else if (document.findPW.mail.value=="") {
		alert("이메일을 입력해 주세요");
		document.findPW.mail.focus();
	} else {
		document.findPW.action = "find_password";
		document.findPW.submit();
	}
}