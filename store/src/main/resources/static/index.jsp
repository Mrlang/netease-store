<!DOCTYPE html>
<html>
<head>

    #include("./common/global.vm")
    <title>主页</title>
    #include("./common/meta.vm")bai
    #include("./common/include-base-styles.vm")
    <link type="text/css" rel="stylesheet" href="/css/index.css"/>
</head>

<body>
    $!session
====
    $session
    #include("./common/header-nav.vm")

    <div class="container">

        <div class="jumbotron">
            <h1>
                小小商店
            </h1>

            <p>
                Spring + Bootstrap 3
            </p>

            <p>
                <a class="btn btn-primary btn-large" href="http://github.com/vito16/shop">Github</a>
            </p>
        </div>

    </div>
    <!-- /container -->

    #include("./common/footer.vm")
    #include("./common/include-base-js.vm")

</body>
</html>