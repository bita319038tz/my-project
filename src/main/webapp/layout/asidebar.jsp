<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    if(session.getAttribute("islogin") == null){
    	response.sendRedirect("../index.jsp");
    }
    %>
 <div>
 <!--header start-->
    <header class="header dark-bg">
      <div class="toggle-nav">
        <div class="icon-reorder tooltips" data-original-title="Toggle Navigation" data-placement="bottom"><i class="icon_menu"></i></div>
      </div>

      <!--logo start-->
      <a href="index.html" class="logo">Cosmetic <span class="lite">Store</span></a>
      <!--logo end-->

      <div class="top-nav notification-row">
        <!-- notificatoin dropdown start-->
        <ul class="nav pull-right top-menu">
          
          <!-- user login dropdown start-->
          <li class="dropdown">
            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="profile-ava">
                                <img alt="" th:src="@{img/avatar1_small.jpg}">
                            </span>
                            <span class="username"><%=session.getAttribute("fullName") %></span>
                            <b class="caret"></b>
                        </a>
            <ul class="dropdown-menu extended logout">
              <div class="log-arrow-up"></div>
              <li class="eborder-top">
                <a href="#"><i class="icon_profile"></i> My Profile</a>
              </li>
              <li>
                <a href="../index.jsp"><i class="icon_key_alt"></i> Log Out</a>
              </li>
            </ul>
          </li>
          <!-- user login dropdown end -->
        </ul>
        <!-- notificatoin dropdown end-->
      </div>
    </header>
    <!--header end-->

<aside>
  <div id="sidebar" class="nav-collapse ">
    <!-- sidebar menu start-->
    <ul class="sidebar-menu">
      <li class="active">
        <a class="" href="dashboard.jsp">
            <i class="icon_house_alt"></i>
            <span>Dashboard</span>
        </a>
      </li>
      <li class="">
        <a class="" href="#">
            <i class="fa fa-shopping-cart"></i>
            <span>Order</span>
        </a>
      </li>
      <li class="">
        <a class="" href="#">
            <i class="fa fa-shopping-cart"></i>
            <span>Stock</span>
        </a>
      </li>
      <li class="sub-menu">
        <a href="javascript:;" class="">
            <i class="icon_folder-add"></i>
            <span>Configure</span>
            <span class="menu-arrow arrow_carrot-right"></span>
        </a>
        <ul class="sub">
          <li><a class="" href="categories.jsp">Categories</a></li>
          <li><a class="" href="customer.jsp">Customers</a></li>
          <li><a class="" href="product.jsp">Products</a></li>
          <li><a class="" href="supplier.jsp">Suppliers</a></li>
          <li><a class="" href="user.jsp">Users</a></li>
        </ul>
      </li>

      <li class="sub-menu">
        <a href="javascript:;" class="">
            <i class="icon_documents_alt"></i>
            <span>Report</span>
            <span class="menu-arrow arrow_carrot-right"></span>
        </a>
        <ul class="sub">
          <li><a class="" href="#">Customers</a></li>
          <li><a class="" href="#">Suppliers</a></li>
          <li><a class="" href="#">Orders</a></li>
        </ul>
      </li>

    </ul>
    <!-- sidebar menu end-->
  </div>
</aside>
 </div>
