<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!-- Page Sidebar -->
<div class="page-sidebar" id="sidebar">
    <!-- Page Sidebar Header-->
    <div class="sidebar-header-wrapper">
        <input type="text" class="searchinput"/>
        <i class="searchicon fa fa-search"></i>
        <div class="searchhelper">Search Reports, Charts, Emails or Notifications</div>
    </div>
    <!-- /Page Sidebar Header -->
    <!-- Sidebar Menu -->
    <ul class="nav sidebar-menu">
        <!--Dashboard-->
        <li>
            <a>
                <i class="menu-icon glyphicon glyphicon-home"></i>
                <span class="menu-text"> 控制面板 </span>
            </a>
        </li>
        <!--UI Elements-->
        <li>
            <a href="#" class="menu-dropdown">
                <i class="menu-icon fa fa-desktop"></i>
                <span class="menu-text"> 项目管理 </span>

                <i class="menu-expand"></i>
            </a>
            <ul class="submenu">
                <li>
                    <a href="${pageContext.request.contextPath}/project/list">
                        <span class="menu-text">项目列表</span>
                    </a>
                </li>
            </ul>
        </li>
    </ul>
    <!-- /Sidebar Menu -->
</div>