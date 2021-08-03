<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<nav class="navbar navbar-expand-lg navbar-light bg-info">
    <div class="container-fluid">
        <a class="navbar-brand" style="color: floralwhite" href="#">Insta</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <c:if test="${sessionScope.user != null}">
                <li class="nav-item">
                    <a class="nav-link active" style="color: floralwhite" aria-current="page"
                       href="${pageContext.request.contextPath}/regContent">Home</a>
                </li>
                </c:if>
                <c:if test="${sessionScope.user == null}">
                <li class="nav-item">
                    <a class="nav-link active" style="color: floralwhite" aria-current="page"
                       href="${pageContext.request.contextPath}/home">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" style="color: floralwhite"
                       href="https://play.google.com/store/apps?hl=ru&gl=US">App</a>
                </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" style="color: floralwhite" href="#" id="navbarDropdown"
                           role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Join
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/authorization">Sign in</a></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/reg">Registration</a></li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li><a class="dropdown-item" href="#">Rules</a></li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Welcome: Guest</a>
                    </li>
                    <c:set var="today" value="<%=new java.util.Date()%>"/>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#" tabindex="-1"
                           aria-disabled="true"><fmt:formatDate type="both" value="${today}"/>
                        </a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.user != null}">
                    <li class="nav-item">
                        <a class="nav-link active" style="color: floralwhite" aria-current="page"
                           href="${pageContext.request.contextPath}/account">Account</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" style="color: floralwhite" aria-current="page"
                           href="${pageContext.request.contextPath}/calc">Calculator</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#" tabindex="-1"
                           aria-disabled="true">${requestScope.welcome}</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#" tabindex="-1"
                           aria-disabled="true"><fmt:formatDate type="both" value="${today}"/></a>
                    </li>
                </c:if>
            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
