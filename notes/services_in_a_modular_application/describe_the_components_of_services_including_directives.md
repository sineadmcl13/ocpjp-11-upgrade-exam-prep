### Describe the components of Services including directives

A service consists of 2 major parts:
 - A service interface
 - 1 or more service implementations
 
The service interface is typically located in a service interface java module. This generally only contains the 
service interface plus any classes and interface related to the service interface.
  
The service implementations are provided by separate java modules. 

#### Service Interface Module
Java service interface modules do not require a special declaration of the service interface. 
You just create a regular Java module and export the java package that contains the service interface

```java
module services_interface.module {
  exports com.example.serviceInterface;
}
```
The service interface is just a normal java interface

#### Service Implementation Module
A java module that wants to implement a service interface from a service interface module must:
 - Require the service interface module
 - Implement the service interface with a java class
 - Declare the service interface implementation in its module descriptor
 
A service provider will use "provides ... with ..." directive to declare what service interface it intends to use 
(by using `provides` keyword) and what implementation of the interface it wants to expose (by using `with` keyword).
 
 ```java
module service_interface_impl.module {
  requires services_interface.module;
  
  provides com.example.service.jinterface with
    com.example.service.interfaceImpl;
}
```

The module descriptor in the example declares that it requires the service interface module 
(`services_interface.module`). 

It also declares that is provides an implementation for the service interface 
`com.example.service.anInterface` with `com.example.service.interfaceImpl`

#### Service Client Module
A service client module or also known as a service consumer module or service user module is a module that uses a 
service specified in the an external module and implemented by yet another external module

In order to use the service, the client module must declare that it `uses` the service.

```java
module com.client.serviceClient {
  requires services_interface.module;
  
  uses com.example.service.anInterface;
}
``` 

The service module descriptor declares that is requires `services_interface.module` which contains the service 
interface.
It does not need to require the service implementation modules as they are looked up at runtime. 
Only the service interface module is required.

Within the service module, an implementation of the service interface can be looked up at runtime using

```java
Iterable<anInterface> services = ServiceLoader.load(anInterface.class);
```

[Code Examples for Service modules](/examples/services_in_a_modular_application)

| [Previous](README.md) | [Next](design_service_type_load_using_service_loader_check_for_dependencies.md) |
| :--------- | ----------: | 