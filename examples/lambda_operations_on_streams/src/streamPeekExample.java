import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class streamPeekExample {

  public static void main(String[] args){

    List<String> names = Arrays.asList("Mike", "John", "David", "Peter");
    Stream<String> stream = names.stream().peek(System.out::println);
  }
}
