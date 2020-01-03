import java.util.Arrays;
import java.util.List;

public class streamMapExample {

  public static void main(String[] args){
    List<String> names = Arrays.asList("paul", "peter", "mike", "suzy");
    names.stream().map(String::toUpperCase).forEach(System.out::println);
  }

}
