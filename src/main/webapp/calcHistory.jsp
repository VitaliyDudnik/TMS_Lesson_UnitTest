<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>calcHistory</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<jsp:include page="_Header.jsp"/>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-7 mt-5">
            <table class="table table-bordered w-auto">
                <thead>
                <tr>
                    <th>Username</th>
                    <th>Date</th>
                    <th>Number1</th>
                    <th>Operation</th>
                    <th>Number2</th>
                    <th>Result</th>
                </tr>
                </thead>
                <c:forEach var="item" items="${requestScope.history}">
                    <tbody>
                    <tr>
                        <td>${item.username}</td>
                        <td>${item.date}</td>
                        <td>${item.num1}</td>
                        <td>${item.operation}</td>
                        <td>${item.num2}</td>
                        <td>${item.result}</td>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>
        </div>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
