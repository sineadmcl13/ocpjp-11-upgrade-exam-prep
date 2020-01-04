### Use Path interface to operate on file and directory paths

A `java.nio.file.Path` object represents a directory hierarchy (that may or may not include a file) on the file system.
There are no methods in the `Path` interface that allow working with directories or files. The defines methods are 
for working with `Path` objects only. 

#### Create Path
Prior to Java 7 you would write
```java
File file = new File("README.txt");
```
from Java 7 you can use the `Paths` class to obtain a `Path`
```java
Path path = Paths.get("README.txt");
```

To facilitate migration to Java 7 the `File` class has a new `toPath()` method that transforms a `File` to a `Path`
```java
Path path = new File("README.txt").toPath();
```

>Just like `File`, a `Path` can also refer to a non-existent file. If the path does not physically exist on the disk 
>no runtime exception will be thrown from the methods outlined below

- #### `toString()`
The `toString()` method returns the string representation of the `Path`
```java
Path path = Paths.get("/resources/README.txt");
String pathString = path.toString();
System.out.println(pathString);
// outputs /resources/README.txt
```

- #### `getFileName()`
The `getFileName()` method returns the name of the file or directory denoted by this path as a `Path` object. 
The file name is the farthest element from the root in the directory hierarchy
```java
Path path = Paths.get("/resources/README.txt");
System.out.println(path.getFileName());
// outputs READEME.txt
```

- #### `getName(int index)`
The `getName(int index)` method returns a name element of this path as a `Path object` 
The index is 0 indexed. If the index provided is negative or greater or equal to the number of elements in the Path
, or if the Path has zero name elements then `IllegalArgumentException` is thrown
```java
Path path = Paths.get("/resources/README.txt");
System.out.println(path.getName(0));
// outputs resources
```

- #### `getNameCount()`
The `getNameCount()` method return the number of elements in the path
```java
Path path = Paths.get("/resources/README.txt");
System.out.println(path.getNameCount());
// outputs 2
```

- #### `subPath(int beginIndex, int endIndex)`
The `subPath(int beginIndex, int endIndex)` method returns a relative `PAth` that is a subsequence of the name elements 
of this path.
The `beginIndex` and `endIndex` parameters specify the subsequence of name elements. The returned `PAth` object has 
the name elements that begin at `beginIndex` and extend to the element at index `endIndex-1`

```java
Path path = Paths.get("/resources/README.txt");
System.out.println(path.subPath(0, 1));
// outputs resources
``` 

- #### `getRoot`
THe `getRoot()` method returns the root component of this path as a `Path` object, or null if this path does not have 
a root component (e.g for relative paths)
```java
Path path = Paths.get("/resources/README.txt");
System.out.println(path.getRoot());
// outputs /
```
```java
Path path = Paths.get("resources/README.txt");
System.out.println(path.getRoot());
// outputs null
```

- #### `resolveSibling(Path other)`
The `resolveSibling(Path other)` and `resolveSibling(String other)` methods resolve the given path against this paths 
parent path. 
If this path does not have a parent path, or `other` is absolute, then this method returns `other`. If `other` is an 
empty path then this method return the paths parent, or where this path doesnt have a parent, it returns the empty path  
```java
Path path = Paths.get("resources/README.txt");
Path other = Paths.get("README2.txt");
System.out.println(path.resolveSibling(other));
//outputs /resources/README2.txt
```
```java
Path path = Paths.get("resources/README.txt");
Path emptyOther = Paths.get("");
System.out.println(path.resolveSibling(emptyOther));
//outputs /resources
```

#### Removing redundancies from a `Path`
The `normalize()` method returns a path that is this path with redundant name elements eliminated. 
```java
Path pathToBeNormalized = Paths.get("/resources/foo/../README.txt");
Path normalizedPath = pathToBeNormalized.normalize();
System.out.println(normalizedPath);
//outputs /resources/README.txt
System.out.println(normalizedPath.getNameCount());
//outputs 2
```

#### Creating a path between two paths
The `relativize()` method provides the capability to construct a path from one location in the file system to another 
location. This method constructs a path originating from the original path and ending at the location specified by 
the passed-in path, with the new path being relative to the original path.
```java
Path p1 = Paths.get("/resources/README.txt");
Path p2 = Paths.get("/resources/foo/README2.txt");
System.out.println(p1.relativize(p2));
//outputs ../foo/README2.txt
```
A relative path CANNOT be constructed if only one of the paths includes a root element. 
If both paths include a root element, the capability to construct a relative path is system dependent. 

#### Joining two Paths

- #### `Path.resolve(Path other)`
You can combine paths by using `Path.resolve(Path other)` or `PAth.resolve(string other)`
You pass in a partial path, which is a path that does not include a root element and that is appended to the 
original path

If the `other` parameter is an absolute path then this method return `other`. If `other` is an empty path then this 
method returns this path. Otherwise the method considers this path to be a directory and resolves the given parameter 
against this path

```java
Path path1 = Paths.get("/resources");
Path path2 = Paths.get("README.txt");
System.out.println(path1.resolve(path2));
//outputs /resources/README.txt
```
```java
Path path1 = Paths.get("/resources");
Path path2 = Paths.get("/README.txt");
System.out.println(path1.resolve(path2));
//outputs /README.txt
```

#### Factory methods
JAva 11 added two new overloaded static methods to the `java.nio.file.Path` interface to conveniently 
create an instance of the interface

```java
public static Path of(String first, String... more);
public static Path of(URI uri);
```
```java
Path newPath = Path.of("/", "resources", "README.txt");
System.out.println(newPath);
//outputs /resources/README.txt
```

[Code Samples](/examples/java_file_io_nio2/src/pathInterfaceExamples.java)