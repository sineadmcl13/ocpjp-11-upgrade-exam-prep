### Describe how a modular project is compiled and run

#### Unnamed Module
From Java 9, all Java classes must be located in a module for the Java VM to use them. 
But you can still use the `-classpath` (synonyms: `-cp` and `--class-path`) argument to the Java VM when running an application. 
All classes found on the classpath will be included in what Java calls the __unnamed__ module. This supports backwards
 compatibility and allows you to use older classes. 
 
- The unnamed module exports all its packages. 
- The classes in the unnamed module are only readable by other classes in the unnamed module. No named module can read
 the classes of the unnamed module.
- All classes in the unnamed module `requires` all modules found on the module path. 
- All classes in the unnamed module can read all classes exported by all the Java modules found on the module path.

#### Automatic Modules
An automatic module is a JAR on the module path without the `module-info.class` 
They are named modules which are automatically created from a non-modular JAR.

The module implicitly has a `requires` clause for all other modules and all of its packages are exported and opened.

> A non-modular JAR becomes modular (automatic module) JAR when used by a modular application via `--module-path`
> option and becomes part of the unnamed module when used by a modular application via `--class-path` option.


#### Automatic module name derivation
Without the presence of the `meta-info.class` file, the name of an automatic module can be determined if the JAR file 
has the attribute `Automatic-Module-Name` in its main manifest `(META-INF/MANIFEST.MF)`. 
In this case its value is the module name. 

Otherwise derived from the name of the JAR file using the following rules
 1. The .jar suffix is removed.
 2. If the name matches the regular expression `-(\\d+(\\.|$))` then the module name will be derived from the subsequence
  preceding the hyphen of the first occurrence. 
  The subsequence after the hyphen is parsed as a `version` and ignored if it cannot be parsed as a `version`.
 3. All non-alphanumeric characters `([^A-Za-z0-9])` in the module name are replaced with a dot `(".")`, all repeating dots
  are replaced with one dot, and all leading and trailing dots are removed.
  
As an example, a JAR file named `foo-bar.jar` will derive a module name `foo.bar` with no version

A JAR file named `foo-bar-1.2.3-SNAPSHOT.jar` will derive a module name `foo.bar` and `1.2.3-SNAPSHOT` as the version

#### Java command line options for modules

//TODO 