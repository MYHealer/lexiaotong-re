package com.yfanads.android.adx.thirdpart.filedownload.download;

import android.os.SystemClock;
import com.yfanads.android.adx.thirdpart.filedownload.connection.FileDownloadConnection;
import com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase;
import com.yfanads.android.adx.thirdpart.filedownload.exception.FileDownloadGiveUpRetryException;
import com.yfanads.android.adx.thirdpart.filedownload.exception.FileDownloadNetworkPolicyException;
import com.yfanads.android.adx.thirdpart.filedownload.stream.FileDownloadOutputStream;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadLog;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadUtils;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class FetchDataTask {
    static final int BUFFER_SIZE = 4096;
    private final ProcessCallback callback;
    private final FileDownloadConnection connection;
    private final int connectionIndex;
    private final long contentLength;
    long currentOffset;
    private final FileDownloadDatabase database;
    private final int downloadId;
    private final long endOffset;
    private final DownloadRunnable hostRunnable;
    private final boolean isWifiRequired;
    private volatile long lastSyncBytes;
    private volatile long lastSyncTimestamp;
    private FileDownloadOutputStream outputStream;
    private final String path;
    private volatile boolean paused;
    private final long startOffset;

    /* JADX INFO: renamed from: com.yfanads.android.adx.thirdpart.filedownload.download.FetchDataTask$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public /* synthetic */ FetchDataTask(FileDownloadConnection fileDownloadConnection, ConnectionProfile connectionProfile, DownloadRunnable downloadRunnable, int i, int i2, boolean z, ProcessCallback processCallback, String str, AnonymousClass1 anonymousClass1) {
        this(fileDownloadConnection, connectionProfile, downloadRunnable, i, i2, z, processCallback, str);
    }

    private void checkAndSync() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (FileDownloadUtils.isNeedSync(this.currentOffset - this.lastSyncBytes, jElapsedRealtime - this.lastSyncTimestamp)) {
            sync();
            this.lastSyncBytes = this.currentOffset;
            this.lastSyncTimestamp = jElapsedRealtime;
        }
    }

    private void sync() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        try {
            this.outputStream.flushAndSync();
            int i = this.connectionIndex;
            if (i >= 0) {
                this.database.updateConnectionModel(this.downloadId, i, this.currentOffset);
            } else {
                this.callback.syncProgressFromCache();
            }
            if (FileDownloadLog.NEED_LOG) {
                FileDownloadLog.d(this, "require flushAndSync id[%d] index[%d] offset[%d], consume[%d]", Integer.valueOf(this.downloadId), Integer.valueOf(this.connectionIndex), Long.valueOf(this.currentOffset), Long.valueOf(SystemClock.uptimeMillis() - jUptimeMillis));
            }
        } catch (IOException e) {
            if (FileDownloadLog.NEED_LOG) {
                FileDownloadLog.d(this, "Because of the system cannot guarantee that all the buffers have been synchronized with physical media, or write to filefailed, we just not flushAndSync process to database too %s", e);
            }
        }
    }

    public void pause() {
        this.paused = true;
    }

    private FetchDataTask(FileDownloadConnection fileDownloadConnection, ConnectionProfile connectionProfile, DownloadRunnable downloadRunnable, int i, int i2, boolean z, ProcessCallback processCallback, String str) {
        this.lastSyncBytes = 0L;
        this.lastSyncTimestamp = 0L;
        this.callback = processCallback;
        this.path = str;
        this.connection = fileDownloadConnection;
        this.isWifiRequired = z;
        this.hostRunnable = downloadRunnable;
        this.connectionIndex = i2;
        this.downloadId = i;
        this.database = CustomComponentHolder.getImpl().getDatabaseInstance();
        this.startOffset = connectionProfile.startOffset;
        this.endOffset = connectionProfile.endOffset;
        this.currentOffset = connectionProfile.currentOffset;
        this.contentLength = connectionProfile.contentLength;
    }

    public void run() throws Throwable {
        FileDownloadOutputStream fileDownloadOutputStreamCreateOutputStream;
        String string;
        if (this.paused) {
            return;
        }
        long jFindContentLength = FileDownloadUtils.findContentLength(this.connectionIndex, this.connection);
        if (jFindContentLength == -1) {
            jFindContentLength = FileDownloadUtils.findContentLengthFromContentRange(this.connection);
        }
        if (jFindContentLength == 0) {
            throw new FileDownloadGiveUpRetryException(FileDownloadUtils.formatString("there isn't any content need to download on %d-%d with the content-length is 0", Integer.valueOf(this.downloadId), Integer.valueOf(this.connectionIndex)));
        }
        long j = this.contentLength;
        if (j > 0 && jFindContentLength != j) {
            if (this.endOffset == -1) {
                string = FileDownloadUtils.formatString("range[%d-)", Long.valueOf(this.currentOffset));
            } else {
                string = FileDownloadUtils.formatString("range[%d-%d)", Long.valueOf(this.currentOffset), Long.valueOf(this.endOffset));
            }
            throw new FileDownloadGiveUpRetryException(FileDownloadUtils.formatString("require %s with contentLength(%d), but the backend response contentLength is %d on downloadId[%d]-connectionIndex[%d], please ask your backend dev to fix such problem.", string, Long.valueOf(this.contentLength), Long.valueOf(jFindContentLength), Integer.valueOf(this.downloadId), Integer.valueOf(this.connectionIndex)));
        }
        long j2 = this.currentOffset;
        InputStream inputStream = null;
        try {
            boolean zIsSupportSeek = CustomComponentHolder.getImpl().isSupportSeek();
            if (this.hostRunnable != null && !zIsSupportSeek) {
                throw new IllegalAccessException("can't using multi-download when the output stream can't support seek");
            }
            fileDownloadOutputStreamCreateOutputStream = FileDownloadUtils.createOutputStream(this.path);
            try {
                this.outputStream = fileDownloadOutputStreamCreateOutputStream;
                if (zIsSupportSeek) {
                    fileDownloadOutputStreamCreateOutputStream.seek(this.currentOffset);
                }
                if (FileDownloadLog.NEED_LOG) {
                    FileDownloadLog.d(this, "start fetch(%d): range [%d, %d), seek to[%d]", Integer.valueOf(this.connectionIndex), Long.valueOf(this.startOffset), Long.valueOf(this.endOffset), Long.valueOf(this.currentOffset));
                }
                inputStream = this.connection.getInputStream();
                byte[] bArr = new byte[4096];
                if (this.paused) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fileDownloadOutputStreamCreateOutputStream != null) {
                        try {
                            sync();
                        } catch (Throwable th) {
                            try {
                                fileDownloadOutputStreamCreateOutputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                            throw th;
                        }
                    }
                    if (fileDownloadOutputStreamCreateOutputStream != null) {
                        try {
                            fileDownloadOutputStreamCreateOutputStream.close();
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            return;
                        }
                    }
                    return;
                }
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        try {
                            inputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                        if (fileDownloadOutputStreamCreateOutputStream != null) {
                            try {
                                sync();
                            } catch (Throwable th2) {
                                try {
                                    fileDownloadOutputStreamCreateOutputStream.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                                throw th2;
                            }
                        }
                        if (fileDownloadOutputStreamCreateOutputStream != null) {
                            try {
                                fileDownloadOutputStreamCreateOutputStream.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        long j3 = this.currentOffset - j2;
                        if (jFindContentLength != -1 && jFindContentLength != j3) {
                            throw new FileDownloadGiveUpRetryException(FileDownloadUtils.formatString("fetched length[%d] != content length[%d], range[%d, %d) offset[%d] fetch begin offset[%d]", Long.valueOf(j3), Long.valueOf(jFindContentLength), Long.valueOf(this.startOffset), Long.valueOf(this.endOffset), Long.valueOf(this.currentOffset), Long.valueOf(j2)));
                        }
                        this.callback.onCompleted(this.hostRunnable, this.startOffset, this.endOffset);
                        return;
                    }
                    fileDownloadOutputStreamCreateOutputStream.write(bArr, 0, i);
                    long j4 = i;
                    this.currentOffset += j4;
                    this.callback.onProgress(j4);
                    checkAndSync();
                    if (this.paused) {
                        try {
                            inputStream.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                        try {
                            sync();
                            try {
                                return;
                            } catch (IOException e8) {
                                return;
                            }
                        } finally {
                            try {
                                fileDownloadOutputStreamCreateOutputStream.close();
                            } catch (IOException e9) {
                                e9.printStackTrace();
                            }
                        }
                    }
                    if (this.isWifiRequired && FileDownloadUtils.isNetworkNotOnWifiType()) {
                        throw new FileDownloadNetworkPolicyException();
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e10) {
                        e10.printStackTrace();
                    }
                }
                if (fileDownloadOutputStreamCreateOutputStream != null) {
                    try {
                        sync();
                    } catch (Throwable th4) {
                        try {
                            fileDownloadOutputStreamCreateOutputStream.close();
                        } catch (IOException e11) {
                            e11.printStackTrace();
                        }
                        throw th4;
                    }
                }
                if (fileDownloadOutputStreamCreateOutputStream != null) {
                    try {
                        fileDownloadOutputStreamCreateOutputStream.close();
                        throw th;
                    } catch (IOException e12) {
                        e12.printStackTrace();
                        throw th;
                    }
                }
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            fileDownloadOutputStreamCreateOutputStream = null;
        }
    }

    public static class Builder {
        ProcessCallback callback;
        FileDownloadConnection connection;
        Integer connectionIndex;
        ConnectionProfile connectionProfile;
        Integer downloadId;
        DownloadRunnable downloadRunnable;
        Boolean isWifiRequired;
        String path;

        public Builder setCallback(ProcessCallback processCallback) {
            this.callback = processCallback;
            return this;
        }

        public Builder setConnection(FileDownloadConnection fileDownloadConnection) {
            this.connection = fileDownloadConnection;
            return this;
        }

        public Builder setConnectionIndex(int i) {
            this.connectionIndex = Integer.valueOf(i);
            return this;
        }

        public Builder setConnectionProfile(ConnectionProfile connectionProfile) {
            this.connectionProfile = connectionProfile;
            return this;
        }

        public Builder setDownloadId(int i) {
            this.downloadId = Integer.valueOf(i);
            return this;
        }

        public Builder setHost(DownloadRunnable downloadRunnable) {
            this.downloadRunnable = downloadRunnable;
            return this;
        }

        public Builder setPath(String str) {
            this.path = str;
            return this;
        }

        public Builder setWifiRequired(boolean z) {
            this.isWifiRequired = Boolean.valueOf(z);
            return this;
        }

        public FetchDataTask build() throws IllegalArgumentException {
            FileDownloadConnection fileDownloadConnection;
            ConnectionProfile connectionProfile;
            Integer num;
            if (this.isWifiRequired != null && (fileDownloadConnection = this.connection) != null && (connectionProfile = this.connectionProfile) != null && this.callback != null && this.path != null && (num = this.downloadId) != null && this.connectionIndex != null) {
                return new FetchDataTask(fileDownloadConnection, connectionProfile, this.downloadRunnable, num.intValue(), this.connectionIndex.intValue(), this.isWifiRequired.booleanValue(), this.callback, this.path, null);
            }
            throw new IllegalArgumentException();
        }
    }
}
