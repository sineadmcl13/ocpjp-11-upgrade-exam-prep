package service_client_module.com.sineadmcl.client;

import service_interface_example.com.sineadmcl.service.GreetingInterface;

import java.util.Optional;
import java.util.ServiceLoader;

public class example {

  public static void main(String[] args) throws Exception {
    Optional<GreetingInterface> optionalGreeter = ServiceLoader.load(GreetingInterface.class).findFirst();
    GreetingInterface greeter = optionalGreeter.orElseThrow(() -> new Exception("No service provider found"));
    System.out.println(greeter.sayHello());
  }
}