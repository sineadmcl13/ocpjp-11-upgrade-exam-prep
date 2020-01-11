### Utility Logger Module

This is the same utility-logger dependency but its been migrated to a module for use in the bottom-up migration
approach

Compile the module
```shell script
javac module-info.java com/sineadmcl/logging/UtilityLogger.java
```

A jar of the module can be created
```shell script
jar --create --file ../generated_jars/utility-logger-module.jar .
```

We can run the example app from the example_app directory and running
```shell script
java --add-modules utility.logger --module-path ../generated_jars/utility-logger-module.jar --class-path ../generated_jars/example-app.jar com/sineadmcl/app/ExampleApp
```