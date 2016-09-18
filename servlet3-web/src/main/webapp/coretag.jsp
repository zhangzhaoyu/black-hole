<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML>

<html>
<head>
    <title></title>
</head>
<br>
    <c:forEach var="token" items="zhang,zhao,yu">
        ${token} </br>
    </c:forEach>
    <hr>
    <c:forTokens items="zhang:zhao:yu" delims=":" var="item">
        ${item} </br>
    </c:forTokens>
</body>
</html>
