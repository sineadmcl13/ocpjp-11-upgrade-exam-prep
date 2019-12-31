package service_provider_example.com.sineadmcl.provider.example;

import service_interface_example.com.sineadmcl.service.GreetingInterface;

public class GreetingImpl implements GreetingInterface {

  @Override
  public String sayHello() {
    return "Hello";
  }
}
