package com.adprof.sdk;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class mn extends HandlerThread {
    public mn(String str) {
        super(str);
    }

    @Override // android.os.HandlerThread
    public void onLooperPrepared() {
        super.onLooperPrepared();
        new Handler(getLooper());
        Handler handler = nn.f1329a;
    }
}
