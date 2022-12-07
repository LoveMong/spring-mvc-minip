	
// 게시글 등록 유효성 검사
function boardCheck() {

	if (document.frm.board_writer.value.length === 0) {
		alert("작성자를 입력해주세요.");
		frm.board_writer.focus();
		return false;
	}
	if (document.frm.board_pwd.value.length === 0) {
		alert("비밀번호를 입력해주세요.");
		frm.board_pwd.focus();
		return false;
	}
	if (document.frm.board_title.value.length === 0) {
		alert("제목을 입력해주세요.");
		frm.board_title.focus();
		return false;
	}
	if (document.frm.board_content.value.length === 0) {
		alert("내용을 입력해주세요.");
		frm.board_content.focus();
		return false;
	}

	frm.submit();

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

		return false

	}


}






