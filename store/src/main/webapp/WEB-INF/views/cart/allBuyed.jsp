<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/common/global.jsp" %>
    <title>购物车</title>
    <%@ include file="/common/meta.jsp" %>
    <%@ include file="/common/include-base-styles.jsp" %>
    <link type="text/css" rel="stylesheet" href="${ctx}/css/product.css"/>
</head>

<body>
<%@include file="/common/header-nav.jsp" %>
<div class="container">
    <div class="row">
        <table class="table table-responsive table-striped">
            <c:choose>
                <c:when test="${empty bigCart.carts}">
                    <tbody class="text-center">
                    <tr>
                        <td>已购商品为空，继续去选购商品吧...</td>
                    </tr>
                    </tbody>
                </c:when>
                <c:otherwise>
                    <thead>
                    <tr>
                        <td>编号</td>
                        <td>图片</td>
                        <td>标题</td>
                        <td>购买价格</td>
                        <td>购买数量</td>
                        <td>购买时间</td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${bigCart.carts}" var="cartItem">
                        <c:set var="ci" value="${cartItem}"></c:set>
                        <tr pid="${ci.pid}">
                            <td>${ci.pid}</td>
                            <%--<td>${ci.img}</td>--%>
                            <td>
                                <div class="col-md-2 text-center">
                                    <img class="img-responsive img-rounded" src="${ci.img}">
                                </div>
                            </td>
                            <td>${ci.title}</td>
                            <td>${ci.price}</td>
                            <td>${ci.count}</td>
                            <td><fmt:formatDate value="${ci.time}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </c:otherwise>
            </c:choose>
        </table>
        <%--<div id="delSuccess" class="alert alert-success" style="display: none;">删除成功...</div>--%>
        <%--<div id="delAllSuccess" class="alert alert-success" style="display: none;">购物车清空成功....</div>--%>
    </div>
    <div class="row">
        总价： ￥${bigCart.totalPrice}
    </div>
    <div class="row">
        <div class="col-md-6 col-xs-9">
            <a class="btn btn-info" href="${ctx}/product/">继续购买</a>
            <%--<a class="btn btn-info" id="cleanCart" >清空购物车</a>--%>
        </div>

        <%--<div class="col-md-6 col-xs-3 text-right">--%>
            <%--<a class="btn btn-primary" href="${ctx}/cart/buyAll">结账</a>--%>
        <%--</div>--%>
    </div>
</div>

</div>
<!-- /container -->
<%@include file="/common/footer.jsp" %>
<%@ include file="/common/include-base-js.jsp" %>
<script src="${ctx }/js/cart.js" type="text/javascript"></script>
</body>
</html>