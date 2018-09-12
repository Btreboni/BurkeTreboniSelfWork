<%-- 
    Document   : sightingAdd
    Created on : Jul 14, 2017, 2:34:24 PM
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
                    <center><h2>Super Hero/Villain Sightings</h2></center>
                    <br>
                    <table id="sightingsTable" class="table table-hover">
                        <tr>
                            <th width="25%">Date</th>
                            <th width="25%">Super Human</th>
                            <th width="25%">Location</th>
                            <th width="25%">Organization</th>
                        </tr>
                        <tbody id="content-rows">
                            <!--Sightings Table List-->
                            <c:forEach var="sighting" items="${sightingList}">
                                <tr>
                                    <td>
                                        <c:out value="${sighting.sightingDate}"/>
                                    </td>
                                    <td>
                                        <c:out value="${sighting.superName}"/>
                                    </td>
                                    <td>
                                        <c:out value="${sighting.locationName}"/>
                                    </td>
                                    <td>
                                        <c:out value="${sighting.organizationName}"/>
                                    </td>
                                    <td>
                                        <a href="displayEditSighting?sightingId=${sighting.sightingId}">
                                            Edit
                                        </a>

                                    </td>
                                    <td>
                                        <a href="sightingDelete?sightingId=${sighting.sightingId}">
                                            Delete
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>             
                </div> <!-- End col div -->
                <div class="col-md-6">
                    <center><h2>Add New Super Hero/Villain</h2></center>
                    <br>
                    <form class="form-horizontal" 
                          role="form" 
                          method="POST" 
                          action="/sightingAdd/add">

                        <div class="form-group">
                            <label for="add-superHuman" 
                                   class="col-md-4 control-label">
                                Super Human:
                            </label>
                            <div class="col-md-8">
                                <select class="form-control" 
                                        name="superId" 
                                        placeholder="Batman"
                                        required>
                                    <c:forEach var="hero" items="${superList}">
                                        <option value="${hero.superId}">${hero.superName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="add-sighting-date" 
                                   class="col-md-4 control-label">
                                Sighting Date:
                            </label>
                            <div class="col-md-8">
                                <input type="Date" 
                                       class="form-control" 
                                       name="sightingDate" 
                                       placeholder="YYYYMMDD"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="add-location" class="col-md-4 control-label">Location:</label>
                            <div class="col-md-8">
                                <select class="form-control" 
                                        name="locationId" 
                                        placeholder="Location"
                                        required>
                                    <c:forEach var="location" items="${locationList}">
                                        <option value="${location.locationId}">${location.locationName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <input type="submit" 
                                       id="add-sighting" 
                                       formmethod="POST" 
                                       formaction="sightingAdd/add" 
                                       class="btn btn-primary" 
                                       value="Add New Sighting"/>
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
