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
    <title>Title</title>
</head>
<body>
<form action="showMortage" method="get" name="show-mortage-form">
    <table>
        <tr>
            <td>Customer Name : </td>
            <td><input type="text" name="customerName" placeholder="Type you name" required /></td>
        </tr>
        <tr>
            <td>Principle</td>
            <td><input type="number" name="totalloan" placeholder="Type principle amount" required /></td>
        </tr>
        <tr>
            <td>Yearly interest rate : </td>
            <td><input type="text"  name="interest" placeholder="Type interest rate" required /></td>
        </tr>
        <tr>
            <td>Number of years to repay</td>
            <td><input type="number" name="years" placeholder="Numfer of years to repay" required /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Calculate" /></td>
            <td><input type="reset" value="Clear" /></td>
        </tr>
    </table>
</form>
<h1>EMI is ${emi}.</h1>
</body>
<script type="application/javascript" >

</script>
</html>
