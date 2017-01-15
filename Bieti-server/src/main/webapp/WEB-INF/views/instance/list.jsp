<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<!-- Head -->
<head>
    <title>Blank Page</title>
    <%@include file="/WEB-INF/views/common/header.jsp" %>
</head>
<!-- /Head -->
<!-- Body -->
<body>
<!-- Loading Container -->
<div class="loading-container">
    <div class="loader"></div>
</div>
<!--  /Loading Container -->
<!-- Navbar -->
<%@include file="/WEB-INF/views/common/topbar.jsp" %>
<!-- /Navbar -->
<!-- Main Container -->
<div class="main-container container-fluid">
    <!-- Page Container -->
    <div class="page-container">
        <!-- Page Sidebar -->
        <%@include file="/WEB-INF/views/common/sidebar.jsp" %>
        <!-- /Page Sidebar -->
        <!-- Page Content -->
        <div class="page-content">
            <!-- Page Breadcrumb -->
            <div class="page-breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="fa fa-home"></i>
                        <a href="#">Home</a>
                    </li>
                    <li>
                        <a href="#">More Pages</a>
                    </li>
                    <li class="active">Blank Page</li>
                </ul>
            </div>
            <!-- /Page Breadcrumb -->
            <!-- Page Header -->
            <div class="page-header position-relative">
                <div class="header-title">
                    <h1>
                        Blank Page
                    </h1>
                </div>
            </div>
            <!-- /Page Header -->
            <!-- Page Body -->
            <div class="page-body">
                <div class="row">
                    <div class="col-xs-12 col-md-12">
                        <div class="widget radius-bordered">
                            <div class="widget-header">
                                <span class="widget-caption">应用实例列表</span>
                            </div>
                            <div class="widget-body">

                                <table class="table table-bordered table-striped table-condensed flip-content">
                                    <thead class="flip-content bordered-palegreen">
                                    <tr>
                                        <td>
                                            <label>
                                                <input type="checkbox">
                                                <span class="text"></span>
                                            </label>
                                        </td>
                                        <th>ID</th>
                                        <th>IP地址</th>
                                        <th>主机名称</th>
                                        <th>操作系统</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${list}" var="item">
                                        <tr>
                                            <td>
                                                <label>
                                                    <input type="checkbox" name="instances" value="${item.id}">
                                                    <span class="text"></span>
                                                </label>
                                            </td>
                                            <td>${item.id}</td>
                                            <td>${item.address}</td>
                                            <td>${item.hostname}</td>
                                            <td>${item.path}</td>
                                            <td>
                                                <div class="buttons-preview">
                                                    <a data-provider="deploy" data-id="${item.id}"
                                                       class="btn btn-info">部署</a>
                                                    <a data-provider="start" data-id="${item.id}"
                                                       class="btn btn-success">启动</a>
                                                    <a data-provider="restart" data-id="${item.id}"
                                                       class="btn btn-warning">重启</a>
                                                    <a data-provider="stop" data-id="${item.id}"
                                                       class="btn btn-danger">停止</a>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>

                        </div>
                    </div>
                </div>
            </div>

        </div>
        <!-- /Page Body -->
    </div>
    <!-- /Page Content -->
</div>
<!-- /Page Container -->
<!-- Main Container -->
</div>
<%@include file="/WEB-INF/views/common/footer.jsp" %>

<!--Page Related Scripts-->
<script src="${pageContext.request.contextPath}/assets/js/bootbox/bootbox.js"></script>
<script>
    $(document).ready(function () {
        //执行部署指令
        $("[data-provider='deploy']").click(function () {
            var _id = $(this).data("id");
            $.post("/command/deploy", {"id": _id}, function (result) {
                bootbox.confirm("部署提交成功", function (bootReult) {
                    if (bootReult) {
                        //
                    }
                });//bootbox
            }, "json");
        });

    });//JQ END
</script>
</body>
<!--  /Body -->
</html>

