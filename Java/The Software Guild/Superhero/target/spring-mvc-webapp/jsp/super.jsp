<%-- 
    Document   : super
    Created on : Jul 14, 2017, 10:39:12 AM
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
                    <li role="presentation" ><a href="${pageContext.request.contextPath}/displaySuperPage">Add Super Human</a></li>
                </ul>    
            </div>
        </div>    
        <div class="container">
            <!-- Main Page Content Start -->
            <div class="row">
                <div class="col-md-12">
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
                        <c:forEach var="superList" items="${superList}">
                            <tr>
                                <td>
                                    <c:out value="${superList.superName}"/>
                                </td>
                                <td>
                                    <c:out value="${superList.superDescription}"/>
                                </td>
                                <td>
                                    <c:out value="${superList.superPowerName}"/>
                                </td>
                                <td>
                                    <c:out value="${superList.organizationName}"/>
                                </td>
                                <td>
                                    <a href="displayEditSuper?superId=${superList.superId}">
                                        Edit
                                    </a>

                                </td>
                                <td>
                                    <a href="superDelete?superId=${superList.superId}">
                                        Delete
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>                    
                </div> <!-- End col div -->
            </div>
        </div><!--End container div -->

        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
