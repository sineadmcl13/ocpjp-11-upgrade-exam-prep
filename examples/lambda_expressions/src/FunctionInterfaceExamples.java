import java.util.function.BiFunction;
import java.util.function.DoubleFunction;
import java.util.function.Function;

public class FunctionInterfaceExamples {

  public static void main(String[] args){
    Function<String, Integer> f1 = (s) -> s.length();
    System.out.println(f1.apply("Hello World"));

    BiFunction<String, String, Integer> f2 = (s1, s2) -> s1.concat(s2).length();
    System.out.println(f2.apply("Hello", "World"));

    DoubleFunction<Double> f3 = (d) -> d * 100;
    System.out.println(f3.apply(100.50));
  }
}
