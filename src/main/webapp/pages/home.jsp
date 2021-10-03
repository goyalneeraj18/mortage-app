<%--
  Created by IntelliJ IDEA.
  User: neeraj
  Date: 2.10.2021
  Time: 11.22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mortage Calculator</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>

<body>
<h1> Mortage Calculator </h1>
<form method="get" name="show-mortage-form">
    <table>
        <tr>
            <td>Customer Name : </td>
            <td><input type="text" id = "customerName" name="customerName" placeholder="Type you name, we are not going to store it in our system"  required /></td>
        </tr>
        <tr>
            <td>Principle</td>
            <td><input type="number" id="totalloan" name="totalloan" placeholder="Type principle amount" required /></td>
        </tr>
        <tr>
            <td>Yearly interest rate : </td>
            <td><input type="text" id="interest" name="interest" placeholder="Type interest rate" required /></td>
        </tr>
        <tr>
            <td>Number of years to repay</td>
            <td><input type="number" id="years" name="years" placeholder="Number of years to repay" required /></td>
        </tr>
        <tr>
            <td><input type="button" value="Calculate" id="submit" /></td>
            <td><input type="reset" value="Clear" /></td>
        </tr>
    </table>
</form>
<div id="result-div"></div>
</body>
<script type="text/javascript" >
    $(document).ready(function(){
        var val = "";
        $("#submit").click(function(event) {
            event.preventDefault();
            var customerName = $('#customerName').val();
            var totalloan = $('#totalloan').val();
            var interest = $('#interest').val();
            var years = $('#years').val();
            $.ajax({
                type: "GET",
                data: {customerName : customerName, totalloan : totalloan, interest : interest, years : years},
                url: "http://localhost:8080/mortageCalculate/customer",
                success : function (emi) {
                    $('#result-div').text(customerName + ", Your monthly EMI will be " + emi + " €");
                },
                error : function (jqXHR, textStatus, errorThrown) {
                    console.log(' Error in processing! '+textStatus);
                }
            });
        });
    });
</script>
</html>
