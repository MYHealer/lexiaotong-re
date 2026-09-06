package com.yfanads.android.adx.thirdpart.filedownload.download;

import android.os.Process;
import com.yfanads.android.adx.thirdpart.filedownload.connection.FileDownloadConnection;
import com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase;
import com.yfanads.android.adx.thirdpart.filedownload.exception.FileDownloadGiveUpRetryException;
import com.yfanads.android.adx.thirdpart.filedownload.model.ConnectionModel;
import com.yfanads.android.adx.thirdpart.filedownload.model.FileDownloadHeader;
import com.yfanads.android.adx.thirdpart.filedownload.model.FileDownloadModel;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadLog;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadUtils;
import java.io.IOException;
import java.net.SocketException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class DownloadRunnable implements Runnable {
    private final ProcessCallback callback;
    private final ConnectTask connectTask;
    final int connectionIndex;
    private final int downloadId;
    private FetchDataTask fetchDataTask;
    private final boolean isWifiRequired;
    private final String path;
    private volatile boolean paused;

    /* JADX INFO: renamed from: com.yfanads.android.adx.thirdpart.filedownload.download.DownloadRunnable$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public /* synthetic */ DownloadRunnable(int i, int i2, ConnectTask connectTask, ProcessCallback processCallback, boolean z, String str, AnonymousClass1 anonymousClass1) {
        this(i, i2, connectTask, processCallback, z, str);
    }

    private long getDownloadedOffset() {
        FileDownloadDatabase databaseInstance = CustomComponentHolder.getImpl().getDatabaseInstance();
        if (this.connectionIndex < 0) {
            FileDownloadModel fileDownloadModelFind = databaseInstance.find(this.downloadId);
            if (fileDownloadModelFind != null) {
                return fileDownloadModelFind.getSoFar();
            }
            return 0L;
        }
        for (ConnectionModel connectionModel : databaseInstance.findConnectionModel(this.downloadId)) {
            if (connectionModel.getIndex() == this.connectionIndex) {
                return connectionModel.getCurrentOffset();
            }
        }
        return 0L;
    }

    public void discard() {
        pause();
    }

    /* JADX WARN: Code duplicated, block: B:54:0x0103  */
    /* JADX WARN: Code duplicated, block: B:55:0x0105 A[Catch: all -> 0x00ef, TryCatch #7 {all -> 0x00ef, blocks: (B:3:0x0010, B:8:0x001a, B:10:0x002c, B:16:0x005a, B:17:0x008c, B:18:0x008d, B:22:0x009a, B:24:0x00d7, B:52:0x00fb, B:55:0x0105, B:57:0x0109, B:60:0x011a, B:62:0x011e, B:64:0x0128, B:65:0x012d, B:69:0x013a), top: B:76:0x0010 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x011e A[Catch: all -> 0x00ef, TryCatch #7 {all -> 0x00ef, blocks: (B:3:0x0010, B:8:0x001a, B:10:0x002c, B:16:0x005a, B:17:0x008c, B:18:0x008d, B:22:0x009a, B:24:0x00d7, B:52:0x00fb, B:55:0x0105, B:57:0x0109, B:60:0x011a, B:62:0x011e, B:64:0x0128, B:65:0x012d, B:69:0x013a), top: B:76:0x0010 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x0128 A[Catch: all -> 0x00ef, TryCatch #7 {all -> 0x00ef, blocks: (B:3:0x0010, B:8:0x001a, B:10:0x002c, B:16:0x005a, B:17:0x008c, B:18:0x008d, B:22:0x009a, B:24:0x00d7, B:52:0x00fb, B:55:0x0105, B:57:0x0109, B:60:0x011a, B:62:0x011e, B:64:0x0128, B:65:0x012d, B:69:0x013a), top: B:76:0x0010 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x0134  */
    /* JADX WARN: Code duplicated, block: B:87:0x013a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x0137 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:? A[RETURN, SYNTHETIC] */
    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Exception e;
        long downloadedOffset;
        Process.setThreadPriority(10);
        long j = this.connectTask.getProfile().currentOffset;
        FileDownloadConnection fileDownloadConnectionConnect = null;
        boolean z2 = false;
        while (!this.paused) {
            try {
                try {
                    try {
                        fileDownloadConnectionConnect = this.connectTask.connect();
                        int responseCode = fileDownloadConnectionConnect.getResponseCode();
                        z = true;
                        if (FileDownloadLog.NEED_LOG) {
                            FileDownloadLog.d(this, "the connection[%d] for %d, is connected %s with code[%d]", Integer.valueOf(this.connectionIndex), Integer.valueOf(this.downloadId), this.connectTask.getProfile(), Integer.valueOf(responseCode));
                        }
                        if (responseCode != 206 && responseCode != 200) {
                            throw new SocketException(FileDownloadUtils.formatString("Connection failed with request[%s] response[%s] http-state[%d] on task[%d-%d], which is changed after verify connection, so please try again.", this.connectTask.getRequestHeader(), fileDownloadConnectionConnect.getResponseHeaderFields(), Integer.valueOf(responseCode), Integer.valueOf(this.downloadId), Integer.valueOf(this.connectionIndex)));
                        }
                        try {
                            FetchDataTask.Builder builder = new FetchDataTask.Builder();
                            if (this.paused) {
                                fileDownloadConnectionConnect.ending();
                                return;
                            }
                            FetchDataTask fetchDataTaskBuild = builder.setDownloadId(this.downloadId).setConnectionIndex(this.connectionIndex).setCallback(this.callback).setHost(this).setWifiRequired(this.isWifiRequired).setConnection(fileDownloadConnectionConnect).setConnectionProfile(this.connectTask.getProfile()).setPath(this.path).build();
                            this.fetchDataTask = fetchDataTaskBuild;
                            fetchDataTaskBuild.run();
                            if (this.paused) {
                                this.fetchDataTask.pause();
                            }
                        } catch (FileDownloadGiveUpRetryException e2) {
                            e = e2;
                            if (!this.callback.isRetry(e)) {
                                this.callback.onError(e);
                                if (fileDownloadConnectionConnect == null) {
                                    return;
                                }
                            } else if (z || this.fetchDataTask != null) {
                                if (this.fetchDataTask != null) {
                                    downloadedOffset = getDownloadedOffset();
                                    if (downloadedOffset > 0) {
                                        this.connectTask.updateConnectionProfile(downloadedOffset);
                                    }
                                }
                                this.callback.onRetry(e);
                                if (fileDownloadConnectionConnect != null) {
                                    fileDownloadConnectionConnect.ending();
                                }
                                z2 = z;
                            } else {
                                FileDownloadLog.w(this, "it is valid to retry and connection is valid but create fetch-data-task failed, so give up directly with %s", e);
                                this.callback.onError(e);
                                if (fileDownloadConnectionConnect == null) {
                                    return;
                                }
                            }
                        } catch (IOException e3) {
                            e = e3;
                            if (!this.callback.isRetry(e)) {
                                if (z) {
                                }
                                if (this.fetchDataTask != null) {
                                    downloadedOffset = getDownloadedOffset();
                                    if (downloadedOffset > 0) {
                                        this.connectTask.updateConnectionProfile(downloadedOffset);
                                    }
                                }
                                this.callback.onRetry(e);
                                if (fileDownloadConnectionConnect != null) {
                                    fileDownloadConnectionConnect.ending();
                                }
                                z2 = z;
                            } else {
                                this.callback.onError(e);
                                if (fileDownloadConnectionConnect == null) {
                                    return;
                                }
                            }
                        } catch (IllegalAccessException e4) {
                            e = e4;
                            if (!this.callback.isRetry(e)) {
                                if (z) {
                                }
                                if (this.fetchDataTask != null) {
                                    downloadedOffset = getDownloadedOffset();
                                    if (downloadedOffset > 0) {
                                        this.connectTask.updateConnectionProfile(downloadedOffset);
                                    }
                                }
                                this.callback.onRetry(e);
                                if (fileDownloadConnectionConnect != null) {
                                    fileDownloadConnectionConnect.ending();
                                }
                                z2 = z;
                            } else {
                                this.callback.onError(e);
                                if (fileDownloadConnectionConnect == null) {
                                    return;
                                }
                            }
                        } catch (IllegalArgumentException e5) {
                            e = e5;
                            if (!this.callback.isRetry(e)) {
                                if (z) {
                                }
                                if (this.fetchDataTask != null) {
                                    downloadedOffset = getDownloadedOffset();
                                    if (downloadedOffset > 0) {
                                        this.connectTask.updateConnectionProfile(downloadedOffset);
                                    }
                                }
                                this.callback.onRetry(e);
                                if (fileDownloadConnectionConnect != null) {
                                    fileDownloadConnectionConnect.ending();
                                }
                                z2 = z;
                            } else {
                                this.callback.onError(e);
                                if (fileDownloadConnectionConnect == null) {
                                    return;
                                }
                            }
                        }
                    } catch (FileDownloadGiveUpRetryException | IOException | IllegalAccessException | IllegalArgumentException e6) {
                        e = e6;
                        z = false;
                    }
                } catch (Throwable th) {
                    if (fileDownloadConnectionConnect != null) {
                        fileDownloadConnectionConnect.ending();
                    }
                    throw th;
                }
            } catch (FileDownloadGiveUpRetryException | IOException | IllegalAccessException | IllegalArgumentException e7) {
                z = z2;
                e = e7;
            }
            fileDownloadConnectionConnect.ending();
            return;
        }
        if (fileDownloadConnectionConnect != null) {
            fileDownloadConnectionConnect.ending();
        }
    }

    private DownloadRunnable(int i, int i2, ConnectTask connectTask, ProcessCallback processCallback, boolean z, String str) {
        this.downloadId = i;
        this.connectionIndex = i2;
        this.paused = false;
        this.callback = processCallback;
        this.path = str;
        this.connectTask = connectTask;
        this.isWifiRequired = z;
    }

    public void pause() {
        this.paused = true;
        FetchDataTask fetchDataTask = this.fetchDataTask;
        if (fetchDataTask != null) {
            fetchDataTask.pause();
        }
    }

    public static class Builder {
        private ProcessCallback callback;
        private final ConnectTask.Builder connectTaskBuilder = new ConnectTask.Builder();
        private Integer connectionIndex;
        private Boolean isWifiRequired;
        private String path;

        public DownloadRunnable buildForTest(ConnectTask connectTask) {
            return new DownloadRunnable(connectTask.downloadId, 0, connectTask, this.callback, false, "", null);
        }

        public Builder setCallback(ProcessCallback processCallback) {
            this.callback = processCallback;
            return this;
        }

        public Builder setConnectionIndex(Integer num) {
            this.connectionIndex = num;
            return this;
        }

        public Builder setConnectionModel(ConnectionProfile connectionProfile) {
            this.connectTaskBuilder.setConnectionProfile(connectionProfile);
            return this;
        }

        public Builder setEtag(String str) {
            this.connectTaskBuilder.setEtag(str);
            return this;
        }

        public Builder setHeader(FileDownloadHeader fileDownloadHeader) {
            this.connectTaskBuilder.setHeader(fileDownloadHeader);
            return this;
        }

        public Builder setId(int i) {
            this.connectTaskBuilder.setDownloadId(i);
            return this;
        }

        public Builder setPath(String str) {
            this.path = str;
            return this;
        }

        public Builder setUrl(String str) {
            this.connectTaskBuilder.setUrl(str);
            return this;
        }

        public Builder setWifiRequired(boolean z) {
            this.isWifiRequired = Boolean.valueOf(z);
            return this;
        }

        public DownloadRunnable build() {
            if (this.callback != null && this.path != null && this.isWifiRequired != null && this.connectionIndex != null) {
                ConnectTask connectTaskBuild = this.connectTaskBuilder.build();
                return new DownloadRunnable(connectTaskBuild.downloadId, this.connectionIndex.intValue(), connectTaskBuild, this.callback, this.isWifiRequired.booleanValue(), this.path, null);
            }
            throw new IllegalArgumentException(FileDownloadUtils.formatString("%s %s %B", this.callback, this.path, this.isWifiRequired));
        }
    }
}
