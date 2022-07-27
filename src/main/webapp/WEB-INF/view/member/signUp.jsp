<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8" %> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="ko">
   <head>
      <meta charset="UTF-8" />
      <link rel="icon" href="/img/just-eat-r-128.png" />
      <title>회원 가입 | Just Eat</title>
      <link rel="stylesheet" href="/css/style.css" />
   </head>
   <body>
      <form
         action="/members/signUp"
         method="post"
         onsubmit="return formCheck(this)"
      >
         <div class="member-out-box">
            <div class="member-submit-box">
               <img
                  class="icon"
                  src="/img/just-eat-r-1280.png"
                  style="height: 120px"
               />
               <div class="member-title">회원 가입</div>
               <div class="member-title" style="font-size: 16px">
                  Just Eat 에 오신 것을 환영합니다.
               </div>
               <div class="warning-msg" id="msg"></div>
               <input
                  class="member-input-text"
                  type="text"
                  name="email"
                  placeholder="이메일"
                  autofocus
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
                  name="nickname"
                  placeholder="이름"
               />
               <input
                  class="member-input-text"
                  type="text"
                  name="phone"
                  placeholder="전화번호"
               />
               <input
                  class="member-input-text"
                  type="text"
                  name="address"
                  placeholder="주소"
               />
               <input
                  class="member-input-text"
                  type="text"
                  name="birth"
                  placeholder="생일"
               />
               <input type="text" id="name" name="gender" hidden />
               <div class="select-gender" role="radio-group">
                  <input
                     type="radio"
                     id="male"
                     name="sex"
                     onclick="document.querySelector('#name').value = 'male'"
                  /><label for="male">남성</label>
                  <input
                     type="radio"
                     id="female"
                     name="sex"
                     onclick="document.querySelector('#name').value = 'female'"
                  /><label for="female">여성</label>
               </div>
               <button class="member-btn-a" type="submit">회원 가입</button>
               <button class="member-btn-b" onclick="location.href='/'">
                  홈으로 돌아가기
               </button>
            </div>
         </div>
      </form>
      <script src="/js/app.js"></script>
   </body>
</html>
