<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<html lang="ko">
<html>
    <head>
       <meta charset="UTF-8">
       <title>자가진단 결과</title>
       <style type="text/css">
       <link rel="stylesheet" href="/css/style.css" />
        b{
            font-size: 16pt;
        }
       </style>
    </head>
    <body>

        <fieldset style="max-width: 10cm">
        <legend><p style="font-size: large">회원님의 자가진단 결과</p></legend>
        <%request.setCharacterEncoding("UTF-8");%>

        <div>
        오늘 먹은 칼로리 : <b>${param.daykcal}kcal</b><br>
        몸무게 : <b>${param.dayweight}kg</b><br>
        오늘 한 운동량은 : <b>${param.dayexercise}단계</b>
        </div>





        <!--
        request.getParameter("name값") <- 데이터 입력 가져오기
        getParameter는 String으로 결과값 리턴
        getParameterValues는 여러개 리턴할때 사용 String 배열로 리턴
        String *Arr[] = request.getParameterValues("name값")
        for(String * : *Arr){ }로 처리
        switch 문은 int 값만 취급 따라서 String 값을 int로 바꿔주기
        -->




        </fieldset>
        <br>
        <fieldset style="max-width: 10cm">
        <div>
        <%
        out.println("추천 식단 리스트");

        %>
        </div>
        </fieldset>
        <br>
        <b><a href='javascript:history.go(-1)'>처음으로</a></b>
    </body>
</html>