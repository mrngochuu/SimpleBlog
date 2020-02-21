<%-- 
    Document   : confirmation
    Created on : Jan 14, 2020, 4:53:58 PM
    Author     : ngochuu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <title>Confirmation Page</title>
    </head>
    <body>
        <div class="container-fluid"> 
            <div class="row">
                <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
                    <div class="card card-signin my-5">
                        <div class="card-body">
                            <h2>Hello ${param.txtFullname}, </h2>
                            <p>A code send your email. Please enter code to complete registration!</p>
                            <form action="MainController" method="POST" class="form-signin">
                                Code: <input type="text" name="txtCode" class="mb-3"/>
                                <font color="red"><p class="mb-3">${requestScope.INVALID}</p></font>
                                <input type="hidden" name="txtEmail" value="${param.txtEmail}"/>
                                <input type="hidden" name="txtFullname" value="${param.txtFullname}"/>
                                <input type="submit" name="action" value="Confirm" class="btn btn-lg btn-primary btn-block text-uppercase mb-3">
                            </form>
                            <hr class="m3-b">
                            <div class="mb-3">
                                <c:url var="homeLink" value="MainController">
                                    <c:param name="action" value="SearchArticle"/>
                                </c:url>
                                <a href="${homeLink}">Home Page</a>
                            </div>
                            <div class="mb-3">
                                <c:url var="resendLink" value="MainController">
                                    <c:param name="action" value="SendingCode"/>
                                    <c:param name="txtEmail" value="${param.txtEmail}"/>
                                    <c:param name="txtFullname" value="${param.txtFullname}" />
                                </c:url>
                                <a href="${resendLink}">Resend code</a>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
