<%-- 
    Document   : locationAdd
    Created on : Jul 14, 2017, 11:34:34 AM
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
                    <center><h2>Locations</h2></center>
                    <br>
                    <table id="locationTable" class="table table-hover">
                        <tr>
                            <th width="24%">Location Name</th>
                            <th width="27%">Description</th>
                            <th width="24%">Address</th>
                            <th width="12.5%">Latitude</th>
                            <th width="12.5%">Longitude</th>

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
                <!-- 
                    Add col to hold the new contact form - have it take up the other 
                    half of the row
                -->
                <div class="col-md-6">
                    <center><h2>Add New Location</h2></center>
                    <br>
                    <form class="form-horizontal" 
                          role="form" method="POST" 
                          action="createLocation">
                        <div class="form-group">
                            <label for="add-location-name" class="col-md-4 control-label">Location Name:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="locationName" placeholder="Progressive Field"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-location-description" class="col-md-4 control-label">Description:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="locationDescription" placeholder="He flew right onto the field!"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-location-address" class="col-md-4 control-label">Address:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="locationAddress" placeholder="123 Indians Drive, Cleveland,OH 43235"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-location-latitude" class="col-md-4 control-label">Latitude:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="locationLatitude" placeholder="43.01826"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-location-longitude" class="col-md-4 control-label">Longitude:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="locationLongitude" placeholder="-81.2343"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <input type="submit" 
                                       id="add-location" 
                                       formmethod="POST" 
                                       formaction="locationAdd/add" 
                                       class="btn btn-primary" 
                                       value="Add New Location"/>
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
