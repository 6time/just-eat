function formCheck(frm) {
  var msg = "";

  if (frm.email.value.length < 3) {
    setMessage("⚠️ 이메일의 길이는 3 이상이어야 합니다.", frm.email);
    return false;
  } else if (
    !frm.email.value.includes("@") ||
    !frm.email.value.includes(".com")
  ) {
    setMessage("⚠️ 올바른 이메일 형식을 입력해주세요.");
    return false;
  }

  if (frm.password.value.length < 3) {
    setMessage("⚠️ 비밀번호의 길이는 3 이상이어야 합니다.");
    return false;
  }

  if (frm.nickname.value == "") {
    setMessage("⚠️ 이름을 적어주세요.");
    return false;
  }

  if (frm.gender.value == "") {
    setMessage("⚠️ 성별을 선택해주세요.");
    return false;
  }

  return true;
}

function setMessage(msg) {
  document.getElementById("msg").innerHTML = msg;
}
