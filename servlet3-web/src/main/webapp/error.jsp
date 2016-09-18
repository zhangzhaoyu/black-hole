<%@ page import="java.io.PrintWriter" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML>

<html>
<head>
    <title></title>
</head>
<body>
<h1>exception:</h1>
<!-- set isErrorPage, than can use exception -->
<%= exception%>
<%
    pageContext.getException().printStackTrace(new PrintWriter(out));
%>
</body>
</html>
