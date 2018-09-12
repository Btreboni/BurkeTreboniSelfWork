<%-- 
    Document   : organizationAdd
    Created on : Jul 14, 2017, 1:49:18 PM
    Author     : Burke Treboni
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>H.E.R.O.</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"> 
    </head>
    <body>
        <div class="container">
            <div class="navBar">
                <!--Navigation Bar-->
                <jsp:include page="navBar.jsp" />
            </div>
        </div>
        <div class="container">
            <!-- Main Page Content Start -->
            <div class="row">
                <div class="col-md-6">
                    <center><h2>Organizations</h2></center>
                    <br>
                    <table id="organizationTable" class="table table-hover">
                        <tr>
                            <th width="20%">Organization Name</th>
                            <th width="20%">Description</th>
                            <th width="20%">Address</th>
                            <th width="10%">Phone</th>
                            <th width="12.5%">Email</th>
                        </tr>
                        <c:forEach var="currentOrganization" items="${organizationList}">
                            <tr>
                                <td>
                                    <a href="displayOrganizationDetails?organizationId=${currentOrganization.organizationId}">
                                        <c:out value="${currentOrganization.organizationName}"/>
                                    </a>
                                </td>
                                <td>
                                    <c:out value="${currentOrganization.organizationDescription}"/>
                                </td>
                                <td>
                                    <c:out value="${currentOrganization.organizationAddress}"/>
                                </td>
                                <td>
                                    <c:out value="${currentOrganization.organizationPhone}"/>
                                </td>
                                <td>
                                    <c:out value="${currentOrganization.organizationEmail}"/>
                                </td>
                                <td>
                                    <a href="displayEditOrganization?organizationId=${currentOrganization.organizationId}">
                                        <!--check this-->
                                        Edit
                                    </a>

                                </td>
                                <td>
                                    <a href="organizationDelete?organizationId=${currentOrganization.organizationId}">
                                        Delete
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>                    
                </div> <!-- End Organization Display Div -->
                <div class="col-md-6">
                    <center><h2>Add New Organization</h2></center>
                    <br>
                    <form class="form-horizontal" 
                          role="form" method="POST" 
                          action="createOrganization">
                        <div class="form-group">
                            <label for="add-organization-name" class="col-md-4 control-label">Organization Name:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="organizationName" placeholder="The Suicide Squad"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-organization-description" class="col-md-4 control-label">Description:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="organizationDescription" placeholder="Harley Quinn can be quite Vexing!"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-organization-address" class="col-md-4 control-label">Address:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="organizationAddress" placeholder="22 Elizabeth Arkham Asylum Rd NY,NY"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-organization-phone" class="col-md-4 control-label">Phone:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="organizationPhone" placeholder="2129891765"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-organization-email" class="col-md-4 control-label">Email:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="organizationEmail" placeholder="HQuinn@HAHAHA.com"/>
                            </div>
                        </div>
                       <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <input type="submit" 
                                       id="add-organization" 
                                       formmethod="POST" 
                                       formaction="organizationAdd/add" 
                                       class="btn btn-primary" 
                                       value="Add New Organization"/>
                            </div>
                        </div>
                    </form>
                </div> <!-- End col div -->
            </div> <!-- End row div -->
            <!-- Main Page Content Stop -->  
        </div>
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
