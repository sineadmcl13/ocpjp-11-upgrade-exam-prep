#### Example service interface, provider and client modules

To build the modules and run example:
- Commands listed below are based on the assumption you are in the `examples/services_in_a_modular_application
` directory

compile service code
```shell script
javac --module-source-path service_interface_example/src -d compiled-modules -m service_interface_example
```
---
compile provider code
```shell script
javac --module-path compiled-modules --module-source-path service_provider_example/src -d compiled-modules -m service_provider_example
```
---

compile client code
```shell script
javac --module-path compiled-modules --module-source-path service_client_module/src -d compiled-modules -m service_client_module
```
---

run the client code
```shell script
java --module-path compiled-modules -m service_client_module/service_client_module.com.sineadmcl.client.example
```

Output :
```shell script
Hello
```