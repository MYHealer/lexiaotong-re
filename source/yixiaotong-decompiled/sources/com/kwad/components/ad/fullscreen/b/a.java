package com.kwad.components.ad.fullscreen.b;

import android.content.Context;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class a {
    public static void H(Context context) {
        b bVarI = I(context);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (bVarI == null) {
            bVarI = new b(jCurrentTimeMillis, 1);
        } else if (!bVarI.m(jCurrentTimeMillis)) {
            bVarI.kd = jCurrentTimeMillis;
            bVarI.ke = 1;
        } else {
            bVarI.ke++;
        }
        a(context, bVarI);
    }

    public static boolean b(Context context, AdTemplate adTemplate) {
        b bVarI = I(context);
        return (bVarI == null || !bVarI.Q(com.kwad.components.ad.fullscreen.a.b.dg())) && com.kwad.sdk.core.response.helper.b.ea(adTemplate);
    }

    private static void a(Context context, b bVar) {
        if (context == null || bVar == null) {
            c.d("FullScreenLocalHelper", "saveFullScreenLocalInfo illegal arguments.");
        } else {
            context.getSharedPreferences("ksadsdk_fullscreen_local_ad_count", 0).edit().putString("key_local_info", bVar.toJson().toString()).apply();
        }
    }

    private static b I(Context context) {
        if (context == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(context.getSharedPreferences("ksadsdk_fullscreen_local_ad_count", 0).getString("key_local_info", null));
            b bVar = new b();
            bVar.parseJson(jSONObject);
            return bVar;
        } catch (Exception e) {
            c.printStackTraceOnly(e);
            return null;
        }
    }
}
