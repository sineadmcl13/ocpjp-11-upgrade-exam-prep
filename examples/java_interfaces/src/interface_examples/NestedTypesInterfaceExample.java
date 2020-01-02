package interface_examples;

public interface NestedTypesInterfaceExample {

  void action();

  interface nestedActionInterface {
    String NESTED_INTERFACE_CONSTANT = "calling from nested interface";
    void doNestedAction();
  }

}
