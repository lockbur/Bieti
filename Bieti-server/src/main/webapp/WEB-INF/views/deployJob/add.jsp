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
                                <span class="widget-caption">我的应用列表</span>
                                <div class="widget-buttons buttons-bordered">
                                    <button class="btn btn-info btn-xs"><i class="fa fa-save"></i>保存</button>
                                </div>
                            </div>
                            <div class="widget-body">
                                <form class="form-horizontal form-bordered" role="form" action="/deployJob/save" method="POST">
                                    <div class="form-group">
                                        <label for="name" class="col-sm-2 control-label no-padding-right">任务名称</label>
                                        <div class="col-sm-10">
                                            <input type="text" id="name" name="name" class="form-control" value="测试任务名称">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="appId" class="col-sm-2 control-label no-padding-right">所属应用</label>
                                        <div class="col-sm-10">
                                            <select id="appId" name="appId">
                                                <c:forEach var="app" items="${apps}">
                                                    <option value="${app.id}">${app.name}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-offset-2 col-sm-10">
                                            <button type="submit" class="btn btn-palegreen">保存</button>
                                        </div>
                                    </div>
                                </form>
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
//            $.post("/command/deploy", {"id": _id}, function (result) {
//                bootbox.confirm("部署提交成功", function (bootReult) {
//                    if (bootReult) {
//                        //
//                    }
//                });//bootbox
//            }, "json");
        });

    });//JQ END
</script>
</body>
<!--  /Body -->
</html>

