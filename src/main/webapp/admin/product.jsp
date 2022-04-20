<%@page import="cosmetic.model.Product"%>
<%@page import="cosmetic.dao.ProductDao"%>
<%@page import="cosmetic.model.Category"%>
<%@page import="cosmetic.dao.CategoryDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        </div>
        
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addModal" style="margin: 10px 0px;">New Product</button>
		 
		 <div class="row">
		 <%if(request.getAttribute("error")!= null){out.println("<div class='alert alert-danger text-center col-md-12' id='alert-message'>"+request.getAttribute("error")+"</div>");}%>
		 <%if(request.getSession().getAttribute("success")!= null){out.println("<div class='alert alert-success text-center col-md-12' id='alert-message'>"+request.getSession().getAttribute("success")+"</div>");}%>
          <c:remove var="success" scope="session" /> 
          <div class="col-lg-12">
            <section class="panel">
              <header class="panel-heading">
                Users
              </header>

              <table class="table table-striped table-advance table-hover">
                <thead>
                  <tr>
                   	<th> Sno</th>
                   	<th> Product Name</th>
                    <th> Category</th>
                    <th> Price</th>
                    <th class="text-right"> Action</th>
                  </tr>
                </thead>
                <tbody>
                <%
                CategoryDao customerDao = new CategoryDao();
                List<Category> categories = customerDao.getAllCategory();
                
                ProductDao productDao = new ProductDao();
                List<Product> productList = productDao.getAllProducts();
                int count = 1;
                for(Product product : productList)
                { %>
	                <tr>
	                	<td><%=count %></td>
	                	<td><%=product.getProductName()%></td>
	                	<td><%=product.getCategoryName()%></td>
	                	<td><%=product.getProductPrice()%></td>
	                	<td class="text-right">
	                      <div class="btn-group">
	                        <a class="btn btn-success" href=""><i class="fa fa-edit"></i></a>
	                        
	                        <a class="btn btn-primary" href=""><i class="fa fa-book"></i></a>
	                        <a onclick="return confirm('Record will be deleted, are you sure?')" class="btn btn-danger" href="../deleteProduct?id=<%=product.getProductId()%>"><i class="fa fa-trash"></i></a>
	                      </div>
	                    </td>
	                </tr>
	          <% count++;
	          } %>
                </tbody>
              </table>
            </section>
          </div>
        </div>
        
         <div class="modal fade" id="addModal" data-backdrop="static" data-keyboard="false">
            <div class="modal-dialog modal-lg">
              <div class="modal-content">
                  <div class="modal-header">
                      <h4>Add New Product</h4>
                 </div>
                    <form action="../product?action=add" method="POST">
                    <div class="modal-body">
                          <div class="row" style="padding:20px;">
                              <div class="col-md-12">
                                  <div class="form-group">
                                        <label>Product Name</label>
                                        <input type="text" name="name" class="form-control" placeholder="product name" required="required">
                                  </div>
                                  
                                  <div class="form-group">
                                        <label>Price</label>
                                        <input type="number" name="price" class="form-control" placeholder="price" required="required">
                                  </div>
                                  
                                  <div class="form-group">
                                        <label>Category</label>
                                        <select  name="category" class="form-control" id="" required="required">
                                            <option value="">--select product category--</option>
                                            <%for(Category category : categories){ %>
                                            	<option value="<%=category.getCategory_id()%>"><%=category.getCategory_name() %></option>
                                          <%}%>
                                        </select> 
                                    </div>
                              </div>
                          </div>
                      </div>
                    <div class="modal-footer">
                       <button type="submit" class="btn btn-success">Save</button>
                       <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    </div>
                    </form>
              </div>
              <!-- /.modal-content -->
            </div>
            <!-- /.modal-dialog -->
          </div>
        
      </section>
    </section>
    <!--main content end-->
  </section>
  <!-- container section start -->

  <!-- container section end -->
<jsp:include page="../layout/footer.jsp" />
</body>