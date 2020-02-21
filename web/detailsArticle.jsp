<%-- 
    Document   : detailsArticle
    Created on : Jan 15, 2020, 9:59:28 PM
    Author     : ngochuu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <title>${requestScope.ARTICLE_DETAILS.title}</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-8 col-md-8 col-lg-8 mx-auto mt-3 border">
                    <h1 class="font-weight-bold mb-3">${requestScope.ARTICLE_DETAILS.title}</h1>
                    <p class="mb-3">Posting Date: ${requestScope.ARTICLE_DETAILS.postingDate.date}/${requestScope.ARTICLE_DETAILS.postingDate.month + 1}/${requestScope.ARTICLE_DETAILS.postingDate.year + 1900}</p>
                    <hr class="mb-3">
                    <h3 class="mb-3">${requestScope.ARTICLE_DETAILS.description}</h3>
                    <p class="mb-3">${requestScope.ARTICLE_DETAILS.content}</p>
                    <hr class="mb-3">
                    <h3 class="mb-3">Author</h3>
                    <p class="mb-3">Author name: ${requestScope.AUTHOR_DETAILS.name}</p>
                    <p class="mb-3">Author email: ${requestScope.AUTHOR_DETAILS.email}</p>
                    <c:if test="${sessionScope.ROLE.roleName eq 'admin'}">
                        <h3 class="mb-3">Details</h3>
                        <p class="mb-3">Article ID: ${requestScope.ARTICLE_DETAILS.articleID}</p>
                        <c:if test="${requestScope.ARTICLE_DETAILS.statusID == 1}"><p class="btn btn-block btn-secondary mb-3" style="width: 100px;">NEW</p></c:if>
                        <c:if test="${requestScope.ARTICLE_DETAILS.statusID == 2}"><p class="btn btn-block btn-success mb-3" style="width: 100px;">ACTIVE</p></c:if>
                        <c:if test="${requestScope.ARTICLE_DETAILS.statusID == 3}"><p class="btn btn-block btn-danger mb-3" style="width: 100px;">DELETED</p></c:if>
                    </c:if>

                    <h3 class="mb-3">COMMENTS</h3>
                    <c:if test="${not empty requestScope.LIST_COMMENT}">
                        <c:forEach items="${requestScope.LIST_COMMENT}" var="commentDTO">
                            <div>
                                <hr>
                                ${commentDTO.email}<br>
                                ${commentDTO.commentDate.date}/${commentDTO.commentDate.month + 1}/${commentDTO.commentDate.year + 1900}<br>
                                ${commentDTO.content}
                            </div>
                        </c:forEach>
                    </c:if>
                    <c:if test="${sessionScope.ROLE.roleName eq 'member'}">
                        <form action="MainController" method="POST" class="form-signin mt-5">
                            <textarea type="text" name="txtComment" class="mb-3 form-control"></textarea>
                            <font color="red"><p class="mb-3">${requestScope.INVALID}</p></font>
                            <input type="hidden" name="articleID" value="${requestScope.ARTICLE_DETAILS.articleID}"/>
                            <button type="submit" name="action" value="Comment" class="btn btn-block btn-primary btn-lg mb-3">Comment</button>
                        </form>
                    </c:if>
                    <c:if test="${sessionScope.ROLE.roleName eq 'admin'}">
                        <c:url var="approvalLink" value="MainController">
                            <c:param name="action" value="AdminApprovalArticle"/>
                            <c:param name="articleID" value="${requestScope.ARTICLE_DETAILS.articleID}" />
                        </c:url>
                        <c:url var="deleteLink" value="MainController">
                            <c:param name="action" value="AdminDeleteArticle"/>
                            <c:param name="articleID" value="${requestScope.ARTICLE_DETAILS.articleID}" />
                        </c:url>
                        <c:if test="${requestScope.ARTICLE_DETAILS.statusID == 1}">
                            <a href="${approvalLink}"><p class="btn btn-block btn-dark" style="width: 100px;">Accept</p></a>
                        </c:if>
                        <c:if test="${requestScope.ARTICLE_DETAILS.statusID != 3}">
                            <a href="${deleteLink}"><p class="btn btn-block btn-warning" style="width: 100px;">Delete</p></a>
                        </c:if>
                    </c:if>
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
        <%@include file="footer.jsp" %>
    </body>
</html>
