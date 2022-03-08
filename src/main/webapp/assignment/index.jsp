
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Admin Panel</title>

    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">


    <link rel="stylesheet" href="https://phpscriptpoint.com/cc/courseplus/public/admin/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://phpscriptpoint.com/cc/courseplus/public/admin/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://phpscriptpoint.com/cc/courseplus/public/admin/css/ionicons.min.css">
    <link rel="stylesheet" href="https://phpscriptpoint.com/cc/courseplus/public/admin/css/datepicker3.css">
    <link rel="stylesheet" href="https://phpscriptpoint.com/cc/courseplus/public/admin/css/bootstrap-timepicker.min.css">
    <link rel="stylesheet" href="https://phpscriptpoint.com/cc/courseplus/public/admin/css/select2.min.css">
    <link rel="stylesheet" href="https://phpscriptpoint.com/cc/courseplus/public/admin/css/dataTables.bootstrap.css">
    <link rel="stylesheet" href="https://phpscriptpoint.com/cc/courseplus/public/admin/css/AdminLTE.min.css">
    <link rel="stylesheet" href="https://phpscriptpoint.com/cc/courseplus/public/admin/css/magnific-popup.css">
    <link rel="stylesheet" href="https://phpscriptpoint.com/cc/courseplus/public/admin/css/summernote.css">
    <link rel="stylesheet" href="https://phpscriptpoint.com/cc/courseplus/public/admin/css/spacing.css">
    <link rel="stylesheet" href="https://phpscriptpoint.com/cc/courseplus/public/admin/css/style.css">

    <script src="https://phpscriptpoint.com/cc/courseplus/public/admin/js/jquery-2.2.4.min.js"></script>
    <script src="https://phpscriptpoint.com/cc/courseplus/public/admin/js/bootstrap.min.js"></script>
    <script src="https://phpscriptpoint.com/cc/courseplus/public/admin/js/jquery.dataTables.min.js"></script>
    <script src="https://phpscriptpoint.com/cc/courseplus/public/admin/js/dataTables.bootstrap.min.js"></script>
    <script src="https://phpscriptpoint.com/cc/courseplus/public/admin/js/select2.full.min.js"></script>
    <script src="https://phpscriptpoint.com/cc/courseplus/public/admin/js/jscolor.js"></script>
    <script src="https://phpscriptpoint.com/cc/courseplus/public/admin/js/moment.min.js"></script>
    <script src="https://phpscriptpoint.com/cc/courseplus/public/admin/js/bootstrap-datepicker.js"></script>
    <script src="https://phpscriptpoint.com/cc/courseplus/public/admin/js/bootstrap-timepicker.min.js"></script>
    <script src="https://phpscriptpoint.com/cc/courseplus/public/admin/js/fastclick.js"></script>
    <script src="https://phpscriptpoint.com/cc/courseplus/public/admin/js/jquery.slimscroll.min.js"></script>
    <script src="https://phpscriptpoint.com/cc/courseplus/public/admin/js/app.min.js"></script>
    <script src="https://phpscriptpoint.com/cc/courseplus/public/admin/js/jquery.magnific-popup.min.js"></script>
    <script src="https://phpscriptpoint.com/cc/courseplus/public/admin/js/summernote.js"></script>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>


<body class="hold-transition fixed skin-blue sidebar-mini">
<div class="wrapper">
    <header class="main-header">


        <a class="logo">
            <span class="logo-lg">Assignment</span>
        </a>

        <nav class="navbar navbar-static-top">

            <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                <span class="sr-only">Toggle navigation</span>
            </a>
        </nav>
    </header>


    <aside class="main-sidebar">
        <section class="sidebar">
            <ul class="sidebar-menu">

                <li class="treeview">
                    <a href="${pageContext.request.contextPath}/driver">
                        <i class="fa fa-usd"></i> <span>Driver</span>
                    </a>
                </li>

                <li class="treeview ">
                    <a href="${pageContext.request.contextPath}/router">
                        <i class="fa fa-usd"></i> <span>Router</span>
                    </a>
                </li>

                <li class="treeview ">
                    <a href="${pageContext.request.contextPath}/assignment">
                        <i class="fa fa-usd"></i> <span>Assignment</span>
                    </a>
                </li>


            </ul>
        </section>
    </aside>

    <div class="content-wrapper">
        <section class="content-header">
            <div class="content-header-left">
                <h1>View Products</h1>
            </div>
            <div class="content-header-right">
                <a href="${pageContext.request.contextPath}/assignment/create" class="btn btn-primary btn-sm">Add
                    New</a>
            </div>
        </section>

        <section class="content">

            <div class="row">
                <div class="col-md-12">
                    <div class="box box-info">

                        <div class="box-body table-responsive">
                            <table id="example1" class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th>Teaan lái xe</th>
                                    <th>Tên quãng đường</th>
                                    <th>Số lượt đi</th>
                                </tr>
                                </thead>
                                <tbody>

                                <c:forEach var="assignment" items="${assignmentList}">
                                    <tr>
                                        <td>${assignment.driver.name}</td>
                                        <td>${assignment.router.name}</td>
                                        <td>${assignment.turnNumber}</td>

                                        <td>
                                            <a href="${pageContext.request.contextPath}/assignment/update/${assignment.id}"
                                               class="btn btn-primary btn-xs">Edit</a>
                                            <a href="${pageContext.request.contextPath}/assignment/delete/${assignment.id}"
                                               class="btn btn-danger btn-xs"
                                               onClick="return confirm('Are you sure?');">Delete</a>
                                        </td>
                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>

</div>
</body>
</html>
