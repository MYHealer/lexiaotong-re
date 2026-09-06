package com.kwad.sdk.utils;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class cc extends Handler {
    private WeakReference<a> brA;

    public interface a {
        void a(Message message);
    }

    public cc(a aVar) {
        this.brA = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        a aVar;
        try {
            WeakReference<a> weakReference = this.brA;
            if (weakReference == null || (aVar = weakReference.get()) == null) {
                return;
            } else {
                aVar.a(message);
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
        super.handleMessage(message);
    }
}
