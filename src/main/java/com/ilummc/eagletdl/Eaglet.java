package com.ilummc.eagletdl;

/**
 * Test class
 */
public class Eaglet {

    public static void main(String[] args) {
        new EagletTask().url("http://sgp-ping.vultr.com/vultr.com.100MB.bin")
                .file("F:\\test.dl")
                .setThreads(32)
                .sha1("363F1FE692C86438A331B7268F6994CF51E5CCC5")
                .setOnProgress(event -> System.out.println(event.getSpeedFormatted()))
                .setOnComplete(event -> System.out.println("Complete"))
                .start();
    }

}
