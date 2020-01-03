import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class calculationExamples {

  public static void main(String[] args){

    Stream<String> names = Stream.of("James", "John", "Peter", "Paul", "Mike");

    System.out.println("Count of names = " + names.count());
    System.out.println("Max name = " + names.max(Comparator.naturalOrder()));
    System.out.println("Min name = " + names.min(Comparator.naturalOrder()));

    IntStream stream = IntStream.of(2, 4, 6, 1, 34, 5, 9);

    System.out.println("Sum of numbers = " + stream.sum());
    System.out.println("Average number = " + stream.average());
  }
}
