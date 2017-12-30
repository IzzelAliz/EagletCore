package com.ilummc.eagletdl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

class SplitDownload implements Runnable {

    private URL url;
    long startIndex, endIndex;
    private File target;
    private EagletTask task;

    private transient long currentIndex, lastUpdateTime = System.currentTimeMillis();

    SplitDownload(URL url, long startIndex, long endIndex, File dest, EagletTask task) {
        this.url = url;
        this.startIndex = this.currentIndex = startIndex;
        this.endIndex = endIndex;
        target = dest;
        this.task = task;
    }

    long getLastUpdateTime() {
        return lastUpdateTime;
    }

    long getCurrentIndex() {
        return currentIndex;
    }

    @Override
    public void run() {
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // set the connection properties
            task.httpHeader.forEach(connection::addRequestProperty);
            connection.setRequestMethod(task.requestMethod);
            connection.setConnectTimeout(task.connectionTimeout);
            connection.setReadTimeout(task.readTimeout);
            // set the download range
            connection.setRequestProperty("Range", "bytes=" + startIndex + "-" + endIndex);
            connection.connect();
            // if response code not equals 206, it means that the server do not support multi thread downloading
            if (connection.getResponseCode() == 206) {
                RandomAccessFile file = new RandomAccessFile(target, "rwd");
                file.seek(startIndex);
                byte[] buf = new byte[1024];
                int len;
                try (BufferedInputStream stream = new BufferedInputStream(connection.getInputStream())) {
                    while ((len = stream.read(buf)) > 0) {
                        file.write(buf, 0, len);
                        lastUpdateTime = System.currentTimeMillis();
                        currentIndex += len;
                    }
                }
            } else throw new DoNotSupportMultipleThreadException();
        } catch (Exception e) {
            task.onError.handle(new ErrorEvent(e, task));
        }
    }
}
