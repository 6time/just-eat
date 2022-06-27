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
         request.setCharacterEncoding("UTF-8");
         String kcal = request.getParameter("kcal");
         out.println("오늘 먹은 칼로리 :<b>"+kcal+"</b><br>");

         String weight = request.getParameter("weight");
         out.println("몸무게 :"+weight+"</b><br>");

         String energyArr[] = request.getParameterValues("energy");
        out.println("오늘 한 운동량은");
        for(String energy : energyArr){
        int n = Integer.parseInt(energy);
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
        }
        %>
        <br>
        <b><a href='javascript:history.go(-1)'>다시</a></b>
    </body>
</html>