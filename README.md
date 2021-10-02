# mortage-app
A Java application to calculate mortage

This is a spring boot application which is created for a customer as well as for Money Bin inc to generate the report for all its customer by file as well as 
from the database.

Steps to compile & Package.
1. Once you clone the repo locally.
2.  mvn clean package
3.  To run the spring boot app <b>mvn spring-boot:run</b>

There are some end point is exposed to use
GET request localhost:8080/mortageCalculate/customer?
with some requestparams
customerName
totalloan
interest
years

Get request localhost:8080/mortageCalculate/getAll (This will fetch the the map object for all the data from Prospects table in database and respective emi for customers.


There is a file which will read the file prospects.txt from resource folder and generate the desired out for Money bin CEO.

<b>com.moneybin.mortageapp.GenerateReport.java </b>

To generate report
<b>./generate-output-with-emi.sh</b>
