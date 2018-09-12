<%-- 
    Document   : sightingEdit
    Created on : Jul 14, 2017, 2:34:34 PM
    Author     : Burke Treboni
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/home.css">

        <style>
            h1 {
                text-align: center;
            }

            .footer{
                margin-top: 20px;
            }
        </style>
        <title>Location Edit</title>
    </head>
    <body>
        <div class="container">
            <h1>Location Edit</h1>
            <hr/>
            <jsp:include page="navBar.jsp"/>
        </div>
        <div class="container">
            <div class="row col-md-12">
                <div class="col-md-10 col-md-offset-1">
                    <br/>
                    <br/>
                    <sf:form class="form-horizontal"
                             role="form"
                             id="edit-sighting-form"
                             action="editSighting"
                             method="POST"
                             modelAttribute="sighting">

                        <div>
                            <sf:input type="hidden"
                                      id="sightingId"
                                      name="sightingId"
                                      class="form-control"
                                      path="sightingId"/>
                        </div>

                        <!--Location Name Drop Down-->
                        <div class="form-group">
                            <label for="sightingId" class="col-md-2 control-label">Location Name:</label>
                            <div class="col-md-5">
                                <select class="form-control"
                                        name="locationId"
                                        placeholder="Progressive Field"
                                        path="locationId"
                                        required>
                                    <c:forEach var="locationList" items="${locationList}">
                                        <option value="${locationList.locationId}">${locationList.locationName}${locationlist.locationId}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <!--Super Name-->
                        <div class="form-group">
                            <label for="edit-super-name" class="col-md-2 control-label">Super Hero:</label>
                            <div class="col-md-5">
                                <select class="form-control"
                                        name="superId"
                                        placeholder="Superman"
                                        path="superId"
                                        required>
                                    <c:forEach var="superList" items="${superList}">
                                        <option value="${superList.superId}">${superList.superName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <!--Sighting Date-->
                        <div class="form-group">
                            <label for="edit-sighting-date" class="col-md-2 control-label">Sighting Date:</label>
                            <div class="col-md-5">
                                <sf:input type="date"
                                          id="sightingDate"
                                          style="color:gray;"
                                          name="sightingDate"
                                          class="form-control"
                                          path="sightingDate"/>
                            </div>
                        </div>
                        <!--Submit Button-->
                        <div class="form-group">
                            <div class="col-md-offset-2 col-md-8">
                                <input type="submit"
                                       id="edit-location"
                                       action="editSighting"/>
                            </div>
                        </div>
                    </sf:form>

                    <!--Cancel Button-->
                    <div>
                        <form action="${pageContext.request.contextPath}/sighting" method="GET">
                            <div class="col-md-offset-2">
                                <button class="btn btn-default col-md-offset-2"
                                        id="cancel-edit-sighting-button"
                                        type="submit">
                                    Cancel
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>                                        
</div>
</body>
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</html>