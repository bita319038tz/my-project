<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../layout/header.jsp" />
<body>
  <!-- container section start -->
  <section id="container" class="">
 	<!-- navbar section start -->
	<jsp:include page="../layout/asidebar.jsp" />
 	<!-- navbar section end -->

    <!--main content start-->
    <section id="main-content">
      <section class="wrapper">
        <!--overview start-->
        <div class="row">
          <div class="col-lg-12">
            <ol class="breadcrumb">
              <li><i class="fa fa-home"></i><a href="#">Home</a></li>
              <li><i class="fa fa-user"></i>Customer</li>
            </ol>
          </div>
        </div>
        
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addModal" style="margin: 10px 0px;">New Customer</button>
		 
		 <div class="row">
          <div class="col-lg-12">
            <section class="panel">
              <header class="panel-heading">
                Departments
              </header>

              <table class="table table-striped table-advance table-hover">
                <thead>
                  <tr>
                   	<th> Sno</th>
                    <th> Customer Name</th>
                    <th> Phone Number</th>
                    <th> Address</th>
                    <th class="text-right"> Action</th>
                  </tr>
                </thead>
                <tbody>
	                <tr>
	                	<td>1</td>
	                	<td>Hasina Amour</td>
	                	<td>088665443</td>
	                	<td>PEMBA</td>
	                	<td></td>
	                </tr>
	                
	                <tr>
	                	<td>2</td>
	                	<td>Hawa Salum Kombo</td>
	                	<td>0889776544</td>
	                	<td>Fuoni</td>
	                	<td></td>
	                </tr>
                </tbody>
              </table>
            </section>
          </div>
        </div>
        
        
      </section>
    </section>
    <!--main content end-->
  </section>
  <!-- container section start -->

  <!-- container section end -->
<jsp:include page="../layout/footer.jsp" />
<script src="..vendors//jscript/department.js"></script>
</body>