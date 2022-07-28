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
 body {
                width: 500px;
                margin-left:auto;
                margin-right:auto;
                
            }
            table{
                white-space: nowrap;
                overflow:hidden;
                text-overflow:ellipsis;
                border: 1px solid #666666;
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
            .button{
                background-color: #B3DBF2;
                border-color:#f1f1f1;
            }
</style>
<body>
<h1>게시글 수정</h1>
<form action="/boards/view/${Article.article_id}/update" method="post" autocomplete="off"> <!-- 수정 /boards -->
    <table>
        <tr>
            <th>제목 : </th>
            <td><input type="text"  id="article_title" name="article_title" value="${Article.article_title}" maxlength="30" required></td>
        </tr>
        <tr>
            <th>내용 : </th>
            <td><textarea id="article_text" name="article_text" cols="30" rows="10" maxlength="150" required>${Article.article_text}</textarea></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input class="button" type="submit" value="등록">
                <input class="button" type="button" value="취소" onclick="location.href='/boards'">
            </td>
        </tr>
    </table>
</form>
</body>
</html>

