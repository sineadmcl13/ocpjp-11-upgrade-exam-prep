import java.util.function.DoubleUnaryOperator;
import java.util.function.UnaryOperator;

public class UnaryOperatorInterfaceExamples {

  public static void main(String [] args){
    UnaryOperator<String> u1 = String::toUpperCase;
    System.out.println(u1.apply("Hello World"));

    DoubleUnaryOperator u2 = (d) -> { return d * d; };
    System.out.println(u2.applyAsDouble(100));
  }

}
