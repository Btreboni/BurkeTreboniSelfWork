<%-- 
    Document   : location
    Created on : Jul 13, 2017, 8:20:39 PM
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
            <div class="locationAddbar">
                <ul class="locatoinAdd nav-tab">
                    <li role="presentation" ><a href="${pageContext.request.contextPath}/locationAdd">Add Location</a></li>
                </ul>    
            </div>
        </div>    
        <div class="container">
            <!-- Main Page Content Start -->
            <div class="row">
                <div class="col-md-12">
                    <center><h2>Locations</h2></center>
                    <br>
                    <table id="locationTable" class="table table-hover">
                        <tr>
                            <th width="20%">Location Name</th>
                            <th width="20%">Description</th>
                            <th width="20%">Address</th>
                            <th width="10%">Latitude</th>
                            <th width="10%">Longitude</th>
                            <th width="10%"></th>
                            <th width="10%"></th>
                        </tr>
                        <c:forEach var="currentLocation" items="${locationList}">
                            <tr>
                                <td>
                                    <a href="displayLocationDetails?locationId=${currentLocation.locationId}">
                                        <c:out value="${currentLocation.locationName}"/>
                                    </a>
                                </td>
                                <td>
                                    <c:out value="${currentLocation.locationDescription}"/>
                                </td>
                                <td>
                                    <c:out value="${currentLocation.locationAddress}"/>
                                </td>
                                <td>
                                    <c:out value="${currentLocation.locationLatitude}"/>
                                </td>
                                <td>
                                    <c:out value="${currentLocation.locationLongitude}"/>
                                </td>
                                <td>
                                    <a href="displayEditLocation?locationId=${currentLocation.locationId}">
                                        <!--check this-->
                                        Edit
                                    </a>

                                </td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/locationDelete?locationId=${currentLocation.locationId}">
                                        Delete
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>                    
                </div> <!-- End col div -->
            </div>
        </div>
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>