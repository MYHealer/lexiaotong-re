package com.ubixnow.ooooo;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.ExoPlayer;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class f0 {

    public static final class OooO00o {
        public String OooO00o;
        public boolean OooO0O0;
    }

    private f0() {
    }

    public static OooO00o OooO00o(Context context) {
        g0 g0Var = new g0();
        g0Var.OooO0O0 = context;
        if (!g0Var.OooO00o(context)) {
            return null;
        }
        OooO00o oooO00o = g0Var.OooO00o;
        try {
            String string = Settings.Global.getString(context.getContentResolver(), "oaid");
            if (TextUtils.isEmpty(string)) {
                string = oOo00o00.OooO0o0("oaid");
            }
            if (TextUtils.isEmpty(string)) {
                OooO00o(context, g0Var);
                return oooO00o;
            }
            oooO00o.OooO0O0 = false;
            oooO00o.OooO00o = string;
            return oooO00o;
        } catch (Exception unused) {
            OooO00o(context, g0Var);
            return oooO00o;
        }
    }

    private static void OooO00o(Context context, g0 g0Var) {
        try {
            Intent intent = new Intent("com.hihonor.id.HnOaIdService");
            intent.setPackage("com.hihonor.id");
            context.bindService(intent, g0Var, 1);
            g0Var.OooO0o0.await(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
            g0Var.OooO00o();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("AdvertisingIdPlatform", "getAdvertisingIdInfo error=" + e.getMessage());
            g0Var.OooO00o();
        }
    }

    public static boolean OooO0O0(Context context) {
        return new g0().OooO00o(context);
    }
}
