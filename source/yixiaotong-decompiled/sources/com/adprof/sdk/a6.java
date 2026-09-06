package com.adprof.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class a6 extends q5 {
    public a6(Activity activity, String str, r5 r5Var) {
        super(activity, str, r5Var);
    }

    public void b(Context context, int i, Bundle bundle, d dVar) {
        try {
            a(StubApp.getOrigApplicationContext(context.getApplicationContext()), i, bundle, dVar);
            boolean z = bundle.getBoolean("enableKeepOn", false);
            boolean z2 = bundle.getBoolean("enableScreenLockDisplayAd", false);
            if (Build.VERSION.SDK_INT >= 27) {
                if (z) {
                    a().setTurnScreenOn(true);
                }
                if (z2) {
                    a().setShowWhenLocked(true);
                    a().setTurnScreenOn(true);
                }
                if (z) {
                    a().getWindow().addFlags(128);
                }
                if (!z2) {
                    return;
                }
            } else {
                if (z) {
                    a().getWindow().addFlags(128);
                }
                if (!z2) {
                    return;
                }
            }
            a().getWindow().addFlags(2621440);
        } catch (Throwable th) {
            pk.b("optionSetting error", th);
        }
    }
}
