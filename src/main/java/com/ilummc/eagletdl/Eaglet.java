package com.ilummc.eagletdl;

/**
 * Test class
 */
public class Eaglet {

    public static void main(String[] args) {
        //new EagletTask().url("http://sgp-ping.vultr.com/vultr.com.100MB.bin")
        new EagletTask().url("http://central.maven.org/maven2/org/jetbrains/kotlin/kotlin-stdlib/1.2.31/kotlin-stdlib-1.2.31.jar")
                .file("F:\\test.dl")
                .setThreads(48)
                .readTimeout(1000)
                .connectionTimeout(1000)
                .maxRetry(30)
                .md5("6e73967afe18f7ca3bf80b6f0ea4eae1")
                .sha1("153dcd9ed9db246a7e36f4d7609e2a9f4718c674")
                .setOnConnected(event -> System.out.println(event.getContentLength()))
                .setOnProgress(event -> System.out.println(event.getSpeedFormatted() + " " + event.getPercentageFormatted()))
                .setOnComplete(event -> System.out.println("Complete"))
                .start();
    }

}
