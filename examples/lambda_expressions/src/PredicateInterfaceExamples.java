import java.util.function.BiPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

public class PredicateInterfaceExamples {

  public static void main(String[] args){
    Predicate<String> p1 = s -> s.length() > 10;
    System.out.println(p1.test("Hello World"));

    BiPredicate<String, String> p2 = (s1, s2) -> s1.length() > s2.length();
    System.out.println(p2.test("Hello", "World"));

    LongPredicate p3 = l -> l > 100;
    System.out.println(p3.test(200L));
  }
}
