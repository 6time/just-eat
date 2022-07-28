<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="ko">
<body>
<link rel="stylesheet" href="/css/style.css" />
<div class="member-out-box">
  <center>
    <table summary="목록">
    <caption>
    </caption>
    <thead>
    <tr>
    <th><h3>날짜</h3></th>
    <th><h3>칼로리</h3></th>
    <th><h3>몸무게</h3></th>
    <th><h3>운동량</h3></th>
    </tr>
    </thead>

    <c:if test="${List.size() == 0 }">
    <tfoot>
    <tr>
    <td colspan="3">현재 데이터가 없습니다.</td>
    /tr>
    </tfoot>
    </c:if>
    <tr>
    <tbody>
    <div class="member-btn-c">
    <h1>${name}님의 일일 변화 !</h1>
    </div>
    <%request.setCharacterEncoding("UTF-8");%>

    <c:forEach var="result" items="${selfTests}" varStatus="status">
    <td><c:out value="| ${result.regDate} | "/></td>
    <td><c:out value="| ${result.daykcal}kcal | "/></td>
    <td><c:out value="| ${result.dayweight}kg | "/></td>
    <td><c:out value="| ${result.dayexercise}단계 |"/></td>
    </tr>
    </c:forEach>
    </tbody>
    </table>

</div>
</body>
</html>>