
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>calc</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<jsp:include page="_Header.jsp"/>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-sm-4 mt-5">
            <form action="${pageContext.request.contextPath}/calc" method="post">
                <div class="mb-3">

                    <input type="number" name="num1" class="form-control" placeholder="Number 1"
                           id="exampleInputPassword1" required>
                </div>
                <select name="operation" class="form-select mb-3" aria-label="Default select example" required>
                    <option value="sum">+</option>
                    <option value="sub">-</option>
                    <option value="mul">*</option>
                    <option value="div">/</option>
                </select>
                <div class="mb-3">

                    <input type="number" name="num2" class="form-control" placeholder="Number 1"
                           id="exampleInputPassword2" required>
                </div>
                <button type="submit" class="btn btn-primary">Calc</button>
                <a class="btn btn-primary offset-md-7" href="${pageContext.request.contextPath}/history" role="button">History</a>
            </form>
            <div class="alert alert-primary" role="alert">
                <p>${requestScope.result}</p>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
