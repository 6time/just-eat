<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8" %> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="error" value="${param.error == 1 ? '⚠️ 이메일 또는 비밀번호가 일치하지 않습니다.' : '' }"/>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <link rel="icon" href="/img/just-eat-r-128.png" />
    <title>로그인 | Just Eat</title>
    <link rel="stylesheet" href="/css/style.css" />
  </head>
  <body>
    <div class="member-out-box">
      <form
        action="<c:url value='/members'/>"
        method="post"
        onsubmit="return formCheck(this)"
      >
        <div class="member-submit-box">
          <img
            class="icon"
            src="/img/just-eat-r-1280.png"
            style="height: 120px"
          />
          <div class="member-title">로그인</div>
          <div class="member-title" style="font-size: 16px">
            Just Eat 계정 사용
          </div>
          <button
            id="kakao"
            class="member-btn-sns"
            onclick="location.href='https://kauth.kakao.com/oauth/authorize?client_id=5739de64ac097aace6fd7e1231e8f94b&redirect_uri=http://localhost:3070/members/kakao&response_type=code'"
            type="button"
          >
            <img
              id="kakao"
              src="https://www.svgrepo.com/show/368252/kakao.svg"
              style="height: 24px"
            />
            <span class="sns-text">1초 만에 카카오로 로그인하기</span>
          </button>
          <div class="warning-msg" id="msg">${error}</div>
          <input
            class="member-input-text"
            type="text"
            name="email"
            value="${cookie.email.value}"
            placeholder="이메일"
          />
          <input
            class="member-input-text"
            type="password"
            name="password"
            placeholder="비밀번호"
          />
          <input type="hidden" name="toURL" value="${param.toURL}" />
          <button class="member-btn-a" type="submit">로그인</button>
          <label class="remember-id"
            ><input type="checkbox" name="rememberId" ${empty cookie.email.value
            ? "" : "checked"}>ID 기억하기</label
          >
          <div>아직 회원이 아니신가요?</div>
          <a href="/members/signUp">계정 생성</a>
        </div>
      </form>
    </div>
    <script src="/js/app.js"></script>
  </body>
</html>
