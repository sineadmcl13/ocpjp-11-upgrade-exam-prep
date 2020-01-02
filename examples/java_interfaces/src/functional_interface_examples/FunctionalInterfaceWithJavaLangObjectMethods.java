package functional_interface_examples;

@FunctionalInterface
public interface FunctionalInterfaceWithJavaLangObjectMethods {

  boolean isActionCompleted();

  boolean equals(Object var1); // ignored as its a public method from java.lang.Object

}
