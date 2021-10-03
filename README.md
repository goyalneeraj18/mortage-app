# mortage-app
A Java application to calculate mortage

This is a spring boot application which is created for a customer as well as for Money Bin inc to generate the report for all its customer by file as well as 
from the database.

<h2>Steps to compile & Package </h2>
1. Once you clone the repo locally.
2. mvn clean package
3.  To run the spring boot app <b>mvn spring-boot:run</b>

Once the spring boot application is started, There is a Runner file <i>GenerateReportOnSpringBootStartup.java</i> which will start run with input file prospects.txt which is present in resource/static folder and generate output.txt similar lines for all customers

"CustomerName wants to borrow X € for a period of Z years and pay E € each month"



<h2>Spring Boot REST End point details</h2>

<ol>
  <li>
http://localhost:8080/mortageCalculate/customer?            GET          customerName , totalloan , interest , years
  </li>
  <li>
    http://localhost:8080/mortageCalculate/customers         GET   
    This will read all the data from prospects table from database and will result like this
    [
    "Juha wants to borrow 1000.0 € for a period of 2 years and pay 44 € each month",
    "Karvinen wants to borrow 4356.0 € for a period of 6 years and pay 63 € each month",
    "Claes Månsson wants to borrow 1300.55 € for a period of 2 years and pay 59 € each month",
    "Clarencé,Andersson wants to borrow 2000.0 € for a period of 4 years and pay 47 € each month"
]
  </li>
  </ol>
 
 <h2>>Database Details </h2>
 Currently i have configured the h2 in memory database used for actual DB connection. It can be changed according to your local database.
