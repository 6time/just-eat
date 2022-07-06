<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>게시글 읽기</title>
</head>
<body>
<h1>read</h1>
<table>
    <tr>
        <th>제목 : </th>
        <td>쓴제목</td>
    </tr>
    <tr>
        <th>내용 : </th>
        <td>쓴내용</td>
    </tr>

    <tr>
        <th></th>
    </tr>
    <tr>
        <td></td>
        <td>
            <input type="submit" value="등록">
            <input type="button" value="수정">
            <input type="button" value="취소" onclick="location.href='/boards'">
        </td>
    </tr>
</table>
</body>
</html>