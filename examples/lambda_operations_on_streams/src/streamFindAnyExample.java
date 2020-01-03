import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class streamFindAnyExample {

  public static void main(String[] args){
    List<String> names = Arrays.asList("paul", "peter", "penny", "patrick");

    Optional<String> name = names.stream().findAny();
    name.ifPresent(System.out::println);
  }
}
