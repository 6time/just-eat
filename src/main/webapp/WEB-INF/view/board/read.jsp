<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>게시글 읽기</title>
</head>
<body>
<h1>read</h1>
<form action="/boards" method="post">
<table>
    <tr>
        <th>제목 : </th>
        <td>${Article.article_title}</td>
   </tr>
   <tr>
        <th>내용 : </th>
       <td>${Article.article_text}</td>
   </tr>
    <tr>
        <th></th>
    </tr>
    <tr>
        <td></td>
        <td>
            <input type="submit" value="등록">
            <input type="button" value="삭제" onclick="location.href='/boards/view/${Article.article_id}/delete'">
            <input type="button" value="취소" onclick="location.href='/boards'">
        </td>
    </tr>
</table>
</form>
</body>
</html>