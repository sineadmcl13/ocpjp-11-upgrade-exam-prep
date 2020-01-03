import java.util.Arrays;
import java.util.List;

public class streamAnyMatchExample {

  public static void main(String[] args){
    List<String> names = Arrays.asList("paul", "peter", "mike", "suzy");

    boolean anyNameStartsWithM = names.stream().anyMatch(name -> name.startsWith("m"));
    System.out.println(anyNameStartsWithM);
  }
}
