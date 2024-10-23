<%-- 
    Document   : dashboard
    Created on : Oct 18, 2024, 12:38:25 AM
    Author     : stephhoang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Admin - Dashboard</title>

        <!-- Custom fonts for this template-->
        <link href="${pageContext.request.contextPath}/vendor-admin/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Page level plugin CSS-->
        <link href="${pageContext.request.contextPath}/vendor-admin/datatables/dataTables.bootstrap4.css" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="${pageContext.request.contextPath}/css/sb-admin.css" rel="stylesheet">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/colReorder-bootstrap4.css">
        
        <style>
            .error{
                color:red;
            }
        </style>

    </head>

    <body id="page-top">

        <!-- Navbar -->
        <jsp:include page="../common/admin/navbar.jsp"></jsp:include>

            <div id="wrapper">

                <!-- Sidebar -->
            <jsp:include page="../common/admin/sidebar.jsp"></jsp:include>

                <div id="content-wrapper">

                    <div class="container-fluid">

                        <!-- Breadcrumbs-->
                    <jsp:include page="../common/admin/breadcrumbs.jsp"></jsp:include>

                        <!-- Icon Cards-->
                    <jsp:include page="../common/admin/icon-cards.jsp"></jsp:include>

                        <!-- DataTables Example -->
                        <div class="card mb-3">
                            <div class="card-header">
                                <i class="fas fa-table"></i>
                                Product
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Name</th>
                                                <th>Image</th>
                                                <th>Quantity</th>
                                                <th>Price</th>
                                                <th>Category</th>
                                                <th>Description</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${products}" var="p">
                                            <tr>
                                                <td>${p.getId()}</td>
                                                <td>${p.getName()}</td>
                                                <td>
                                                    <img src="${pageContext.request.contextPath}/img/product/${p.getImage()}" width="100" height="100" alt="alt"/>
                                                </td>
                                                <td>${p.getQuantity()}</td>
                                                <td>${p.getPrice()}</td>
                                                <td>
                                                    <c:forEach items="${categories}" var="c">
                                                        <c:if test="${c.getId() == p.getCategoryId()}">
                                                            ${c.getName()}
                                                        </c:if>
                                                    </c:forEach>
                                                </td>
                                                <td>${p.getDescription()}</td>
                                                <td>
                                                    <button type="button" class="btn btn-primary">Edit</button>
                                                    <button type="button" class="btn btn-danger">Delete</button>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>                     
                    </div>

                </div>
                <!-- /.container-fluid -->

                <!-- Sticky Footer -->
                <jsp:include page="../common/admin/footer.jsp"></jsp:include>

                </div>
                <!-- /.content-wrapper -->

            </div>
            <!-- /#wrapper -->

            <!-- Scroll to Top Button-->
            <a class="scroll-to-top rounded" href="#page-top">
                <i class="fas fa-angle-up"></i>
            </a>

            <!-- Logout Modal-->
            <jsp:include page="../common/admin/logout-modal.jsp"></jsp:include>
            
            <jsp:include page="../admin/addProduct.jsp"></jsp:include>

            <!-- Bootstrap core JavaScript-->
            <script src="${pageContext.request.contextPath}/vendor-admin/jquery/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/vendor-admin/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="${pageContext.request.contextPath}/vendor-admin/jquery-easing/jquery.easing.min.js"></script>

        <!-- Page level plugin JavaScript-->
        <script src="${pageContext.request.contextPath}/vendor-admin/chart.js/Chart.min.js"></script>
        <script src="${pageContext.request.contextPath}/vendor-admin/datatables/jquery.dataTables.js"></script>
        <script src="${pageContext.request.contextPath}/vendor-admin/datatables/dataTables.bootstrap4.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="${pageContext.request.contextPath}/js/admin/sb-admin.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/admin/colReorder-bootstrap4-min.js"></script>
        <script src="${pageContext.request.contextPath}/js/admin/colReorder-dataTables-min.js"></script>

        <!-- Demo scripts for this page-->
        <script src="${pageContext.request.contextPath}/js/admin/demo/datatables-demo.js"></script>
        <script src="${pageContext.request.contextPath}/js/admin/demo/chart-area-demo.js"></script>
        <script src="${pageContext.request.contextPath}/js/admin/colReorder-dataTables-min.js"></script>
        <script src="${pageContext.request.contextPath}/js/admin/colReorder-bootstrap4-min.js"></script>


    </body>

</html>