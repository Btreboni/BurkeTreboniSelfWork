<%-- 
    Document   : super
    Created on : Jul 13, 2017, 8:20:33 PM
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
                    <center><h2>Super Hero/Villains</h2></center>
                    <br>
                    <table id="superTable" class="table table-hover">
                        <tr>
                            <th width="20%">Super Name</th>
                            <th width="20%">Description</th>
                            <th width="20%">Power</th>
                            <th width="20%">Organization</th>
                            <th width="10%"></th>
                            <th width="10%"></th>
                        </tr>
                        <tbody id="content-rows">
                            <c:forEach var="shoList" items="${shoList}">
                                <tr>
                                    <td>
                                        <c:out value="${shoList.superName}"/>
                                    </td>
                                    <td>
                                        <c:out value="${shoList.superDescription}"/>
                                    </td>
                                    <td>
                                        <c:out value="${shoList.superPowerName}"/>
                                    </td>
                                    <td>
                                        <c:out value="${shoList.organizationName}"/>
                                    </td>
                                    <td>
                                        <a href="displayEditSuper?superId=${shoList.superId}">
                                            Edit
                                        </a>

                                    </td>
                                    <td>
                                        <a href="superDelete?superId=${shoList.superId}">
                                            Delete
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>                    
                </div> <!-- End col div -->


                <!-- 
                    Add col to hold the new contact form - have it take up the other 
                    half of the row
                -->
                <div class="col-md-6">
                    <center><h2>Add New Super Hero/Villain</h2></center>
                    <br>
                    <form class="form-horizontal" 
                          role="form" 
                          method="POST" 
                          action="superAdd/add">
                        <div class="form-group">
                            <label for="add-super-name" 
                                   class="col-md-4 control-label">Super Name:</label>
                            <div class="col-md-8">
                                <input type="text" 
                                       class="form-control" 
                                       name="superName" 
                                       placeholder="Superman"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-description" class="col-md-4 control-label">Description:</label>
                            <div class="col-md-8">
                                <input type="text" 
                                       class="form-control" 
                                       name="superDescription" 
                                       placeholder="Ex: Faster than a speeding bullet!"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-super-power" class="col-md-4 control-label">
                                Super Power:
                            </label>
                            <div class="col-md-8">
                                <select class="form-control" 
                                        name="superPowerId" 
                                        placeholder="Flight"
                                        required>
                                    <!-- Add to items = superList-->
                                    <c:forEach var="superPower" items="${powerList}">
                                        <option value="${superPower.superPowerId}">${superPower.superPowerName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-organization" class="col-md-4 control-label">
                                Organization:
                            </label>
                            <div class="col-md-8">
                                <select type="text" 
                                        class="form-control" 
                                        name="organizationId" 
                                        placeholder="Justice League"
                                        required>
                                    <!-- Add to items = organizationList-->
                                    <c:forEach var="organizationChoice" items="${organizationList}">
                                        <option value="${organizationChoice.organizationId}">${organizationChoice.organizationName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <input type="submit" 
                                       id="add-super-human" 
                                       formmethod="POST" 
                                       formaction="superAdd/add" 
                                       class="btn btn-primary" 
                                       value="Add Super Human"/>
                            </div>
                        </div>
                    </form>
                </div> <!-- End col div -->
            </div><!--End container div -->
            <!-- Main Page Content Stop -->  
        </div>
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/super.js"></script>
    </body>
</html>
