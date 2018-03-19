<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target=".navbar-collapse">
                <span class="icon-bar"></span> <span class="icon-bar"></span> <span
                    class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">小小商店</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="${ctx}/">首页</a></li>
                <li><a href="${ctx}/product/">商品</a></li>
                <c:choose>
                    <c:when test="${not empty login_user}">
                        <li><a href="${ctx}/product/listNotBuyed">未买商品</a></li>
                    </c:when>
                </c:choose>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <c:choose>
                    <c:when test="${not empty login_user}">
                        <li class="dropdown">
                            <a class="dropdown-toggle"  href="#">
                                    ${login_user.nickname}
                            </a>
                        </li>
                        <li class="dropdown">
                            <a class="dropdown-toggle" href="${ctx}/cart/finace">
                                    财务
                            </a>
                        </li>
                        <li><a href="${ctx}/user/logout">注销</a></li>
                    </c:when>
                    <c:when test="${not empty login_admin}">
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                    ${login_admin.nickname}
                            </a>
                        </li>
                        <li class="dropdown">
                            <a class="dropdown-toggle" href="${ctx}/product/new">
                                发布
                            </a>
                        </li>
                        <li><a href="${ctx}/user/logout">注销</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="${ctx}/user/login">登陆</a></li>
                        <li><a href="${ctx}/user/logout">注册</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
            <c:if test="${not empty login_user}">
                <form class="navbar-form navbar-right" role="cart">
                    <a href="${ctx}/cart/" class="btn btn-info">购物车</a>
                </form>
            </c:if>

        </div>
        <!--/.nav-collapse -->
    </div>
</div>