	
// 게시글 등록 유효성 검사
function boardCheck() {

	if (document.frm.name.value.length == 0) {
		alert("작성자를 입력해주세요.");
		frm.name.focus();
		return false;
	}
	if (document.frm.pass.value.length == 0) {
		alert("비밀번호를 입력해주세요.");
		frm.pass.focus();
		return false;
	}
	if (document.frm.title.value.length == 0) {
		alert("제목을 입력해주세요.");
		frm.title.focus();
		return false;
	}
	
	return true;

}

function open_win(url, name) {

	let popupX = (window.screen.width / 2) - (450 / 2);
	popupX += window.screenLeft;
	let popupY = (window.screen.height / 2) - (400 / 2);
	let option = "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=400, left=" + popupX + ", top=" + popupY;

	window.open(url, name, option);

}
// window.open을 이용한 idCheck version
// let url = "/register/checkId?member_id=" + document.jrm.member_id.value;
// let popupX = (window.screen.width / 2) - (450 / 2);
// popupX += window.screenLeft;
// let popupY = (window.screen.height / 2) - (400 / 2);
// let option = "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=400, left=" + popupX + ", top=" + popupY;
// window.open(url, "_blank", option);

function passCheck() {
	
	if (document.frm.pass.value.length == 0) {
	
		alert("비밀번호를 입력하세요.");

		return false;
		
		}
	
	return true;

}



