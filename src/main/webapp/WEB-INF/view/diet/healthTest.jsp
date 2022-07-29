<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="ko">
   <head>
      <meta charset="UTF-8" />
      <link rel="icon" href="/img/just-eat-r-128.png" />
      <title>진단 | Just Eat</title>
      <link rel="stylesheet" href="/css/diet.css" />
   </head>
   <body>
        <form action="/health/new" method="post">
             <div class="test-out-box">
                  <div class="number_box">
                       <input class="health-input-number" type="number" name="height" placeholder="키를 입력하세요." step="0.1" min="100" max="300">
                       <input class="health-input-number" type="number" name="weight" placeholder="몸무게를 입력하세요." step="0.1" min="1" max="200">
                       <input class="health-input-number" type="number" id="health" name="goal" placeholder="목표까지 몸무게를 입력하세요." step="0.1" min="1" max="200">
                  </div>

                  <div class="select-exercise" role="radio-group">
                       <font size="2">평소 어떤 강도로 운동하시나요?</font>

                       <input type="radio" id="1" name="exercise" value="1.2">
                           <label for="1">아주 가볍게<br>호흡에 변함이 없는 정도<br>스트레칭</label>
                       <input type="radio" id="2" name="exercise" value="1.3">
                            <label for="2">조금 가볍게<br>숨이 깊어지지만, 편히 대화할 수 있는 정도<br>걷기, 가벼운 근력 회복 운동</label>
                       <input type="radio" id="3" name="exercise" value="1.4">
                            <label for="3">보통<br>대화하기엔 숨쉬기 다소 힘든 정도<br>적당한 달리기, 중강도 운동</label>
                       <input type="radio" id="4" name="exercise" value="1.5">
                            <label for="4">조금 강하게<br>숨이 많이 차고 숨쉬기 힘든 정도<br>빠른 달리기, 고강도 근력 운동</label>
                       <input type="radio" id="5" name="exercise" value="1.6">
                             <label for="5">아주 강하게<br>숨쉬기 매우 힘들고 극도로 힘이 드는 정도<br>전력으로 달리기 등</label>
                  </div>

                  <div class="exerciseNumber-box">
                       주 몇회 운동하시나요?
                       <div class="select-exerciseNumber" role="radio-group">
                            <input type="radio" id="5" name="exerciseNumber" value="0">
                                 <label for="5">주 0회</label>
                            <input type="radio" id="6" name="exerciseNumber" value="0.1">
                                 <label for="6">주 1~3회</label>
                            <input type="radio" id="7" name="exerciseNumber" value="0.2">
                                 <label for="7">주 4~6회</label>
                            <input type="radio" id="8" name="exerciseNumber" value="0.3">
                                 <label for="8">주 7회</label>
                       </div>
                  </div>

                  <div class="button-box">
                       <button class="health-button" type="submit">진단 시작</button>
                       <button class="health-button" type="reset">다시 작성</button>
                  </div>
             </div>
        </form>
   </body>
</html>