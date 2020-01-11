### Migrate the application developed using a Java version prior to SE 9 to SE 11 including top-down and bottom-up migration, splitting a Java SE 8 application into modules for migration

#### Pre-migration
Using [example-app](/examples/migration_to_a_modular_application/example_app)
We have a basic app with one class that depends on a [Utility-logger](/examples/migration_to_a_modular_application/utility_logger)

We can build the example app as normal specifying the location of dependency utility-logger.jar to be used as the 
classpath 
```shell script
javac -cp ../generated_jars/utility-logger.jar com/sineadmcl/app/ExampleApp.java 
```
We can create an jar from the xample app and run
```shell script
jar --create --file ../generated_jars/example-app.jar .
```
```shell script
java -classpath ../generated_jars/example-app.jar:../generated_jars/utility-logger.jar com.sineadmcl.app.ExampleApp
Jan 11, 2020 10:56:18 AM com.sineadmcl.logging.UtilityLogger logInfo
INFO: This is an existing app that can be used to migrate to modular java
```

#### Top down migration
For top-down migration the applications JARs are transformed into modules by creating `module-info.java` 
files for them. 
The dependencies are turned into automatic modules by putting them on the module path instead of the class path.

- #### Check dependencies for application to create proper module descriptor: 
    To create the `module-info.java` for the [example-app](/examples/migration_to_a_modular_application/example_app)
    we use the `jdeps` tool
```shell script
jdeps --module-path generated_jars/utility-logger.jar -s generated_jars/example-app.jar
example-app.jar -> java.base
example-app.jar -> utility.logger
utility.logger -> java.base
utility.logger -> java.logging
```

The example app depends on 3 modules; `java.base`, `java.logging` and `utility.logger`.

As such we can create the following `module-info.java`
```java
module example.app {
    requires utility.logger;
    requires java.logging;
}
	
```
> `java.base` is implicitly required by all modules, so doesn't need to be included in the `module-info.java`

After creating the `module-info.java` we can recompile the migrated app
Example after the migration can be seen in the example app [top-down-mirgated-app](/examples/migration_to_a_modular_application/top-down-migrated-app)

We can then recompile the migrated app 
```shell script
javac -p ../generated_jars/utility-logger.jar module-info.java com/sineadmcl/app/ExampleApp.java 
```
Then we can recreate the example app
```shell script
jar --create --file ../generated_jars/migrated-example-app.jar .
```
and then run the application
```shell script
java --module-path ../generated_jars/utility-logger.jar:../generated_jars/migrated-example-app.jar -m example_app/com.sineadmcl.app.ExampleApp
Jan 11, 2020 12:05:47 PM com.sineadmcl.logging.UtilityLogger logInfo
INFO: This is an existing app that has been migrated to modular java
```


#### Bottom up Migration
We make all library JARs modular and put on the module path, 
keep application JAR non-modular and put on the class path (it will become part of the unnamed module). 

 The unnamed module:

  - Reads all other modules
  - Exports all its packages
  - Cannot have any dependencies declared on it
  - Cannot be accessed by a named module (the one with `module-info.class`) 

Using the same [example-app](/examples/migration_to_a_modular_application/example_app) which has a dependency on
[Utility-logger](/examples/migration_to_a_modular_application/utility_logger) we make the utility-logger modular

- #### Check dependencies for application to create proper module descriptor: 
    To create the `module-info.java` for the [Utility-logger](/examples/migration_to_a_modular_application/utility_logger)
    we use the `jdeps` tool
```shell script
jdeps -s ../generated_jars/utility-logger.jar
utility-logger.jar -> java.base
utility-logger.jar -> java.logging
```

It is easy in this case to believe that we only require `java.logging` and create the following module definition
```java
module utility_logger {
  requires java.logging;
}
```
but this definition is __wrong__ because the library must export packages to be used by the application 
(or unnamed module). We need to use `jdeps` to accurately generate a `module-info.java`
```shell script
jdeps --generate-module-info . ../generated_jars/utility-logger.jar   
writing to ./utility.logger/module-info.java
```

which generates 
```java
module utility.logger {
    requires java.logging;

    exports com.sineadmcl.logging;
}
```
An example of the utility-logger after its been migrated to a module can be found in [utility_logger_module](/examples/migration_to_a_modular_application/utility_logger_module)

>  NOTE: module name may not contain dash character, it get replaced with period character automatically by jdeps utility. 

Now we can recomplile the utility-logger
```java
javac utility.logger/module-info.java utility.logger/com/sineadmcl/logging/UtilityLogger.java 
```
And a jar created by running
```shell script
jar --create --file ../generated_jars/utility-logger-module.jar .
```
And the example app can be ran 
```shell script
java --add-modules utility.logger --module-path ../generated_jars/utility-logger-module.jar --class-path ../generated_jars/example-app.jar com/sineadmcl/app/ExampleApp
```

When the compiler compiles code in the unnamed module, or the Java launcher is invoked and the main class of the 
application is loaded from the class path into the unnamed module of the application class loader, then the default 
set of root modules for the unnamed module is computed as follows:

- The `java.se` module is a root, if it exists. If it does not exist then every `java.*` module on the upgrade module
  path or among the system modules that exports at least one package, without qualification, is a root
- Every `non-java.*` module on the upgrade path or among the system modules that exports at least one package, 
  without qualification, is also a root

Otherwise, the default set of root modules depends upon the following phase:
- At compile time it is usually the set of modules being compiled
- At link time it is empty
- At run time it is the applications main module, as specified via the `--module` (or `-m` for short) launcher option

It is occasionally necessary to add modules to the default root set in order to ensure that modules will be present in 
the module graph. In any phase the option `--add-mdules <module>` where `,module>` is a module name, adds the named 
modules to the default set of root modules

So in the example above, we used `--add-modules utility.logger` to tell the Java runtime to include the module by name 
in the default root set
