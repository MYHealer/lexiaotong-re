package com.jd.ad.sdk.jad_fs;

import android.app.Application;
import com.byazt.hs.sl;
import com.jd.ad.sdk.logger.Logger;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: JADCheatCheckRecorder.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_an {
    public final List<jad_dq> jad_an = new ArrayList();
    public jad_dq jad_bo;
    public jad_dq jad_cp;

    public final String jad_an(List<jad_dq> list, int i) {
        if (i < 1 || list.size() < i) {
            return "";
        }
        int iFloor = (int) Math.floor(list.size() / i);
        if (iFloor > 9) {
            iFloor = 9;
        }
        ArrayList<jad_dq> arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < iFloor) {
            i2++;
            arrayList.add(list.get((i * i2) - 1));
        }
        long j = ((jad_dq) arrayList.get(0)).jad_an;
        StringBuilder sb = new StringBuilder();
        for (jad_dq jad_dqVar : arrayList) {
            sb.append("|").append(jad_dqVar.jad_bo).append(",").append(jad_dqVar.jad_cp).append(",").append(jad_dqVar.jad_an - j);
            j = jad_dqVar.jad_an;
        }
        return sb.toString();
    }

    public final String jad_an() {
        int i;
        JSONObject jSONObject = new JSONObject();
        try {
            Application applicationJad_an = com.jd.ad.sdk.jad_fq.jad_cp.jad_an();
            jSONObject.putOpt("jbr", Integer.valueOf(com.jd.ad.sdk.jad_qd.jad_an.jad_tg()));
            jSONObject.putOpt("sof", Integer.valueOf(com.jd.ad.sdk.jad_qd.jad_an.jad_zm()));
            jSONObject.putOpt(sl.c, Integer.valueOf(com.jd.ad.sdk.jad_qd.jad_an.jad_cp(applicationJad_an)));
            jSONObject.putOpt("em", Integer.valueOf(com.jd.ad.sdk.jad_qd.jad_an.jad_uh()));
            try {
                i = com.jd.ad.sdk.jad_qd.jad_an.jad_an("af", true) ? 1 : -1;
            } catch (Exception unused) {
            }
            jSONObject.putOpt("af", Integer.valueOf(i));
            jSONObject.putOpt("hoo", com.jd.ad.sdk.jad_qd.jad_an.jad_vi());
            jSONObject.putOpt("open", com.jd.ad.sdk.jad_qd.jad_an.jad_wj());
            jSONObject.putOpt("dbg", com.jd.ad.sdk.jad_qd.jad_an.jad_sf());
            jSONObject.putOpt("clo", "NA");
            jSONObject.putOpt("pac", com.jd.ad.sdk.jad_qd.jad_an.jad_an());
            jSONObject.putOpt("soa", com.jd.ad.sdk.jad_qd.jad_an.jad_qd());
            Logger.d("Cheat AC Params: " + jSONObject);
        } catch (JSONException e) {
            Logger.d("getCheatParams Exception: " + e);
        }
        return jSONObject.toString();
    }
}
