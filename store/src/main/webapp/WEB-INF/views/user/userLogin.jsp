<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/common/global.jsp" %>
    <title>登陆</title>
    <%@ include file="/common/meta.jsp" %>
    <%@ include file="/common/include-base-styles.jsp" %>
    <link type="text/css" rel="stylesheet" href="${ctx}/css/login.css"/>
</head>

<body>

<%@include file="/common/header-nav.jsp" %>
<div class="container">
    <form:form role="form" action="${ctx}/user/login"
               method="post" id="loginForm" class="form-signin"
               onsubmit="return sendMd5()"  >
        <!-- 自动隐藏提示信息 -->
        <c:if test="${not empty param.errorPwd}">
            <div id="errorPwd" class="alert alert-success">用户密码错误...</div>
            <!-- 自动隐藏提示信息 -->
            <script type="text/javascript">
                setTimeout(function () {
                    $('#errorPwd').hide('slow');
                }, 5000);
            </script>
        </c:if>
        <!-- 自动隐藏提示信息 -->
        <c:if test="${not empty param.error}">
            <div id="error" class="alert alert-success">未登录或会话失效...</div>
            <!-- 自动隐藏提示信息 -->
            <script type="text/javascript">
                setTimeout(function () {
                    $('#error').hide('slow');
                }, 5000);
            </script>
        </c:if>

        <h2 class="form-signin-heading">系统登录</h2>

        <div class="form-group">
            <input type="text" class="form-control username" name="username" id="username" placeholder="账号" required autofocus>
        </div>
        <div class="form-group">
            <input type="password" class="form-control password_noMd5" name="password_noMd5" placeholder="密码" id="password_noMd5" required>
        </div>
        <div class="form-group">
            <input type="hidden" class="form-control" id="password_md5" name="password">
        </div>
        <div class="form-group">
            <label class="checkbox">
                <input type="checkbox" name="remember">自动登陆
            </label>
        </div>
        <div class="form-group">
            <button class="btn btn-lg btn-primary btn-block" type="submit">登陆</button>
        </div>

    </form:form>
</div>
<!-- /container -->

<%@ include file="/common/include-base-js.jsp" %>
<script src="${ctx }/js/md5.js" type="text/javascript"></script>
<script src="${ctx }/js/login.js" type="text/javascript"></script>
</body>
</html>