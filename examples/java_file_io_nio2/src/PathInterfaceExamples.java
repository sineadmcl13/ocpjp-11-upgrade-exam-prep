import java.nio.file.Path;
import java.nio.file.Paths;

public class PathInterfaceExamples {

  public static void main(String[] args){

    Path path = Paths.get("/resources/README.txt");
    System.out.println("path.toString():" + path.toString());
    System.out.println("path.getFileName(): " + path.getFileName());
    System.out.println("path.getName(0): " + path.getName(0));
    System.out.println("path.getNameCount(): " + path.getNameCount());
    System.out.println("path.subpath(0, 1): " + path.subpath(0, 1));
    System.out.println("path.getRoot(): " + path.getRoot());

    Path other = Paths.get("README2.txt");
    System.out.println("path.resolveSibling(Paths.get(\"README2.txt\")): " + path.resolveSibling(other));
    Path emptyOther = Paths.get("");
    System.out.println("path.resolveSibling(emptyOther): " + path.resolveSibling(emptyOther));


    Path pathToBeNormalized = Paths.get("/resources/foo/../README.txt");
    Path normalizedPath = pathToBeNormalized.normalize();
    System.out.println("Paths.get(\"/resources/foo/../README.txt\").normalize(): " + normalizedPath);
    System.out.println("normalizedPath.getNameCount(): " + normalizedPath.getNameCount());

    Path p1 = Paths.get("/resources/README.txt");
    Path p2 = Paths.get("/resources/foo/README2.txt");
    System.out.println("Paths.get(\"/resources/README.txt\").relativize(Paths.get(\"/resources/foo/README2.txt\")): " + p1.relativize(p2));

    Path path1 = Paths.get("/resources");
    Path path2 = Paths.get("README.txt");
    System.out.println("Paths.get(\"/resources\").resolve(Paths.get(\"README.txt\")): " + path1.resolve(path2));

    Path newPath = Path.of("/", "resources", "README.txt");
    System.out.println("Path.of(\"/\", \"resources\", \"README.txt\"): " + newPath);

  }

}
