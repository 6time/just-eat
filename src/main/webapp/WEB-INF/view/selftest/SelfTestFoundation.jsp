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
  <fieldset style="max-width: fit-content">
<div>
<h2>오늘 하루 자가진단</h2>
<form action="selftest" method="post">
  <p></p>
  <fieldset style="max-width: 11cm">

    오늘 하루동안 섭취한 칼로리를 입력하세요.
    <br/><br/>
    <input type="number" min='0' max='100000' name="daykcal" size="20" required>
    <br/>

  </fieldset>
  </div><br/>

  <div>
  <fieldset style="max-width: 11cm">

    현재 몸무게를 입력하세요.
    <br/><br/>
    <input type="number" min='1' max='650' name="dayweight" size="20" required>
    <br/>

  </fieldset>
  </div><br/>

  <div>
  <fieldset style="max-width: 11cm">
    오늘 하루동안 한 운동량을 입력하세요.
    <br/><br/>
    <input type="radio" name="dayexercise" value="1" checked>1단계
    <input type="radio" name="dayexercise" value="2" >2단계
    <input type="radio" name="dayexercise" value="3" >3단계
    <input type="radio" name="dayexercise" value="4" >4단계
    <input type="radio" name="dayexercise" value="5" >5단계
  </fieldset>
  </div>

  <div>
  <fieldset style="max-width: 11cm">
    <legend><p style="font-size: large">단계별 부가 설명</p></legend>
    <p>1단계 호흡의 변화 없음 (스트레칭)</p>
    <p>2단계 숨이 깊어지지만 편히 대화 가능 (걷기)</p>
    <p>3단계 대화하기엔 숨쉬기 다소 힘든정도 <br>(적당한 달리기)</p>
    <p>4단계 숨이 많이 차고 숨쉬기 힘든 정도 <br>(빠른 달리기)</p>
    <p>5단계 숨쉬기 매우 힘들고 극도록 힘이 드는 정도 <br>(전력 달리기)</p>
  </fieldset>
  </div>
  <input type="hidden" name="member_id" value="${sessionScope.session.member_id}"/>
  <input type="hidden" name="name" value="${sessionScope.session.name}"/>
  <p/>
  <input type="submit" value="제출" >
  <input type="reset" value="다시작성">
  <p></p>

</fieldset>
</form>
</body>
</html>