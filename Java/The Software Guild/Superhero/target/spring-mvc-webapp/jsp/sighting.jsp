<%-- 
    Document   : sighting
    Created on : Jul 13, 2017, 8:21:04 PM
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
            <div class="superAddbar">
                <ul class="supAdd nav-tab">
                    <li role="presentation" ><a href="${pageContext.request.contextPath}/sightingAdd">Add Super Human Sighting</a></li>
                </ul>    
            </div>
        </div>    
        <div class="container">
            <!-- Main Page Content Start -->
            <div class="row">
                <div class="col-md-12">
                    <center><h2>Super Hero/Villain Sighting</h2></center>
                    <br>
                    <table id="sightingsTable" class="table table-hover">
                        <tr>
                            <th width="20%">Location</th>
                            <th width="20%">Super Human</th>
                            <th width="20%">Organization</th>
                            <th width="20%">Date</th>
                            <th width="10%"></th>
                            <th width="10%"></th>

                        </tr>
                        <tbody id="content-rows">
                            <!--Sightings Table List-->
                            <c:forEach var="currentSighting" items="${sightingList}">
                                <tr>
                                    <td>
                                        <c:out value="${currentSighting.locationName}"/>

                                    </td>
                                    <td>
                                        <c:out value="${currentSighting.superName}"/>
                                    </td>
                                    <td>
                                        <c:out value="${currentSighting.organizationName}"/>
                                    </td>
                                    <td>
                                        <c:out value="${currentSighting.sightingDate}"/>
                                    </td>
                                    <td>
                                        <a href="displayEditSighting?sightingId=${currentSighting.sightingId}">
                                            Edit
                                        </a>

                                    </td>
                                    <td>
                                        <a href="sightingDelete?sightingId=${currentSighting.sightingId}">
                                            Delete
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>                    
                </div> <!-- End col div -->
            </div>
            <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
