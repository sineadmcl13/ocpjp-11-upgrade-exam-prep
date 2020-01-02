package interface_examples;

public class InterfaceUsageExample {

  public static void main(String[] args){

    //interface constant variable usage
    System.out.println(ConstantVariableInterfaceExample.GREETING);

    //default method of interface usage
    DefaultMethodInterfaceExample dfInterface = new DefaultMethodInterfaceExample() {
      // not overriding or implementing deleteAction()
    };
    dfInterface.deleteAction();

    //nested interface usage
    System.out.println(NestedTypesInterfaceExample.nestedActionInterface.NESTED_INTERFACE_CONSTANT);

    //interface with static method example
    StaticMethodInterfaceExample.logAction();

    //interface with private method example
    PrivateMethodInterfaceExample pmInterface = new PrivateMethodInterfaceExample() {
      @Override
      public void action() {
        System.out.println("Implementing action() of interface");
      }
    };
    pmInterface.action();
    pmInterface.reverseAction(); //method calls private method logReverseAction()
    //uncomment following line to check you cannot access the private method of interface_examples.PrivateMethodInterfaceExample
    // pmInterface.logReverseAction();

    // interface with private static example
    PrivateStaticMethodInterfaceExample pmsInterface = new PrivateStaticMethodInterfaceExample() {};
    pmsInterface.logActionDetails(); //method calls private static method actionLogDetails()
    //uncomment following line to check you cannot access the private method of interface_examples.PrivateStaticMethodInterfaceExample
    //pmsInterface.actionLogDetails();

  }

}
