package com.meishu.sdk.core.webview.listener;

/* JADX INFO: compiled from: OnJsEventProxyListener.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f4986a;

    public e(d dVar) {
        this.f4986a = dVar;
    }

    @Override // com.meishu.sdk.core.webview.listener.d
    public boolean clickAppDownloadInfo(String str) {
        d dVar = this.f4986a;
        if (dVar != null) {
            return dVar.clickAppDownloadInfo(str);
        }
        return false;
    }

    @Override // com.meishu.sdk.core.webview.listener.d
    public void dismissAd() {
        d dVar = this.f4986a;
        if (dVar != null) {
            dVar.dismissAd();
        }
    }

    @Override // com.meishu.sdk.core.webview.listener.d
    public String getActivityState() {
        d dVar = this.f4986a;
        return dVar != null ? dVar.getActivityState() : "";
    }

    @Override // com.meishu.sdk.core.webview.listener.d
    public String getDeviceInfo() {
        d dVar = this.f4986a;
        return dVar != null ? dVar.getDeviceInfo() : "";
    }

    @Override // com.meishu.sdk.core.webview.listener.d
    public boolean isAppBackground() {
        d dVar = this.f4986a;
        if (dVar != null) {
            return dVar.isAppBackground();
        }
        return false;
    }

    @Override // com.meishu.sdk.core.webview.listener.d
    public boolean isSoundsOpen() {
        d dVar = this.f4986a;
        if (dVar != null) {
            return dVar.isSoundsOpen();
        }
        return false;
    }

    @Override // com.meishu.sdk.core.webview.listener.d
    public void notifyRewarded() {
        d dVar = this.f4986a;
        if (dVar != null) {
            dVar.notifyRewarded();
        }
    }

    @Override // com.meishu.sdk.core.webview.listener.d
    public boolean setShakeOrTurnState(boolean z) {
        d dVar = this.f4986a;
        return dVar != null ? dVar.setShakeOrTurnState(z) : z;
    }

    @Override // com.meishu.sdk.core.webview.listener.d
    public void setSoundsOpen(boolean z) {
        d dVar = this.f4986a;
        if (dVar != null) {
            dVar.setSoundsOpen(z);
        }
    }

    @Override // com.meishu.sdk.core.webview.listener.d
    public void setVideoPlayState(boolean z) {
        d dVar = this.f4986a;
        if (dVar != null) {
            dVar.setVideoPlayState(z);
        }
    }
}
