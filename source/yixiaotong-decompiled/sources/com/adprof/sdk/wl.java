package com.adprof.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.adprof.sdk.api.AdError;
import com.huawei.openalliance.ad.constant.br;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class wl extends s5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static IntentFilter f1506a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f809a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public hm f810a;

    public wl(d dVar, hm hmVar, String str) {
        super(str);
        this.f809a = dVar;
        this.f810a = hmVar;
        a();
    }

    @Override // com.adprof.sdk.s5
    public IntentFilter a() {
        if (f1506a == null) {
            IntentFilter intentFilter = new IntentFilter();
            f1506a = intentFilter;
            intentFilter.addAction("action.splash.play");
            f1506a.addAction("action.splash.click");
            f1506a.addAction("action.splash.close");
            f1506a.addAction("action.splash.play.error");
            f1506a.addAction("action.land.page.show");
            f1506a.addAction("action.land.page.dismiss");
        }
        return f1506a;
    }

    @Override // com.adprof.sdk.s5
    public void b() {
        super.b();
        this.f810a = null;
        this.f809a = null;
        f1506a = null;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        qh.a(context);
        qh.a(intent);
        if (this.f810a != null && a(intent)) {
            String action = intent.getAction();
            boolean booleanExtra = intent.getBooleanExtra("isSkip", false);
            if (action != null) {
                action.hashCode();
                switch (action) {
                    case "action.splash.play":
                        this.f810a.a(this.f809a);
                        break;
                    case "action.splash.play.error":
                        String stringExtra = intent.getStringExtra("error");
                        hm hmVar = this.f810a;
                        hmVar.getClass();
                        AdError adError = AdError.ERROR_AD_PLAY;
                        adError.setMessage(stringExtra);
                        hmVar.a(adError, false, br.b.V);
                        hmVar.m654a();
                        break;
                    case "action.splash.click":
                        this.f810a.c();
                        break;
                    case "action.splash.close":
                        this.f810a.a(booleanExtra);
                        break;
                    case "action.land.page.dismiss":
                        this.f810a.d();
                        break;
                    case "action.land.page.show":
                        this.f810a.e();
                        break;
                }
            }
        }
    }
}
