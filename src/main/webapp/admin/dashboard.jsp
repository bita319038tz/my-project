<%@page import="cosmetic.dao.ProductDao"%>
<%@page import="cosmetic.dao.CustomerDao"%>
<%@ page import="cosmetic.dao.SupplierDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	CustomerDao customerDao = new CustomerDao();
	ProductDao productDao = new ProductDao();
	SupplierDao supplierDao = new SupplierDao();
%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
  <meta name="author" content="GeeksLabs">
  <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
  <link rel="shortcut icon" href="img/favicon.png">

  <title>Cosmetic Store</title>

  <!-- Bootstrap CSS -->
  <link href="../vendors/css/bootstrap.min.css" rel="stylesheet">
  <!-- bootstrap theme -->
  <link href="../vendors/css/bootstrap-theme.css" rel="stylesheet">
  <!--external css-->
  <!-- font icon -->
  <link href="../vendors/css/elegant-icons-style.css" rel="stylesheet" />
  <link href="../vendors/css/font-awesome.min.css" rel="stylesheet" />
  <!-- easy pie chart-->
  <link href="../vendors/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen" />
  <!-- owl carousel -->
  <!-- Custom styles -->
  <link href="../vendors/css/widgets.css" rel="stylesheet">
  <link href="../vendors/css/style.css" rel="stylesheet">
  <link href="../vendors/css/style-responsive.css" rel="stylesheet" />
  <link href="../vendors/css/xcharts.min.css" rel=" stylesheet">
  <link href="../vendors/css/jquery-ui-1.10.4.min.css" rel="stylesheet">
</head>

<body>
  <!-- container section start -->
  <section id="container" class="">
    <!--sidebar start-->
    <jsp:include page="../layout/asidebar.jsp" />
    <!--sidebar end-->

    <!--main content start-->
    <section id="main-content">
      <section class="wrapper">
        <!--overview start-->
        <div class="row">
          <div class="col-lg-12">
            <ol class="breadcrumb">
              <li><i class="fa fa-home"></i><a href="#">Home</a></li>
              <li><i class="fa fa-laptop"></i>Dashboard</li>
            </ol>
          </div>
        </div>

        <div class="row">
          <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
            <div class="info-box blue-bg">
              <i class="fa fa-group"></i>
              <div class="count"><%=customerDao.countCustomer() %></div>
              <div class="title">Customers</div>
            </div>
            <!--/.info-box-->
          </div>
          <!--/.col-->

          <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
            <div class="info-box brown-bg">
              <i class="fa fa-shopping-cart"></i>
              <div class="count">7.538</div>
              <div class="title">Orders</div>
            </div>
            <!--/.info-box-->
          </div>
          <!--/.col-->

          <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
            <div class="info-box dark-bg">
              <i class="fa fa-th"></i>
              <div class="count"><%=productDao.countProduct() %></div>
              <div class="title">Products</div>
            </div>
            <!--/.info-box-->
          </div>
          <!--/.col-->

          <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
            <div class="info-box green-bg">
              <i class="fa fa-users"></i>
              <div class="count"><%=supplierDao.countSupplier() %></div>
              <div class="title">Suppliers</div>
            </div>
            <!--/.info-box-->
          </div>
          <!--/.col-->

        </div>
        <!--/.row-->

      </section>
    </section>
    <!--main content end-->
  </section>
  <!-- container section start -->

  <!-- javascripts -->
  <script src="../vendors/js/jquery.js"></script>
  <script src="../vendors/js/jquery-ui-1.10.4.min.js"></script>
  <script src="../vendors/js/jquery-1.8.3.min.js"></script>
  <script type="text/javascript" src="../vendors/js/jquery-ui-1.9.2.custom.min.js"></script>
  <!-- bootstrap -->
  <script src="../vendors/js/bootstrap.min.js"></script>
  <!-- nice scroll -->
  <script src="../vendors/js/jquery.scrollTo.min.js"></script>
  <script src="../vendors/js/jquery.nicescroll.js" type="text/javascript"></script>
  <!-- charts scripts -->
  <script src="../vendors/assets/jquery-knob/js/jquery.knob.js"></script>
  <script src="../vendors/js/jquery.sparkline.js" type="text/javascript"></script>
  <script src="../vendors/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.js"></script>
  <script src="../vendors/js/owl.carousel.js"></script>
  <!-- jQuery full calendar -->
  <script src="../vendors/js/fullcalendar.min.js"></script>
    <!-- Full Google Calendar - Calendar -->
    <script src="../vendors/assets/fullcalendar/fullcalendar/fullcalendar.js"></script>
    <!--script for this page only-->
    <script src="../vendors/js/calendar-custom.js"></script>
    <script src="../vendors/js/jquery.rateit.min.js"></script>
    <!-- custom select -->
    <script src="../vendors/js/jquery.customSelect.min.js"></script>
    <script src="../vendors/assets/chart-master/Chart.js"></script>

    <!--custome script for all page-->
    <script src="../vendors/js/scripts.js"></script>
    <!-- custom script for this page-->
    <script src="../vendors/js/sparkline-chart.js"></script>
    <script src="../vendors/js/easy-pie-chart.js"></script>
    <script src="../vendors/js/jquery-jvectormap-1.2.2.min.js"></script>
    <script src="../vendors/js/jquery-jvectormap-world-mill-en.js"></script>
    <script src="../vendors/js/xcharts.min.js"></script>
    <script src="../vendors/js/jquery.autosize.min.js"></script>
    <script src="../vendors/js/jquery.placeholder.min.js"></script>
    <script src="../vendors/js/gdp-data.js"></script>
    <script src="../vendors/js/morris.min.js"></script>
    <script src="../vendors/js/sparklines.js"></script>
    <script src="../vendors/js/charts.js"></script>
    <script src="../vendors/js/jquery.slimscroll.min.js"></script>

</body>

</html>
