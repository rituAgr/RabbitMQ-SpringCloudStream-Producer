##Spring Cloud Stream Application - Message-Producer

###Inorder to locally do the following - 

1. Run ```docker run -d --hostname local-rabbit --name demo-rmq -p 15672:15672 -p 5672:5672 rabbitmq:3.6.11-management```
2. Then start the application.
3. Hit the endpoint - 
```
POST http://localhost:8081
   Content-Type: application/json
   
   {
     "id" : "123",
     "msg" : "Ritu"
   }
   ```


###Inorder to run the application over pcf
1. Create rabbit-test instance at pcf.
2. ```gradle clean build```
3. ```cf push``` This will take the manifest file at home directory of application and deploy application at PCF.
4. Hit the endpoint as follows. But the url might be needed to be changed as it is random route.
```$xslt
POST https://rabbit-producer.cfaa.hcsctest.net/
Content-Type: application/json

{
  "id" : "123",
  "msg" : "Ritu"
}
```

###Note:

1. All properties for pcf are binded by vcap.service, but the port because it was unable to convert String to Int over pcf.
2. For looking at consumer side look for ```RabbitMQ-SpringCloudStream-Consumer``` repo.

 
