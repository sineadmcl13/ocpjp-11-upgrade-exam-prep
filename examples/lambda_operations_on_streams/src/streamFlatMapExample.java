import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class streamFlatMapExample {

  public static void main(String[] args){
    List<String> maleNames = Arrays.asList("paul", "peter", "mike", "john");
    List<String> femaleNames = Arrays.asList("lucy", "anna", "clare", "suzy");

    Stream.of(maleNames, femaleNames).flatMap(Collection::stream).forEach(System.out::println);

  }
}
