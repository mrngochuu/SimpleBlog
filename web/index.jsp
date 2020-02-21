<%-- 
    Document   : index.jsp
    Created on : Jan 13, 2020, 1:14:22 PM
    Author     : ngochuu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <title>Home Page</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container-fluid"> 
            <div class="row">
                <div class="col-sm-8 col-md-8 col-lg-8 mx-auto">
                    <div class="card card-signin my-5">
                        <div class="card-body">
                            <h5 class="card-title text-center mb-3"><font color="red">${requestScope.MESSAGE}</font></h5>
                            <form action="MainController" method="GET" class="form-signin">
                                <input type="text" name="txtSearch" value="${param.txtSearch}" placeholder="Search by Content" class="mb-3 mr-3"/>
                                <button type="submit" name="action" value="SearchArticle" class="mb-3">Search</button>
                            </form>
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th style="width: 35%; text-align: center;">Title</th>
                                        <th style="width: 35%; text-align: center;">Short Description</th>
                                        <th style="width: 20%; text-align: center;">Author</th>
                                        <th style="width: 10%; text-align: center;">Date</th>
                                    </tr>
                                </thead>
                                <c:if test="${not empty requestScope.LIST_ARTICLES}">
                                    <c:forEach items="${LIST_ARTICLES}" var="article">
                                        <tr>
                                            <c:url var="detailsLink" value="MainController">
                                                <c:param name="action" value="ShowArticle"/>
                                                <c:param name="articleID" value="${article.articleID}"/>
                                            </c:url>
                                            <td style="text-align: center;"><a href="${detailsLink}" style="text-decoration: none; color: black;">${article.title}</a></td>
                                            <td style="text-align: center;">${article.description}</td>
                                            <td style="text-align: center;">${requestScope.LIST_USERS[article.email]}<br>${article.email}</td>
                                            <td style="text-align: center;">${article.postingDate.date}/${article.postingDate.month + 1}/${article.postingDate.year + 1900}</td>
                                        </tr>
                                    </c:forEach>
                                </c:if>
                            </table>
                            Page: 
                            <c:forEach var='i' begin="1" end="${requestScope.TOTAL_PAGE}">
                                <c:url var="pageNum" value="MainController">
                                    <c:param name="action" value="SearchArticle"/>
                                    <c:param name="txtPage" value="${i}"/>
                                    <c:param name="txtSearch" value="${param.txtSearch}" />
                                </c:url>
                                <div class="mx-auto d-inline">
                                    <a href="${pageNum}">${i}</a>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
