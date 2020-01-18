import java.util.function.LongSupplier;
import java.util.function.Supplier;

public class SupplierInterfaceExamples {

  public static void main(String [] args){
    Supplier<String> s1 = () -> "Hello World";
    System.out.println(s1.get());

    LongSupplier s2 = () -> { return 10L; };
    System.out.println(s2.getAsLong());
  }

}
