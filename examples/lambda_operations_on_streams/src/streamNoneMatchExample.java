import java.util.Arrays;
import java.util.List;

public class streamNoneMatchExample {

  public void main(String[] args){
    List<String> names = Arrays.asList("paul", "peter", "mike", "suzy");

    boolean allNamesStartWithP = names.stream().noneMatch(name -> name.startsWith("P"));
    System.out.println(allNamesStartWithP);
  }
}
