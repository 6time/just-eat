function formCheck(frm) {
    var msg = '';

    if(frm.member_id.value.length < 3) {
        setMessage('ID 의 길이는 3 이상이어야 합니다.');
        return false;
    }

    if(frm.password.value.length < 3) {
        setMessage('비밀번호의 길이는 3 이상이어야 합니다.');
        return false;
    }

    return true;
}

function setMessage(msg, element){
    document.getElementById("msg").innerHTML = '<i class="inner-message"> ${'${msg}'}</i>';

    if(element) {
        element.select();
    }
}