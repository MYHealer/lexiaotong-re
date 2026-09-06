package com.byazt.aas;

import com.byazt.ete.ic;
import com.google.android.exoplayer2.ExoPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 131, 350})
public class p {
    public static void c(JSONObject jSONObject, ic icVar) {
        if (jSONObject == null || icVar == null) {
            return;
        }
        try {
            JSONObject jSONObjectC = com.byazt.nr.gr.c().c(icVar.eo());
            int iOptInt = 0;
            if (jSONObjectC != null && jSONObjectC.has("click_calculation_type")) {
                iOptInt = Math.abs(System.currentTimeMillis() - jSONObjectC.optLong("click_calculation_time", 0L)) <= ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS ? jSONObjectC.optInt("click_calculation_type", 0) : 0;
                com.byazt.nr.gr.c().tt(icVar.eo());
            }
            int iE = icVar.e();
            int iPe = icVar.pe();
            jSONObject.put("calculation_method", iE);
            jSONObject.put("calculation_method_twist", iPe);
            jSONObject.put("click_calculation_type", iOptInt);
        } catch (Throwable unused) {
        }
    }
}
