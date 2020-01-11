### Utility Logger

The purpose of this basic application is to act as a dependency in an existing app that is being migrated to modular
java

Compile the app by running
```shell script
javac com/sineadmcl/logging/UtilityLogger.java 
```

A jar of the app can be created by running
```shell script
jar --create --file ./generated_jars/utility-logger.jar .
```

Determine the dependencies for bottom-up migration
```shell script
jdeps -s ../generated_jars/utility-logger.jar
utility-logger.jar -> java.base
utility-logger.jar -> java.logging
```

Generate module-info for bottom-up migration
```shell script
jdeps --generate-module-info . ../generated_jars/utility-logger.jar
```