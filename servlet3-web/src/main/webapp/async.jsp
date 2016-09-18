<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Async Test</title>
    <script type="text/javascript">

        function asyncUpdate() {
            var xhr;
            if (window.XMLHttpRequest) {
                xhr = new XMLHttpRequest();
            }
            else if (window.ActiveXObject) {
                xhr = new ActiveXObject("Microsoft.XMLHTTP");
            }
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4) {
                    if (xhr.status === 200) {
                        document.getElementById('data').innerHTML = xhr.responseText;
                        asyncUpdate();
                    }
                }
            };

            xhr.open("GET", 'asyncNum?timestamp=' + new Date().getTime());
            xhr.send(null);
        }
        window.onload = asyncUpdate;
    </script>
</head>
<body>
    实时信息: <span id="data">0</span>
</body>
</html>
