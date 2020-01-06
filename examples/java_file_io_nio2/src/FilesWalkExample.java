import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FilesWalkExample{
  public static void main(String [] args){
    Path start = Paths.get("./");
    int maxDepth = 3;

    try (Stream<Path> stream = Files.walk(start, maxDepth)) {
      stream.forEach(System.out::println);
    } catch(IOException ex){
      System.out.println("An exception has been caught: " + ex );
    }
  }
}