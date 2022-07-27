<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="ko">
   <head>
      <meta charset="UTF-8" />
      <link rel="icon" href="/img/just-eat-r-128.png" />
      <title>진단 | Just Eat</title>
      <link rel="stylesheet" href="/css/style.css" />
   </head>
   <body>
      <form action="/health/new" method="post">
         <p>키를 입력하세요.<br>
         <input type="number" id="health" name="height" placeholder="예) 160.0" step="0.1" min="100" max="300"></p>

         <p>몸무게를 입력하세요.<br>
         <input type="number" id="health" name="weight" placeholder="예) 40.0" step="0.1" min="1" max="200"></p>

         <p>목표까지의 몸무게를 입력하세요.<br>
         <input type="number" id="health" name="goal" placeholder="예) 40.0" step="0.1" min="1" max="200"></p>

         <b>평소 어떤 강도로 운동하시나요?</b><br>
         <p><input type="radio" id="health" name="exercise" value="1.2">아주 가볍게<br>
            <font size="2">&nbsp; &nbsp; &nbsp;호흡에 변함이 없는 정도<br>
                &nbsp; &nbsp; &nbsp;스트레칭</font></p>
         <p><input type="radio" id="health" name="exercise" value="1.3">조금 가볍게<br>
            <font size="2">&nbsp; &nbsp; &nbsp;숨이 깊어지지만, 편히 대화할 수 있는 정도<br>
                 &nbsp; &nbsp; &nbsp;걷기, 가벼운 근력 회복 운동</font></p>
         <p><input type="radio" id="health" name="exercise" value="1.4">보통<br>
            <font size="2">&nbsp; &nbsp; &nbsp;대화하기엔 숨쉬기 다소 힘든 정도<br>
                 &nbsp; &nbsp; &nbsp;적당한 달리기, 중강도 운동</font></p>
         <p><input type="radio" id="health" name="exercise" value="1.5">조금 강하게<br>
            <font size="2">&nbsp; &nbsp; &nbsp;숨이 많이 차고 숨쉬기 힘든 정도<br>
                 &nbsp; &nbsp; &nbsp;빠른 달리기, 고강도 근력 운동</font></p>
         <p><input type="radio" id="health" name="exercise" value="1.6">아주 강하게<br>
            <font size="2">&nbsp; &nbsp; &nbsp;숨쉬기 매우 힘들고 극도로 힘이 드는 정도<br>
                 &nbsp; &nbsp; &nbsp;전력으로 달리기 등</font></p>

         <b>주 몇회 운동하시나요?</b><br>
         <p>
            <input type="radio" id="health" name="exerciseNumber" value="0">주 0회<br>
            <input type="radio" id="health" name="exerciseNumber" value="0.1">주 1~3회<br>
            <input type="radio" id="health" name="exerciseNumber" value="0.2">주 4~6회<br>
            <input type="radio" id="health" name="exerciseNumber" value="0.3">주 7회<br>
         </p>
         <p></p>
            <input type="submit" value="진단시작">
            <input type="reset" value="다시작성">
      </form>
   </body>
</html>