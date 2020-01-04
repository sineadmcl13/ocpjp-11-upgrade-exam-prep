import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class filesClassExamples {

  public static void main(String[] args) throws Exception {
    createAndReadFromFile();
    bufferedReaderAndWriterExample();
    unbufferedInputStreamExample();
    java11ReadWriteExample();
  }

  private static void createAndReadFromFile() throws Exception {
    Path tempFile = Paths.get("/tmp/README.txt");
    try {
      Path existingFile = Files.createFile(tempFile);
      System.out.println(Arrays.toString(Files.readAllBytes(existingFile)));

    } catch (IOException ex){
      System.out.println("Exception caught performing file operations");
    } finally {
      Files.deleteIfExists(tempFile);
    }
  }

  private static void bufferedReaderAndWriterExample() throws Exception {
    String s = "String to write to temp file";
    Path file = Paths.get("/tmp/README.txt");

    try (BufferedWriter writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8)) {
      writer.write(s, 0, s.length());
    } catch (IOException x) {
      System.err.format("IOException: %s%n", x);
    }

    try (BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {
      String line = null;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
    } catch (NoSuchFileException x ) {
      System.err.format("No such file: %s", x.getFile());
    } catch (IOException  x) {
      System.err.println(x);
    } finally {
      Files.deleteIfExists(file);
    }
  }

  public static void unbufferedInputStreamExample() throws Exception {
    Path file = Paths.get("/tmp/README.txt");
    String s = "String to write to temp file, unbuffered";
    try (OutputStream out = Files.newOutputStream(file)){
      out.write(s.getBytes());
    } catch (IOException  x) {
      System.err.println(x);
    }

    try (InputStream in = Files.newInputStream(file);
         BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
    } catch (NoSuchFileException  x) {
      System.err.println("No such file exists: " + x.getFile());
    } catch (IOException  x) {
      System.err.println(x);
    } finally {
      Files.deleteIfExists(file);
    }
  }


  public static void java11ReadWriteExample() throws Exception {
    Path tempFile = Files.createTempFile(null, "tempFile.txt");
    System.out.format("The temporary file: %s%n", tempFile);
    String s = "String to write to temp file, using Java 11 methods";

    try {
      Files.writeString(tempFile, s);
    } catch (IOException  x) {
      System.err.println(x);
    }

    try {
      System.out.println(Files.readString(tempFile));
    } catch (NoSuchFileException  x) {
      System.err.println("No such file exists: " + x.getFile());
    } catch (IOException  x) {
      System.err.println(x);
    } finally {
      Files.deleteIfExists(tempFile);
    }
  }

}
