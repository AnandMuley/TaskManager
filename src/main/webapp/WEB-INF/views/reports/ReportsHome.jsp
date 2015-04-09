<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <%@ include file="../Include.jsp"%>
    <title>Task Home</title>
    <script type="application/javascript">
        $(document).ready(function(){

            $('#date-picker').datepicker({
                todayBtn: "linked",
                todayHighlight: true,
                format: "dd-M-yyyy",
                autoclose: true
            }).on('changeDate',function(e){
//                var dateSel = e.format('dd-M-yyyy');
//                var taskDate = dateSel;
//                if(undefined!=dateSel){
//                    location.href  = "datedtasks?clientDate="+dateSel;
//                    //console.log('Selected : '+ dateSel);
//                    //$('#queue-date').html(dateSel);
//                    //$('#taskDate').val(taskDate);
//                }

            });

        });
    </script>
</head>
<body>
<%@include file="../Navigation.jsp"%>
<div class="table">
    <div class="table-row">

        <div align="center" class="table-cell date-picker-container">
            <h2>Select date range</h2>
            <form method="post" action="generate">
            <div  id="date-picker" class="input-daterange input-group">
                <input type="text" class="input-sm form-control" name="startDate" />
                <span class="input-group-addon">to</span>
                <input type="text" class="input-sm form-control" name="endDate" />
            </div>
            <div class="save-btn">
                <button type="submit" class="btn btn-lg btn-success" href="#" role="button">Generate Report</button>
            </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>