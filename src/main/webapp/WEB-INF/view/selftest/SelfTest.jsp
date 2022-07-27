<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<html lang="ko">
<html>
    <head>
       <meta charset="UTF-8">
       <title>자가진단 결과</title>
       <link rel="stylesheet" href="/css/style.css" />
    </head>
    <body>
    <div class="member-out-box">
        <center>
        <div class="member-btn-a">
        <h1>${param.name}님의 오늘의 헬스 다이어리</h1>
        </div>
        <%request.setCharacterEncoding("UTF-8");%>

        <div><h3>
        칼로리 : <b>${param.daykcal}kcal</b><br>
        몸무게 : <b>${param.dayweight}kg</b><br>
        운동량 : <b>${param.dayexercise}단계</b>
        </h3></div>
        <br>

        <button class="home button" onclick="location.href='/'" >
        홈으로 돌아가기
        <br>
        <button type="button" class="healthBtn" onClick="location.href='health'">
        헬스 테스트 하러가기
        <button type="button" class="healthBtn" onClick="location.href='list'">
        나의 헬스 다이어리 보러 가기
    </div>
    </body>
</html>