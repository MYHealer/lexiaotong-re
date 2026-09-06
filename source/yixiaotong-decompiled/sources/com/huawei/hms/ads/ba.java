package com.huawei.hms.ads;

import com.huawei.hms.ads.jsb.inner.data.AppDownloadInfo;
import com.huawei.openalliance.ad.download.app.AppDownloadTask;
import com.huawei.openalliance.ad.download.app.AppStatus;
import com.huawei.openalliance.ad.inter.listeners.AppDownloadListener;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class ba extends av {
    private static final String Z = "JsbOnDownloadChange";

    public static class a implements AppDownloadListener {
        private String Code;
        private String I;
        private String V;
        private String Z;
        private Map<String, RemoteCallResultCallback<String>> B = Collections.synchronizedMap(new c(5));
        private Map<String, RemoteCallResultCallback<String>> C = Collections.synchronizedMap(new c(5));
        private Map<String, RemoteCallResultCallback<String>> S = Collections.synchronizedMap(new c(5));
        private Map<String, RemoteCallResultCallback<String>> F = Collections.synchronizedMap(new c(5));

        public a() {
            fh.Code("jsb", "DownloadListener init");
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
        public void Code(AppStatus appStatus, com.huawei.openalliance.ad.inter.data.AppInfo appInfo) {
            Map<String, RemoteCallResultCallback<String>> map = this.B;
            if (map == null || map.size() <= 0) {
                return;
            }
            for (Map.Entry<String, RemoteCallResultCallback<String>> entry : this.B.entrySet()) {
                if (entry != null) {
                    String key = entry.getKey();
                    RemoteCallResultCallback<String> value = entry.getValue();
                    if (value != null) {
                        ah.Code(value, this.Code, 1000, com.huawei.openalliance.ad.utils.ad.V(new AppDownloadInfo(appInfo, appStatus)), false);
                    }
                    if (appStatus == AppStatus.DOWNLOADFAILED) {
                        AppDownloadTask appDownloadTaskCode = com.huawei.openalliance.ad.download.app.g.I().Code(appInfo);
                        Map<String, RemoteCallResultCallback<String>> map2 = this.C;
                        if (map2 != null && map2.size() > 0 && this.C.get(key) != null) {
                            ah.Code(this.C.get(key), this.V, 1000, com.huawei.openalliance.ad.utils.ad.V(new AppDownloadInfo(appInfo, appDownloadTaskCode != null ? appDownloadTaskCode.S() : 0)), false);
                        }
                    }
                }
            }
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
        public void Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo) {
            if (fh.Code()) {
                fh.Code(ba.Z, "onAppOpen with appInfo");
            }
            Map<String, RemoteCallResultCallback<String>> map = this.S;
            if (map == null || map.size() <= 0) {
                return;
            }
            for (RemoteCallResultCallback<String> remoteCallResultCallback : this.S.values()) {
                if (remoteCallResultCallback != null) {
                    ah.Code(remoteCallResultCallback, this.I, 1000, com.huawei.openalliance.ad.utils.ad.V(new AppDownloadInfo(appInfo, AppStatus.INSTALLED)), false);
                }
            }
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
        public void Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo, int i) {
            AppDownloadTask appDownloadTaskCode = com.huawei.openalliance.ad.download.app.g.I().Code(appInfo);
            if (appDownloadTaskCode != null) {
                Code(com.huawei.hms.ads.utils.a.Code(appDownloadTaskCode), appInfo);
            }
            Map<String, RemoteCallResultCallback<String>> map = this.C;
            if (map == null || map.size() <= 0) {
                return;
            }
            Iterator<RemoteCallResultCallback<String>> it = this.C.values().iterator();
            while (it.hasNext()) {
                ah.Code(it.next(), this.V, 1000, com.huawei.openalliance.ad.utils.ad.V(new AppDownloadInfo(appInfo, i)), false);
            }
        }

        public void Code(RemoteCallResultCallback<String> remoteCallResultCallback, String str, String str2) {
            this.B.put(str2, remoteCallResultCallback);
            this.Code = str;
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
        public void Code(String str) {
        }

        public void I(RemoteCallResultCallback<String> remoteCallResultCallback, String str, String str2) {
            this.S.put(str2, remoteCallResultCallback);
            this.I = str;
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
        public void V(com.huawei.openalliance.ad.inter.data.AppInfo appInfo) {
            if (com.huawei.openalliance.ad.utils.al.Code(this.F)) {
                return;
            }
            for (RemoteCallResultCallback<String> remoteCallResultCallback : this.F.values()) {
                if (remoteCallResultCallback != null) {
                    ah.Code(remoteCallResultCallback, this.Z, 1000, com.huawei.openalliance.ad.utils.ad.V(new AppDownloadInfo(appInfo, AppStatus.DOWNLOAD)), false);
                }
            }
        }

        public void V(RemoteCallResultCallback<String> remoteCallResultCallback, String str, String str2) {
            this.C.put(str2, remoteCallResultCallback);
            this.V = str;
        }

        public void Z(RemoteCallResultCallback<String> remoteCallResultCallback, String str, String str2) {
            this.F.put(str2, remoteCallResultCallback);
            this.Z = str;
        }
    }

    private static class b {
        private static a Code = new a();

        static {
            fh.Code(ba.Z, "register global Jsb app download Listener.");
            com.huawei.openalliance.ad.download.a.Code().Z(Code);
        }

        private b() {
        }
    }

    static class c<K, V> extends LinkedHashMap<K, V> {
        private static final long Code = 8139502072983476335L;
        private final int V;

        c(int i) {
            this.V = i;
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
            return size() > this.V;
        }
    }

    public ba(String str) {
        super(str);
    }

    protected a V() {
        return b.Code;
    }
}
