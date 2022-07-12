function formCheck(frm) {
    var msg = '';
    if(frm.member_id.value.length < 3) {
        setMessage('ID 의 길이는 3 이상이어야 합니다.')
    }

}