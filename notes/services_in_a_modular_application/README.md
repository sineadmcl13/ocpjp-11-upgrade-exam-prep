### Services in a Modular Application

Java supported service-provider loading facility via the `java.util.ServiceLoader` class. Using the Service Loader 
you could have a service provider interface (SPI) simply called Service, and multiple implementations of the SPI 
simply called Service Providers. 
These Service Providers in Java 8 and earlier are located in the classpath and loaded at run time.

#### Java 9 Services
With Java 9 comes a new concept called `services`. 
You can develop Services and Service Providers as modules. 
A service module declares that it uses one or more interfaces whose implementations will be provided at run time by 
some provider modules. 

A provider module declares what implementations of service interfaces it provides. 
The module that discovers and loads service providers must contain a `uses` directive in its declaration. 

[ServiceLoader javadoc](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/ServiceLoader.html)