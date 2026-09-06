package com.adprof.sdk;

import java.util.TimerTask;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class wg extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1502a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ yg f802a;

    public wg(yg ygVar, int i) {
        this.f802a = ygVar;
        this.f1502a = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        try {
            yg ygVar = this.f802a;
            if (ygVar.f858b) {
                ygVar.b = this.f1502a;
            } else {
                fn.a(new vg(this), 0L);
                this.f1502a--;
            }
        } catch (Exception e) {
            pk.b("OpenAdManager", "Error in countdown task: " + e.getMessage());
            yg.a(this.f802a);
        }
    }
}
