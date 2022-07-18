<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8" %> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <link rel="icon" href="/img/just-eat-r-128.png" />
    <title>공지사항 | Just Eat</title>
    <link rel="stylesheet" href="/css/style.css" />
  </head>
  <body>
    <div class="box">
      <div class="article-box">
        <div class="login-title">공지사항</div>
        <div class="nav"></div>
        <div class="login-text">게시글</div>
        <div class="nav"></div>
        <div class="member">

          <c:if test="${sessionScope.session!=null}">
            <a class="member-btn-a" href="<c:url value='/self'/>">글 작성</a>
          </c:if>
          <button
            class="member-btn-b"
            onclick="location.href='/'"
            type="button"
          >
            홈으로 돌아가기
          </button>
        </div>
      </div>
    </div>
  </body>
</html>
