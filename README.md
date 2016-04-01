Jersey-HelloJersey
------------
**start server**
mvn exec:java

**running test**
Junit test class: org.oursight.jersey.hello.MyResourceTest
(not need to start the sever, it will be started in junit setup()

Service Urls
-----------
- GET http://localhost:9999/myapp/myresource/a-username-as-paramter  
  return a json object represented by java bean org.oursight.jersey.hello.Hello
- POST http://localhost:9999/myapp/myresource/hello  
  using post body {"id":123,"name":"user name"} then will echo back as json
  