Jersey-HelloJersey
------------
mvn exec:java

Service Urls
-----------
- GET http://localhost:9999/myapp/myresource/123  
  return a string "hello123" 
- POST http://localhost:9999/myapp/myresource/hello  
  using post body {"id":123,"name":"user name"} then will echo back as json