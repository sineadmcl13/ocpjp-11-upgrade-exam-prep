package functional_interface_examples;

public class FunctionalInterfaceUsageExamples {

  public static void main(String[] args) {
    //using lambda as functional interface implementation
    callActionOnFunctionalInterface(() -> true);

    DefaultMethodFunctionalInterfaceExample dInterfaceEx = () -> false;
    callActionCompletedOnInterface(dInterfaceEx.isActonCompleted());

    //calling default method of functional interface we didnt override or implement
    dInterfaceEx.abortAction();

    StaticMethodFunctionalInterfaceExample sInterfaceExample = () -> false;
    callActionCompletedOnInterface(sInterfaceExample.isActonCompleted());
    StaticMethodFunctionalInterfaceExample.abortAction();

    FunctionalInterfaceWithJavaLangObjectMethods fInterfaceExample = () -> false;
    callActionCompletedOnInterface(fInterfaceExample.isActionCompleted());
    System.out.println(fInterfaceExample.equals((FunctionalInterfaceWithJavaLangObjectMethods) () -> false));

  }

  public static void callActionOnFunctionalInterface(FunctionalInterfaceExample fInterfaceEx){
    callActionCompletedOnInterface(fInterfaceEx.isActionCompleted());
  }

  private static void callActionCompletedOnInterface(boolean isActionCompleted){
    System.out.println("Result of calling functional interface isActionCompletedMethod = " + isActionCompleted);
  }

}
