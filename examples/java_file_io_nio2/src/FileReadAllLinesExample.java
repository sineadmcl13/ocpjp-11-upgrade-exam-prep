import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class FileReadAllLinesExample {
  public static void main(String [] args){
    Path f = Paths.get("./notes/java_file_io_nio2/README.md");
    try {
      List<String> fileContentList = Files.readAllLines(f);
      fileContentList.forEach(System.out::println);
    } catch(IOException ex){
      System.out.println("An exception has been caught: " + ex );
    }
  }
}
