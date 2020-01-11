### Example App

The purpose of this basic application is so that it can be used to facilitate testing bottom up and top down
migration strategies to modular java

Compile the app by running
```shell script
javac -cp ../generated_jars/utility-logger.jar com/sineadmcl/app/ExampleApp.java 
```

A jar of the app can be created by running
```shell script
jar --create --file ../generated_jars/example-app.jar .
```

Running Java8 style
```shell script
java -classpath ../generated_jars/example-app.jar:../generated_jars/utility-logger.jar com.sineadmcl.app.ExampleApp
```

Determine the dependencies for top-down migrating
```shell script
jdeps --module-path ../generated_jars/utility-logger.jar -s ../generated_jars/example-app.jar
example-app.jar -> java.base
example-app.jar -> utility.logger
utility.logger -> java.base
utility.logger -> java.logging
```
