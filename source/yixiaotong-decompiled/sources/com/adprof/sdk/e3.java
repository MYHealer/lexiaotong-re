package com.adprof.sdk;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.ExoPlayer;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class e3 {
    public static c3 a(Context context) {
        ea eaVar = new ea();
        eaVar.f1146a = context;
        if (!eaVar.a(context)) {
            return null;
        }
        c3 c3Var = eaVar.f240a;
        try {
            String string = Settings.Global.getString(context.getContentResolver(), "oaid");
            if (!TextUtils.isEmpty(string)) {
                c3Var.f168a = false;
                c3Var.f1099a = string;
                pk.a("AdvertisingIdPlatform", "use global oaid");
                return c3Var;
            }
        } catch (Exception unused) {
        }
        try {
            pk.a("AdvertisingIdPlatform", "bindService start");
            Intent intent = new Intent("com.hihonor.id.HnOaIdService");
            intent.setPackage("com.hihonor.id");
            context.bindService(intent, eaVar, 1);
            eaVar.f243a.await(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
            eaVar.a();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("AdvertisingIdPlatform", "getAdvertisingIdInfo error=" + e.getMessage());
            eaVar.a();
        }
        return c3Var;
    }
}
