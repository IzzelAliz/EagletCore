## Eaglet

Powerful downloading library for Java.

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