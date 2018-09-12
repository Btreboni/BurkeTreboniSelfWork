<%-- 
    Document   : organization
    Created on : Jul 13, 2017, 8:20:54 PM
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
            <div class="organizationAddbar">
                <ul class="organizationAdd nav-tab">
                    <li role="presentation" ><a href="${pageContext.request.contextPath}/organizationAdd">Add Organization</a></li>
                </ul>    
            </div>
        </div>    
        <div class="container">
            <!-- Main Page Content Start -->
            <div class="row">
                <div class="col-md-12">
                    <center><h2>Organizations</h2></center>
                    <br>
                    <table id="organizationTable" class="table table-hover">
                        <tr>
                            <th width="19%">Organization Name</th>
                            <th width="19%">Description</th>
                            <th width="19%">Address</th>
                            <th width="10%">Phone</th>
                            <th width="13%">Email</th>
                            <th width="10%"></th>
                            <th width="10%"></th>
                        </tr>
                        <c:forEach var="currentOrganization" items="${organizationList}">
                            <tr>
                                <td>
                                    <c:out value="${currentOrganization.organizationName}"/>
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
                </div> <!-- End col div -->
            </div>
            <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>