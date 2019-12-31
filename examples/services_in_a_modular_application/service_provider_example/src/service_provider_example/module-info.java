module service_provider_example {
  requires service_interface_example;

  provides service_interface_example.com.sineadmcl.service.GreetingInterface
      with service_provider_example.com.sineadmcl.provider.example.GreetingImpl;
}