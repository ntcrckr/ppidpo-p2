# HW 02
Client-server currency rate provider

To start run the following gradle configs:
```
client-server -> eureka -> application -> bootRun
client-server -> discovery -> application -> bootRun
client-server -> server -> application -> bootRun
client-server -> client -> application -> bootRun
```

To test discovery service make request:
```
GET http://localhost:8000/currencyRate
```
