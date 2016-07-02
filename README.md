# HelloJersey
It's a RESTful Web Service project developed using:
<br><i>- Java</i>
<br><i>- Jersey</i>
<br><i>- Spring</i>
<br><i>- Hibernate</i>
<br><i>- Maven</i>
<br><i>- Tomcat/WebLogic</i>
<br><i>- MySQL</i>

To test, you can use Postman, that should produce and consume JSON:
<br>
<br><b>GET:</b>
<br><i>- http://localhost:8080/HelloJersey/rest/products/</i>
<br><i>- http://localhost:8080/HelloJersey/rest/products/{id}</i>

<br><b>POST/PUT:</b>
<br><i>- http://localhost:8080/HelloJersey/rest/products/</i>

<br><i>Example:</i>
<br>{
<br>&emsp;"product": {
<br>&emsp;&emsp;"id": 1,
<br>&emsp;&emsp;"name": "TV"
<br>&emsp;}
<br>}

<br><b>DELETE:</b>
<br><i>- http://localhost:8080/HelloJersey/rest/products/{id}</i>