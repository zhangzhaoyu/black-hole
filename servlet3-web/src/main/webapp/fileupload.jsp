<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML>

<html>
<head>
    <title>file upload</title>
</head>
<body>
<h2>File Upload</h2>

<form action="<%=request.getContextPath()%>/upload" method="POST" enctype="multipart/form-data">
    <input name="photo" type="file"/> </br>
    <input type="submit" value="submit" name="upload"/>
</form>
</body>
</html>
