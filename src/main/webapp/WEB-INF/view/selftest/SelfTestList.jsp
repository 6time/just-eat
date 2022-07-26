<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="ko">
<body>
<div class="container">
  <div>
    <table summary="목록">
    <caption>
    </caption>
    <thead>
    <tr>
    <th>#</th>
    <th>이름</th>
    <th>칼로리</th>
    <th>몸무게</th>
    <th>운동량</th>
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

    <fieldset style="max-width: 10cm">
            <legend><p style="font-size: large">회원님의 일일 변화 !</p></legend>
            <%request.setCharacterEncoding("UTF-8");%>

    <c:forEach var="result" items="${selfTests}" varStatus="status">
    <td><c:out value="${result.reg_data}"/></td>
    <td><c:out value="${result.name}"/></td>
    <td><c:out value="${result.daykcal}"/></td>
    <td><c:out value="${result.dayweight}"/></td>
    <td><c:out value="${result.dayexercise}"/></td>
    </tr>
    </c:forEach>
    </fieldset>
    </tbody>
    </table>
  </div>
</div> <!-- /container -->
</body>
</html>>