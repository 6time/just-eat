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
        <div class="member-title">공지사항</div>
        <div class="nav"></div>
        <div class="member">
          <div class="member-title">${info.title}</div>
          <div class="member-title">${info.content}</div>
          <c:if test="${sessionScope.session!=null}">
            <a class="member-btn-a" href="<c:url value='/info/delete/${member_id}/${info_id}'/>"
              >공지사항 수정</a
            >
            <a class="member-btn-a" href="<c:url value='/info/delete/${sessionScope.session.member_id}/${info.info_id}'/>"
              >공지사항 삭제</a
            >
          </c:if>
          <a class="member-btn-b" href="/info/list"> 목록으로 돌아가기 </a>
        </div>
      </div>
    </div>
  </body>
</html>
