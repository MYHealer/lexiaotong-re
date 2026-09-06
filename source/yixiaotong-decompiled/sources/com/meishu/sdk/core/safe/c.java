package com.meishu.sdk.core.safe;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: compiled from: SafeHandler.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c extends Handler {
    public c() {
    }

    public void a(Message message) {
        super.handleMessage(message);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        try {
            a(message);
        } catch (Throwable th) {
            th.printStackTrace();
            com.meishu.sdk.core.exception.a.a(th);
        }
    }

    public c(Looper looper) {
        super(looper);
    }
}
