<%@ page import="java.io.PrintWriter" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
    ServletContext servletContext = pageContext.getServletContext();
    ServletConfig servletConfig = pageContext.getServletConfig();
    HttpSession httpSession = pageContext.getSession();
    JspWriter printWriter = pageContext.getOut();

    pageContext.setAttribute("name", "zhangzhaoyu");
    pageContext.getAttribute("name");

    pageContext.setAttribute("name", "zhangzhaoyu", pageContext.SESSION_SCOPE);
    pageContext.getAttribute("name", pageContext.SESSION_SCOPE);

    // find attribute from page, request, session and application in order.
    pageContext.findAttribute("zhang");
%>
</body>
</html>
