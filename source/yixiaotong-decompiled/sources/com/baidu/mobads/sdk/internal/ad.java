package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.XAdNativeResponse;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class ad implements g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BaiduNativeManager.FeedAdListener f1713a;

    public ad(BaiduNativeManager.FeedAdListener feedAdListener) {
        this.f1713a = feedAdListener;
    }

    @Override // com.baidu.mobads.sdk.internal.g.a
    public void a(List<NativeResponse> list) {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f1713a;
        if (feedAdListener != null) {
            feedAdListener.onNativeLoad(list);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.g.a
    public void a(int i, String str, NativeResponse nativeResponse) {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f1713a;
        if (feedAdListener != null) {
            feedAdListener.onNoAd(i, str, nativeResponse);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.g.a
    public void b(int i, String str, NativeResponse nativeResponse) {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f1713a;
        if (feedAdListener != null) {
            feedAdListener.onNativeFail(i, str, nativeResponse);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.g.a
    public void a(NativeResponse nativeResponse) {
        if (nativeResponse instanceof XAdNativeResponse) {
            ((XAdNativeResponse) nativeResponse).onADExposed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.g.a
    public void a(NativeResponse nativeResponse, int i) {
        if (nativeResponse instanceof XAdNativeResponse) {
            ((XAdNativeResponse) nativeResponse).onADExposureFailed(i);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.g.a
    public void b(NativeResponse nativeResponse) {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f1713a;
        if (feedAdListener != null && (feedAdListener instanceof BaiduNativeManager.PortraitVideoAdListener)) {
            ((BaiduNativeManager.PortraitVideoAdListener) feedAdListener).onAdClick();
        } else if (nativeResponse instanceof XAdNativeResponse) {
            ((XAdNativeResponse) nativeResponse).onAdClick();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.g.a
    public void a() {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f1713a;
        if (feedAdListener != null) {
            feedAdListener.onLpClosed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.g.a
    public void b() {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f1713a;
        if (feedAdListener != null) {
            feedAdListener.onVideoDownloadSuccess();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.g.a
    public void c() {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f1713a;
        if (feedAdListener != null) {
            feedAdListener.onVideoDownloadFailed();
        }
    }
}
