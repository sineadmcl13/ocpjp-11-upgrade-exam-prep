### Migration To A Modular Application

Most Java code was written prior to the introduction of the module system and must continue to work just as it did
prior to the changes introduced in Java 9.

The module system can, compile and run applications composed of JAR files on the class path even though the platform 
itself is composed of modules. It also allows existing applications to be migrated to modular form in a flexible and 
gradual manner.

At some point you may be involved in migrating your application to Java 9 and trying to modularize it. 
A change of such magnitude, which involves third-party libraries and rethinking of the code structure, 
would require proper planning and implementation. The Java team has suggested two migration approaches:

  - Bottom-up migration 
  - Top-down migration


| [Previous](../java_file_io_nio2/use_stream_api_with_files.md) | [Next](migrate_application_to_java_11_using_top_down_and_bottom_up_migration.md) |
| :--------- | ----------: | 