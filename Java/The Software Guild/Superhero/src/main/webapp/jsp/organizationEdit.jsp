<%-- 
    Document   : organizationEdit
    Created on : Jul 14, 2017, 1:49:02 PM
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
                             id="edit-organization-form"
                             action="editOrganization"
                             method="POST"
                             modelAttribute="organization">

                        <div>
                            <!--OrganizationId-->
                            <sf:input type="hidden"
                                      id="organizationId"
                                      name="organizationId"
                                      class="form-control"
                                      path="organizationId"/>
                        </div>

                        <!--Organization Name-->
                        <div class="form-group">
                            <label for="organizationId" class="col-md-2 control-label">Organization Name:</label>
                            <div class="col-md-5">
                                <sf:input type="text"
                                          id="organizationName"
                                          style="color:gray;"
                                          name="organizationName"
                                          class="form-control"
                                          path="organizationName"
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
                                          path="organizationDescription"
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
                                          name="organizaitionAddress"
                                          class="form-control"
                                          path="organizationAddress"/>
                            </div>
                        </div>
                        <!--Phone-->
                        <div>
                            <div class="form-group">
                                <label for="edit-organization-phone" class="col-md-2 control-label">
                                    Phone Number:
                                </label>
                                <div class="col-md-10">
                                    <sf:input id="phone"
                                              name="phone"
                                              class="form-control"
                                              path="organizationPhone"/>
                                </div>
                            </div>
                        </div>


                        <!--Email-->
                        <div class="form-group">
                            <label for="edit-organization-email" class="col-md-2 control-label">Email:</label>
                            <div class="col-md-10">
                                <sf:input id="email"
                                          name="email"
                                          class="form-control"
                                          path="organizationEmail"/>
                            </div>
                        </div>
                        <br>


                        <!--Submit Button-->
                        <div class="form-group">
                            <div class="col-md-offset-2 col-md-8">
                                <input type="submit"
                                       id="edit-location"
                                       action="editOrganization"/>
                            </div>
                        </div>
                    </sf:form>

                    <!--Cancel Button-->
                    <div>
                        <form action="${pageContext.request.contextPath}/" method="GET">
                            <div class="col-md-offset-2">
                                <button class="btn btn-default col-md-offset-2"
                                        id="cancel-organization-create-button"
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