package interface_examples;

public interface PrivateStaticMethodInterfaceExample {

  default void logActionDetails(){
    System.out.println(actionLogDetails());
  }

  private static String actionLogDetails(){
   return "called private static method of interface";
  }

}
