<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <%@ include file="../Include.jsp"%>
    <title>Live Tasks</title>
</head>
<body>
<%@include file="../Navigation.jsp"%>
<div align="center">
    <h2>Live Tasks Home</h2>
    <script type="application/javascript" src="${pageContext.request.contextPath}/resources/js/LiveTask.js"></script>
</div>
<div class="row">
    <div class="col-lg-3">
        <div class="thumbnail">
            <div align="center" class="caption">
                <h3>Prodcat Issue</h3>
                <div class="row">
                    <div id="startTimePanel" class="col-lg-12">Start Time : 01:44 PM</div>
                </div>
                <div class="row">
                    <div id="endTimePsanel">End Time : 02:00 PM</div>
                </div>
                    <div class="row" align="center">
                        <div id="timerPanel" class="col-lg-1">0</div>
                        <div class="col-lg-3">mins</div>
                    </div>
                <p>
                    <div id="taskStatus">Active</div>
                </p>
                <p>
                    <a id="startTaskBtn" href="#" class="btn btn-primary" role="button">Start</a>
                    <a href="#" class="btn btn-default" role="button">Stop</a>
                </p>
            </div>
        </div>
    </div>
</div>

</body>
</html>