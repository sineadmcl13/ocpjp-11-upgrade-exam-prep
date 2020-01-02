package functional_interface_examples;

@FunctionalInterface
public interface StaticMethodFunctionalInterfaceExample {

  boolean isActonCompleted();

  static void abortAction(){
    System.out.println("Calling from the static method in a functional interface");
  }

}
