# Actuator Demo Project
Interacting with Spring Cloud Actuator API.

### API Endpoints:
#### General:
* `curl localhost:8080/actuator` - Get all enabled API endpoints.
* `curl http://localhost:8080/actuator/info` - Get general info about the application(contact details of developer).
* `curl http://localhost:8080/actuator/health` - Get the health of the app and of the app dependants

#### Configuration
* `curl http://localhost:8080/actuator/env` - Get the env variables, app config, config server config, etc.
* `curl http://localhost:8080/actuator/conditions` - Get all conditions of auto-configuration.
* `curl http://localhost:8080/actuator/beans` - Get all beans.
* `curl http://localhost:8080/actuator/mappings` - Get all mappings from endpoints to "action methods". 
* `curl http://localhost:8080/actuator/loggers` - Get all loggers, logger levels & associated packages.

#### Troubleshooting
* `curl http://localhost:8080/actuator/heapdump` - Get a Dump of the heap memory.
* `curl http://localhost:8080/actuator/threaddump` - Get a Dump of the thread info.
* `curl http://localhost:8080/actuator/httptrace` - Get a trace of the last 100 api requests. Includes:
  - request method
  - request path
  - timestamp
  - request headers
  - response headers
  - time taken to handle request