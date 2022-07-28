<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>게시판 작성</title>
</head>
<style>
        body {
            width: 500px;    
            margin: auto;
                 
                
                
            }
            table{
                white-space: nowrap;
                overflow:hidden;
                text-overflow:ellipsis;
                border-collapse: collapse
            }
        
            td  {
                padding: 10px;
                
                
                
            }
        th  {
                background-color: #B3DBF2;
                padding: 10px;
                
                
                
            }
        tr{
            border-bottom: 1px solid #666666;
        }
        a {
                text-decoration: none;
                color: black;
        }
        button{
                background-color:#B3DBF2;
                border-color:#f1f1f1;
            }
</style>
<body>
    <h1>게시글</h1>
    <table>
        <tr>
           <th>번호</th>
           <th>제목</th>
           <th>작성자</th>
           <th>작성일</th>
           <th>조회수</th>
        </tr>
         <c:forEach var="articles" items="${Articles}">
        <tr>
            <td>${articles.article_id}</td>
            <td><a href="${path}/boards/view/${articles.article_id}">${articles.article_title}</a></td>
            <td>${articles.article_writer}</td>
            <td><fmt:formatDate pattern="yyyy-MM-dd" value="${articles.article_time}"/></td>
            <td>${articles.reNum}</td>
        </tr>
        </c:forEach>
      </table>
      <button type="button" onclick="location.href='/boards/write'">글쓰기</button>
      <button type="button" onclick="location.href='/'">메인화면</button>
</body>
</html>
           
            







