package com.ilummc.eagletdl;

import java.text.DecimalFormat;

public class ProgressEvent {

    private long speed;
    private EagletTask task;

    ProgressEvent(long speed, EagletTask task) {
        this.speed = speed;
        this.task = task;
    }

    public EagletTask getTask() {
        return task;
    }

    public long getSpeed() {
        return speed;
    }

    /**
     * Get the speed with format like <code>X.00 MiB</code>, <code>Y.50 GiB</code>, etc.
     *
     * @return formatted speed string
     */
    public String getSpeedFormatted() {
        return format(getSpeed());
    }

    private static String formatDouble(double d) {
        return new DecimalFormat("0.00").format(d);
    }

    private static String format(long l) {
        if (l < 1024) return l + " B";
        if (l < 1024 * 1024) return formatDouble((double) l / 1024D) + " KiB";
        if (l < 1024 * 1024 * 1024) return formatDouble((double) l / (1024D * 1024D)) + " MiB";
        if (l < 1024 * 1024 * 1024 * 1024L) return formatDouble((double) l / (1024D * 1024D * 1024)) + " GiB";
        return "";
    }
}
