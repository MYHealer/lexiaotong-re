package com.adprof.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class vp implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ wp f1487a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f785a;

    public vp(wp wpVar, String str) {
        this.f1487a = wpVar;
        this.f785a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        wp wpVar = this.f1487a;
        String str = this.f785a;
        synchronized (wpVar.f816c) {
            wpVar.f813a.edit().putString("read_second_chapter", str).apply();
        }
    }
}
