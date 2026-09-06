package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.mobads.sdk.api.FullScreenVideoAd;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.ScreenVideoAdListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class dh extends dj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private FullScreenVideoAd.FullScreenVideoAdListener f1807a;

    public dh(Context context, String str, boolean z) {
        super(context, str, z, IAdInterListener.AdProdType.PRODUCT_FULLSCREENVIDEO);
    }

    @Override // com.baidu.mobads.sdk.internal.dj
    public void a(ScreenVideoAdListener screenVideoAdListener) {
        super.a(screenVideoAdListener);
        if (screenVideoAdListener instanceof FullScreenVideoAd.FullScreenVideoAdListener) {
            this.f1807a = (FullScreenVideoAd.FullScreenVideoAdListener) screenVideoAdListener;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.dj, com.baidu.mobads.sdk.internal.bj
    protected void g(String str) {
        FullScreenVideoAd.FullScreenVideoAdListener fullScreenVideoAdListener = this.f1807a;
        if (fullScreenVideoAdListener != null) {
            fullScreenVideoAdListener.onAdSkip(Float.parseFloat(str));
        }
    }
}
