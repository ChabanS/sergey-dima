<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf8">
        <title><spring:message code="label.title" /></title>
        <!--        CSS, JS         -->
        <spring:url value="resources/css/bootstrap.min.css" var="bootstrapCss" />
        <link href="${bootstrapCss}" rel="stylesheet">
        <spring:url value="resources/css/main.css" var="maincss" />
        <link href="${maincss}" rel="stylesheet">
        <spring:url value="resources/css/bootstrap-datetimepicker.min.css" var="bootstrapdatetimepicker" />
        <link href="${bootstrapdatetimepicker}" rel="stylesheet"/>
        <spring:url value="resources/css/font-awesome.min.css" var="fontawesome" />
        <link href="${fontawesome}" rel="stylesheet" />
        <spring:url value="resources/js/jquery-1.11.1.min.js" var="jquery" />
        <script type="text/javascript" src="${jquery}"></script>
        <spring:url value="resources/js/moment-with-locales.min.js" var="momentwithlocales" />
        <script type="text/javascript" src="${momentwithlocales}"></script>
        <spring:url value="resources/js/bootstrap-datetimepicker.min.js" var="bootstrapdatetimepicker" />
        <script type="text/javascript" src="${bootstrapdatetimepicker}"></script>
        <spring:url value="resources/js/bootstrap.min.js" var="bootstrapjs" />       
        <script src="${bootstrapjs}"></script>
    </head>
    <body>

        </br>
        </br>
        </br>
        </br>
        </br>
        </br>
        <form method="post" action="<c:url value="/register" />">
            <div class="container">
                <div class="row">
                    <div class="col-md-4 col-md-offset-4">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <c:if test="${not empty param.error}">
                                    <font color="red"> <spring:message code="label.loginerror" />
                                        : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message} </font>
                                    </c:if> 
                                <h3 class="panel-title">Registration users</h3>
                            </div>
                            <div class="panel-body">
                                <fieldset>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="<spring:message code="label.login" />" name="username" type="text">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Name" name="name" type="text">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="<spring:message code="label.password" />" name="password" type="password" value="">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Position" name="position" type="text" value="">
                                    </div>

                                    <div class="col-md-6">
                                        <input class="btn btn-lg btn-success btn-block" type="submit" value="Registration">
                                    </div>
                                    <div class="col-md-6">
                                        <a class="btn btn-lg btn-danger btn-block" href=index >Cancel</a>
                                    </div>
                                </fieldset>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>