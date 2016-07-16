# HelloJersey
It's a RESTful Web Service project developed using:
<i>
<br>- Java
<br>- Jersey
<br>- Spring
<br>- Hibernate
<br>- Jettison
<br>- JUnit
<br>- Maven
<br>- MySQL
<br>- Tomcat
</i>

To test, you can run the tests or use Postman (Chrome Extension), that should produce and consume JSON:
<br>
<br><b>GET:</b>
<i>
<br>- http://localhost:8080/HelloJersey/rest/products/
<br>- http://localhost:8080/HelloJersey/rest/products/{id}
</i>

<br><b>POST/PUT:</b>
<i>
<br>- http://localhost:8080/HelloJersey/rest/products/
</i>

<br>Example:
<i>
<br>{
<br>&emsp;"product": {
<br>&emsp;&emsp;"id": 1,
<br>&emsp;&emsp;"name": "TV"
<br>&emsp;}
<br>}
</i>

<br><b>DELETE:</b>
<i>
<br>- http://localhost:8080/HelloJersey/rest/products/{id}
</i>
