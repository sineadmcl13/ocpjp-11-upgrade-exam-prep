### Example App After Migration Using Top-Down Migration

Compile the app by running
```shell script
javac -p ../generated_jars/utility-logger.jar module-info.java com/sineadmcl/app/ExampleApp.java 
```

A jar of the app can be created by running
```shell script
jar --create --file ../generated_jars/migrated-example-app.jar .
```

```shell script
java --module-path ../generated_jars/utility-logger.jar:../generated_jars/migrated-example-app.jar -m example_app/com.sineadmcl.app.ExampleApp
```

