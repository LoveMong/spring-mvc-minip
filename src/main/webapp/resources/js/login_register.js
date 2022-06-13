
let id;
let jpwd;
let cpwd;
let name;
let email;
// 공백만 입력된 경우
let blank_pattern = /^\s+|\s+$/g;
//문자열에 공백이 있는 경우
let blank_pattern_S = /[\s]/g;
//특수문자가 있는 경우
let special_pattern = /[`~!@#$%^&*|\\\'\";:\/?]/gi;
// 비밀번호 유효성 검사
let password_pattern = /^[a-zA-z0-9]{4,12}$/;


$(document).ready(function(){

// login_register 폼 변경 TAP
    $('#login-form-link').click(function(e) {
        $("#login-form").delay(100).fadeIn(100);
        $("#register-form").fadeOut(100);
        $('#register-form-link').removeClass('active');
        $(this).addClass('active');
        e.preventDefault();
    });
    $('#register-form-link').click(function(e) {
        $("#register-form").delay(100).fadeIn(100);
        $("#login-form").fadeOut(100);
        $('#login-form-link').removeClass('active');
        $(this).addClass('active');
        e.preventDefault();
    });

// 아이디 생성 시 중복 검사
    $('#idCheck').click(function(){

        id = document.getElementById("member_id").value;

        if (id === "") {
            setMessage_Join("아이디를 입력해주세요.", jrm.member_id)
            jrm.member_id.focus();
            return false;
        }
        if (id.replace(blank_pattern, '') === "") {
            setMessage_Join("아이디에 공백이 포함되었습니다.", jrm.member_id)
            jrm.member_id.focus();
            return false;
        }
        if (blank_pattern_S.test(id) === true) {
            setMessage_Join("아이디에 공백이 포함되었습니다.", jrm.member_id)
            jrm.member_id.focus();
            return false;
        }
        if (special_pattern.test(id) === true) {
            setMessage_Join("아이디에 특수문자가 포함되었습니다.", jrm.member_id)
            jrm.member_id.focus();
            return false;
        }
        if (id.search(/\W|\s/g) > -1) {
            setMessage_Join("아이디에 공백 또는 특수문자가 포함되었습니다.", jrm.member_id)
            jrm.member_id.focus();
            return false;
        }


        let url = "/register/checkId?member_id=" + document.jrm.member_id.value;
        let popupX = (window.screen.width / 2) - (450 / 2);
        popupX += window.screenLeft;
        let popupY = (window.screen.height / 2) - (400 / 2);
        let option = "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=400, left=" + popupX  + ", top=" + popupY;
        window.open(url, "_blank", option);


    });

    document.getElementById("member_id").onclick = function () {

        document.getElementById("idCheck").value = "Check ID";

    }

// 중복 체크된 아이디 사용
    $('#start').click(function(){

        let member_id = $('#member_id').val();

        opener.jrm.member_id.value = member_id; //opener -> 자식창에서 부모창 선택

        opener.jrm.idCheck.value = "Check Completed";

        self.close();

    });




});

// Login 유효성 검사
function loginCheck() {

    if (document.frm.memberId.value.length == 0) {
        setMessage_Login('아이디를 입력해주세요.', frm.member_id)
        return false;
    }
    if (document.frm.memberPwd.value == "") {
        setMessage_Login('패스워드를 입력해주세요.', frm.memberPwd)
        return false;
    }

    return true;

}
function setMessage_Login(message, element){
    document.getElementById("message").innerHTML = `<i class="fa fa-exclamation-circle"> ${message}</i>`;
    if(element) {
        element.select();
    }
}




function joinCheck() {

    id = document.getElementById("member_id").value;
    jpwd = document.getElementById("member_jpwd").value;
    cpwd = document.getElementById("member_cpwd").value;
    name = document.getElementById("member_name").value;
    email = document.getElementById("member_email").value;

    if(document.getElementById("idCheck").value === "Check ID") {
        setMessage_Join("아이디 확인이 필요합니다.", jrm.member_id);
        jrm.member_id.focus();
        return false;
    }

    if (name == "") {
        setMessage_Join("이름을 입력해주세요.", jrm.member_name);
        return false;
    }
    if (email == "") {
        setMessage_Join("이메일을 입력해주세요.", jrm.member_email);
        return false;
    }
    if (jpwd == "") {
        setMessage_Join("비밀번호를 입력해주세요.", jrm.member_jpwd);
        return false;
    }
    if (!password_pattern.test(jpwd)) {
        setMessage_Join("비밀번호는 영문 대소문자와 숫자 4~12자리로 입력해주세요.", jrm.member_jpwd);
        return false;
    }
    if (cpwd == "") {
        setMessage_Join("비밀번호를 확인해주세요.", jrm.member_cpwd);
        return false;
    }
    if (jpwd != cpwd) {
        setMessage_Join("비밀번호가 일치하지 않습니다.", jrm.member_cpwd);
        return false;
    }

    document.register_form.submit();


}

function setMessage_Join(message, element){
    document.getElementById("message_join").innerHTML = `<i class="fa fa-exclamation-circle"> ${message}</i>`;
    if(element) {
        element.select();
    }
}

function idok(userid) {

    opener.jrm.userid.value = document.jrm.userid.value;

    self.close();
};

function editCheck() {


    let epwd = document.getElementById('epwd').value;
    let ecpwd = document.getElementById('ecpwd').value;


    if (document.prm.userid.value.length == 0) {
        alert("아이디를 입력해주세요.");
        prm.userid.focus();
        return false;
    }
    if (document.prm.name.value.length == 0) {
        alert("이름을 입력해주세요.");
        prm.name.focus();
        return false;
    }
    if (document.prm.email.value.length == 0) {
        alert("이메일을 입력해주세요.");
        prm.email.focus();
        return false;
    }
    if (document.prm.epwd.value == "") {
        alert("암호는 반드시 입력해야 합니다.");
        prm.epwd.focus();
        return false;
    }
    if (document.prm.ecpwd.value == "") {
        alert("비밀번호를 확인해주세요.");
        prm.ecpwd.focus();
        return false;
    }
    if (epwd != ecpwd) {
        alert("비밀번호를 확인해주세요.");
        prm.cpwd.focus();
        return false;
    }

    return true;

}