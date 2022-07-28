<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="comment" value="${sessionScope.session == null ? '로그인이 필요합니다.' : '댓글을 입력하세요.'}"/>
<c:set var="disable" value="${sessionScope.session == null ? 'disabled' : 'required'}"/>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>게시글 읽기</title>
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
                border-collapse: collapse;
                
                
                
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
<!-- 게시글 상세보기 -->
<h1>게시글 상세보기</h1>
<form action="/boards/view/{Article.article_id}/update" method="get">
<table>
    <tr>
        <th>제목 : </th>
        <td>${Article.article_title}</td>
   </tr>
   <tr>
    <th>작성자 :</th>
    <td>${Article.article_writer}</td>
  </tr>
   <tr>
        <th>내용 : </th>
       <td>${Article.article_text}</td>
   </tr>
    <tr>
        <td></td>
        <td>
        <!--수정/삭제 권한 부여-->
        <c:if test="${Article.member_id == session}">
            <input class="button" type="button" value="수정" onclick="location.href='/boards/view/${Article.article_id}/update'">
            <input class="button" type="button" value="삭제" onclick="location.href='/boards/view/${Article.article_id}/delete'">
        </c:if>
            <input class="button" type="button" value="목록으로" onclick="location.href='/boards'">
        </td>
    </tr>
</table>
</form>
<!-- 댓글 기능 -->
<h2>댓글</h2>
<form action="/boards/view/${Article.article_id}/commentsWrite" method="post" autocomplete="off">
<table>
    <tr>
        <th>${Member.name}</th>
        <td><input type="text" placeholder="${comment}" id="comment_text" name="comment_text" maxlength="30" ${disable}></td>
    </tr>
        <tr>
            <td>

            </td>
            <td>
                <input class="button" type="submit" value="등록">
            </td>    
        </tr>
</table>
</form>
<!-- 댓글 리스트 -->
<table>
    <c:forEach var="comments" items="${Comments}">
    <tr>
        <th> ${comments.comment_id}번 댓글 </th>
        <td> ${comments.comment_writer} </td>
        <td></td>
        <td> ${comments.comment_text}</td>
    
        
    </tr>
    </c:forEach>
</table>
</body>
</html>

