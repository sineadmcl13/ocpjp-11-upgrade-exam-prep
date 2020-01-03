import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class sortingCollectionsExamples {

  public static void main(String[] args){

    Stream<String> names = Stream.of("Bill", "Mike", "Connor");
    names.sorted().forEach(System.out::println);
    names.sorted(Comparator.reverseOrder()).forEach(System.out::println);

    Comparator<String> c1 = Comparator.comparing(n -> n.length());
    names.sorted(c1).forEach(System.out::println);

    Stream<String> moreNames = Stream.of("Aaron", "Andy", "Barney", "Bill");
    Comparator<String> c2 = Comparator.comparing(n -> n.length());
    moreNames.sorted(c1.thenComparing(c2)).forEach(System.out::println);

    //sorting a list
    List<String> males = new ArrayList<>();
    males.add("Paul"); males.add("Mike"); males.add("Steve");
    Collections.sort(males);
    System.out.print(males);

    List<String> females = new ArrayList<>();
    females.add("Penny"); females.add("Emma"); females.add("Anna");
    females.sort(Comparator.comparingInt(String::length));
    System.out.print(females);

  }
}
