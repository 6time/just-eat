<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <link rel="icon" href="/img/just-eat-r-128.png" />
    <title>로그인 | Just Eat</title>
    <link rel="stylesheet" href="/css/style.css" />
  </head>
  <body>
  <c:if test="true">HELLO</c:if>
    <div class="member-title">로그인</div>
    <input class="member-input" placeholder="이메일" />
    <input class="member-input" placeholder="비밀번호" />
    <button class="member-button">로그인</button>
  </body>
</html>
