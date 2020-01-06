import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilesFindExample{
  public static void main(String [] args){
    Path start = Paths.get("../");
    int maxDepth = 3;

    try(Stream<Path> stream = Files.find(start, maxDepth, (path, attr) -> String.valueOf(path).endsWith(".java"))){
      String joined = stream.sorted()
          .map(String::valueOf)
          .collect(Collectors.joining("; "));
      System.out.println(joined);
    } catch(IOException ex){
      System.out.println("An exception has been caught");
    }
  }
}