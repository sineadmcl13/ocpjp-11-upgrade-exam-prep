import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class streamFindFirstExample {

  public static void main(String[] args){
    List<String> names = Arrays.asList("paul", "peter", "mike", "suzy");

    Optional<String> firstName =  names.stream().findFirst();
    firstName.ifPresent(System.out::println);
  }
}
