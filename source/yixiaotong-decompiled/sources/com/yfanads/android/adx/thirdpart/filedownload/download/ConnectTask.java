package com.yfanads.android.adx.thirdpart.filedownload.download;

import android.text.TextUtils;
import com.yfanads.android.adx.thirdpart.filedownload.connection.FileDownloadConnection;
import com.yfanads.android.adx.thirdpart.filedownload.connection.RedirectHandler;
import com.yfanads.android.adx.thirdpart.filedownload.model.FileDownloadHeader;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadLog;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadUtils;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class ConnectTask {
    final int downloadId;
    private String etag;
    final FileDownloadHeader header;
    private ConnectionProfile profile;
    private List<String> redirectedUrlList;
    private Map<String, List<String>> requestHeader;
    final String url;

    /* JADX INFO: renamed from: com.yfanads.android.adx.thirdpart.filedownload.download.ConnectTask$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class Reconnect extends Throwable {
        public Reconnect() {
        }
    }

    public /* synthetic */ ConnectTask(ConnectionProfile connectionProfile, int i, String str, String str2, FileDownloadHeader fileDownloadHeader, AnonymousClass1 anonymousClass1) {
        this(connectionProfile, i, str, str2, fileDownloadHeader);
    }

    private void addRangeHeader(FileDownloadConnection fileDownloadConnection) throws ProtocolException {
        if (fileDownloadConnection.dispatchAddResumeOffset(this.etag, this.profile.startOffset)) {
            return;
        }
        if (!TextUtils.isEmpty(this.etag)) {
            fileDownloadConnection.addHeader("If-Match", this.etag);
        }
        this.profile.processProfile(fileDownloadConnection);
    }

    private void fixNeededHeader(FileDownloadConnection fileDownloadConnection) {
        FileDownloadHeader fileDownloadHeader = this.header;
        if (fileDownloadHeader == null || fileDownloadHeader.getHeaders().get("User-Agent") == null) {
            fileDownloadConnection.addHeader("User-Agent", FileDownloadUtils.defaultUserAgent());
        }
    }

    public FileDownloadConnection connect() throws IllegalAccessException, IOException {
        FileDownloadConnection fileDownloadConnectionCreateConnection = CustomComponentHolder.getImpl().createConnection(this.url);
        addUserRequiredHeader(fileDownloadConnectionCreateConnection);
        addRangeHeader(fileDownloadConnectionCreateConnection);
        fixNeededHeader(fileDownloadConnectionCreateConnection);
        this.requestHeader = fileDownloadConnectionCreateConnection.getRequestHeaderFields();
        if (FileDownloadLog.NEED_LOG) {
            FileDownloadLog.d(this, "<---- %s request header %s", Integer.valueOf(this.downloadId), this.requestHeader);
        }
        fileDownloadConnectionCreateConnection.execute();
        ArrayList arrayList = new ArrayList();
        this.redirectedUrlList = arrayList;
        FileDownloadConnection fileDownloadConnectionProcess = RedirectHandler.process(this.requestHeader, fileDownloadConnectionCreateConnection, arrayList);
        if (FileDownloadLog.NEED_LOG) {
            FileDownloadLog.d(this, "----> %s response header %s", Integer.valueOf(this.downloadId), fileDownloadConnectionProcess.getResponseHeaderFields());
        }
        return fileDownloadConnectionProcess;
    }

    public String getFinalRedirectedUrl() {
        List<String> list = this.redirectedUrlList;
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<String> list2 = this.redirectedUrlList;
        return list2.get(list2.size() - 1);
    }

    public ConnectionProfile getProfile() {
        return this.profile;
    }

    public Map<String, List<String>> getRequestHeader() {
        return this.requestHeader;
    }

    public boolean isRangeNotFromBeginning() {
        return this.profile.currentOffset > 0;
    }

    public void retryOnConnectedWithNewParam(ConnectionProfile connectionProfile, String str) throws Reconnect {
        if (connectionProfile == null) {
            throw new IllegalArgumentException();
        }
        this.profile = connectionProfile;
        this.etag = str;
        throw new Reconnect();
    }

    public void updateConnectionProfile(long j) {
        ConnectionProfile connectionProfile = this.profile;
        long j2 = connectionProfile.currentOffset;
        if (j == j2) {
            FileDownloadLog.w(this, "no data download, no need to update", new Object[0]);
            return;
        }
        ConnectionProfile connectionProfileBuildConnectionProfile = ConnectionProfile.ConnectionProfileBuild.buildConnectionProfile(connectionProfile.startOffset, j, connectionProfile.endOffset, connectionProfile.contentLength - (j - j2));
        this.profile = connectionProfileBuildConnectionProfile;
        if (FileDownloadLog.NEED_LOG) {
            FileDownloadLog.i(this, "after update profile:%s", connectionProfileBuildConnectionProfile);
        }
    }

    private ConnectTask(ConnectionProfile connectionProfile, int i, String str, String str2, FileDownloadHeader fileDownloadHeader) {
        this.downloadId = i;
        this.url = str;
        this.etag = str2;
        this.header = fileDownloadHeader;
        this.profile = connectionProfile;
    }

    private void addUserRequiredHeader(FileDownloadConnection fileDownloadConnection) {
        HashMap<String, List<String>> headers;
        FileDownloadHeader fileDownloadHeader = this.header;
        if (fileDownloadHeader == null || (headers = fileDownloadHeader.getHeaders()) == null) {
            return;
        }
        if (FileDownloadLog.NEED_LOG) {
            FileDownloadLog.v(this, "%d add outside header: %s", Integer.valueOf(this.downloadId), headers);
        }
        for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (value != null) {
                Iterator<String> it = value.iterator();
                while (it.hasNext()) {
                    fileDownloadConnection.addHeader(key, it.next());
                }
            }
        }
    }

    public static class Builder {
        private ConnectionProfile connectionProfile;
        private Integer downloadId;
        private String etag;
        private FileDownloadHeader header;
        private String url;

        public Builder setConnectionProfile(ConnectionProfile connectionProfile) {
            this.connectionProfile = connectionProfile;
            return this;
        }

        public Builder setDownloadId(int i) {
            this.downloadId = Integer.valueOf(i);
            return this;
        }

        public Builder setEtag(String str) {
            this.etag = str;
            return this;
        }

        public Builder setHeader(FileDownloadHeader fileDownloadHeader) {
            this.header = fileDownloadHeader;
            return this;
        }

        public Builder setUrl(String str) {
            this.url = str;
            return this;
        }

        public ConnectTask build() {
            ConnectionProfile connectionProfile;
            Integer num = this.downloadId;
            if (num != null && (connectionProfile = this.connectionProfile) != null && this.url != null) {
                return new ConnectTask(connectionProfile, num.intValue(), this.url, this.etag, this.header, null);
            }
            throw new IllegalArgumentException();
        }
    }
}
