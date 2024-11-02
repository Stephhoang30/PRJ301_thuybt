<%-- 
    Document   : sidebar
    Created on : Oct 18, 2024, 12:49:29 AM
    Author     : stephhoang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<ul class="sidebar navbar-nav">
    <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown"
           aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-fw fa-folder"></i>
            <span>Management</span>
        </a>
        <div class="dropdown-menu" aria-labelledby="pagesDropdown">          
            <a class="dropdown-item" href="dashboard">Product List</a>
            <a class="dropdown-item" href="register.html">User List</a>
            <a class="dropdown-item" href="forgot-password.html">Forgot Password</a>
        </div>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="charts.html">
            <i class="fas fa-fw fa-chart-area"></i>
            <span>Charts</span></a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="tables.html">
            <i class="fas fa-fw fa-table"></i>
            <span>Tables</span></a>
    </li>
</ul>