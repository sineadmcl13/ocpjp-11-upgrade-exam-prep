package interface_examples;

public interface StaticMethodInterfaceExample {
  void action();

  static void logAction(){
    System.out.println("Logging out from interface static method");
  }

}
