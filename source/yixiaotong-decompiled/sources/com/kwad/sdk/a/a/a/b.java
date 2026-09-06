package com.kwad.sdk.a.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.ai;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class b {
    public static int auj = 0;
    public static long vL = -1;

    private static boolean m(long j) {
        return ir() > 0 && j > 0 && ir() / 2460601000L == j / 2460601000L;
    }

    public static void J(Context context) {
        a aVar = new a();
        if (m(System.currentTimeMillis())) {
            auj++;
        } else {
            auj = 1;
        }
        vL = System.currentTimeMillis();
        aVar.auj = auj;
        aVar.kd = vL;
        ai.at(context, aVar.toJson().toString());
    }

    private static long ir() {
        long j = vL;
        if (j != -1) {
            return j;
        }
        String strVv = ai.Vv();
        if (TextUtils.isEmpty(strVv)) {
            return 0L;
        }
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(strVv));
            vL = aVar.kd;
            auj = aVar.auj;
        } catch (Exception e) {
            c.printStackTraceOnly(e);
        }
        return vL;
    }

    public static int dV() {
        if (!m(System.currentTimeMillis())) {
            auj = 0;
        }
        return auj;
    }
}
