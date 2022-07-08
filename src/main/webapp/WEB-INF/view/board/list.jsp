<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>게시판 작성</title>
</head>
<body>
    <h1>게시글</h1>
    <table>
        <tr>
           <th>번호</th>
                <th>제목</th>
           <!-- <th>작성자</th> -->
           <!-- <th>날짜</th> -->
        </tr>
         <c:forEach var="articles" items="${Articles}">
        <tr>

                <td>${articles.article_id}</td>
                <!-- 수정 -->
                <td><a href="${path}/boards/view/${articles.article_id}">${articles.article_title}</a></td> <!-- 원래는 /boards/view/no -->
            <!-- <td>jiwon</td> -->
            <!-- <td>yyyy-mm-dd</td> -->

        </tr>
        </c:forEach>
        </table>
        <a href="/boards/write">글쓰기</a>
</body>
</html>
