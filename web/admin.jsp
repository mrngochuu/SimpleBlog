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
        <title>Admin Page</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container-fluid"> 
            <div class="row">
                <div class="col-sm-12 col-md-12 col-lg-12 mx-auto">
                    <div class="card card-signin my-5">
                        <div class="card-body">
                            <h5 class="card-title text-center mb-3"><font color="red">${requestScope.MESSAGE}</font></h5>
                            <form action="MainController" method="POST" class="form-signin">
                                <input type="text" name="txtSearch" value="${param.txtSearch}" placeholder="Search by Content" class="mb-3 mr-3" />
                                <input type="text" name="txtAuthorName" value="${param.txtAuthorName}" placeholder="Author name" class="mb-3 mr-3"/>
                                <select class="browser-default mb-3 mr-3" name="cbStatus">
                                    <option value="0">--Status--</option>
                                    <c:forEach items="${sessionScope.LIST_STATUS}" var="statusDTO">
                                        <option value="${statusDTO.statusID}" <c:if test="${param.cbStatus == statusDTO.statusID}">selected</c:if>>${statusDTO.statusName}</option>
                                    </c:forEach>
                                </select>
                                <button type="submit" name="action" value="AdminSearchArticle" class="mb-3">Search</button>
                            </form>
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th style="width: 5%; text-align: center;">ID</th>
                                        <th style="width: 30%; text-align: center;">Title</th>
                                        <th style="width: 30%; text-align: center;">Short Description</th>
                                        <th style="width: 15%; text-align: center;">Author</th>
                                        <th style="width: 5%; text-align: center;">Date</th>
                                        <th style="width: 5%; text-align: center;">Status</th>
                                        <th style="width: 5%; text-align: center;">Approval</th>
                                        <th style="width: 5%; text-align: center;">Delete</th>
                                    </tr>
                                </thead>
                                <c:if test="${not empty requestScope.LIST_ARTICLES}">
                                    <c:forEach items="${LIST_ARTICLES}" var="article">
                                        <tr>
                                            <c:url var="detailsLink" value="MainController">
                                                <c:param name="action" value="AdminShowArticle"/>
                                                <c:param name="articleID" value="${article.articleID}"/>
                                            </c:url>
                                            <c:url var="approvalLink" value="MainController">
                                                <c:param name="action" value="AdminApprovalArticle"/>
                                                <c:param name="articleID" value="${article.articleID}" />
                                                <c:param name="txtPage" value="${i}"/>
                                                <c:param name="txtSearch" value="${param.txtSearch}" />
                                                <c:param name="txtAuthorName" value="${param.txtAuthorName}"/>
                                                <c:param name="cbStatus" value="${param.cbStatus}"/>
                                            </c:url>
                                            <c:url var="deleteLink" value="MainController">
                                                <c:param name="action" value="AdminDeleteArticle"/>
                                                <c:param name="articleID" value="${article.articleID}" />
                                                <c:param name="txtPage" value="${i}"/>
                                                <c:param name="txtSearch" value="${param.txtSearch}" />
                                                <c:param name="txtAuthorName" value="${param.txtAuthorName}"/>
                                                <c:param name="cbStatus" value="${param.cbStatus}"/>
                                            </c:url>
                                            <td style="text-align: center;">${article.articleID}</td>
                                            <td style="text-align: center;"><a href="${detailsLink}" style="text-decoration: none; color: black;">${article.title}</a></td>
                                            <td style="text-align: center;">${article.description}</td>
                                            <td style="text-align: center;">
                                                ${requestScope.LIST_USERS[article.email]}<br>
                                                ${article.email}
                                            </td>
                                            <td style="text-align: center;">${article.postingDate.date}/${article.postingDate.month + 1}/${article.postingDate.year + 1900}</td>
                                            <td style="text-align: center;">
                                                <c:if test="${article.statusID == 1}"><p class="btn btn-block btn-secondary">NEW</p></c:if>
                                                <c:if test="${article.statusID == 2}"><p class="btn btn-block btn-success">ACTIVE</p></c:if>
                                                <c:if test="${article.statusID == 3}"><p class="btn btn-block btn-danger">DELETED</p></c:if>
                                                </td>
                                                <td style="text-align: center;">
                                                <c:if test="${article.statusID == 1}">
                                                    <a href="${approvalLink}"><p class="btn btn-block btn-dark">Accept</p></a>
                                                </c:if>
                                            </td>
                                            <td style="text-align: center;">
                                                <c:if test="${article.statusID != 3}">
                                                    <a href="${deleteLink}"><p class="btn btn-block btn-warning">Delete</p></a>
                                                </c:if>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </c:if>
                            </table>
                            Page: 
                            <c:forEach var='i' begin="1" end="${requestScope.TOTAL_PAGE}">
                                <c:url var="pageNum" value="MainController">
                                    <c:param name="action" value="AdminSearchArticle"/>
                                    <c:param name="txtPage" value="${i}"/>
                                    <c:param name="txtSearch" value="${param.txtSearch}" />
                                    <c:param name="txtAuthorName" value="${param.txtAuthorName}"/>
                                    <c:param name="cbStatus" value="${param.cbStatus}"/>
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
