package com.yfanads.android.adx.thirdpart.filedownload.download;

import com.yfanads.android.adx.thirdpart.filedownload.connection.FileDownloadConnection;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadProperties;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadUtils;
import java.net.ProtocolException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class ConnectionProfile {
    static final int RANGE_INFINITE = -1;
    final long contentLength;
    final long currentOffset;
    final long endOffset;
    private final boolean isForceNoRange;
    private final boolean isTrialConnect;
    final long startOffset;

    /* JADX INFO: renamed from: com.yfanads.android.adx.thirdpart.filedownload.download.ConnectionProfile$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class ConnectionProfileBuild {
        public static ConnectionProfile buildBeginToEndConnectionProfile(long j) {
            return new ConnectionProfile(0L, 0L, -1L, j, (AnonymousClass1) null);
        }

        public static ConnectionProfile buildConnectionProfile(long j, long j2, long j3, long j4) {
            return new ConnectionProfile(j, j2, j3, j4, (AnonymousClass1) null);
        }

        public static ConnectionProfile buildToEndConnectionProfile(long j, long j2, long j3) {
            return new ConnectionProfile(j, j2, -1L, j3, (AnonymousClass1) null);
        }

        public static ConnectionProfile buildTrialConnectionProfile() {
            return new ConnectionProfile(null);
        }

        public static ConnectionProfile buildTrialConnectionProfileNoRange() {
            return new ConnectionProfile(0L, 0L, 0L, 0L, true, null);
        }
    }

    public /* synthetic */ ConnectionProfile(long j, long j2, long j3, long j4, AnonymousClass1 anonymousClass1) {
        this(j, j2, j3, j4);
    }

    public /* synthetic */ ConnectionProfile(long j, long j2, long j3, long j4, boolean z, AnonymousClass1 anonymousClass1) {
        this(j, j2, j3, j4, z);
    }

    public String toString() {
        return FileDownloadUtils.formatString("range[%d, %d) current offset[%d]", Long.valueOf(this.startOffset), Long.valueOf(this.endOffset), Long.valueOf(this.currentOffset));
    }

    public /* synthetic */ ConnectionProfile(AnonymousClass1 anonymousClass1) {
        this();
    }

    public void processProfile(FileDownloadConnection fileDownloadConnection) throws ProtocolException {
        String string;
        if (this.isForceNoRange) {
            return;
        }
        if (this.isTrialConnect && FileDownloadProperties.getImpl().trialConnectionHeadMethod) {
            fileDownloadConnection.setRequestMethod("HEAD");
        }
        if (this.endOffset == -1) {
            string = FileDownloadUtils.formatString("bytes=%d-", Long.valueOf(this.currentOffset));
        } else {
            string = FileDownloadUtils.formatString("bytes=%d-%d", Long.valueOf(this.currentOffset), Long.valueOf(this.endOffset));
        }
        fileDownloadConnection.addHeader("Range", string);
    }

    private ConnectionProfile() {
        this.startOffset = 0L;
        this.currentOffset = 0L;
        this.endOffset = 0L;
        this.contentLength = 0L;
        this.isForceNoRange = false;
        this.isTrialConnect = true;
    }

    private ConnectionProfile(long j, long j2, long j3, long j4) {
        this(j, j2, j3, j4, false);
    }

    private ConnectionProfile(long j, long j2, long j3, long j4, boolean z) {
        if (!(j == 0 && j3 == 0) && z) {
            throw new IllegalArgumentException();
        }
        this.startOffset = j;
        this.currentOffset = j2;
        this.endOffset = j3;
        this.contentLength = j4;
        this.isForceNoRange = z;
        this.isTrialConnect = false;
    }
}
