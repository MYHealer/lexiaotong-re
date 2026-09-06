package com.adprof.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class we extends s5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static IntentFilter f1500a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ye f799a;

    public we(ye yeVar, String str) {
        super(str);
        this.f799a = yeVar;
        a();
    }

    @Override // com.adprof.sdk.s5
    public IntentFilter a() {
        if (f1500a == null) {
            IntentFilter intentFilter = new IntentFilter();
            f1500a = intentFilter;
            intentFilter.addAction("action.native.temple.show");
            f1500a.addAction("action.native.temple.click");
            f1500a.addAction("action.native.temple.dismiss");
            f1500a.addAction("action.land.page.show");
            f1500a.addAction("action.land.page.dismiss");
        }
        return f1500a;
    }

    @Override // com.adprof.sdk.s5
    public void b() {
        super.b();
        this.f799a = null;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.f799a != null && a(intent)) {
            String action = intent.getAction();
            if (TextUtils.isEmpty(action)) {
                return;
            }
            action.getClass();
            action.hashCode();
            switch (action) {
                case "action.native.temple.dismiss":
                case "action.native.temple.click":
                case "action.native.temple.show":
                    this.f799a.getClass();
                    break;
                case "action.land.page.dismiss":
                    ((f0) this.f799a).i();
                    break;
                case "action.land.page.show":
                    ((f0) this.f799a).j();
                    break;
            }
        }
    }
}
