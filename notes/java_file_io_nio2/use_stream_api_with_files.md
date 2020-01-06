### Use Stream API with Files

- #### `Files.find(...)`
Returns a `Stream` that is lazily populated with `Path` by searching for files in a file tree rooted at a given starting file
```java
public static Stream<path> find(Path start,
                                int maxDepth,
                                BiPredicate<Path, BasicFileAttributes> matcher,
                                FileVisitOption... options) 
                                throws IOException
```

The method `find(...)` accepts three arguments: 
    
   1. The directory path `start` is the initial starting point
   2. The `maxDepth` defines the maximum folder depth to be searched
   3. A matching predicate defines the search logic 

The `find(...)` method walks the tree in exactly the same manner specified by the `walk(...)` method. The `Path` object 
is obtained as if by resolving the relative path against the start and is only included in the return `Stream` if the 
`BiPredicate` returns `true`

Operating on a closed stream will result in an `IllegalStateException`. 
```java
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
```

[Code Sample](/examples/java_file_io_nio2/src/FilesFindExample.java)

- #### `File.walk(...)`
Returns a `Stream` that is lazily populated with Path by walking the file tree rooted at a given starting file. 
The file tree is traversed depth-first, the elements in the stream are `Path` objects that are obtained as if by 
resolving the relative path against start.
```java
public static Stream<Path> walk(Path start,
                                int maxDepth,
                                FileVisitOption... options)
                                throws IOException
```
Points to note about the `Files.walk(...)` method

   1. The first value that is returned is the starting directory itself
   2. It walks the directory in a depth first manner, meaning it process the children of a directory before moving to
      the sibling directory
   3. The order of processing siblings is not defined, so the order is not guaranteed
```java
Path start = Paths.get("../");
int maxDepth = 3;
        
try(Stream<Path> stream = Files.walk(start, maxDepth)){
  stream.forEach(System.out::println);
} catch(IOException ex){
  System.out.println("An exception has been caught: " + ex );
}
```
[Code Sample](/examples/java_file_io_nio2/src/FilesWalkExample.java)

- #### `Files.lines(...)`
Reads all the lines from a file as a `Stream`. Bytes from the file are decoded into characters using the UTF-8 charset
```java
public static Stream<String> lines(Path path) throws IOException
```
The stream is lazily populated, which mean it doesn't read the whole file upfront. 
It reads the files as you consume the elements of the stream.
```java
Path file = Paths.get("./README.md");
try (Stream<String> stream = Files.lines(file)) {
  stream.forEach(System.out::println);
} catch(IOException ex){
  System.out.println("An exception has been caught: " + ex );
}
```
[Code Sample](/examples/java_file_io_nio2/src/FileLinesExample.java)

- #### `Files.readAllLines(...)`
The `readAllLines(...)` method reads all lines from a file into a List of Strings. 
Bytes from the file are decoded into characters using the UTF-8 charset. 
```java
public static List<String> readAllLines(Path path) throws IOException
```
```java
Path f = Paths.get("./README.md");
try {
  List<String> fileContentList = Files.readAllLines(f);
  fileContentList.forEach(System.out::println);
} catch(IOException ex){
  System.out.println("An exception has been caught: " + ex );
}
```
[Code Sample](/examples/java_file_io_nio2/src/FileReadAllLinesExample.java)