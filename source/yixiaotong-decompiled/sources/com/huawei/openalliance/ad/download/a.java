package com.huawei.openalliance.ad.download;

import com.huawei.openalliance.ad.download.app.AppStatus;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.inter.listeners.AppDownloadListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class a implements AppDownloadListener {
    private static final String Code = "AppDownloadListenerRegister";
    private static final String I = "outer_listener_key";
    private static final String Z = "jsb_listener_key";
    private final CopyOnWriteArraySet<AppDownloadListener> B;
    private Map<String, AppDownloadListener> V;

    /* JADX INFO: renamed from: com.huawei.openalliance.ad.download.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: renamed from: com.huawei.openalliance.ad.download.a$a, reason: collision with other inner class name */
    private static class C0531a {
        private static a Code = new a(null);

        private C0531a() {
        }
    }

    private a() {
        this.V = new ConcurrentHashMap();
        this.B = new CopyOnWriteArraySet<>();
        com.huawei.openalliance.ad.download.app.g.I().Code(this);
    }

    /* synthetic */ a(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static a Code() {
        return C0531a.Code;
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
    public void Code(AppStatus appStatus, AppInfo appInfo) {
        for (AppDownloadListener appDownloadListener : this.V.values()) {
            if (appDownloadListener != null) {
                appDownloadListener.Code(appStatus, appInfo);
            }
        }
        for (AppDownloadListener appDownloadListener2 : this.B) {
            if (appDownloadListener2 != null) {
                appDownloadListener2.Code(appStatus, appInfo);
            }
        }
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
    public void Code(AppInfo appInfo) {
        for (AppDownloadListener appDownloadListener : this.V.values()) {
            if (appDownloadListener != null) {
                appDownloadListener.Code(appInfo);
            }
        }
        for (AppDownloadListener appDownloadListener2 : this.B) {
            if (appDownloadListener2 != null) {
                appDownloadListener2.Code(appInfo);
            }
        }
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
    public void Code(AppInfo appInfo, int i) {
        for (AppDownloadListener appDownloadListener : this.V.values()) {
            if (appDownloadListener != null) {
                appDownloadListener.Code(appInfo, i);
            }
        }
        for (AppDownloadListener appDownloadListener2 : this.B) {
            if (appDownloadListener2 != null) {
                appDownloadListener2.Code(appInfo, i);
            }
        }
    }

    public void Code(AppDownloadListener appDownloadListener) {
        if (appDownloadListener == null) {
            this.V.remove(I);
        } else {
            this.V.put(I, appDownloadListener);
        }
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
    public void Code(String str) {
        for (AppDownloadListener appDownloadListener : this.V.values()) {
            if (appDownloadListener != null) {
                appDownloadListener.Code(str);
            }
        }
        for (AppDownloadListener appDownloadListener2 : this.B) {
            if (appDownloadListener2 != null) {
                appDownloadListener2.Code(str);
            }
        }
    }

    public void I(AppDownloadListener appDownloadListener) {
        if (appDownloadListener == null) {
            return;
        }
        this.B.remove(appDownloadListener);
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
    public void V(AppInfo appInfo) {
        for (AppDownloadListener appDownloadListener : this.V.values()) {
            if (appDownloadListener != null) {
                appDownloadListener.V(appInfo);
            }
        }
        for (AppDownloadListener appDownloadListener2 : this.B) {
            if (appDownloadListener2 != null) {
                appDownloadListener2.V(appInfo);
            }
        }
    }

    public void V(AppDownloadListener appDownloadListener) {
        if (appDownloadListener == null) {
            return;
        }
        this.B.add(appDownloadListener);
    }

    public void Z(AppDownloadListener appDownloadListener) {
        if (appDownloadListener == null) {
            this.V.remove(Z);
        } else {
            this.V.put(Z, appDownloadListener);
        }
    }
}
