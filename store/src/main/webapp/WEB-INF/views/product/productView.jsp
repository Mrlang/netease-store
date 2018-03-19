<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/common/global.jsp"%>
<title>${product.title} 商品信息</title>
<%@ include file="/common/meta.jsp"%>
<%@ include file="/common/include-base-styles.jsp"%>
<link type="text/css" rel="stylesheet" href="${ctx}/css/index.css"/>
</head>

<body>
    <%@include file="/common/header-nav.jsp" %>
	<div class="container">
        <div class="row">
            <div class="col-md-5 text-center">
                <img class="img-responsive img-rounded" src="${ctx}${product.img}">
            </div>
            <div class="col-md-7">
                <div class="form-group">
                    <label>商品名称：</label>${product.title}
                </div>
                <div class="form-group">
                    <label>商品编码：</label>${product.id}
                </div>
                <div class="form-group">
                    <label>商品摘要：</label>${product.description}
                </div>
                <div class="form-group">
                    <label>商品价格：</label>${product.price}
                </div>
                <div class="form-group">
                    <label>全文介绍：</label>${product.content}
                </div>
                <p>
                    <c:if test="${product.saled == 0 && not empty login_user}">
                        <a class="btn btn-primary btn-lg  btn-block addCart" productid="${product.id}" role="button">加入购物车</a>
                    </c:if>
                    <c:if test="${product.saled != 0 && not empty login_user}">
                        <a class="btn btn-info btn-lg  btn-block disabled" productid="${product.id}" role="button">加入购物车</a>
                    </c:if>
                    <c:if test="${not empty login_admin}">
                        <a class="btn btn-primary btn-lg  btn-block" productid="${product.id}" role="button" href="/product/edit/${product.id}">编辑</a>
                    </c:if>
                </p>
            </div>
        </div>
        </div>


    </div> <!-- /container -->

    <%@include file="/common/footer.jsp" %>
	<%@ include file="/common/include-base-js.jsp"%>
    <script src="${ctx }/js/product.js" type="text/javascript"></script>
</body>
</html>