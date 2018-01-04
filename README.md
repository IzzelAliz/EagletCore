## Eaglet

Powerful downloading library for Java.

### Import as Dependency

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.ilummc.eagletdl/EagletCore/badge.svg)](http://mvnrepository.com/artifact/com.ilummc.eagletdl/EagletCore)

```xml
<dependency>
  <groupId>com.ilummc.eagletdl</groupId>
  <artifactId>EagletCore</artifactId>
  <version>1.0</version>
</dependency>
```

### How to start
```java
new EagletTask().url("http://sgp-ping.vultr.com/vultr.com.100MB.bin")
        .file("F:\\test.dl")
        .setThreads(32)
        .sha1("363F1FE692C86438A331B7268F6994CF51E5CCC5")
        .setOnProgress(event -> System.out.println(event.getSpeedFormatted()))
        .setOnComplete(event -> System.out.println("Complete"))
        .start();
```

### License

The MIT License