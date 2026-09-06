package com.jd.ad.sdk.jad_ob;

import android.app.Application;
import android.util.Log;
import com.jd.ad.sdk.bl.initsdk.JADYunSdk;
import com.jd.ad.sdk.jad_qd.jad_jw;
import com.jd.ad.sdk.jad_zm.jad_ly;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.multi.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ConfigurationHelper.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_cp {
    public static void jad_an(jad_ly.jad_an jad_anVar, String str) {
        byte[] bArrJad_bo;
        String strJad_an = com.jd.ad.sdk.jad_fq.jad_fs.jad_an("aHR0cHM6Ly9qYW5hcGkuamQuY29tL2Fuc2RrL3YxL2luaXREYXRh");
        com.jd.ad.sdk.jad_zm.jad_fs jad_fsVar = new com.jd.ad.sdk.jad_zm.jad_fs();
        jad_fsVar.jad_bo("User-Agent", com.jd.ad.sdk.jad_qd.jad_hu.jad_dq());
        jad_fsVar.jad_bo("Content-Type", "application/stream");
        jad_fsVar.jad_bo("Encryption", "AES");
        jad_ly.jad_bo jad_boVarJad_an = com.jd.ad.sdk.jad_zm.jad_bo.jad_an();
        jad_boVarJad_an.jad_er = strJad_an;
        jad_boVarJad_an.jad_bo = jad_fsVar;
        Application applicationJad_an = com.jd.ad.sdk.jad_fq.jad_cp.jad_an();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("aId", JADYunSdk.getAppId());
            jSONObject.put("pId", jad_jw.jad_an(applicationJad_an));
            jSONObject.put("cat", jad_an.jad_an());
            jSONObject.put("t", System.currentTimeMillis());
            jSONObject.put("rid", str);
            jSONObject.put("oid", jad_jw.jad_bo());
            jSONObject.put("di", jad_jw.jad_an());
            jSONObject.put("plat", "android");
            jSONObject.put("osv", com.jd.ad.sdk.jad_qd.jad_hu.jad_cp());
            jSONObject.put("sdkv", BuildConfig.VERSION_NAME);
        } catch (JSONException e) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.AN_REQUEST_JSON_ERROR;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, 2, jad_anVar2.jad_an, jad_anVar2.jad_an(e.getMessage()), 0);
        }
        Logger.d("AN API Request: " + jSONObject);
        try {
            bArrJad_bo = com.jd.ad.sdk.jad_fq.jad_an.jad_bo(jSONObject.toString());
        } catch (Exception e2) {
            Logger.d(Log.getStackTraceString(e2));
            bArrJad_bo = new byte[0];
        }
        jad_boVarJad_an.jad_fs = new com.jd.ad.sdk.jad_zm.jad_er(bArrJad_bo);
        jad_boVarJad_an.jad_hu = true;
        jad_boVarJad_an.jad_jt = jad_anVar;
        jad_boVarJad_an.jad_an(com.jd.ad.sdk.jad_ep.jad_bo.jad_cp);
    }
}
