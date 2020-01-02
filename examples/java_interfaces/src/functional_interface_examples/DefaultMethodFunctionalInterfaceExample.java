package functional_interface_examples;

@FunctionalInterface
public interface DefaultMethodFunctionalInterfaceExample {

  boolean isActonCompleted();

  default void abortAction(){
    System.out.println("Calling from the default method in a functional interface");
  }

}
