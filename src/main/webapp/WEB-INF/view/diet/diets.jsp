<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="ko">
    <head>
      <meta charset="UTF-8" />
      <link rel="icon" href="/img/just-eat-r-128.png" />
      <title>진단결과 | Just Eat</title>
   </head>
   <body>
      <h4>${name}님 금주의 식단!!</h4>
      <p>※ 목표까지 소요기간<br>
         ${health.goal_week}주</p>
      <h6>월</h6>
   </body>
</html>