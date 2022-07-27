<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<style>
    body{
    margin: 0 auto;
    width: 300px;
}
</style>
<body>
<h1>update</h1>
<form action="/boards/view/${Article.article_id}/update" method="post"> <!-- 수정 /boards -->
    <table>
        <tr>
            <th>제목 : </th>
            <td><input type="text"  id="article_title" name="article_title" value="${Article.article_title}" required></td>
        </tr>
        <tr>
            <th>내용 : </th>
            <td><textarea id="article_text" name="article_text" cols="30" rows="10"  required>${Article.article_text}</textarea></td>
        </tr>
        <tr>
            <th></th>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="등록">
                <input type="button" value="취소" onclick="location.href='/boards'">
            </td>
        </tr>
    </table>
</form>
</body>
</html>

