### Use jdeps to determine dependencies and identify way to address the cyclic dependencies

The `jdeps` command shows the package-level or class-level dependencies of Java class files. The input class can be 
a path name to a `.class` file, a directory, a JAR file, or a fully qualified class name to analyze all class files. 

The options determine the output. By default the `jdeps` command writes the dependencies to the system output
```shell script
jdeps [options] path ...
```

jdeps options include :

- `-dotoutput dir_name` (or `--dot-output dir_name`)
    
    Specifies the destination directory for the DOT file output. If this option is specified, the the `jdeps` command 
    generates one .`dot` file for each analyzed archive named `archive-file-name.dot` that lists the dependencies, and
    also a summary file named `summary.dot` that lists the dependencies among the archive files
    
- `-s` (or `-summary`)
    
    Prints a dependency summary only

- `-jdkinternals` (or `--jdk-internals`)
    
    Finds class-level dependencies in the JDK internal APIs. By default, this option analyzes all classes specified in 
    the `--class-path` option and input files unless you specified the `-include` option. You can't use this option 
    with the `-p`, `-e` and `-s` options

- `-cp path` (or `-classpath path`, or `--class-path path`)
    
    Specifies where to find class files

- `--module-path module path`
    
    Specifies the module path

- `-m module_name` (or `--module module_name`)
    
    Specifies the root module for analysis
 
- `--generate-module-info dir`

    Generates `module-info.java` under the specified directory. The specified JAR files will be analysed. This option 
    cannot be used with `--dot-output` or `--class-path` options. Use the `--generate-open-module` option for open 
    modules
    
- `--generated-open-module`
    Generates `module-info.java` for the specified JAR files under the specified directory as open modules. 
    This option cannot be used with `--dot-output` or `--class-path` options. 
    
#### Cyclic dependencies 
Cyclic dependencies between modules can be recognised by the java compiler. 

An example of a cyclic dependency is as follows
```java
module modA {
  requires modB;
}
```
```java
module modB {
  requires modA;
}
```

Potential solutions to resolve a cyclic dependency could be:
- Merge the 2 modules into a single module
- Break the cycle using interfaces

The result of option 2 would be to refactor all interfaces from class methods which create dependencies into a 
new module named modC
```java
module modA {
  requires modC;
}
```
```java
module modB {
  requires modC;
}
```