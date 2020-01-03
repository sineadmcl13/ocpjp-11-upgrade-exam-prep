import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class optionalExamples {

  public static void main(String[] args){
    Optional<?> emptyOptional = Optional.empty();
    System.out.println("Empty Optional present: " + emptyOptional.isPresent());

    Optional<String> stringOptional = Optional.of("stringOptional");
    System.out.println(stringOptional.get());

    stringOptional.stream().forEach(System.out::println);

    String s = null;
    Optional<String> nullableOptional = Optional.ofNullable(s);
    System.out.println(nullableOptional.orElse("nullable Optional alternative value"));

    List<Optional<?>> listOfOptionals = Arrays.asList(emptyOptional, stringOptional, nullableOptional);
    listOfOptionals.stream().flatMap(Optional::stream).forEach(System.out::println);

  }
}
