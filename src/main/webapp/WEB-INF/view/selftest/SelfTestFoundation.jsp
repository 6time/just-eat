<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>자가진단</title>
  <link rel="stylesheet" href="/css/style.css" />
</head>

<body>
<fieldset class="member-out-box">
<br/>
<form action="selftest" method="post">
  <p></p>

    <div class="member-btn-c">
    <center><h1>오늘 하루 자가진단</h1></center>
    </div>
    <br/>
    <center><h3>오늘 하루동안 섭취한 칼로리를 입력하세요.</h3>
    <input type="number" min='0' max='100000' name="daykcal" class="self-input-text" style="text-align:center" placeholder="칼로리" required>
    <br/>

  </div><br/>

  <div>

    <center><h3>현재 몸무게를 입력하세요.</h3><center>
    <input type="number" min='1' max='650' name="dayweight"  class="self-input-text" style="text-align:center" placeholder="몸무게" required>
    <br/>

  </div><br/>
  <div>
    <h3>오늘 하루동안 한 운동량을 입력하세요.</h3>
    <input type="radio" name="dayexercise" value="1" checked>1단계
    <input type="radio" name="dayexercise" value="2" >2단계
    <input type="radio" name="dayexercise" value="3" >3단계
    <input type="radio" name="dayexercise" value="4" >4단계
    <input type="radio" name="dayexercise" value="5" >5단계
    <br>
  </div>
    </center>
    <center><h3>단계별 부가 설명</h3></center>
    <p style="font-size: large">1단계 호흡의 변화 없음 (스트레칭)</p>
    <p style="font-size: large">2단계 숨이 깊어지지만 편히 대화 가능 (걷기)</p>
    <p style="font-size: large">3단계 대화하기엔 숨쉬기 다소 힘든정도 <br>(적당한 달리기)</p>
    <p style="font-size: large">4단계 숨이 많이 차고 숨쉬기 힘든 정도 <br>(빠른 달리기)</p>
    <p style="font-size: large">5단계 숨쉬기 매우 힘들고 극도록 힘이 드는 정도 <br>(전력 달리기)</p>

  <input type="hidden" name="member_id" value="${sessionScope.session}"/>
  <input type="hidden" name="name" value="${name}"/>
  <p align="right">
  <input type="submit" value="제출">
  <input type="reset" value="다시작성">
  </p>


</form>
</body>
</html>