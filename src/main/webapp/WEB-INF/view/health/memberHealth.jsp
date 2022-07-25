<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="ko">
   <head>
      <meta charset="UTF-8" />
      <link rel="icon" href="/img/just-eat-r-128.png" />
      <title>진단결과 | Just Eat</title>
      <link rel="stylesheet" href="/css/style.css" />
   </head>
   <body>
   <h4>${member.name}님의 진단정보</h4>
   <p>※ 목표까지 소요기간<br>
      ${health.goalWeek}주</p>
   <p>※ 하루동안 섭취해야할 칼로리<br>
      ${health.kcal}kcal</p>
      <!-- <p>※ 탄수화물<br>
                 ${carb}g</p>
              <p>※ 단백질<br>
                 ${protein}g</p>
              <p>※ 지방<br>
                 ${fat}g</p> -->

   </body>
</html>