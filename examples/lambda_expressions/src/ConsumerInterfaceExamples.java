import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class ConsumerInterfaceExamples {

  public static void main(String[] args){
    Consumer<String> c1 = (c) -> System.out.println(c);
    c1.accept("Hello World");

    BiConsumer<String, String> c2 = (s1, s2) -> System.out.println(s1.concat(s2));
    c2.accept("Hello", "World");

    IntConsumer c3 = System.out::println;
    c3.accept(100);
  }
}
