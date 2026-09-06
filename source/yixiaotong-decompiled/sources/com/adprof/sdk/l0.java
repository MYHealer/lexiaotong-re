package com.adprof.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.adprof.sdk.api.ApkDownloadListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class l0 extends s5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IntentFilter f1275a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public g7 f434a;

    public l0(g7 g7Var, String str) {
        super(str);
        this.f434a = g7Var;
    }

    @Override // com.adprof.sdk.s5
    public IntentFilter a() {
        if (this.f1275a == null) {
            IntentFilter intentFilter = new IntentFilter();
            this.f1275a = intentFilter;
            intentFilter.addAction("action.ad.download.start");
            this.f1275a.addAction("action.ad.download.end");
            this.f1275a.addAction("action.ad.download.fail");
            this.f1275a.addAction("action.ad.install.start");
            this.f1275a.addAction("action.ad.install.end");
        }
        return this.f1275a;
    }

    @Override // com.adprof.sdk.s5
    public void b() {
        super.b();
        this.f434a = null;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action;
        qh.a(context);
        qh.a(intent);
        if (this.f434a == null || !a(intent) || (action = intent.getAction()) == null) {
            return;
        }
        boolean zEqualsIgnoreCase = "1".equalsIgnoreCase(intent.getStringExtra("result"));
        long longExtra = intent.getLongExtra("downloadId", -1L);
        action.getClass();
        action.hashCode();
        switch (action) {
            case "action.ad.install.start":
                cf cfVar = (cf) this.f434a;
                cfVar.getClass();
                pk.a("NativeUnifiedAd InstallAPKStart: " + zEqualsIgnoreCase + " l:" + cfVar.f1111a.f1128a);
                ApkDownloadListener apkDownloadListener = cfVar.f1111a.f1128a;
                if (apkDownloadListener != null) {
                    apkDownloadListener.onInstallStart(zEqualsIgnoreCase);
                    break;
                }
                break;
            case "action.ad.install.end":
                cf cfVar2 = (cf) this.f434a;
                cfVar2.getClass();
                pk.a("NativeUnifiedAd InstallAPKEnd: " + zEqualsIgnoreCase + " l:" + cfVar2.f1111a.f1128a);
                ApkDownloadListener apkDownloadListener2 = cfVar2.f1111a.f1128a;
                if (apkDownloadListener2 != null) {
                    apkDownloadListener2.onInstallEnd(zEqualsIgnoreCase);
                    break;
                }
                break;
            case "action.ad.download.end":
                cf cfVar3 = (cf) this.f434a;
                cfVar3.getClass();
                pk.a("NativeUnifiedAd DownloadAPKEnd: " + zEqualsIgnoreCase + " id: " + longExtra + " l:" + cfVar3.f1111a.f1128a);
                ApkDownloadListener apkDownloadListener3 = cfVar3.f1111a.f1128a;
                if (apkDownloadListener3 != null) {
                    apkDownloadListener3.onDownloadEnd(zEqualsIgnoreCase);
                    break;
                }
                break;
            case "action.ad.download.start":
                cf cfVar4 = (cf) this.f434a;
                cfVar4.getClass();
                pk.a("NativeUnifiedAd DownloadAPKStart: " + zEqualsIgnoreCase + " id: " + longExtra + " l:" + cfVar4.f1111a.f1128a);
                ApkDownloadListener apkDownloadListener4 = cfVar4.f1111a.f1128a;
                if (apkDownloadListener4 != null) {
                    apkDownloadListener4.onDownloadStart(zEqualsIgnoreCase);
                    break;
                }
                break;
        }
    }
}
