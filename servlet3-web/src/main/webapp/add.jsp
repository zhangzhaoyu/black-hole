<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="error.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML>

<html>
<head>
    <title></title>
</head>
<body>
<%
    String a = request.getParameter("a");
    String b = request.getParameter("b");

    out.println(Integer.parseInt(a) + Integer.parseInt(b));
%>
</body>
</html>
