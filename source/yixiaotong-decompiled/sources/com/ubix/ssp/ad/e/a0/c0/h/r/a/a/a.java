package com.ubix.ssp.ad.e.a0.c0.h.r.a.a;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.android.exoplayer2.ExoPlayer;
import com.ubix.ssp.ad.e.a0.u;
import com.ubix.ssp.ad.e.a0.v;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: com.ubix.ssp.ad.e.a0.c0.h.r.a.a.a$a, reason: collision with other inner class name */
    public static final class C1066a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8666a;
        public boolean b;
    }

    private a() {
    }

    public static C1066a a(Context context) {
        b bVar = new b();
        bVar.b = context;
        if (!bVar.a(context)) {
            return null;
        }
        C1066a c1066a = bVar.f8667a;
        try {
            String string = Settings.Global.getString(context.getContentResolver(), "oaid");
            if (TextUtils.isEmpty(string)) {
                String strD = v.d(context, "ubix_sp_special_seed", "seed");
                string = TextUtils.isEmpty(strD) ? v.d(context, "ubix_sp_special_seed", "oaid") : new String(Base64.decode(strD.getBytes(), 10));
                long jC = v.c(context, "ubix_sp_special_seed", "seed_time");
                if (!TextUtils.isEmpty(string) && (jC <= 0 || System.currentTimeMillis() - jC > 86400000)) {
                    a(context, bVar);
                }
            }
            if (TextUtils.isEmpty(string)) {
                a(context, bVar);
                return c1066a;
            }
            c1066a.b = false;
            if (TextUtils.isEmpty(c1066a.f8666a)) {
                c1066a.f8666a = string;
            }
            u.e("AdvertisingIdPlatform", "use global oaid" + string);
            return c1066a;
        } catch (Exception unused) {
            a(context, bVar);
            return c1066a;
        }
    }

    private static void a(Context context, b bVar) {
        try {
            u.e("AdvertisingIdPlatform", "bindService start");
            Intent intent = new Intent("com.hihonor.id.HnOaIdService");
            intent.setPackage("com.hihonor.id");
            context.bindService(intent, bVar, 1);
            bVar.e.await(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
            bVar.a();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("AdvertisingIdPlatform", "getAdvertisingIdInfo error=" + e.getMessage());
            bVar.a();
        }
    }

    public static boolean b(Context context) {
        return new b().a(context);
    }
}
