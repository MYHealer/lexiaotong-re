package com.yfanads.android.libs.net;

import com.yfanads.android.libs.utils.Util;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class LocationCallBack {
    protected boolean toggleMain;

    public LocationCallBack(boolean z) {
        this.toggleMain = z;
    }

    /* JADX INFO: renamed from: onResponse, reason: merged with bridge method [inline-methods] */
    public abstract void m1258lambda$onResult$0$comyfanadsandroidlibsnetLocationCallBack(String str);

    public void onResult(final String str) {
        Util.MAIN_HANDLER.post(new Runnable() { // from class: com.yfanads.android.libs.net.LocationCallBack$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1258lambda$onResult$0$comyfanadsandroidlibsnetLocationCallBack(str);
            }
        });
    }
}
