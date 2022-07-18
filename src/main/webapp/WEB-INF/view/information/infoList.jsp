<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8" %> <%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%> <%@taglib prefix="fmt"
uri="http://java.sun.com/jstl/fmt_rt"%>
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
          <table class="article-table">
            <thead>
              <tr class="article-table-header">
                <th>번호</th>
                <th>제목</th>
                <th>글쓴이</th>
                <th>작성일</th>
                <th>조회</th>
                <th>추천</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="board" items="${infoBoardList}">
                <tr>
                  <td>${board.info_id}</td>
                  <td class="article-body-title">
                    <a href="<c:url value='/info/${board.info_id}'/>"
                      >${board.title}</a
                    >
                  </td>
                  <td class="article-body-author">${board.writer}</td>
                  <td>
                    <fmt:formatDate
                      value="${board.reg_date}"
                      pattern="yyyy-MM-dd"
                      type="date"
                    />
                  </td>
                  <td>${board.view_cnt}</td>
                  <td>추천</td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
          <c:if test="${sessionScope.session!=null}">
            <a class="member-btn-a" href="<c:url value='/info/write'/>"
              >글 작성</a
            >
          </c:if>
          <a class="member-btn-b" href="/"> 홈으로 돌아가기 </a>
        </div>
      </div>
    </div>
  </body>
</html>
