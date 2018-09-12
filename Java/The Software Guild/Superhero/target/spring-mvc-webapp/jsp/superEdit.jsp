<%-- 
    Document   : superEdit
    Created on : Jul 14, 2017, 11:00:13 AM
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
        <title>Super Edit</title>
    </head>
    <body>
        <div class="container">
            <h1>Super Edit</h1>
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
                             id="edit-super-form"
                             action="editSuper"
                             method="POST"
                             modelAttribute="hero">

                        <div>
                            <sf:input type="hidden"
                                      id="superId"
                                      name="superId"
                                      class="form-control"
                                      path="superId"/>
                        </div>

                        <!--Super Name-->
                        <div class="form-group">
                            <label for="superId" class="col-md-2 control-label">Super Hero:</label>
                            <div class="col-md-5">
                                <sf:input type="text"
                                          id="superName"
                                          style="color:gray;"
                                          placeholder="The Eiffel Tower"
                                          name="superName"
                                          class="form-control"
                                          path="superName"
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
                                          path="superDescription"
                                          required="required"/>

                            </div>
                        </div>
                        <!--power-->
                        <div class="form-group">
                            <label for="edit-super-power" class="col-md-2 control-label">Super Power:</label>
                            <div class="col-md-5">
                                <select class="form-control"
                                        name="superPowerId"
                                        placeholder="Flight"
                                        path="superPowerId"
                                        required>
                                    <c:forEach var="sPowerList" items="${sPowerList}">
                                        <option value="${sPowerList.superPowerId}">${sPowerList.superPowerName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <!--organization-->
                        <div class="form-group">
                            <label for="edit-organization" class="col-md-2 control-label">Organization:</label>
                            <div class="col-md-5">
                                <select class="form-control"
                                        name="organizationId"
                                        placeholder="Suicide Squad"
                                        path="oranizationId"
                                        required>
                                    <c:forEach var="orgList" items="${orgList}">
                                        <option value="${orgList.organizationId}">${orgList.organizationName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <br>


                        <!--Submit Button-->
                        <div class="form-group">
                            <div class="col-md-offset-2 col-md-8">
                                <input type="submit"
                                       id="edit-super"
                                       action="editSuper"/>
                            </div>
                        </div>
                    </sf:form>

                    <!--Cancel Button-->
                    <div>
                        <form action="${pageContext.request.contextPath}/" method="GET">
                            <div class="col-md-offset-2">
                                <button class="btn btn-default col-md-offset-2"
                                        id="cancel-super-edit-button"
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