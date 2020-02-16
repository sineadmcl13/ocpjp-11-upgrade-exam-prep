### Use Files class to check, delete, copy or move a file or directory

The `java.nio.file.Files` class consists of static methods that use `Path` objects to work with files and directories.

All methods that access the file system can throw a `java.io.IOException` and many specific exceptions extend 
`FileSystemException`. This class has some useful methods that return the file involved, the detailed message string 
the reason why the operation failed and the other file involved (if any) 

Several `Files` methods also accept an arbitrary number of arguments when flags are specified. 

#### Copy a File
To copy one file to another you would use `Files.copy` method
```java
Files.copy(Path source, Path target, CopyOption... options);
```

The `options` argument are enums that specify how the file should be copied. There are 2 different `Enum` classes, 
`LinkOption` and `StandardCopyOption` which implement the `CopyOption` interface

Available options for `Files.copy` include:
 - `LinkOPtion.NOFOLLOW_LINKS`
    
    Indicates that symbolic links should NOT be followed. If the file to be copied is a symbolic link, the link is 
    copied and not the target of the link 
    
 - `StandardCopyOption.COPY_ATTRIBUTES`
    
    Copies the file attributes associated wit the file to the target file. The exact file attributes supported are file 
    system and platform dependent, but last-modified tim eis support across platforms and is copied to the target file
    
 - `StandardCopyOption.REPLCASE_EXISTING`
    
    Performs the copy even when the target file already exists. If the target is a symbolic link, the link itself is 
    copied. If the target is a non-empty directory, the copy fails with the `FileAlreadyExistsException`
    
#### Move a file
You can move a file be using the `File.move(...)` method
```java
Files.move(Path source, Path target, CopyOption... options);
```
The available `StandardCopyOptions` enums available are:
 - `StandardCopyOPtion.REPLACE_EXISTING`
 
    Performs the move even when the target file already exists. If the target is a symbolic link, the symbolic link 
    is replaced but what is points to is not affected
    
  - `StandardCopyOption.ATOMIC_MOVE`
  
    Performs the move as an atomic file operation. If the file system does not support an atomic move, an exception 
    is thrown. With an `ATOMIC_MOVE` you can move a file into a directory and be guaranteed that nay process watching 
    the directory accesses a complete file
    
#### Reading, Writing and Creating Files

- `readAllBytes(Path p)` and `readAllLines(Path p, Charset c)`
    If you have a small file, you can use the `readAllBytes(...)` and `realAllLines(...)` methods. They handle most of 
    the work such as opening and closing the stream, but are not intended for handling large files.
```java
Path existingFile = Paths.get("/resouces/README.txt");
String fileContents = Arrays.toString(Files.readAllBytes(existingFile));
System.out.println(fileContents);
```

#### Buffered I/O methods for text files

- `newBufferedReader(path p, Charset c)`

    The `java.nio.file` package supports channel I/O, which moves data in buffers, bypassing some of the layers that 
    can bottleneck stream I/O

    The `newBufferedReader(Path p, Charset c)` method opens a file for reading, returning a `BufferedReader` that can 
    be used to read text from a file in an efficient manner

```java
Path file = Paths.get("resources/README.txt");
try (BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {
  String line = null;
  while ((line = reader.readLine()) != null) {
    System.out.println(line);
  }
} catch (NoSuchFileException x ) {
  System.err.format("No such file: %s", x.getFile());
} catch (IOException  x) {
  System.err.println(x);
}
```

- `newBufferedWriter(Path p, Charset c, OpenOption...)`

    You can use the `newBufferedWriter(Path p, Charset c, OpenOption...)` method to write to a file using a BufferedWriter
```java
String s = "String to write to temp file";
Path file = Paths.get("/tmp/README.txt");
try (BufferedWriter writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8)) {
  writer.write(s, 0, s.length());
} catch (IOException x) {
  System.err.format("IOException: %s%n", x);
}
```  

#### Methods for unbuffered streams and interoperable with `java.io` APIs

 - `newInputStream(Path p, OpenOption...)`
 
    To open a file for reading, you can use the `newInputStream(Path p, OpenOption...)` method. This methods returns an 
    unbuffered input stream for reading bytes from the file
    
```java
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
} 
```

Several of the `Files` methods take an optional `OpenOptions` parameter. The following `StandardOpenOptions` enum 
constants are supported:
 - `APPEND` - appends bytes to be written to the end of the file
 - `CREATE` - creates a new file if one doesn't already exist
 - `CREATE_NEW` - creates a new file, failing if one already exists
 - `DELETE_ON_CLOSE` - makes a best effort attempt to delete the file when the appropriate close method is called
 - `DSYNC` - requires that every update to the files content be written synchronously
 - `READ` - opens the file for read access
 - `SPARSE` - when used with the `CREATE_NEW` option then this option provides a hint that the new file will be sparse
 - `SYNC` - requires that every update to the files content or metadata be written synchronously 
 - `TRUNCATE_EXISTING` - if the file already exists and is opened for `WRITE` access, its length is truncated to 0
 - `WRITE` - opens the file for write access
 

#### Glob argument
The `newDirectoryStream` method in the `Files` class a `String` glob argument.

You can use the glob syntax to specify pattern-matching behaviour. A glob pattern is specified as a string and is 
matched against other strings, such as directory or file names

e.g
 - `*.java` matches any path ending in `.java`
 - `*.*` matches any path containing a dot
 -`/home/*/*` matches any nested sub path matching `home/*/*`
 
#### Creating temporary files
You can create a temporary file using the `Files.createTempFile(...)` method
```java
public static Path createTempFile(Path dir,
                                  String prefix,
                                  String suffix,
                                  FileAttribute<?>... attrs) throws IOException;
```
This method allows you to specify a directory for the temporary file whereas the next overloaded `createTempFile` 
creates a new file in the default temporary-file directory.
```java
public static Path createTempFile(String prefix,
                                  String suffix,
                                  FileAttribute<?>... attrs) throws IOException;
```

A temporary file is just a simple file until you make sure that it is truly temporary by specifying an automatic 
mechanism to delete the temporary files periodically or at a specified time. There are 3 approaches to doing this:
- via `File.deleteOnExit()
- via a shutdown hook `Runtime.getRuntime().addShutdownHook(new Thread() { ... });`
- via `StandardOpenOption.DELETE_ON_CLOSE`

#### Java 11 Read/Write String to/from file
Java 11 also added the following methods to `java.nio.file.Files` to directly read and write `String` from a file 
```java
public static String readString(Path path) throws IOException
public static String readString(Path path, Charset c) throws IOException
```

```java
public static Path writeString(Path path, CharSequence csq, OpenOption... options) throws IOException
public static Path writeString(Path path, CharSequence csq, Charset cs, OpenOption... options) throws IOException					
```

[Code Samples](/examples/java_file_io_nio2/src/FilesClassExamples.java)

| [Previous](use_path_interface_to_operate_on_file_and_directory_paths.md) | [Next](use_stream_api_with_files.md) |
| :--------- | ----------: | 