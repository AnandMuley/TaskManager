/**
 * Created by Anand Muley on 22/01/15.
 */


$('document').ready(function(){

    $('#startTaskBtn').click(function(){
        setInterval(fnStartTimer,1000);
    });

});

function fnStartTimer(){
    $('#timerPanel').html('1 mins');
}