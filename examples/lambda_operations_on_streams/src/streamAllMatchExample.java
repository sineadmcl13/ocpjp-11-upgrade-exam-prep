import java.util.Arrays;
import java.util.List;

public class streamAllMatchExample {

  public static void main(String[] args){
    List<String> names = Arrays.asList("paul", "peter", "mike", "suzy");

    boolean allNamesStartWithP = names.stream().allMatch(name -> name.startsWith("P"));
    System.out.println(allNamesStartWithP);
  }

}
