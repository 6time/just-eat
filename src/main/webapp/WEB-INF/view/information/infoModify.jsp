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
        <form
          action="<c:url value='/info/modify/${info.member_id}'/>"
          method="post"
        >
          <div class="member-title">공지사항 수정</div>
          <div class="nav"></div>
          <div class="member">
            <input
              class="member-input-text"
              name="title"
              placeholder="공지사항 제목"
            />
            <input
              class="member-input-text"
              name="content"
              placeholder="공지사항 내용"
            />
            <button class="member-btn-a" type="submit">공지사항 수정</button>
            <a class="member-btn-b" href="/info/list"> 목록으로 돌아가기 </a>
          </div>
        </form>
      </div>
    </div>
  </body>
</html>
