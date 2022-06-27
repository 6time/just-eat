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
<h2>오늘 하루 자가진단</h2>
<form action="/st" method="post">

  <fieldset style="max-width: 10cm">
    오늘 하루동안 섭취한 칼로리를 입력하세요.
    <br/>
    <br/>
    <input type="text" name="kcal" size="20">
    <br/>
  </field-set>

  <br/>

  <fieldset style="max-width: 10cm">
    현재 몸무게를 입력하세요.
    <br/>
    <br/>
    <input type="text" name="weight" size="20">
    <br/>
  </fieldset>

  <br/>

  <fieldset style="max-width: 10cm">
    오늘 하루동안 한 운동량을 입력하세요.
    <br/>
    <br/>
    <input type="radio" name="energy" value="1" >1단계
    <input type="radio" name="energy" value="2" >2단계
    <input type="radio" name="energy" value="3" >3단계
    <input type="radio" name="energy" value="4" >4단계
    <input type="radio" name="energy" value="5" >5단계
  </fieldset>

  <fieldset style="max-width: 10cm">
    <legend><p style="font-size: large">단계별 부가 설명</p></legend>
    <p></p>
    <p>1단계</p>
    <p>2단계</p>
    <p>3단계</p>
    <p>4단계</p>
    <p>5단계</p>
  </fieldset>

  <p></p>
  <input type="submit" value="제출" >
  <input type="reset" value="다시작성" >

</form>
</body>
</html>