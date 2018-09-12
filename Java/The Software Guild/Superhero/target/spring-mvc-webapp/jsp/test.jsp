<%-- 
    Document   : test
    Created on : Jul 22, 2017, 3:18:50 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/home.css">

        <script src='https://cloud.tinymce.com/stable/tinymce.min.js?apiKey=8gb9pxvd80c26aaq2nzqgom5o56s9nrg4jjh6hz6sjlbgbmw'></script>
        <script>
            tinymce.init({
                selector: '#blogText',
                height: 300,
                width: '100%',
                theme: 'modern',
                plugins: [
                    'advlist autolink lists link image charmap print preview hr anchor pagebreak',
                    'searchreplace wordcount visualblocks visualchars code fullscreen',
                    'insertdatetime media nonbreaking save table contextmenu directionality',
                    'emoticons template paste textcolor colorpicker textpattern imagetools codesample toc'
                ],
                toolbar1: 'undo redo | insert | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image',
                toolbar2: 'print preview media | forecolor backcolor emoticons | codesample',
                image_advtab: true,
                templates: [
                    {title: 'Test template 1', content: 'Test 1'},
                    {title: 'Test template 2', content: 'Test 2'}
                ]
            });
        </script>
        <style>
            h1 {
                text-align: center;
            }

            .footer{
                margin-top: 20px;
            }
        </style>
        <title>Write Your Blog!</title>
    </head>
    <body>
        <div class="container">
            <h1>Create New Blog</h1>
            <hr/>
            <jsp:include page="nav.jsp"/>
        </div>

        <!--Beginning of Create Blog Page-->

        <div class="container">
            <div class="row col-md-12">
                <div class="col-md-10 col-md-offset-1">
                    <br/>
                    <br/>
                    <form class="form-horizontal"
                          role="form"
                          id="create-blog-post-form"
                          action="createNewBlogPost"
                          method="POST">
                        <div class="form-group">
                            <label for="add-blog-title" class="col-md-3 control-label">Blog Title:</label>
                            <div class="col-md-5">
                                <input type="text"
                                       id="blogTitle"
                                       style="color:gray;"
                                       placeholder="Title of Blog Post"
                                       name="blogTitle"
                                       class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-start-date" class="col-md-3 control-label">Post Date:</label>
                            <div class="col-md-5">
                                <input type="date" 
                                       id="startDate" 
                                       style="color:gray;"
                                       placeholder="YYYYMMDD"
                                       name="blogStartDate"
                                       class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-end-date" class="col-md-3 control-label">Expire Date:</label>
                            <div class="col-md-5">
                                <input type="date" 
                                       id="endDate" 
                                       style="color:gray;"
                                       placeholder="YYYYMMDD"
                                       name="blogEndDate"
                                       class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-blog-content" class="col-md-3 control-label">Blog Content:</label>
                            <div class="col-md-5">
                                <textarea id="blogText"
                                          name="blogContent"
                                          class="form-control">

                                </textarea>
                            </div>
                        </div>
                        <div class="form-group"
                             <label for="add-tag" class="col-md-3 control-label">Create Tags:</label>
                            <div class="col-md-5">
                                <input type="text"
                                       id="tag"
                                       placeholder="#Believeland"
                                       name="blogTag"
                                       class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <input type="submit"
                                       id="add-blog-post"
                                       formmethod="POST"
                                       formaction="createNewBlogPost"
                                       value="Create Blog Post"
                            </div>
                        </div>
                    </form>
                    <form action="${pageContext.request.contextPath}/displayAdminPage" method="GET">
                        <button class="btn btn-default"
                                id="cancel-blog- post-creation- button"
                                type="submit">
                            Cancel
                        </button>
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
    <script src="js/jquery-3.1.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</html>