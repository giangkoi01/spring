<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
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
        <h1>Add Product</h1>
      </div>
      <div class="content-header-right">
        <a href="${pageContext.request.contextPath}/assignment" class="btn btn-primary btn-sm">View
          All</a>
      </div>
    </section>

    <section class="content">
      <div class="row">
        <div class="col-md-12">
          <form action="${pageContext.request.contextPath}/assignment/update/${assignment.id}" class="form-horizontal" method="post">
            <div class="box box-info">
              <div class="box-body">
                <div class="form-group">
                  <label  class="col-sm-3 control-label">Tên lái xe</label>
                  <div class="col-sm-4">
                    <select name="driver_id" class="form-control select2">
                      <c:forEach var="driver" items="${listDriver}">
                        <option value="${driver.id}" >${driver.name}</option>
                      </c:forEach>
                    </select>
                  </div>
                </div>

                <div class="form-group">
                  <label  class="col-sm-3 control-label">Tên tuyến đường</label>
                  <div class="col-sm-4">
                    <select name="router_id" class="form-control select2">
                      <c:forEach var="router" items="${listRouter}">
                        <option value="${router.id}" >${router.name}</option>
                      </c:forEach>
                    </select>
                  </div>
                </div>

                <div class="form-group">
                  <label class="col-sm-3 control-label">Số lượt đi <span>*</span></label>
                  <div class="col-sm-4">
                    <input value="${assignment.turnNumber}" type="text" class="form-control" name="turnNumber">
                  </div>
                </div>


                <div class="form-group">
                  <label for="" class="col-sm-3 control-label"></label>
                  <div class="col-sm-6">
                    <button type="submit" class="btn btn-success pull-left" >Submit
                    </button>
                  </div>
                </div>
              </div>
            </div>
          </form>
        </div>
      </div>
    </section>
  </div>

</div>

</body>
</html>