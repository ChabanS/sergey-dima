<%-- 
    Document   : menu
    Created on : Jan 19, 2017, 8:48:21 PM
    Author     : Sergey
--%>

<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="label.menu" /></title>
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
        <div align="center" class="container">
            </br>
            <div class="row">
                </br>
                <div class="col-lg-2 col-lg-offset-2" >
                    <a href="#" class="btn btn-sq-lg btn-primary btn-block">
                        </br>
                        <i class="fa fa-plus-square fa-5x"></i><br/>
                        </br>
                        <spring:message code="label.add"/>
                    </a>
                </div>
                <div class="col-lg-2 col-lg-offset-1">
                    <a href="#" class="btn btn-sq-lg btn-primary btn-block">
                        </br>
                        <i class="fa fa-pencil-square fa-5x"></i><br/>
                        </br>
                        <spring:message code="label.change"/>
                    </a>
                </div>
                <div class="col-lg-2 col-lg-offset-1">
                    <a href="#" class="btn btn-sq-lg btn-primary btn-block">
                        </br>
                        <i class="fa fa-minus-square fa-5x"></i><br/>
                        </br>
                        <spring:message code="label.delete"/>
                    </a>
                </div> 
            </div>
            <div class="row">
                </br>
                </br>
                <div  class="col-lg-2 col-lg-offset-2" >
                    <a href="#" class="btn btn-sq-lg btn-primary btn-block">
                        </br>
                        <i class="fa fa-cutlery fa-5x"></i><br/>
                        </br>
                        <spring:message code="label.kitchen"/>
                    </a>
                </div>
                <div class="col-lg-2 col-lg-offset-1">
                    <a href="#" class="btn btn-sq-lg btn-primary btn-block">
                        </br>
                        <i class="fa fa-car fa-5x"></i><br/>
                        </br>
                        <spring:message code="label.car"/>
                    </a>
                </div>
                <div class="col-lg-2 col-lg-offset-1">
                    <a href="#" class="btn btn-sq-lg btn-primary btn-block">
                        </br>
                        <i class="fa fa-file-text fa-5x"></i><br/>
                        </br>
                        <spring:message code="label.text"/>
                    </a>
                </div> 
            </div>
            <div class="row">
                </br>
                </br>
                <div class="col-lg-2 col-lg-offset-2">
                    <!--                    <a href="#" class="btn btn-sq-lg btn-primary btn-block">
                                            <i class="fa fa-user fa-5x"></i><br/>
                                            Demo Primary <br>Button
                                        </a>-->
                </div>
                <div class="col-lg-2 col-lg-offset-1">
                    <a href="#" class="btn btn-sq-lg btn-primary btn-block">
                        </br>
                        <i class="fa fa-cogs fa-5x"></i><br/>
                        </br>
                        <spring:message code="label.settings"/>
                    </a>
                </div>
                <div class="col-lg-2 col-lg-offset-1">
                    <!--                    <a href="#" class="btn btn-sq-lg btn-primary btn-block">
                                            <i class="fa fa-user fa-5x"></i><br/>
                                            Demo Primary <br>Button
                                        </a>-->
                </div> 
            </div>
        </div>
    </body>
</html>
