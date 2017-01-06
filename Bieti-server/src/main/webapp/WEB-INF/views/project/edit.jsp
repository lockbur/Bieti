<%-- 
    Document   : list
    Created on : 2015-6-29, 16:21:43
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap design Base</title>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/assets/css/bootstrap.css" rel="stylesheet">
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="${pageContext.request.contextPath}/assets/js/html5shiv.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header pull-left">
            <a class="navbar-brand" href="#">
                &nbsp;<i class="glyphicon glyphicon-leaf"></i>&nbsp;
                Bootstrap template <span class="smaller-75">(v3.1.1)</span>
            </a>
        </div>
        <div class="navbar-header navbar-right">
            <a class="navbar-brand" href="/about/"><i class="glyphicon glyphicon-off"></i></a>
        </div>
    </div>
</div>

<div class="container main-container">
    <h2 class="page-header text-primary">Welcome</small></h2>
    <h4 class="text-success">Click on an item below to start</h4>

    <div class="row">
        <div class="col-xs-12">
            <div class="list-group">
                <a href="html/" class="list-group-item">
                    Demo Pages
                </a>
                <a href="html/#help" class="list-group-item">
                    Demo Pages with On-Page Help Feature Enabled
                </a>
                <hr/>
                <a href="docs/" class="list-group-item">
                    Documentation
                </a>
                <hr/>
                <a href="build/css.html" class="list-group-item">
                    CSS Builder
                </a>
                <a href="build/js.html" class="list-group-item">
                    Javascript Builder
                </a>
                <hr/>
                <a href="examples/" class="list-group-item">
                    Examples
                </a>
            </div>
        </div>
    </div>
</div>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${pageContext.request.contextPath}/assets/js/bootstrap.js"></script>

<script src="${pageContext.request.contextPath}/assets/js/app.js"></script>
</body>
</html>
