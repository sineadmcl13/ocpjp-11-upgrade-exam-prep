import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class collectorsWithStreamExamples {

  public static void main(String[] args){
    List<String> names = Arrays.asList("Pete", "Sally", "Mark", "Tim", "Gareth");
    List<String> namesWithFourChars = names.stream().filter(n -> n.length() == 4).collect(Collectors.toList());
    namesWithFourChars.forEach(System.out::println);

    List<String> list = Arrays.asList("A", "AA", "A", "AAA");
    double result = list.stream().collect(Collectors.averagingDouble(String::length));
    System.out.println(result);

    Map<Integer, List<String>> groupingByResult = list.stream().collect(Collectors.groupingBy(String::length));
    System.out.println(groupingByResult);

    Stream<String> namesStream = Stream.of("John", "Joe", "James");

    String concat = namesStream.collect(Collectors.joining());
    System.out.println(concat);

    Map<Boolean, List<String>> map = namesStream.collect( Collectors.partitioningBy(s -> s.length() <= 4));
    System.out.println(map);
  }
}
