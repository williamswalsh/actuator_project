# Actuator API demonstration project
Interacting with Spring Cloud Actuator API.

### API Endpoints:
#### General:
- `curl localhost:9001/actuator` - Get all enabled API endpoints.
- `curl http://localhost:9001/actuator/startup`
  - Get details on startup time.
  - Useful when you need to find what is causing a longer startup time.
- `curl -X POST http://localhost:9001/actuator/shutdown`
  - This will stop the running spring boot app.
  - For this endpoint to be enabled you must enable this flag: `management.endpoint.shutdown.enabled`
- `curl http://localhost:9001/actuator/info` - Get general info about the application(contact details of developer).
- `curl http://localhost:9001/actuator/health` - Get the health of the app and of the app dependants. \
 Can get very details information on all dependents(Mongo, Cassandra, Config Server, Eureka, Hystrix, JDBC, JMS, etc.) \
 Can also set flag to show more details in response - **management.endpoint.health.show-details** flag \
 Response State can be:
  - UP
  - DOWN
  - UNKNOWN - Status of external system is unclear
  - OUT_OF_SERVICE - external system is reachable but unavailable

#### Configuration
- `curl http://localhost:9001/actuator/env`
  - Gets the env variables, app config, config server config, etc.
  - Using the POST verb you can change configuration in the memory of this application instance that receives the request. This config will be lost after a restart.
    ```shell
    curl http://localhost:9001/actuator/env \
         -d '{"name": "my.config.item", "value": "top_secret_value"}' \
         -H "Content-type: application/json" 
    ```
  - Using the DELETE verb, you can remove properties "created from that endpoint".
    ```shell
    curl http://localhost:9001/actuator/env \
         -X DELETE
    ```
- `curl http://localhost:9001/actuator/conditions` - Get all conditions of auto-configuration.
- `curl http://localhost:9001/actuator/beans` - Get all beans.
- `curl http://localhost:9001/actuator/mappings` - Get all mappings from endpoints to "action methods". 
- `curl http://localhost:9001/actuator/loggers`
  - Gets all loggers, logger levels & associated packages.
  - Displays the effectiveLevel of the logger. This level can be inherited from the parent package
  - You can update the logging level for the package tacos.ingredients, without a restart by executing the POST request:
    ```shell
    curl http://localhost:9001/actuator/loggers/tacos/ingredients \
         -d '{"configuredLevel": "DEBUG"}' \
         -H "Content-type: application/json"  
    ```

#### Troubleshooting
- `curl http://localhost:9001/actuator/heapdump` - Get a dump of the heap memory.
- `curl http://localhost:9001/actuator/threaddump` - Get a dump of the thread info.
- `curl http://localhost:9001/actuator/httptrace`
  - Get a trace of the last 100 api requests. This includes:
    - request method
    - request path
    - timestamp
    - request headers
    - response headers
    - time taken to handle request

#### Metrics
- `curl http://localhost:9001/actuator/metrics`
  - Gets a list of all available metric categories. There are a lot.
- `curl http://localhost:9001/actuator/metrics/http.server.requests`
  - Gets the metrics relating to the "http.server.requests" category
- ```shell 
  curl "http://localhost:9001/actuator/metrics/<CATEGORY>          ?tag=<TAG> :<TAG_VALUE>&tag=<TAG> :<TAG_VALUE>"
  curl "http://localhost:9001/actuator/metrics/http.server.requests?tag=method:GET        &tag=uri   :/car"
  ```
  - Gets the metrics for GET method calls to /** URI in the "http.server.requests" category.

    