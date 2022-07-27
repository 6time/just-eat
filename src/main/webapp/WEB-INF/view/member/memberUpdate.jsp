<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8" %> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="error" value="${param.error == 1 ? '⚠️ 비밀번호가 일치하지 않습니다.' : '' }"/>
<html lang="ko">
   <head>
      <meta charset="UTF-8" />
      <link rel="icon" href="/img/just-eat-r-128.png" />
      <title>회원 정보 | Just Eat</title>
      <link rel="stylesheet" href="/css/style.css" />
   </head>
   <body>
      <div class="member-out-box">
         <div class="member-submit-box">
            <form
               class="member-form"
               action="/members/info/${sessionScope.session}"
               method="post"
               onsubmit="return formCheck(this)"
            >
               <img
                  class="icon"
                  src="/img/just-eat-r-1280.png"
                  style="height: 120px"
               />
               <div class="member-title">회원 정보</div>
               <div class="member-title" style="font-size: 16px">
                  회원 정보 수정
               </div>
               <div class="warning-msg" id="msg">${error}</div>
               <input
                  class="member-input-text"
                  type="text"
                  name="email"
                  placeholder="이메일"
                  value="${updateMember.email}"
                  disabled
               />
               <input
                  class="member-input-text"
                  type="password"
                  name="password"
                  placeholder="비밀번호"
               />
               <input
                  class="member-input-text"
                  type="text"
                  name="name"
                  placeholder="이름"
                  value="${updateMember.name}"
               />
               <input
                  class="member-input-text"
                  type="text"
                  name="phone"
                  placeholder="전화번호"
                  value="${updateMember.phone}"
               />
               <input
                  class="member-input-text"
                  type="text"
                  name="address"
                  placeholder="주소"
                  value="${updateMember.address}"
               />
               <input
                  class="member-input-text"
                  type="text"
                  name="birth"
                  placeholder="생일"
                  value="${updateMember.birth}"
               />
               <button class="member-btn-a" type="submit">
                  회원 정보 수정
               </button>
            </form>
            <button class="member-btn-b" onclick="location.href='/'">
               홈으로 돌아가기
            </button>
         </div>
      </div>
      <script src="/js/app.js"></script>
   </body>
</html>
