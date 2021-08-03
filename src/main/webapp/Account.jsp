<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Account</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<jsp:include page="_Header.jsp"/>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6 mt-5">

            <div class="list-group">
                <a href="${pageContext.request.contextPath}/history" class="list-group-item list-group-item-action">History</a>
                <a href="#" class="list-group-item list-group-item-action">Change username</a>
                <a href="#" class="list-group-item list-group-item-action">Change Password</a>
                <form action="${pageContext.request.contextPath}/logout" method="post">
                    <button type="submit" class="btn btn-primary w-100">Logout</button>
                </form>
            </div>
        </div>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
