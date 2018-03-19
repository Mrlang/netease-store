<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/common/global.jsp" %>
    <title>主页</title>
    <%@ include file="/common/meta.jsp" %>
    <%@ include file="/common/include-base-styles.jsp" %>
    <link type="text/css" rel="stylesheet" href="${ctx}/css/index.css"/>
</head>

<body>
<%@include file="/common/header-nav.jsp" %>
<div class="container">

    <div class="jumbotron">
        <h3>
            小小商店
            <c:if test="${not empty test}">
                ok,${sessionScope.str}
            </c:if>
        </h3>

        <p>
            Spring boot + Spring cloud + docker
        </p>

        <p>
            <a class="btn btn-primary btn-large" href="https://github.com/Mrlang/netease-store">Github</a>
        </p>
    </div>

</div>
<!-- /container -->
<%@include file="/common/footer.jsp" %>
<%@ include file="/common/include-base-js.jsp" %>
</body>
</html>