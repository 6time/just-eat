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
        <h2>자가진단 결과</h2>
        <%
        request.setCharacterEncoding("UTF-8");        //request.getParameter("name값") <- 데이터 입력 가져오기
        String kcal = request.getParameter("kcal");  //getParameter는 String으로 결과값 리턴
        out.println("오늘 먹은 칼로리 : <b>"+kcal+"</b><br>");

        String weight = request.getParameter("weight");
        out.println("몸무게 : <b>"+weight+"</b><br>");

        String energy = request.getParameter("energy"); //getParameterValues는 여러개 리턴할때 사용 String 배열로 리턴
        out.println("오늘 한 운동량은");                  //String *Arr[] = request.getParameterValues("name값")
                                                       //for(String * : *Arr){ }로 처리
        int n = Integer.parseInt(energy);             //switch 문은 int 값만 취급 따라서 String 값을 int로 바꿔주기
        switch(n){
        case 1: out.println("<b>1단계</b>입니다.");
                break;
        case 2: out.println("<b>2단계</b>입니다.");
                break;
        case 3: out.println("<b>3단계</b>입니다.");
                break;
        case 4: out.println("<b>4단계</b>입니다.");
                break;
        case 5: out.println("<b>5단계</b>입니다.");
                break;
        }
        %>
        <br>
        <b><a href='javascript:history.go(-1)'>처음으로</a></b>
    </body>
</html>