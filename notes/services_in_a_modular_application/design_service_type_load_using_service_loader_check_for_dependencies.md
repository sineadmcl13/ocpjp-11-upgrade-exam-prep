### Design a service type, load the services using ServiceLoader, check for dependencies of the services including consumer module and provider module

#### Designing services
A service is a single type, usually an interface or abstract class. The type may have any accessibility. The API
 specification gives 2 general guidelines for design
 
 - A service should declare as many methods as needed to allow service providers to communicate their domain-specific
 properties and other quality-of-implementation factors. 
 An application which obtains a service loader for the service may then invoke these methods on each instance of a
 service provider, in order to choose the best provider for the application 
- A service should express whether its service providers are intended to be direct implementations of the service or to
 be an indirection mechanism such as a "proxy" or a "factory". 
 Service providers tend to be indirection mechanisms when domain-specific objects are relatively expensive to
 instantiate; in this case, the service should be designed so that service providers are abstractions which create 
 "real" implementation on demand.
 
#### Developing service providers
A service provider is a single type, usually a concrete class. An interface or abstract class is permitted because it 
may declare a `static provider()` method. The type must be `public` and must not be an inner class.

An application that obtains a service loader for a given service is indifferent to whether providers of the service 
are deployed in modules or packages as JAR files. The application instantiates service providers via the service 
loader's iterator, or via `Provider` objects in the service loader's stream, without knowledge of the service 
provider's location

#### Deploying service providers as modules 
A service provider that is developed in a module must be specified in a `provides` directive in the module declaration. 
The `provides` directive specifies both the service and the service provider; this helps to locate the provider when
 another module with a `uses` directive obtains a service loader for the service. 
 
A service provider that is developed in a module has no control over when it is instantiated, but it does have control 
over how it is instantiated:

 - If the service provider declares a `provider()` method, then the service loader invokes that method to obtain an
  instance of the service provider.  A provider constructor is a public constructor with no formal parameters.
  
    In this case, the service provider itself NEED NOT be assignable to the service's interface or class
  
 - If the service provider does not declare a `provider()` method, then the service provider is instantiated directly, 
   via its provider constructor. A provider constructor is a public constructor with no formal parameters.
   
   In this case, the service provider MUST be assignable to the service's interface or class.
   
>  A service provider that is deployed as an automatic module on the application module path must have a provider constructor. 
> There is no support for a `provider()` method in this case.  

####  Dependencies of Service modules 

Running the following command will list the dependencies of the service modules
```shell script
jar --describe-module --file=module.jar
```
| [Previous](describe_the_components_of_services_including_directives.md) | [Next](../java_interfaces) |
| :--------- | ----------: | 
