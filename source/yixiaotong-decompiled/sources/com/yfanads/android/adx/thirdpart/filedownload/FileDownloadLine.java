package com.yfanads.android.adx.thirdpart.filedownload;

import android.app.Notification;
import android.os.Looper;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class FileDownloadLine {

    public static class ConnectListener implements Runnable {
        private boolean mIsFinished = false;
        private final ConnectSubscriber mSubscriber;

        public ConnectListener(ConnectSubscriber connectSubscriber) {
            this.mSubscriber = connectSubscriber;
        }

        public boolean isFinished() {
            return this.mIsFinished;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                this.mSubscriber.connected();
                this.mIsFinished = true;
                notifyAll();
            }
        }
    }

    public interface ConnectSubscriber {
        void connected();

        Object getValue();
    }

    private void wait(ConnectSubscriber connectSubscriber) {
        ConnectListener connectListener = new ConnectListener(connectSubscriber);
        synchronized (connectListener) {
            FileDownloader.getImpl().bindService(connectListener);
            if (!connectListener.isFinished()) {
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    throw new IllegalThreadStateException("Sorry, FileDownloader can not block the main thread, because the system is also  callbacks ServiceConnection#onServiceConnected method in the main thread.");
                }
                try {
                    connectListener.wait(200000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public long getSoFar(final int i) {
        if (FileDownloader.getImpl().isServiceConnected()) {
            return FileDownloader.getImpl().getSoFar(i);
        }
        ConnectSubscriber connectSubscriber = new ConnectSubscriber() { // from class: com.yfanads.android.adx.thirdpart.filedownload.FileDownloadLine.2
            private long mValue;

            @Override // com.yfanads.android.adx.thirdpart.filedownload.FileDownloadLine.ConnectSubscriber
            public void connected() {
                this.mValue = FileDownloader.getImpl().getSoFar(i);
            }

            @Override // com.yfanads.android.adx.thirdpart.filedownload.FileDownloadLine.ConnectSubscriber
            public Object getValue() {
                return Long.valueOf(this.mValue);
            }
        };
        wait(connectSubscriber);
        return ((Long) connectSubscriber.getValue()).longValue();
    }

    public byte getStatus(final int i, final String str) {
        if (FileDownloader.getImpl().isServiceConnected()) {
            return FileDownloader.getImpl().getStatus(i, str);
        }
        if (str != null && new File(str).exists()) {
            return (byte) -3;
        }
        ConnectSubscriber connectSubscriber = new ConnectSubscriber() { // from class: com.yfanads.android.adx.thirdpart.filedownload.FileDownloadLine.4
            private byte mValue;

            @Override // com.yfanads.android.adx.thirdpart.filedownload.FileDownloadLine.ConnectSubscriber
            public void connected() {
                this.mValue = FileDownloader.getImpl().getStatus(i, str);
            }

            @Override // com.yfanads.android.adx.thirdpart.filedownload.FileDownloadLine.ConnectSubscriber
            public Object getValue() {
                return Byte.valueOf(this.mValue);
            }
        };
        wait(connectSubscriber);
        return ((Byte) connectSubscriber.getValue()).byteValue();
    }

    public long getTotal(final int i) {
        if (FileDownloader.getImpl().isServiceConnected()) {
            return FileDownloader.getImpl().getTotal(i);
        }
        ConnectSubscriber connectSubscriber = new ConnectSubscriber() { // from class: com.yfanads.android.adx.thirdpart.filedownload.FileDownloadLine.3
            private long mValue;

            @Override // com.yfanads.android.adx.thirdpart.filedownload.FileDownloadLine.ConnectSubscriber
            public void connected() {
                this.mValue = FileDownloader.getImpl().getTotal(i);
            }

            @Override // com.yfanads.android.adx.thirdpart.filedownload.FileDownloadLine.ConnectSubscriber
            public Object getValue() {
                return Long.valueOf(this.mValue);
            }
        };
        wait(connectSubscriber);
        return ((Long) connectSubscriber.getValue()).longValue();
    }

    public void startForeground(final int i, final Notification notification) {
        if (FileDownloader.getImpl().isServiceConnected()) {
            FileDownloader.getImpl().startForeground(i, notification);
        } else {
            wait(new ConnectSubscriber() { // from class: com.yfanads.android.adx.thirdpart.filedownload.FileDownloadLine.1
                @Override // com.yfanads.android.adx.thirdpart.filedownload.FileDownloadLine.ConnectSubscriber
                public void connected() {
                    FileDownloader.getImpl().startForeground(i, notification);
                }

                @Override // com.yfanads.android.adx.thirdpart.filedownload.FileDownloadLine.ConnectSubscriber
                public Object getValue() {
                    return null;
                }
            });
        }
    }
}
