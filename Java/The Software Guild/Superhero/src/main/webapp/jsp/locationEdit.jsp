<%-- 
    Document   : locationEdit
    Created on : Jul 14, 2017, 11:34:47 AM
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
                             id="edit-location-form"
                             action="editLocation"
                             method="POST"
                             modelAttribute="location">

                        <div>
                            <sf:input type="hidden"
                                      id="locationId"
                                      name="locationId"
                                      class="form-control"
                                      path="locationId"/>
                        </div>

                        <!--Location Name-->
                        <div class="form-group">
                            <label for="locationId" class="col-md-2 control-label">Location Name:</label>
                            <div class="col-md-5">
                                <sf:input type="text"
                                          id="locationName"
                                          style="color:gray;"
                                          placeholder="The Eiffel Tower"
                                          name="locationName"
                                          class="form-control"
                                          path="locationName"
                                          required="required"/>

                            </div>
                        </div>
                        <!--Description-->
                        <div class="form-group">
                            <label for="edit-description" class="col-md-2 control-label">Description:</label>
                            <div class="col-md-5">

                                <sf:input type="text"
                                          id="description"
                                          style="color:gray;"
                                          name="description"
                                          class="form-control"
                                          path="locationDescription"
                                          required="required"/>

                            </div>
                        </div>
                        <!--Address-->
                        <div class="form-group">
                            <label for="edit-address" class="col-md-2 control-label">Address:</label>
                            <div class="col-md-5">
                                <sf:input type="text"
                                          id="address"
                                          style="color:gray;"
                                          name="locationAddress"
                                          class="form-control"
                                          path="locationAddress"/>
                            </div>
                        </div>
                        <div>
                            <div class="form-group">
                                <label for="edit-latitude" class="col-md-2 control-label">
                                    Latitude:
                                </label>
                                <div class="col-md-10">
                                    <sf:input id="latitude"
                                              name="latitude"
                                              class="form-control"
                                              path="locationLatitude"/>
                                </div>
                            </div>
                        </div>


                        <!--Longitude-->
                        <div class="form-group">
                            <label for="edit-latitude" class="col-md-2 control-label">Latitude:</label>
                            <div class="col-md-10">
                                <sf:input id="latitude"
                                          name="latitude"
                                          class="form-control"
                                          path="locationLatitude"/>
                            </div>
                        </div>
                        <br>


                        <!--Submit Button-->
                        <div class="form-group">
                            <div class="col-md-offset-2 col-md-8">
                                <input type="submit"
                                       id="edit-location"
                                       action="editLocation"/>
                            </div>
                        </div>
                    </sf:form>

                    <!--Cancel Button-->
                    <div>
                        <form action="${pageContext.request.contextPath}/" method="GET">
                            <div class="col-md-offset-2">
                                <button class="btn btn-default col-md-offset-2"
                                        id="cancel-blog-post-creation-button"
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