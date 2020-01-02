package interface_examples;

public interface PrivateMethodInterfaceExample {

  void action();

  default void reverseAction(){
    logReverseAction();
  }

  private void logReverseAction(){
    System.out.println("Logging out action when default method called");
  }

}
