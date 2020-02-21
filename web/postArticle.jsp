<%-- 
    Document   : postArticle
    Created on : Jan 16, 2020, 3:16:55 PM
    Author     : ngochuu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <title>Post Article</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container-fluid"> 
            <div class="row">
                <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
                    <div class="card card-signin my-5">
                        <div class="card-body">
                            <h5 class="card-title text-center mb-3"><font color="red">${requestScope.MESSAGE}</font></h5>
                            <h3 class="card-title text-center">ARTICLE FORM</h3>
                            <form action="MainController" method="POST" class="form-signin">
                                Title: <input type="text" name="txtTitle" value="${param.txtTitle}" class="form-control mb-3" />
                                <font color="red"><p class="mb-3">${requestScope.INVALID.titleError}</p></font>
                                Short Description: <textarea name="txtDescription" class="form-control mb-3">${param.txtDescription}</textarea>
                                <font color="red"><p class="mb-3">${requestScope.INVALID.descriptionError}</p></font>
                                Content: <textarea name="txtContent" class="form-control mb-3" rows="5">${param.txtContent}</textarea>
                                <font color="red"><p class="mb-3">${requestScope.INVALID.contentError}</p></font>
                                <button type="submit" name="action" value="PostArticle" class="btn btn-lg btn-primary text-uppercase mb-3 btn-block">Post</button>
                            </form>
                            <hr class="my-4">
                            <div class="mb-3">
                                <c:url var="homeLink" value="MainController">
                                    <c:param name="action" value="SearchArticle"/>
                                </c:url>
                                <a href="${homeLink}">Home Page</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
