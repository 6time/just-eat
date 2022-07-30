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
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
  </head>
  <body>
    <div class="box">
      <div class="article-box">
        <div class="member-title">공지사항</div>
        <div class="nav"></div>
        <div class="member">
        <form action="" method="">
          <input type="text" name="member_id" value="${info.member_id}"/>
          <div class="member-title">${info.title}</div>
          <div class="member-title">${info.content}</div>
          <c:if test="${sessionScope.session!=null}">
            <a class="member-btn-a" href="<c:url value='/info/${info.member_id}/${info.info_id}'/>"
              >공지사항 수정</a
            >
            <a class="member-btn-a" id="remove-btn" href="<c:url value='/info/delete/${sessionScope.session}/${info.info_id}'/>"
              >공지사항 삭제</a
            >
          </c:if>
          </form>
          <a class="member-btn-b" id="list-btn" href="/info/list"> 목록으로 돌아가기 </a>
        </div>
      </div>
    </div>
    <script>
    $(document).ready(function(){
        $('#list-btn').on("click", function(){
            location.href = "<c:url value= '/info/list'/>?page=${page}&pageSize=${pageSize}";
        });
        $('#remove-btn').on("click", function(){
                if(!confirm("정말로 삭제하시겠습니까?")) return;
                let form = $('#form');
                form.attr("action", "<c:url value='/info/delete/${sessionScope.session}/${info.info_id}'/>?page=${page}&pageSize=${pageSize}"
                form.attr("method", "post");
                form.submit();
                });
                });
  </body>
</html>
