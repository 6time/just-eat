<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="ko">
   <head>
      <meta charset="UTF-8" />
      <link rel="icon" href="/img/just-eat-r-128.png" />
      <title>진단결과 | Just Eat</title>
      <link rel="stylesheet" href="/css/diet.css" />
   </head>
   <body>
       <div class="health-out-box">
           <div class="health-title">${name}님의 진단정보</div>
               <div class="health-box">
                   <p></p>
                   <p>※ 목표까지 소요기간<br>
                   ${health.goal_week}주</p>
                   <p>※ 하루동안 섭취해야할 칼로리<br>
                   ${health.kcal_min}kcal~${health.kcal_max}kcal</p>
                   <p>※ 단백질<br>
                   ${health.protein_min}g~${health.protein_max}g</p>
                   <p>※ 탄수화물<br>
                   ${health.carb_min}g~${health.carb_max}g</p>
                   <p>※ 지방<br>
                   ${health.fat_min}g~${health.fat_max}g</p>
               </div>

               <div class="button-box">
                   <button class="health-button" onclick="location.href='/health/new'">다시 진단하기</button>
                   <button class="health-button" onclick="location.href='/'">홈으로 돌아가기</button>
               </div>
       </div>
   </body>
</html>