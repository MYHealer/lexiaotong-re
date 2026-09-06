package com.meishu.sdk.core.webview;

/* JADX INFO: compiled from: WebJsReadyChecker.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Boolean f4984a = null;

    public final void a(boolean z) {
        if (this.f4984a != null) {
            return;
        }
        this.f4984a = Boolean.valueOf(z);
        boolean zBooleanValue = this.f4984a.booleanValue();
        a.C0820a c0820a = (a.C0820a) this;
        try {
            com.meishu.sdk.core.webview.listener.d dVar = a.this.g;
            if (dVar != null) {
                dVar.onWebReady(zBooleanValue);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            com.meishu.sdk.core.webview.listener.c cVar = a.this.f;
            if (cVar != null) {
                cVar.a(zBooleanValue);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
